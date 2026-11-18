package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.BrightnessAuto
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.GrammarBookRepository
import com.example.model.AppLanguage
import com.example.model.ThemePreference
import com.example.model.WindowWidthSize
import com.example.ui.components.UnitSummaryCard
import com.example.ui.components.forEnglishGrammar
import com.example.ui.components.forLanguage
import com.example.ui.components.partAccentColor
import com.example.viewmodel.GrammarUiState

@Composable
fun SavedScreen(
    uiState: GrammarUiState,
    windowWidthSize: WindowWidthSize,
    onSelectUnit: (String) -> Unit,
    onToggleBookmark: (String) -> Unit,
    onSetLanguage: (AppLanguage) -> Unit,
    onSetTheme: (ThemePreference) -> Unit,
    onResetProgress: () -> Unit,
    onBrowseChapters: () -> Unit,
    modifier: Modifier = Modifier
) {
    val language = uiState.progress.language
    val bookmarkedUnits = remember(uiState.progress.bookmarkedUnitIds) {
        uiState.allUnits.filter { it.id in uiState.progress.bookmarkedUnitIds }
    }
    var showResetDialog by remember { mutableStateOf(false) }

    if (showResetDialog) {
        AlertDialog(
            onDismissRequest = { showResetDialog = false },
            title = {
                Text(
                    text = if (language == AppLanguage.ARABIC) "إعادة ضبط التقدّم" else "Reset Progress",
                    style = MaterialTheme.typography.titleLarge.forLanguage(language)
                )
            },
            text = {
                Text(
                    text = if (language == AppLanguage.ARABIC) {
                        "هل أنت متأكد من مسح سجل الوحدات المدروسة والمفضلة ونتائج الاختبارات؟"
                    } else {
                        "Are you sure you want to clear studied units, bookmarks, and quiz scores?"
                    },
                    style = MaterialTheme.typography.bodyMedium.forLanguage(language)
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onResetProgress()
                        showResetDialog = false
                    }
                ) {
                    Text(
                        text = if (language == AppLanguage.ARABIC) "مسح" else "Reset",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            dismissButton = {
                TextButton(onClick = { showResetDialog = false }) {
                    Text(if (language == AppLanguage.ARABIC) "إلغاء" else "Cancel")
                }
            }
        )
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .widthIn(max = 980.dp)
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item(key = "saved_header") {
                Text(
                    text = if (language == AppLanguage.ARABIC) "المحفوظات والإعدادات" else "Saved & Settings",
                    style = MaterialTheme.typography.headlineSmall.forLanguage(language),
                    fontWeight = FontWeight.Bold
                )
            }

            // Preferences Card (Language & Theme)
            item(key = "preferences_card") {
                Card(
                    shape = MaterialTheme.shapes.large,
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Text(
                            text = if (language == AppLanguage.ARABIC) "لغة الشرح والواجهة" else "Explanation & UI Language",
                            style = MaterialTheme.typography.titleSmall.forLanguage(language),
                            fontWeight = FontWeight.Bold
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            FilterChip(
                                selected = language == AppLanguage.ARABIC,
                                onClick = { onSetLanguage(AppLanguage.ARABIC) },
                                label = {
                                    Text(
                                        text = "العربية (شرح عربي + أمثلة إنجليزية)",
                                        style = MaterialTheme.typography.labelMedium.forLanguage(AppLanguage.ARABIC)
                                    )
                                },
                                modifier = Modifier.minimumInteractiveComponentSize()
                            )
                            FilterChip(
                                selected = language == AppLanguage.ENGLISH,
                                onClick = { onSetLanguage(AppLanguage.ENGLISH) },
                                label = {
                                    Text(
                                        text = "English",
                                        style = MaterialTheme.typography.labelMedium.forEnglishGrammar()
                                    )
                                },
                                modifier = Modifier.minimumInteractiveComponentSize()
                            )
                        }

                        Text(
                            text = if (language == AppLanguage.ARABIC) "المظهر" else "Appearance",
                            style = MaterialTheme.typography.titleSmall.forLanguage(language),
                            fontWeight = FontWeight.Bold
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            FilterChip(
                                selected = uiState.progress.themePreference == ThemePreference.SYSTEM,
                                onClick = { onSetTheme(ThemePreference.SYSTEM) },
                                leadingIcon = {
                                    Icon(Icons.Default.BrightnessAuto, contentDescription = null, modifier = Modifier.size(16.dp))
                                },
                                label = { Text(if (language == AppLanguage.ARABIC) "تلقائي" else "System") },
                                modifier = Modifier.minimumInteractiveComponentSize()
                            )
                            FilterChip(
                                selected = uiState.progress.themePreference == ThemePreference.LIGHT,
                                onClick = { onSetTheme(ThemePreference.LIGHT) },
                                leadingIcon = {
                                    Icon(Icons.Default.LightMode, contentDescription = null, modifier = Modifier.size(16.dp))
                                },
                                label = { Text(if (language == AppLanguage.ARABIC) "نهاري" else "Light") },
                                modifier = Modifier.minimumInteractiveComponentSize()
                            )
                            FilterChip(
                                selected = uiState.progress.themePreference == ThemePreference.DARK,
                                onClick = { onSetTheme(ThemePreference.DARK) },
                                leadingIcon = {
                                    Icon(Icons.Default.DarkMode, contentDescription = null, modifier = Modifier.size(16.dp))
                                },
                                label = { Text(if (language == AppLanguage.ARABIC) "ليلي" else "Dark") },
                                modifier = Modifier.minimumInteractiveComponentSize()
                            )
                        }

                        OutlinedButton(
                            onClick = { showResetDialog = true },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.minimumInteractiveComponentSize()
                        ) {
                            Icon(
                                imageVector = Icons.Default.DeleteOutline,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.error,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (language == AppLanguage.ARABIC) "إعادة ضبط التقدّم" else "Reset Study Progress",
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }

            item(key = "bookmarks_title") {
                Text(
                    text = if (language == AppLanguage.ARABIC) {
                        "الوحدات المحفوظة (${bookmarkedUnits.size})"
                    } else {
                        "Bookmarked Units (${bookmarkedUnits.size})"
                    },
                    style = MaterialTheme.typography.titleLarge.forLanguage(language),
                    fontWeight = FontWeight.Bold
                )
            }

            if (bookmarkedUnits.isEmpty()) {
                item(key = "empty_bookmarks") {
                    Card(
                        shape = MaterialTheme.shapes.large,
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty_bookmarks),
                                contentDescription = "No bookmarks yet",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .widthIn(max = 260.dp)
                                    .height(170.dp)
                                    .clip(RoundedCornerShape(16.dp))
                            )
                            Text(
                                text = if (language == AppLanguage.ARABIC) "لا توجد وحدات محفوظة بعد" else "No bookmarked units yet",
                                style = MaterialTheme.typography.titleMedium.forLanguage(language),
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = if (language == AppLanguage.ARABIC) {
                                    "اضغط على أيقونة الحفظ في أي وحدة للوصول السريع إليها عند المراجعة."
                                } else {
                                    "Tap the bookmark icon on any grammar unit to save it for quick review."
                                },
                                style = MaterialTheme.typography.bodyMedium.forLanguage(language),
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Button(
                                onClick = onBrowseChapters,
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier
                                    .minimumInteractiveComponentSize()
                                    .testTag("empty_browse_chapters_button")
                            ) {
                                Text(if (language == AppLanguage.ARABIC) "تصفح الفصول" else "Browse Chapters")
                            }
                        }
                    }
                }
            } else {
                val columns = if (windowWidthSize == WindowWidthSize.COMPACT) 1 else 2
                val chunked = bookmarkedUnits.chunked(columns)
                items(
                    count = chunked.size,
                    key = { rowIdx -> "saved_row_$rowIdx" }
                ) { rowIdx ->
                    val rowUnits = chunked[rowIdx]
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        rowUnits.forEach { unit ->
                            val part = GrammarBookRepository.getPartById(unit.partId)
                            val accentColor = part?.let { partAccentColor(it.accent) } ?: MaterialTheme.colorScheme.primary
                            val partTitle = if (language == AppLanguage.ARABIC) part?.titleAr.orEmpty() else part?.titleEn.orEmpty()
                            UnitSummaryCard(
                                unit = unit,
                                partTitle = partTitle,
                                accentColor = accentColor,
                                language = language,
                                isCompleted = unit.id in uiState.progress.completedUnitIds,
                                isBookmarked = true,
                                onClick = { onSelectUnit(unit.id) },
                                onToggleBookmark = { onToggleBookmark(unit.id) },
                                modifier = Modifier.weight(1f)
                            )
                        }
                        repeat(columns - rowUnits.size) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}
