package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.model.AppLanguage
import com.example.model.CommonMistake
import com.example.model.GrammarUnitSummary
import com.example.model.PartAccent
import com.example.model.ThemePreference
import com.example.model.WindowWidthSize
import com.example.ui.theme.GrammarErrorBgDark
import com.example.ui.theme.GrammarErrorBgLight
import com.example.ui.theme.GrammarErrorDark
import com.example.ui.theme.GrammarErrorLight
import com.example.ui.theme.GrammarSuccessBgDark
import com.example.ui.theme.GrammarSuccessBgLight
import com.example.ui.theme.GrammarSuccessDark
import com.example.ui.theme.GrammarSuccessLight
import com.example.ui.theme.PlusJakartaSansFontFamily

private const val LRI = "\u2066"
private const val PDI = "\u2069"

// Isolates contiguous Latin/grammar runs (including contractions, slashes, arrows, and symbols)
// inside Arabic RTL text so punctuation and word order never flip or misalign.
private val INLINE_LATIN_REGEX = Regex(
    """(?:['’]?[A-Za-z0-9][A-Za-z0-9'’/+→\-:.,!?]*(?:\s+(?:->|vs|or|and|&|\+|/|['’]?[A-Za-z0-9][A-Za-z0-9'’/+→\-:.,!?]*))*)"""
)

fun formatBilingualText(text: String, language: AppLanguage): String {
    if (language != AppLanguage.ARABIC) return text
    return INLINE_LATIN_REGEX.replace(text) { match ->
        val raw = match.value
        val trimmedEnd = raw.trimEnd(' ', '.', ',', ':', ';', '!', '?')
        val trailing = raw.substring(trimmedEnd.length)
        if (trimmedEnd.any { it in 'A'..'Z' || it in 'a'..'z' }) {
            "$LRI$trimmedEnd$PDI$trailing"
        } else {
            raw
        }
    }
}

fun TextStyle.forLanguage(language: AppLanguage): TextStyle = copy(
    textDirection = if (language == AppLanguage.ARABIC) TextDirection.Rtl else TextDirection.Ltr
)

fun TextStyle.forEnglishGrammar(): TextStyle = copy(
    fontFamily = PlusJakartaSansFontFamily,
    textDirection = TextDirection.Ltr
)

fun windowWidthSizeFromDp(maxWidth: Dp): WindowWidthSize = when {
    maxWidth < 600.dp -> WindowWidthSize.COMPACT
    maxWidth < 840.dp -> WindowWidthSize.MEDIUM
    else -> WindowWidthSize.EXPANDED
}

@Composable
fun LtrEnglishContent(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        content()
    }
}

@Composable
fun isAppDarkTheme(themePreference: ThemePreference): Boolean = when (themePreference) {
    ThemePreference.SYSTEM -> isSystemInDarkTheme()
    ThemePreference.LIGHT -> false
    ThemePreference.DARK -> true
}

@Composable
fun partAccentColor(accent: PartAccent): Color = when (accent) {
    PartAccent.CRIMSON -> MaterialTheme.colorScheme.primary
    PartAccent.NAVY -> MaterialTheme.colorScheme.secondary
    PartAccent.AMBER -> MaterialTheme.colorScheme.tertiary
    PartAccent.EMERALD -> if (isSystemInDarkTheme()) GrammarSuccessDark else GrammarSuccessLight
}

@Composable
fun LanguageToggleChip(
    language: AppLanguage,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onToggle,
        shape = RoundedCornerShape(50),
        color = MaterialTheme.colorScheme.surfaceVariant,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = modifier
            .minimumInteractiveComponentSize()
            .testTag("language_toggle_chip")
    ) {
        LtrEnglishContent {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.padding(4.dp)
            ) {
                val isAr = language == AppLanguage.ARABIC
                Surface(
                    shape = RoundedCornerShape(50),
                    color = if (isAr) MaterialTheme.colorScheme.primary else Color.Transparent
                ) {
                    Text(
                        text = "عربي",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = if (isAr) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    )
                }
                Surface(
                    shape = RoundedCornerShape(50),
                    color = if (!isAr) MaterialTheme.colorScheme.primary else Color.Transparent
                ) {
                    Text(
                        text = "EN",
                        style = MaterialTheme.typography.labelMedium.forEnglishGrammar(),
                        fontWeight = FontWeight.Bold,
                        color = if (!isAr) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun FormulaBannerCard(
    formulaEn: String,
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.65f),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.35f)),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = if (language == AppLanguage.ARABIC) "القاعدة التركيبية" else "Key Structure Formula",
                style = MaterialTheme.typography.labelLarge.forLanguage(language),
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Bold
            )
            LtrEnglishContent {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = formulaEn,
                        style = MaterialTheme.typography.titleMedium.forEnglishGrammar().copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun MistakeComparisonCard(
    mistake: CommonMistake,
    language: AppLanguage,
    isDark: Boolean,
    modifier: Modifier = Modifier
) {
    val errColor = if (isDark) GrammarErrorDark else GrammarErrorLight
    val errBg = if (isDark) GrammarErrorBgDark else GrammarErrorBgLight
    val okColor = if (isDark) GrammarSuccessDark else GrammarSuccessLight
    val okBg = if (isDark) GrammarSuccessBgDark else GrammarSuccessBgLight

    Card(
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            LtrEnglishContent {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(errBg)
                        .padding(horizontal = 12.dp, vertical = 10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Incorrect",
                        tint = errColor,
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = mistake.wrongEn,
                        style = MaterialTheme.typography.bodyMedium.forEnglishGrammar().copy(
                            fontWeight = FontWeight.Medium
                        ),
                        color = errColor
                    )
                }
            }

            LtrEnglishContent {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(okBg)
                        .padding(horizontal = 12.dp, vertical = 10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Correct",
                        tint = okColor,
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = mistake.correctEn,
                        style = MaterialTheme.typography.bodyMedium.forEnglishGrammar().copy(
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = okColor
                    )
                }
            }

            Text(
                text = formatBilingualText(
                    if (language == AppLanguage.ARABIC) mistake.explanationAr else mistake.explanationEn,
                    language
                ),
                style = MaterialTheme.typography.bodySmall.forLanguage(language),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun UnitSummaryCard(
    unit: GrammarUnitSummary,
    partTitle: String,
    accentColor: Color,
    language: AppLanguage,
    isCompleted: Boolean,
    isBookmarked: Boolean,
    isSelected: Boolean = false,
    onClick: () -> Unit,
    onToggleBookmark: () -> Unit,
    modifier: Modifier = Modifier
) {
    val borderStroke = if (isSelected) {
        BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
    } else {
        BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    }

    Card(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) {
                MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.22f)
            } else {
                MaterialTheme.colorScheme.surface
            }
        ),
        border = borderStroke,
        modifier = modifier
            .fillMaxWidth()
            .testTag("unit_card_${unit.id}")
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
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
                        color = accentColor.copy(alpha = 0.14f)
                    ) {
                        LtrEnglishContent {
                            Text(
                                text = unit.unitBadge,
                                style = MaterialTheme.typography.labelMedium.forEnglishGrammar(),
                                color = accentColor,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                    Text(
                        text = formatBilingualText(partTitle, language),
                        style = MaterialTheme.typography.labelSmall.forLanguage(language),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    if (isCompleted) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Studied",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }

                IconButton(
                    onClick = onToggleBookmark,
                    modifier = Modifier
                        .minimumInteractiveComponentSize()
                        .testTag("bookmark_btn_${unit.id}")
                ) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                        contentDescription = if (isBookmarked) "Remove bookmark" else "Bookmark unit",
                        tint = if (isBookmarked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            if (language == AppLanguage.ARABIC) {
                Text(
                    text = formatBilingualText(unit.titleAr, language),
                    style = MaterialTheme.typography.titleMedium.forLanguage(language),
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
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
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )

            // Dedicated English Title + Formula Pill (clean LTR block with balanced hierarchy)
            LtrEnglishContent {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.65f),
                    border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outlineVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Text(
                            text = unit.titleEn,
                            style = MaterialTheme.typography.labelLarge.forEnglishGrammar().copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.primary,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = unit.formulaEn,
                            style = MaterialTheme.typography.labelSmall.forEnglishGrammar(),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}
