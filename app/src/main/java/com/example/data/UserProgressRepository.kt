package com.example.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.model.AppLanguage
import com.example.model.ThemePreference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.userProgressDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "murphy_grammar_prefs"
)

data class UserProgressSnapshot(
    val completedUnitIds: Set<String> = emptySet(),
    val bookmarkedUnitIds: Set<String> = emptySet(),
    val lastReadUnitId: String? = null,
    val bestQuizScorePercent: Int = 0,
    val quizzesCompleted: Int = 0,
    val partBestScores: Map<String, Int> = emptyMap(),
    val language: AppLanguage = AppLanguage.ARABIC,
    val themePreference: ThemePreference = ThemePreference.SYSTEM
)

class UserProgressRepository(private val context: Context) {

    private object Keys {
        val COMPLETED_UNITS = stringSetPreferencesKey("completed_units")
        val BOOKMARKED_UNITS = stringSetPreferencesKey("bookmarked_units")
        val LAST_READ_UNIT = stringPreferencesKey("last_read_unit")
        val BEST_QUIZ_SCORE = intPreferencesKey("best_quiz_score")
        val QUIZZES_COMPLETED = intPreferencesKey("quizzes_completed")
        val PART_BEST_SCORES = stringSetPreferencesKey("part_best_scores")
        val LANGUAGE = stringPreferencesKey("app_language")
        val THEME = stringPreferencesKey("theme_preference")
    }

    val progressFlow: Flow<UserProgressSnapshot> = context.userProgressDataStore.data.map { prefs ->
        val langName = prefs[Keys.LANGUAGE] ?: AppLanguage.ARABIC.name
        val themeName = prefs[Keys.THEME] ?: ThemePreference.SYSTEM.name
        val rawPartScores = prefs[Keys.PART_BEST_SCORES] ?: emptySet()
        val parsedPartScores = rawPartScores.mapNotNull { entry ->
            val sep = entry.lastIndexOf(':')
            if (sep <= 0) null
            else {
                val partId = entry.substring(0, sep)
                val score = entry.substring(sep + 1).toIntOrNull()
                if (score != null) partId to score else null
            }
        }.toMap()

        UserProgressSnapshot(
            completedUnitIds = prefs[Keys.COMPLETED_UNITS] ?: emptySet(),
            bookmarkedUnitIds = prefs[Keys.BOOKMARKED_UNITS] ?: emptySet(),
            lastReadUnitId = prefs[Keys.LAST_READ_UNIT],
            bestQuizScorePercent = prefs[Keys.BEST_QUIZ_SCORE] ?: 0,
            quizzesCompleted = prefs[Keys.QUIZZES_COMPLETED] ?: 0,
            partBestScores = parsedPartScores,
            language = runCatching { AppLanguage.valueOf(langName) }.getOrDefault(AppLanguage.ARABIC),
            themePreference = runCatching { ThemePreference.valueOf(themeName) }.getOrDefault(ThemePreference.SYSTEM)
        )
    }

    suspend fun toggleUnitCompleted(unitId: String) {
        context.userProgressDataStore.edit { prefs ->
            val current = prefs[Keys.COMPLETED_UNITS] ?: emptySet()
            prefs[Keys.COMPLETED_UNITS] = if (unitId in current) current - unitId else current + unitId
        }
    }

    suspend fun toggleBookmark(unitId: String) {
        context.userProgressDataStore.edit { prefs ->
            val current = prefs[Keys.BOOKMARKED_UNITS] ?: emptySet()
            prefs[Keys.BOOKMARKED_UNITS] = if (unitId in current) current - unitId else current + unitId
        }
    }

    suspend fun setLastReadUnit(unitId: String) {
        context.userProgressDataStore.edit { prefs ->
            prefs[Keys.LAST_READ_UNIT] = unitId
        }
    }

    suspend fun recordQuizResult(scorePercent: Int, partId: String? = null) {
        context.userProgressDataStore.edit { prefs ->
            val prevBest = prefs[Keys.BEST_QUIZ_SCORE] ?: 0
            val count = prefs[Keys.QUIZZES_COMPLETED] ?: 0
            if (scorePercent > prevBest) {
                prefs[Keys.BEST_QUIZ_SCORE] = scorePercent
            }
            prefs[Keys.QUIZZES_COMPLETED] = count + 1

            if (partId != null) {
                val existing = (prefs[Keys.PART_BEST_SCORES] ?: emptySet())
                    .mapNotNull { entry ->
                        val sep = entry.lastIndexOf(':')
                        if (sep <= 0) null
                        else entry.substring(0, sep) to (entry.substring(sep + 1).toIntOrNull() ?: 0)
                    }
                    .toMap()
                    .toMutableMap()
                val prevPartBest = existing[partId] ?: 0
                if (scorePercent >= prevPartBest) {
                    existing[partId] = scorePercent
                    prefs[Keys.PART_BEST_SCORES] = existing.entries.map { "${it.key}:${it.value}" }.toSet()
                }
            }
        }
    }

    suspend fun setLanguage(language: AppLanguage) {
        context.userProgressDataStore.edit { prefs ->
            prefs[Keys.LANGUAGE] = language.name
        }
    }

    suspend fun setThemePreference(theme: ThemePreference) {
        context.userProgressDataStore.edit { prefs ->
            prefs[Keys.THEME] = theme.name
        }
    }

    suspend fun resetProgress() {
        context.userProgressDataStore.edit { prefs ->
            prefs.remove(Keys.COMPLETED_UNITS)
            prefs.remove(Keys.BOOKMARKED_UNITS)
            prefs.remove(Keys.LAST_READ_UNIT)
            prefs.remove(Keys.BEST_QUIZ_SCORE)
            prefs.remove(Keys.QUIZZES_COMPLETED)
            prefs.remove(Keys.PART_BEST_SCORES)
        }
    }
}
