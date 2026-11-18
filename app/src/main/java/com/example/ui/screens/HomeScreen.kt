package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.AppLanguage
import com.example.model.GrammarPart
import com.example.model.GrammarUnitSummary
import com.example.model.WindowWidthSize
import com.example.ui.components.LanguageToggleChip
import com.example.ui.components.LtrEnglishContent
import com.example.ui.components.forEnglishGrammar
import com.example.ui.components.forLanguage
import com.example.ui.components.formatBilingualText
import com.example.ui.components.partAccentColor
import com.example.ui.theme.LoraFontFamily
import com.example.viewmodel.GrammarUiState

@Composable
fun HomeScreen(
    uiState: GrammarUiState,
    windowWidthSize: WindowWidthSize,
    onToggleLanguage: () -> Unit,
    onContinueUnit: (String) -> Unit,
    onOpenPart: (String) -> Unit,
    onStartMixedQuiz: () -> Unit,
    modifier: Modifier = Modifier
) {
    val language = uiState.progress.language
    val totalUnits = uiState.allUnits.size
    val completedCount = uiState.progress.completedUnitIds.size
    val progressFraction = if (totalUnits > 0) completedCount.toFloat() / totalUnits else 0f

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .widthIn(max = 1120.dp)
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            // Top Editorial Header
            item(key = "home_header") {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Text(
                            text = if (language == AppLanguage.ARABIC) {
                                "ملخص كتاب ريموند مورفي"
                            } else {
                                "Raymond Murphy Summary"
                            },
                            style = MaterialTheme.typography.headlineMedium.forLanguage(language),
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = formatBilingualText(
                                if (language == AppLanguage.ARABIC) {
                                    "دليل Essential Grammar in Use المبسط"
                                } else {
                                    "Essential Grammar in Use • Bilingual Edition"
                                },
                                language
                            ),
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontFamily = if (language == AppLanguage.ENGLISH) LoraFontFamily else MaterialTheme.typography.labelLarge.fontFamily
                            ).forLanguage(language),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    LanguageToggleChip(
                        language = language,
                        onToggle = onToggleLanguage
                    )
                }
            }

            // Responsive Hero + Progress Row
            item(key = "hero_section") {
                if (windowWidthSize == WindowWidthSize.COMPACT) {
                    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        HeroBookBanner(
                            language = language,
                            continueUnit = uiState.continueUnit,
                            onContinueClick = { onContinueUnit(uiState.continueUnit.id) },
                            onQuickQuizClick = onStartMixedQuiz
                        )
                        StatsRow(
                            completedCount = completedCount,
                            totalUnits = totalUnits,
                            bookmarkedCount = uiState.progress.bookmarkedUnitIds.size,
                            bestScore = uiState.progress.bestQuizScorePercent,
                            progressFraction = progressFraction,
                            language = language
                        )
                    }
                } else {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        HeroBookBanner(
                            language = language,
                            continueUnit = uiState.continueUnit,
                            onContinueClick = { onContinueUnit(uiState.continueUnit.id) },
                            onQuickQuizClick = onStartMixedQuiz,
                            modifier = Modifier.weight(1.25f)
                        )
                        StatsRow(
                            completedCount = completedCount,
                            totalUnits = totalUnits,
                            bookmarkedCount = uiState.progress.bookmarkedUnitIds.size,
                            bestScore = uiState.progress.bestQuizScorePercent,
                            progressFraction = progressFraction,
                            language = language,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            // Spotlight Rule Card
            item(key = "spotlight_card") {
                SpotlightRuleCard(
                    unit = uiState.spotlightUnit,
                    language = language,
                    onClick = { onContinueUnit(uiState.spotlightUnit.id) }
                )
            }

            // Book Syllabus Roadmap Title
            item(key = "parts_title") {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = if (language == AppLanguage.ARABIC) {
                            "خريطة الكتاب الكاملة (115 وحدة + الملاحق)"
                        } else {
                            "Complete Book Syllabus (115 Units + Appendices)"
                        },
                        style = MaterialTheme.typography.titleLarge.forLanguage(language),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.weight(1f)
                    )
                    Surface(
                        shape = RoundedCornerShape(50),
                        color = MaterialTheme.colorScheme.primaryContainer
                    ) {
                        Text(
                            text = if (language == AppLanguage.ARABIC) "${uiState.parts.size} قسماً" else "${uiState.parts.size} Parts",
                            style = MaterialTheme.typography.labelMedium.forLanguage(language),
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            // Responsive Multi-Column Parts Grid
            val columns = when (windowWidthSize) {
                WindowWidthSize.COMPACT -> 2
                WindowWidthSize.MEDIUM -> 3
                WindowWidthSize.EXPANDED -> 4
            }
            val chunkedParts = uiState.parts.chunked(columns)

            items(
                count = chunkedParts.size,
                key = { idx -> "parts_row_$idx" }
            ) { rowIdx ->
                val rowParts = chunkedParts[rowIdx]
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    rowParts.forEach { part ->
                        val partUnits = uiState.allUnits.filter { it.partId == part.id }
                        val partCompleted = partUnits.count { it.id in uiState.progress.completedUnitIds }
                        PartGridCard(
                            part = part,
                            completedInPart = partCompleted,
                            totalInPart = partUnits.size,
                            language = language,
                            onClick = { onOpenPart(part.id) },
                            modifier = Modifier.weight(1f)
                        )
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
private fun HeroBookBanner(
    language: AppLanguage,
    continueUnit: GrammarUnitSummary,
    onContinueClick: () -> Unit,
    onQuickQuizClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(containerColor = Color(0xFF7F1212)),
        modifier = modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.img_hero_grammar),
                contentDescription = "Essential Grammar in Use Book Illustration",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
                    .clip(MaterialTheme.shapes.extraLarge)
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xE86D0E0E),
                                Color(0xCC8A1515),
                                Color(0x99380909)
                            )
                        )
                    )
            )
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(50),
                    color = Color.White.copy(alpha = 0.18f)
                ) {
                    Text(
                        text = if (language == AppLanguage.ARABIC) {
                            "الدليل العملي لقواعد الإنجليزية"
                        } else {
                            "Cambridge Red Book • Quick Guide"
                        },
                        style = MaterialTheme.typography.labelMedium.forLanguage(language),
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
                    )
                }

                Text(
                    text = if (language == AppLanguage.ARABIC) {
                        "أتقن أساسيات القواعد بأسلوب مبسط ومنظّم"
                    } else {
                        "Master Essential English Grammar, Simplified"
                    },
                    style = MaterialTheme.typography.titleLarge.forLanguage(language),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                // Cohesive framed pill showing the resume unit in both languages cleanly
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color.Black.copy(alpha = 0.28f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        if (language == AppLanguage.ARABIC) {
                            Text(
                                text = formatBilingualText(continueUnit.titleAr, language),
                                style = MaterialTheme.typography.labelLarge.forLanguage(language),
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        LtrEnglishContent {
                            Text(
                                text = "${continueUnit.unitBadge} • ${continueUnit.titleEn}",
                                style = MaterialTheme.typography.bodySmall.forEnglishGrammar(),
                                color = Color.White.copy(alpha = 0.88f),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = onContinueClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color(0xFF8C1414)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .minimumInteractiveComponentSize()
                            .testTag("hero_continue_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (language == AppLanguage.ARABIC) "تابع الدراسة" else "Continue",
                            maxLines = 1
                        )
                    }

                    OutlinedButton(
                        onClick = onQuickQuizClick,
                        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.7f)),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .minimumInteractiveComponentSize()
                            .testTag("hero_quiz_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Quiz,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (language == AppLanguage.ARABIC) "اختبار سريع" else "Quiz",
                            maxLines = 1
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun StatsRow(
    completedCount: Int,
    totalUnits: Int,
    bookmarkedCount: Int,
    bestScore: Int,
    progressFraction: Float,
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = if (language == AppLanguage.ARABIC) "تقدّمك في الكتاب" else "Your Book Mastery",
                    style = MaterialTheme.typography.titleMedium.forLanguage(language),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${(progressFraction * 100).toInt()}%",
                    style = MaterialTheme.typography.titleMedium.forEnglishGrammar(),
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }

            LinearProgressIndicator(
                progress = { progressFraction },
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(50))
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                MiniStatTile(
                    icon = Icons.Default.CheckCircle,
                    value = "$completedCount/$totalUnits",
                    label = if (language == AppLanguage.ARABIC) "وحدات مدروسة" else "Studied",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.weight(1f)
                )
                MiniStatTile(
                    icon = Icons.Default.Bookmark,
                    value = "$bookmarkedCount",
                    label = if (language == AppLanguage.ARABIC) "محفوظة" else "Saved",
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.weight(1f)
                )
                MiniStatTile(
                    icon = Icons.Default.EmojiEvents,
                    value = "$bestScore%",
                    label = if (language == AppLanguage.ARABIC) "أفضل نتيجة" else "Best Quiz",
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun MiniStatTile(
    icon: ImageVector,
    value: String,
    label: String,
    tint: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f),
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 6.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = tint,
                modifier = Modifier.size(18.dp)
            )
            LtrEnglishContent {
                Text(
                    text = value,
                    style = MaterialTheme.typography.titleMedium.forEnglishGrammar(),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun SpotlightRuleCard(
    unit: GrammarUnitSummary,
    language: AppLanguage,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.45f)
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.28f)),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("spotlight_rule_card")
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.AutoAwesome,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = if (language == AppLanguage.ARABIC) "قاعدة مقترحة اليوم" else "Recommended Rule Spotlight",
                    style = MaterialTheme.typography.labelLarge.forLanguage(language),
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.14f)
                ) {
                    LtrEnglishContent {
                        Text(
                            text = unit.unitBadge,
                            style = MaterialTheme.typography.labelMedium.forEnglishGrammar(),
                            color = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }
            }

            if (language == AppLanguage.ARABIC) {
                Text(
                    text = formatBilingualText(unit.titleAr, language),
                    style = MaterialTheme.typography.titleMedium.forLanguage(language),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            LtrEnglishContent {
                Text(
                    text = unit.titleEn,
                    style = MaterialTheme.typography.labelLarge.forEnglishGrammar().copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Text(
                text = formatBilingualText(
                    if (language == AppLanguage.ARABIC) unit.tldrAr else unit.tldrEn,
                    language
                ),
                style = MaterialTheme.typography.bodyMedium.forLanguage(language),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun PartGridCard(
    part: GrammarPart,
    completedInPart: Int,
    totalInPart: Int,
    language: AppLanguage,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val accentColor = partAccentColor(part.accent)
    Card(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = modifier.testTag("part_card_${part.id}")
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = accentColor.copy(alpha = 0.14f)
                ) {
                    Text(
                        text = "${part.number}",
                        style = MaterialTheme.typography.labelMedium.forEnglishGrammar(),
                        color = accentColor,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.MenuBook,
                    contentDescription = null,
                    tint = accentColor,
                    modifier = Modifier.size(16.dp)
                )
            }

            Text(
                text = formatBilingualText(
                    if (language == AppLanguage.ARABIC) part.titleAr else part.titleEn,
                    language
                ),
                style = MaterialTheme.typography.titleSmall.forLanguage(language),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            // Subtle paired secondary title so learner connects Arabic & English terms effortlessly
            if (language == AppLanguage.ARABIC) {
                LtrEnglishContent {
                    Text(
                        text = part.titleEn,
                        style = MaterialTheme.typography.labelSmall.forEnglishGrammar(),
                        color = accentColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            } else {
                Text(
                    text = formatBilingualText(part.titleAr, AppLanguage.ARABIC),
                    style = MaterialTheme.typography.labelSmall.forLanguage(AppLanguage.ARABIC),
                    color = accentColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            LtrEnglishContent {
                Text(
                    text = part.unitRange,
                    style = MaterialTheme.typography.labelSmall.forEnglishGrammar(),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            val ratio = if (totalInPart > 0) completedInPart.toFloat() / totalInPart else 0f
            LinearProgressIndicator(
                progress = { ratio },
                color = accentColor,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .clip(RoundedCornerShape(50))
            )
        }
    }
}
