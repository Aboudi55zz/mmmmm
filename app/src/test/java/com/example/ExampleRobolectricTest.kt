package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.GrammarBookRepository
import com.example.data.GrammarQuizRepository
import com.example.model.AppLanguage
import com.example.ui.components.formatBilingualText
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun `app name matches Murphy Grammar`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Murphy Grammar", appName)
    }

    @Test
    fun `book syllabus covers all 20 parts, units, appendices and comprehensive per-part quizzes`() {
        assertEquals(20, GrammarBookRepository.parts.size)
        assertTrue(GrammarBookRepository.allUnits.size >= 34)
        assertTrue(GrammarQuizRepository.questions.size >= 100)

        val uniqueQuestionIds = GrammarQuizRepository.questions.map { it.id }.toSet()
        assertEquals(
            "Question IDs must be unique",
            GrammarQuizRepository.questions.size,
            uniqueQuestionIds.size
        )

        GrammarBookRepository.parts.forEach { part ->
            assertTrue(
                "Part ${part.id} must have units",
                GrammarBookRepository.getUnitsForPart(part.id).isNotEmpty()
            )
            val partQuestions = GrammarQuizRepository.getQuestionsForPart(part.id)
            assertTrue(
                "Part ${part.id} must have at least 4 quiz questions, got ${partQuestions.size}",
                partQuestions.size >= 4
            )
        }
        GrammarBookRepository.allUnits.forEach { unit ->
            assertTrue(
                "Unit ${unit.id} must reference a valid part",
                GrammarBookRepository.getPartById(unit.partId) != null
            )
            val unitQuestions = GrammarQuizRepository.getQuestionsForUnit(unit.id)
            assertTrue(
                "Unit ${unit.id} must have at least 2 quick-check questions, got ${unitQuestions.size}",
                unitQuestions.size >= 2
            )
        }
        GrammarQuizRepository.questions.forEach { q ->
            val unit = GrammarBookRepository.getUnitById(q.unitId)
            assertTrue("Question ${q.id} must reference a valid unit", unit != null)
            assertEquals("Question ${q.id} partId must match unit partId", unit?.partId, q.partId)
            assertTrue(q.correctIndex in q.options.indices)
        }
    }

    @Test
    fun `bilingual text isolates inline English in Arabic mode`() {
        val raw = "just = منذ لحظات قليلة: I've just had lunch."
        val formattedAr = formatBilingualText(raw, AppLanguage.ARABIC)
        assertTrue(formattedAr.contains("\u2066just\u2069"))
        assertTrue(formattedAr.contains("\u2066I've just had lunch\u2069"))

        val formattedEn = formatBilingualText(raw, AppLanguage.ENGLISH)
        assertEquals(raw, formattedEn)
    }
}
