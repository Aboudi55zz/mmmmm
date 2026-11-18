package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.data.GrammarQuizRepository
import com.example.model.AppLanguage
import com.example.model.GrammarPart
import com.example.model.WindowWidthSize
import com.example.ui.components.LanguageToggleChip
import com.example.ui.components.LtrEnglishContent
import com.example.ui.components.forEnglishGrammar
import com.example.ui.components.forLanguage
import com.example.ui.components.formatBilingualText
import com.example.ui.components.isAppDarkTheme
import com.example.ui.components.partAccentColor
import com.example.ui.theme.GrammarErrorBgDark
import com.example.ui.theme.GrammarErrorBgLight
import com.example.ui.theme.GrammarErrorDark
import com.example.ui.theme.GrammarErrorLight
import com.example.ui.theme.GrammarSuccessBgDark
import com.example.ui.theme.GrammarSuccessBgLight
import com.example.ui.theme.GrammarSuccessDark
import com.example.ui.theme.GrammarSuccessLight
import com.example.viewmodel.GrammarUiState
import com.example.viewmodel.QuizSessionState

@Composable
fun PracticeScreen(
    uiState: GrammarUiState,
    windowWidthSize: WindowWidthSize,
    onStartMixedQuiz: () -> Unit,
    onStartUnstudiedQuiz: () -> Unit,
    onStartPartQuiz: (GrammarPart) -> Unit,
    onRetryCurrentQuiz: () -> Unit,
    onSelectOption: (Int) -> Unit,
    onAdvanceQuiz: () -> Unit,
    onExitQuiz: () -> Unit,
    onToggleLanguage: () -> Unit,
    modifier: Modifier = Modifier
) {
    val session = uiState.quizSession
    val language = uiState.progress.language
    val isDark = isAppDarkTheme(uiState.progress.themePreference)

    if (session.isActive) {
        BackHandler(onBack = onExitQuiz)
        ActiveQuizView(
            session = session,
            language = language,
            isDark = isDark,
            onSelectOption = onSelectOption,
            onAdvanceQuiz = onAdvanceQuiz,
            onRetryCurrentQuiz = onRetryCurrentQuiz,
            onExitQuiz = onExitQuiz,
            modifier = modifier
        )
    } else {
        PracticeHubView(
            uiState = uiState,
            windowWidthSize = windowWidthSize,
            onStartMixedQuiz = onStartMixedQuiz,
            onStartUnstudiedQuiz = onStartUnstudiedQuiz,
            onStartPartQuiz = onStartPartQuiz,
            onToggleLanguage = onToggleLanguage,
            modifier = modifier
        )
    }
}

@Composable
private fun PracticeHubView(
    uiState: GrammarUiState,
    windowWidthSize: WindowWidthSize,
    onStartMixedQuiz: () -> Unit,
    onStartUnstudiedQuiz: () -> Unit,
    onStartPartQuiz: (GrammarPart) -> Unit,
    onToggleLanguage: () -> Unit,
    modifier: Modifier = Modifier
) {
    val language = uiState.progress.language
    val isDark = isAppDarkTheme(uiState.progress.themePreference)
    val columns = when (windowWidthSize) {
        WindowWidthSize.COMPACT -> 1
        WindowWidthSize.MEDIUM -> 2
        WindowWidthSize.EXPANDED -> 3
    }
    val totalBankSize = GrammarQuizRepository.questions.size
    val passedPartsCount = uiState.progress.partBestScores.count { it.value >= 70 }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .widthIn(max = 1040.dp)
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item(key = "practice_header") {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (language == AppLanguage.ARABIC) "تمارين واختبارات مورفي" else "Murphy Practice Lab",
                            style = MaterialTheme.typography.headlineSmall.forLanguage(language),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = formatBilingualText(
                                if (language == AppLanguage.ARABIC) {
                                    "$totalBankSize سؤالاً • أفضل نتيجة: ${uiState.progress.bestQuizScorePercent}% • أقسام مجتازة: $passedPartsCount/${uiState.parts.size}"
                                } else {
                                    "$totalBankSize questions • Best: ${uiState.progress.bestQuizScorePercent}% • Parts passed: $passedPartsCount/${uiState.parts.size}"
                                },
                                language
                            ),
                            style = MaterialTheme.typography.bodyMedium.forLanguage(language),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    LanguageToggleChip(
                        language = language,
                        onToggle = onToggleLanguage
                    )
                }
            }

            // Primary Challenge Cards
            item(key = "practice_modes") {
                if (windowWidthSize == WindowWidthSize.COMPACT) {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        MixedQuizHeroCard(language = language, onClick = onStartMixedQuiz)
                        UnstudiedQuizCard(language = language, onClick = onStartUnstudiedQuiz)
                    }
                } else {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        MixedQuizHeroCard(
                            language = language,
                            onClick = onStartMixedQuiz,
                            modifier = Modifier.weight(1f)
                        )
                        UnstudiedQuizCard(
                            language = language,
                            onClick = onStartUnstudiedQuiz,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            item(key = "by_part_title") {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = if (language == AppLanguage.ARABIC) "اختبارات مخصصة لكل قسم" else "Tests for Every Book Part",
                        style = MaterialTheme.typography.titleLarge.forLanguage(language),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = if (language == AppLanguage.ARABIC) "${uiState.parts.size} اختباراً" else "${uiState.parts.size} Tests",
                        style = MaterialTheme.typography.labelLarge.forLanguage(language),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            val partsWithQuestions = uiState.parts.filter {
                GrammarQuizRepository.getQuestionsForPart(it.id).isNotEmpty()
            }
            val chunked = partsWithQuestions.chunked(columns)

            items(
                count = chunked.size,
                key = { rowIdx -> "practice_parts_row_$rowIdx" }
            ) { rowIdx ->
                val rowParts = chunked[rowIdx]
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    rowParts.forEach { part ->
                        val qCount = GrammarQuizRepository.getQuestionsForPart(part.id).size
                        val bestPartScore = uiState.progress.partBestScores[part.id]
                        val accentColor = partAccentColor(part.accent)
                        val scoreOkColor = if (isDark) GrammarSuccessDark else GrammarSuccessLight
                        val scoreOkBg = if (isDark) GrammarSuccessBgDark else GrammarSuccessBgLight

                        Card(
                            onClick = { onStartPartQuiz(part) },
                            shape = MaterialTheme.shapes.medium,
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                            modifier = Modifier
                                .weight(1f)
                                .testTag("practice_part_${part.id}")
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                modifier = Modifier.padding(14.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(accentColor.copy(alpha = 0.14f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "${part.number}",
                                        style = MaterialTheme.typography.titleMedium.forEnglishGrammar(),
                                        color = accentColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Column(
                                    modifier = Modifier.weight(1f),
                                    verticalArrangement = Arrangement.spacedBy(2.dp)
                                ) {
                                    Text(
                                        text = formatBilingualText(
                                            if (language == AppLanguage.ARABIC) part.titleAr else part.titleEn,
                                            language
                                        ),
                                        style = MaterialTheme.typography.titleSmall.forLanguage(language),
                                        fontWeight = FontWeight.Bold,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    if (language == AppLanguage.ARABIC) {
                                        LtrEnglishContent {
                                            Text(
                                                text = "${part.titleEn} • ${part.unitRange}",
                                                style = MaterialTheme.typography.labelSmall.forEnglishGrammar(),
                                                color = accentColor,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis,
                                                modifier = Modifier.fillMaxWidth()
                                            )
                                        }
                                    }
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Text(
                                            text = if (language == AppLanguage.ARABIC) "$qCount أسئلة" else "$qCount questions",
                                            style = MaterialTheme.typography.bodySmall.forLanguage(language),
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                        if (bestPartScore != null) {
                                            Surface(
                                                shape = RoundedCornerShape(50),
                                                color = if (bestPartScore >= 70) scoreOkBg else MaterialTheme.colorScheme.surfaceVariant
                                            ) {
                                                LtrEnglishContent {
                                                    Text(
                                                        text = "$bestPartScore%",
                                                        style = MaterialTheme.typography.labelSmall.forEnglishGrammar(),
                                                        fontWeight = FontWeight.Bold,
                                                        color = if (bestPartScore >= 70) scoreOkColor else MaterialTheme.colorScheme.onSurfaceVariant,
                                                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp)
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                                Icon(
                                    imageVector = Icons.Default.PlayArrow,
                                    contentDescription = "Start practice",
                                    tint = accentColor
                                )
                            }
                        }
                    }
                    repeat(columns - rowParts.size) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
private fun MixedQuizHeroCard(
    language: AppLanguage,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.35f)),
        modifier = modifier
            .fillMaxWidth()
            .testTag("start_mixed_quiz_button")
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier.padding(18.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Shuffle,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = if (language == AppLanguage.ARABIC) "اختبار شامل من الكتاب" else "Mixed Book Review",
                    style = MaterialTheme.typography.titleMedium.forLanguage(language),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = if (language == AppLanguage.ARABIC) {
                        "12 سؤالاً متنوعاً تغطي كل أبواب الكتاب والملاحق"
                    } else {
                        "12 mixed questions across all 20 parts & appendices"
                    },
                    style = MaterialTheme.typography.bodySmall.forLanguage(language),
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.85f)
                )
            }
        }
    }
}

@Composable
private fun UnstudiedQuizCard(
    language: AppLanguage,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.35f)),
        modifier = modifier
            .fillMaxWidth()
            .testTag("start_unstudied_quiz_button")
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier.padding(18.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Psychology,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = if (language == AppLanguage.ARABIC) "تحدي القواعد الجديدة" else "New Rules Challenge",
                    style = MaterialTheme.typography.titleMedium.forLanguage(language),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    text = if (language == AppLanguage.ARABIC) {
                        "10 أسئلة مركّزة على الوحدات التي لم تُنهها بعد"
                    } else {
                        "10 focused questions on units you haven't studied yet"
                    },
                    style = MaterialTheme.typography.bodySmall.forLanguage(language),
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.85f)
                )
            }
        }
    }
}

@Composable
private fun ActiveQuizView(
    session: QuizSessionState,
    language: AppLanguage,
    isDark: Boolean,
    onSelectOption: (Int) -> Unit,
    onAdvanceQuiz: () -> Unit,
    onRetryCurrentQuiz: () -> Unit,
    onExitQuiz: () -> Unit,
    modifier: Modifier = Modifier
) {
    val okColor = if (isDark) GrammarSuccessDark else GrammarSuccessLight
    val okBg = if (isDark) GrammarSuccessBgDark else GrammarSuccessBgLight
    val errColor = if (isDark) GrammarErrorDark else GrammarErrorLight
    val errBg = if (isDark) GrammarErrorBgDark else GrammarErrorBgLight

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        if (session.isFinished) {
            val total = session.questions.size.coerceAtLeast(1)
            val percent = ((session.correctAnswersCount.toFloat() / total) * 100).toInt()
            Card(
                shape = MaterialTheme.shapes.extraLarge,
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                modifier = Modifier
                    .widthIn(max = 580.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(28.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(72.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.tertiaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.EmojiEvents,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier.size(38.dp)
                        )
                    }
                    Text(
                        text = if (language == AppLanguage.ARABIC) "أحسنت! انتهى الاختبار" else "Practice Complete!",
                        style = MaterialTheme.typography.headlineSmall.forLanguage(language),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = formatBilingualText(
                            if (language == AppLanguage.ARABIC) session.titleAr else session.titleEn,
                            language
                        ),
                        style = MaterialTheme.typography.labelLarge.forLanguage(language),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    LtrEnglishContent {
                        Text(
                            text = "${session.correctAnswersCount} / $total ($percent%)",
                            style = MaterialTheme.typography.displaySmall.forEnglishGrammar().copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Text(
                        text = if (language == AppLanguage.ARABIC) {
                            if (percent >= 80) "إتقان ممتاز لقواعد ريموند مورفي!" else "راجع الوحدات التي أخطأت فيها وجرّب مجدداً."
                        } else {
                            if (percent >= 80) "Great command of Raymond Murphy's rules!" else "Review the missed rules and try again."
                        },
                        style = MaterialTheme.typography.bodyLarge.forLanguage(language),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedButton(
                            onClick = onExitQuiz,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .minimumInteractiveComponentSize()
                        ) {
                            Text(if (language == AppLanguage.ARABIC) "رجوع" else "Done")
                        }
                        Button(
                            onClick = onRetryCurrentQuiz,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .minimumInteractiveComponentSize()
                        ) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(if (language == AppLanguage.ARABIC) "إعادة الاختبار" else "Retry Test")
                        }
                    }
                }
            }
            return
        }

        val question = session.currentQuestion ?: return
        val progress = (session.currentIndex + 1).toFloat() / session.questions.size.coerceAtLeast(1)

        LazyColumn(
            modifier = Modifier
                .widthIn(max = 680.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item(key = "quiz_top_bar") {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = formatBilingualText(
                                if (language == AppLanguage.ARABIC) session.titleAr else session.titleEn,
                                language
                            ),
                            style = MaterialTheme.typography.titleMedium.forLanguage(language),
                            fontWeight = FontWeight.Bold
                        )
                        LtrEnglishContent {
                            Text(
                                text = "${session.currentIndex + 1} / ${session.questions.size}",
                                style = MaterialTheme.typography.labelMedium.forEnglishGrammar(),
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                    IconButton(
                        onClick = onExitQuiz,
                        modifier = Modifier
                            .minimumInteractiveComponentSize()
                            .testTag("exit_quiz_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Exit quiz"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
                LinearProgressIndicator(
                    progress = { progress },
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(50))
                )
            }

            item(key = "quiz_prompt_${question.id}") {
                Card(
                    shape = MaterialTheme.shapes.large,
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Quiz,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(18.dp)
                            )
                            Text(
                                text = formatBilingualText(
                                    if (language == AppLanguage.ARABIC) question.promptAr else "Complete the sentence:",
                                    language
                                ),
                                style = MaterialTheme.typography.labelLarge.forLanguage(language),
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        LtrEnglishContent {
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = question.promptEn,
                                    style = MaterialTheme.typography.headlineSmall.forEnglishGrammar().copy(
                                        fontWeight = FontWeight.Bold
                                    ),
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.padding(14.dp)
                                )
                            }
                        }
                    }
                }
            }

            item(key = "quiz_options_${question.id}") {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    question.options.forEachIndexed { idx, option ->
                        val chosen = session.selectedOptionIndex
                        val isChosen = chosen == idx
                        val isCorrect = idx == question.correctIndex
                        val bg = when {
                            chosen == null -> MaterialTheme.colorScheme.surface
                            isCorrect -> okBg
                            isChosen -> errBg
                            else -> MaterialTheme.colorScheme.surface
                        }
                        val border = when {
                            chosen == null -> MaterialTheme.colorScheme.outlineVariant
                            isCorrect -> okColor
                            isChosen -> errColor
                            else -> MaterialTheme.colorScheme.outlineVariant
                        }
                        val textColor = when {
                            chosen == null -> MaterialTheme.colorScheme.onSurface
                            isCorrect -> okColor
                            isChosen -> errColor
                            else -> MaterialTheme.colorScheme.onSurfaceVariant
                        }

                        Surface(
                            onClick = { onSelectOption(idx) },
                            shape = RoundedCornerShape(14.dp),
                            color = bg,
                            border = BorderStroke(if (isChosen || (chosen != null && isCorrect)) 2.dp else 1.dp, border),
                            modifier = Modifier
                                .fillMaxWidth()
                                .minimumInteractiveComponentSize()
                                .testTag("quiz_option_$idx")
                        ) {
                            LtrEnglishContent {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp)
                                ) {
                                    Text(
                                        text = option,
                                        style = MaterialTheme.typography.titleMedium.forEnglishGrammar(),
                                        color = textColor
                                    )
                                    if (chosen != null && isCorrect) {
                                        Icon(
                                            imageVector = Icons.Default.CheckCircle,
                                            contentDescription = "Correct",
                                            tint = okColor
                                        )
                                    } else if (chosen != null && isChosen) {
                                        Icon(
                                            imageVector = Icons.Default.Close,
                                            contentDescription = "Incorrect",
                                            tint = errColor
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            item(key = "quiz_feedback_${question.id}") {
                AnimatedVisibility(visible = session.selectedOptionIndex != null) {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Surface(
                            shape = MaterialTheme.shapes.medium,
                            color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.6f),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.35f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(14.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text(
                                    text = if (language == AppLanguage.ARABIC) "شرح القاعدة" else "Rule Explanation",
                                    style = MaterialTheme.typography.labelLarge.forLanguage(language),
                                    color = MaterialTheme.colorScheme.secondary,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = formatBilingualText(
                                        if (language == AppLanguage.ARABIC) question.explanationAr else question.explanationEn,
                                        language
                                    ),
                                    style = MaterialTheme.typography.bodyMedium.forLanguage(language),
                                    color = MaterialTheme.colorScheme.onSecondaryContainer
                                )
                            }
                        }

                        Button(
                            onClick = onAdvanceQuiz,
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .minimumInteractiveComponentSize()
                                .testTag("quiz_next_button")
                        ) {
                            val isLast = session.currentIndex == session.questions.lastIndex
                            Text(
                                text = when {
                                    isLast && language == AppLanguage.ARABIC -> "عرض النتيجة النهائية"
                                    isLast -> "See Final Score"
                                    language == AppLanguage.ARABIC -> "السؤال التالي"
                                    else -> "Next Question"
                                },
                                style = MaterialTheme.typography.labelLarge.forLanguage(language)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
