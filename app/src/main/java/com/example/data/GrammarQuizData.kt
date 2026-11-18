package com.example.data

import com.example.model.GrammarQuizQuestion

object GrammarQuizRepository {
    val questions: List<GrammarQuizQuestion> by lazy {
        GrammarQuizPart1.questions + GrammarQuizPart2.questions
    }

    fun getQuestionsForUnit(unitId: String): List<GrammarQuizQuestion> =
        questions.filter { it.unitId == unitId }

    fun getQuestionsForPart(partId: String): List<GrammarQuizQuestion> =
        questions.filter { it.partId == partId }
}
