package com.example.model

enum class AppLanguage {
    ARABIC,
    ENGLISH
}

enum class ThemePreference {
    SYSTEM,
    LIGHT,
    DARK
}

enum class WindowWidthSize {
    COMPACT,
    MEDIUM,
    EXPANDED
}

enum class MainTab {
    HOME,
    CHAPTERS,
    PRACTICE,
    SAVED
}

enum class PartAccent {
    CRIMSON,
    NAVY,
    AMBER,
    EMERALD
}

data class GrammarPart(
    val id: String,
    val number: Int,
    val titleEn: String,
    val titleAr: String,
    val unitRange: String,
    val descriptionEn: String,
    val descriptionAr: String,
    val accent: PartAccent
)

data class GrammarExample(
    val sentenceEn: String,
    val noteAr: String,
    val noteEn: String
)

data class GrammarComparisonRow(
    val formEn: String,
    val formAr: String,
    val structureEn: String,
    val exampleEn: String
)

data class CommonMistake(
    val wrongEn: String,
    val correctEn: String,
    val explanationAr: String,
    val explanationEn: String
)

data class GrammarUnitSummary(
    val id: String,
    val partId: String,
    val unitBadge: String,
    val titleEn: String,
    val titleAr: String,
    val tldrAr: String,
    val tldrEn: String,
    val formulaEn: String,
    val keyPointsAr: List<String>,
    val keyPointsEn: List<String>,
    val examples: List<GrammarExample>,
    val structureTable: List<GrammarComparisonRow>,
    val mistakes: List<CommonMistake>,
    val murphyTipAr: String,
    val murphyTipEn: String
)

data class GrammarQuizQuestion(
    val id: String,
    val unitId: String,
    val partId: String,
    val promptEn: String,
    val promptAr: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanationAr: String,
    val explanationEn: String
)
