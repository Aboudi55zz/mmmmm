package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.GrammarBookRepository
import com.example.data.GrammarQuizRepository
import com.example.data.UserProgressRepository
import com.example.data.UserProgressSnapshot
import com.example.model.AppLanguage
import com.example.model.GrammarPart
import com.example.model.GrammarQuizQuestion
import com.example.model.GrammarUnitSummary
import com.example.model.MainTab
import com.example.model.ThemePreference
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class QuizSessionState(
    val partId: String? = null,
    val titleAr: String = "",
    val titleEn: String = "",
    val questions: List<GrammarQuizQuestion> = emptyList(),
    val currentIndex: Int = 0,
    val selectedOptionIndex: Int? = null,
    val correctAnswersCount: Int = 0,
    val isFinished: Boolean = false
) {
    val currentQuestion: GrammarQuizQuestion?
        get() = questions.getOrNull(currentIndex)
    val isActive: Boolean
        get() = questions.isNotEmpty()
}

data class GrammarUiState(
    val selectedTab: MainTab = MainTab.HOME,
    val parts: List<GrammarPart> = GrammarBookRepository.parts,
    val allUnits: List<GrammarUnitSummary> = GrammarBookRepository.allUnits,
    val searchQuery: String = "",
    val selectedPartFilterId: String? = null,
    val activeDetailUnitId: String? = null,
    val masterDetailSelectedUnitId: String = GrammarBookRepository.allUnits.first().id,
    val progress: UserProgressSnapshot = UserProgressSnapshot(),
    val quizSession: QuizSessionState = QuizSessionState()
) {
    val filteredUnits: List<GrammarUnitSummary>
        get() {
            val q = searchQuery.trim().lowercase()
            return allUnits.filter { unit ->
                val matchesPart = selectedPartFilterId == null || unit.partId == selectedPartFilterId
                val matchesQuery = if (q.isEmpty()) {
                    true
                } else {
                    unit.titleEn.lowercase().contains(q) ||
                        unit.titleAr.lowercase().contains(q) ||
                        unit.unitBadge.lowercase().contains(q) ||
                        unit.tldrEn.lowercase().contains(q) ||
                        unit.tldrAr.lowercase().contains(q) ||
                        unit.formulaEn.lowercase().contains(q)
                }
                matchesPart && matchesQuery
            }
        }

    val continueUnit: GrammarUnitSummary
        get() {
            val lastId = progress.lastReadUnitId
            if (lastId != null) {
                GrammarBookRepository.getUnitById(lastId)?.let { return it }
            }
            return allUnits.firstOrNull { it.id !in progress.completedUnitIds } ?: allUnits.first()
        }

    val spotlightUnit: GrammarUnitSummary
        get() {
            val uncompleted = allUnits.filter { it.id !in progress.completedUnitIds }
            val pool = if (uncompleted.isNotEmpty()) uncompleted else allUnits
            return pool.first()
        }
}

class GrammarViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = UserProgressRepository(application.applicationContext)

    private val _uiState = MutableStateFlow(GrammarUiState())
    val uiState: StateFlow<GrammarUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.progressFlow.collect { snapshot ->
                _uiState.update { it.copy(progress = snapshot) }
            }
        }
    }

    fun selectTab(tab: MainTab) {
        _uiState.update { it.copy(selectedTab = tab) }
    }

    fun updateSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun selectPartFilter(partId: String?) {
        _uiState.update { state ->
            val nextUnits = if (partId == null) {
                state.allUnits
            } else {
                state.allUnits.filter { it.partId == partId }
            }
            val nextMasterId = nextUnits.firstOrNull()?.id ?: state.masterDetailSelectedUnitId
            state.copy(
                selectedPartFilterId = partId,
                masterDetailSelectedUnitId = nextMasterId
            )
        }
    }

    fun openPartInChapters(partId: String) {
        val firstUnit = GrammarBookRepository.getUnitsForPart(partId).firstOrNull()
        _uiState.update {
            it.copy(
                selectedTab = MainTab.CHAPTERS,
                selectedPartFilterId = partId,
                searchQuery = "",
                masterDetailSelectedUnitId = firstUnit?.id ?: it.masterDetailSelectedUnitId,
                activeDetailUnitId = null
            )
        }
    }

    fun openUnit(unitId: String, isExpandedLayout: Boolean) {
        viewModelScope.launch {
            repository.setLastReadUnit(unitId)
        }
        _uiState.update {
            if (isExpandedLayout) {
                it.copy(
                    selectedTab = MainTab.CHAPTERS,
                    masterDetailSelectedUnitId = unitId,
                    activeDetailUnitId = null
                )
            } else {
                it.copy(activeDetailUnitId = unitId)
            }
        }
    }

    fun closeUnitDetail() {
        _uiState.update { it.copy(activeDetailUnitId = null) }
    }

    fun toggleUnitCompleted(unitId: String) {
        viewModelScope.launch {
            repository.toggleUnitCompleted(unitId)
        }
    }

    fun toggleBookmark(unitId: String) {
        viewModelScope.launch {
            repository.toggleBookmark(unitId)
        }
    }

    fun setLanguage(language: AppLanguage) {
        viewModelScope.launch {
            repository.setLanguage(language)
        }
    }

    fun toggleLanguage() {
        val next = if (_uiState.value.progress.language == AppLanguage.ARABIC) {
            AppLanguage.ENGLISH
        } else {
            AppLanguage.ARABIC
        }
        setLanguage(next)
    }

    fun setThemePreference(theme: ThemePreference) {
        viewModelScope.launch {
            repository.setThemePreference(theme)
        }
    }

    fun resetProgress() {
        viewModelScope.launch {
            repository.resetProgress()
        }
    }

    fun startMixedQuiz(count: Int = 12) {
        val picked = GrammarQuizRepository.questions.shuffled().take(count)
        _uiState.update {
            it.copy(
                selectedTab = MainTab.PRACTICE,
                activeDetailUnitId = null,
                quizSession = QuizSessionState(
                    partId = null,
                    titleAr = "اختبار شامل من كتاب مورفي",
                    titleEn = "Mixed Book Review",
                    questions = picked
                )
            )
        }
    }

    fun startUnstudiedQuiz() {
        val completed = _uiState.value.progress.completedUnitIds
        val unstudiedQuestions = GrammarQuizRepository.questions.filter { it.unitId !in completed }
        val pool = if (unstudiedQuestions.isNotEmpty()) unstudiedQuestions else GrammarQuizRepository.questions
        val picked = pool.shuffled().take(10)
        _uiState.update {
            it.copy(
                selectedTab = MainTab.PRACTICE,
                activeDetailUnitId = null,
                quizSession = QuizSessionState(
                    partId = null,
                    titleAr = "تحدي الوحدات الجديدة",
                    titleEn = "Unstudied Units Challenge",
                    questions = picked
                )
            )
        }
    }

    fun startPartQuiz(part: GrammarPart) {
        val partQuestions = GrammarQuizRepository.getQuestionsForPart(part.id)
        if (partQuestions.isEmpty()) return
        _uiState.update {
            it.copy(
                selectedTab = MainTab.PRACTICE,
                activeDetailUnitId = null,
                quizSession = QuizSessionState(
                    partId = part.id,
                    titleAr = "اختبار القسم ${part.number}: ${part.titleAr}",
                    titleEn = "Part ${part.number} Test: ${part.titleEn}",
                    questions = partQuestions.shuffled()
                )
            )
        }
    }

    fun retryCurrentQuiz() {
        val session = _uiState.value.quizSession
        val part = session.partId?.let { GrammarBookRepository.getPartById(it) }
        if (part != null) {
            startPartQuiz(part)
        } else {
            startMixedQuiz()
        }
    }

    fun selectQuizOption(optionIndex: Int) {
        _uiState.update { state ->
            val session = state.quizSession
            val currentQ = session.currentQuestion ?: return@update state
            if (session.selectedOptionIndex != null) return@update state
            val isCorrect = optionIndex == currentQ.correctIndex
            state.copy(
                quizSession = session.copy(
                    selectedOptionIndex = optionIndex,
                    correctAnswersCount = session.correctAnswersCount + if (isCorrect) 1 else 0
                )
            )
        }
    }

    fun advanceQuiz() {
        val currentSession = _uiState.value.quizSession
        if (currentSession.questions.isEmpty()) return
        val nextIndex = currentSession.currentIndex + 1
        if (nextIndex >= currentSession.questions.size) {
            val percent = ((currentSession.correctAnswersCount.toFloat() / currentSession.questions.size) * 100).toInt()
            viewModelScope.launch {
                repository.recordQuizResult(percent, currentSession.partId)
            }
            _uiState.update {
                it.copy(quizSession = currentSession.copy(isFinished = true))
            }
        } else {
            _uiState.update {
                it.copy(
                    quizSession = currentSession.copy(
                        currentIndex = nextIndex,
                        selectedOptionIndex = null
                    )
                )
            }
        }
    }

    fun exitQuiz() {
        _uiState.update { it.copy(quizSession = QuizSessionState()) }
    }
}
