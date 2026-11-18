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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.data.GrammarBookRepository
import com.example.data.GrammarQuizRepository
import com.example.model.AppLanguage
import com.example.model.GrammarPart
import com.example.model.GrammarQuizQuestion
import com.example.model.GrammarUnitSummary
import com.example.model.ThemePreference
import com.example.ui.components.FormulaBannerCard
import com.example.ui.components.LanguageToggleChip
import com.example.ui.components.LtrEnglishContent
import com.example.ui.components.MistakeComparisonCard
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitDetailScreen(
    unit: GrammarUnitSummary,
    language: AppLanguage,
    themePreference: ThemePreference,
    isCompleted: Boolean,
    isBookmarked: Boolean,
    onBack: () -> Unit,
    onToggleCompleted: () -> Unit,
    onToggleBookmark: () -> Unit,
    onToggleLanguage: () -> Unit,
    onNavigateToUnit: (String) -> Unit,
    onStartPartTest: (GrammarPart) -> Unit = {}
) {
    BackHandler(onBack = onBack)

    val part = remember(unit.partId) { GrammarBookRepository.getPartById(unit.partId) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(verticalArrangement = Arrangement.spacedBy(1.dp)) {
                        Text(
                            text = formatBilingualText(
                                if (language == AppLanguage.ARABIC) part?.titleAr.orEmpty() else part?.titleEn.orEmpty(),
                                language
                            ),
                            style = MaterialTheme.typography.titleSmall.forLanguage(language),
                            color = MaterialTheme.colorScheme.onSurface,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        LtrEnglishContent {
                            Text(
                                text = unit.unitBadge,
                                style = MaterialTheme.typography.labelMedium.forEnglishGrammar(),
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier
                            .minimumInteractiveComponentSize()
                            .testTag("detail_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    LanguageToggleChip(
                        language = language,
                        onToggle = onToggleLanguage
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    IconButton(
                        onClick = onToggleBookmark,
                        modifier = Modifier
                            .minimumInteractiveComponentSize()
                            .testTag("detail_bookmark_button")
                    ) {
                        Icon(
                            imageVector = if (isBookmarked) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = "Bookmark unit",
                            tint = if (isBookmarked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        UnitDetailContent(
            unit = unit,
            part = part,
            language = language,
            themePreference = themePreference,
            isCompleted = isCompleted,
            isBookmarked = isBookmarked,
            showInlineHeaderActions = false,
            onToggleCompleted = onToggleCompleted,
            onToggleBookmark = onToggleBookmark,
            onNavigateToUnit = onNavigateToUnit,
            onStartPartTest = onStartPartTest,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun UnitDetailContent(
    unit: GrammarUnitSummary,
    part: GrammarPart?,
    language: AppLanguage,
    themePreference: ThemePreference,
    isCompleted: Boolean,
    isBookmarked: Boolean,
    showInlineHeaderActions: Boolean,
    onToggleCompleted: () -> Unit,
    onToggleBookmark: () -> Unit,
    onNavigateToUnit: (String) -> Unit,
    onStartPartTest: (GrammarPart) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val isDark = isAppDarkTheme(themePreference)
    val accent = part?.let { partAccentColor(it.accent) } ?: MaterialTheme.colorScheme.primary
    val unitQuestions = remember(unit.id) { GrammarQuizRepository.getQuestionsForUnit(unit.id) }
    val selectedAnswers = remember(unit.id) { mutableStateMapOf<String, Int>() }

    val allUnits = GrammarBookRepository.allUnits
    val currentIdx = remember(unit.id) { allUnits.indexOfFirst { it.id == unit.id } }
    val prevUnit = if (currentIdx > 0) allUnits[currentIdx - 1] else null
    val nextUnit = if (currentIdx in 0 until allUnits.lastIndex) allUnits[currentIdx + 1] else null

    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .widthIn(max = 760.dp)
                .fillMaxSize()
                .navigationBarsPadding(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header Card
            item(key = "header_${unit.id}") {
                Card(
                    shape = MaterialTheme.shapes.large,
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = accent.copy(alpha = 0.14f)
                                ) {
                                    LtrEnglishContent {
                                        Text(
                                            text = unit.unitBadge,
                                            style = MaterialTheme.typography.labelMedium.forEnglishGrammar(),
                                            color = accent,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                                        )
                                    }
                                }
                                if (part != null) {
                                    Text(
                                        text = formatBilingualText(
                                            if (language == AppLanguage.ARABIC) part.titleAr else part.titleEn,
                                            language
                                        ),
                                        style = MaterialTheme.typography.labelMedium.forLanguage(language),
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }

                            if (showInlineHeaderActions) {
                                IconButton(
                                    onClick = onToggleBookmark,
                                    modifier = Modifier.minimumInteractiveComponentSize()
                                ) {
                                    Icon(
                                        imageVector = if (isBookmarked) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                                        contentDescription = "Bookmark unit",
                                        tint = if (isBookmarked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }

                        if (language == AppLanguage.ARABIC) {
                            Text(
                                text = formatBilingualText(unit.titleAr, language),
                                style = MaterialTheme.typography.headlineSmall.forLanguage(language),
                                color = MaterialTheme.colorScheme.onSurface,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        LtrEnglishContent {
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = unit.titleEn,
                                    style = MaterialTheme.typography.titleMedium.forEnglishGrammar().copy(
                                        fontWeight = FontWeight.Bold
                                    ),
                                    color = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                                )
                            }
                        }

                        Text(
                            text = formatBilingualText(
                                if (language == AppLanguage.ARABIC) unit.tldrAr else unit.tldrEn,
                                language
                            ),
                            style = MaterialTheme.typography.bodyLarge.forLanguage(language),
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Button(
                            onClick = onToggleCompleted,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isCompleted) {
                                    if (isDark) GrammarSuccessBgDark else GrammarSuccessBgLight
                                } else {
                                    MaterialTheme.colorScheme.primary
                                },
                                contentColor = if (isCompleted) {
                                    if (isDark) GrammarSuccessDark else GrammarSuccessLight
                                } else {
                                    MaterialTheme.colorScheme.onPrimary
                                }
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .minimumInteractiveComponentSize()
                                .testTag("mark_studied_button")
                        ) {
                            Icon(
                                imageVector = if (isCompleted) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircle,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = when {
                                    isCompleted && language == AppLanguage.ARABIC -> "تمت دراسة هذه الوحدة ✓"
                                    isCompleted -> "Marked as Studied ✓"
                                    language == AppLanguage.ARABIC -> "تحديد كوحدة مفهومة"
                                    else -> "Mark Unit as Studied"
                                },
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }
                }
            }

            // Formula Card
            item(key = "formula_${unit.id}") {
                FormulaBannerCard(
                    formulaEn = unit.formulaEn,
                    language = language
                )
            }

            // Key Points
            item(key = "keypoints_${unit.id}") {
                val points = if (language == AppLanguage.ARABIC) unit.keyPointsAr else unit.keyPointsEn
                SectionCard(
                    title = if (language == AppLanguage.ARABIC) "خلاصة القواعد الأساسية" else "Core Rules Summary",
                    language = language
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        points.forEachIndexed { idx, point ->
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                verticalAlignment = Alignment.Top,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Box(
                                    modifier = Modifier
                                        .padding(top = 3.dp)
                                        .size(22.dp)
                                        .clip(CircleShape)
                                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "${idx + 1}",
                                        style = MaterialTheme.typography.labelSmall.forEnglishGrammar(),
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Text(
                                    text = formatBilingualText(point, language),
                                    style = MaterialTheme.typography.bodyMedium.forLanguage(language),
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }
                }
            }

            // Examples
            item(key = "examples_${unit.id}") {
                SectionCard(
                    title = if (language == AppLanguage.ARABIC) "أمثلة تطبيقية من الكتاب" else "Examples in Context",
                    language = language
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        unit.examples.forEach { example ->
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outlineVariant),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    modifier = Modifier.padding(12.dp),
                                    verticalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    LtrEnglishContent {
                                        Surface(
                                            shape = RoundedCornerShape(8.dp),
                                            color = MaterialTheme.colorScheme.surface,
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Text(
                                                text = example.sentenceEn,
                                                style = MaterialTheme.typography.titleSmall.forEnglishGrammar().copy(
                                                    fontWeight = FontWeight.SemiBold
                                                ),
                                                color = MaterialTheme.colorScheme.onSurface,
                                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
                                            )
                                        }
                                    }
                                    Text(
                                        text = formatBilingualText(
                                            if (language == AppLanguage.ARABIC) example.noteAr else example.noteEn,
                                            language
                                        ),
                                        style = MaterialTheme.typography.bodySmall.forLanguage(language),
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Structure Table
            item(key = "table_${unit.id}") {
                SectionCard(
                    title = if (language == AppLanguage.ARABIC) "جدول التراكيب" else "Structure Breakdown",
                    language = language
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        unit.structureTable.forEachIndexed { index, row ->
                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = formatBilingualText(
                                        if (language == AppLanguage.ARABIC) row.formAr else row.formEn,
                                        language
                                    ),
                                    style = MaterialTheme.typography.labelLarge.forLanguage(language),
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.Bold
                                )
                                LtrEnglishContent {
                                    Surface(
                                        shape = RoundedCornerShape(8.dp),
                                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                                            verticalArrangement = Arrangement.spacedBy(2.dp)
                                        ) {
                                            Text(
                                                text = row.structureEn,
                                                style = MaterialTheme.typography.labelMedium.forEnglishGrammar(),
                                                color = MaterialTheme.colorScheme.secondary
                                            )
                                            Text(
                                                text = row.exampleEn,
                                                style = MaterialTheme.typography.bodyMedium.forEnglishGrammar(),
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                        }
                                    }
                                }
                            }
                            if (index < unit.structureTable.lastIndex) {
                                HorizontalDivider(
                                    color = MaterialTheme.colorScheme.outlineVariant,
                                    modifier = Modifier.padding(vertical = 2.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Common Mistakes
            if (unit.mistakes.isNotEmpty()) {
                item(key = "mistakes_${unit.id}") {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.error,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = if (language == AppLanguage.ARABIC) "انتبه للأخطاء الشائعة" else "Common Mistakes to Avoid",
                                style = MaterialTheme.typography.titleMedium.forLanguage(language),
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        unit.mistakes.forEach { mistake ->
                            MistakeComparisonCard(
                                mistake = mistake,
                                language = language,
                                isDark = isDark
                            )
                        }
                    }
                }
            }

            // Murphy Tip
            item(key = "tip_${unit.id}") {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.7f),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary.copy(alpha = 0.4f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Icon(
                            imageVector = Icons.Default.Lightbulb,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier.size(22.dp)
                        )
                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = if (language == AppLanguage.ARABIC) "نصيحة مورفي الذهبية" else "Murphy's Golden Tip",
                                style = MaterialTheme.typography.labelLarge.forLanguage(language),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = formatBilingualText(
                                    if (language == AppLanguage.ARABIC) unit.murphyTipAr else unit.murphyTipEn,
                                    language
                                ),
                                style = MaterialTheme.typography.bodyMedium.forLanguage(language),
                                color = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                        }
                    }
                }
            }

            // Inline Mini Quick-Check Quiz + Full Part Test Launcher
            if (unitQuestions.isNotEmpty()) {
                item(key = "quick_check_${unit.id}") {
                    UnitQuickCheckSection(
                        questions = unitQuestions,
                        selectedAnswers = selectedAnswers,
                        language = language,
                        isDark = isDark,
                        onSelectOption = { qId, optIdx ->
                            if (qId !in selectedAnswers) {
                                selectedAnswers[qId] = optIdx
                            }
                        }
                    )
                }
            }

            if (part != null) {
                val partQuestionsCount = GrammarQuizRepository.getQuestionsForPart(part.id).size
                if (partQuestionsCount > 0) {
                    item(key = "part_test_cta_${unit.id}") {
                        OutlinedButton(
                            onClick = { onStartPartTest(part) },
                            shape = RoundedCornerShape(14.dp),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
                            modifier = Modifier
                                .fillMaxWidth()
                                .minimumInteractiveComponentSize()
                                .testTag("unit_part_test_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Quiz,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = formatBilingualText(
                                    if (language == AppLanguage.ARABIC) {
                                        "اختبار القسم ${part.number} كامل ($partQuestionsCount أسئلة)"
                                    } else {
                                        "Take Full Part ${part.number} Test ($partQuestionsCount Questions)"
                                    },
                                    language
                                ),
                                style = MaterialTheme.typography.labelLarge.forLanguage(language),
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }
                    }
                }
            }

            // Previous / Next Unit Navigation
            item(key = "nav_footer_${unit.id}") {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, bottom = 12.dp)
                ) {
                    if (prevUnit != null) {
                        OutlinedButton(
                            onClick = { onNavigateToUnit(prevUnit.id) },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .minimumInteractiveComponentSize()
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            LtrEnglishContent {
                                Text(
                                    text = prevUnit.unitBadge,
                                    style = MaterialTheme.typography.labelLarge.forEnglishGrammar(),
                                    maxLines = 1
                                )
                            }
                        }
                    }
                    if (nextUnit != null) {
                        Button(
                            onClick = { onNavigateToUnit(nextUnit.id) },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .minimumInteractiveComponentSize()
                                .testTag("next_unit_button")
                        ) {
                            Text(
                                text = formatBilingualText(
                                    if (language == AppLanguage.ARABIC) "التالي: ${nextUnit.unitBadge}" else "Next: ${nextUnit.unitBadge}",
                                    language
                                ),
                                style = MaterialTheme.typography.labelLarge.forLanguage(language),
                                maxLines = 1
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SectionCard(
    title: String,
    language: AppLanguage,
    content: @Composable () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.forLanguage(language),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            content()
        }
    }
}

@Composable
private fun UnitQuickCheckSection(
    questions: List<GrammarQuizQuestion>,
    selectedAnswers: Map<String, Int>,
    language: AppLanguage,
    isDark: Boolean,
    onSelectOption: (String, Int) -> Unit
) {
    val okColor = if (isDark) GrammarSuccessDark else GrammarSuccessLight
    val okBg = if (isDark) GrammarSuccessBgDark else GrammarSuccessBgLight
    val errColor = if (isDark) GrammarErrorDark else GrammarErrorLight
    val errBg = if (isDark) GrammarErrorBgDark else GrammarErrorBgLight

    Card(
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.35f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Quiz,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = if (language == AppLanguage.ARABIC) "اختبر فهمك للوحدة" else "Quick Unit Check",
                    style = MaterialTheme.typography.titleMedium.forLanguage(language),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            questions.forEach { q ->
                val chosen = selectedAnswers[q.id]
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    if (language == AppLanguage.ARABIC) {
                        Text(
                            text = formatBilingualText(q.promptAr, language),
                            style = MaterialTheme.typography.bodySmall.forLanguage(language),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    LtrEnglishContent {
                        Text(
                            text = q.promptEn,
                            style = MaterialTheme.typography.titleSmall.forEnglishGrammar().copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    q.options.forEachIndexed { idx, opt ->
                        val isChosen = chosen == idx
                        val isCorrect = idx == q.correctIndex
                        val bgColor = when {
                            chosen == null -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                            isCorrect -> okBg
                            isChosen -> errBg
                            else -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
                        }
                        val borderColor = when {
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
                            onClick = { onSelectOption(q.id, idx) },
                            shape = RoundedCornerShape(10.dp),
                            color = bgColor,
                            border = BorderStroke(1.dp, borderColor),
                            modifier = Modifier
                                .fillMaxWidth()
                                .minimumInteractiveComponentSize()
                        ) {
                            LtrEnglishContent {
                                Text(
                                    text = opt,
                                    style = MaterialTheme.typography.bodyMedium.forEnglishGrammar().copy(
                                        fontWeight = if (isChosen || (chosen != null && isCorrect)) FontWeight.Bold else FontWeight.Medium
                                    ),
                                    color = textColor,
                                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp)
                                )
                            }
                        }
                    }

                    AnimatedVisibility(visible = chosen != null) {
                        Text(
                            text = formatBilingualText(
                                if (language == AppLanguage.ARABIC) q.explanationAr else q.explanationEn,
                                language
                            ),
                            style = MaterialTheme.typography.bodySmall.forLanguage(language),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                                .padding(10.dp)
                        )
                    }
                }
            }
        }
    }
}
