package com.example.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.GrammarBookRepository
import com.example.model.AppLanguage
import com.example.model.GrammarPart
import com.example.model.GrammarUnitSummary
import com.example.model.WindowWidthSize
import com.example.ui.components.LanguageToggleChip
import com.example.ui.components.UnitSummaryCard
import com.example.ui.components.forLanguage
import com.example.ui.components.formatBilingualText
import com.example.ui.components.partAccentColor
import com.example.viewmodel.GrammarUiState

@Composable
fun ChaptersScreen(
    uiState: GrammarUiState,
    windowWidthSize: WindowWidthSize,
    onSearchQueryChange: (String) -> Unit,
    onSelectPartFilter: (String?) -> Unit,
    onSelectUnit: (String) -> Unit,
    onToggleBookmark: (String) -> Unit,
    onToggleCompleted: (String) -> Unit,
    onToggleLanguage: () -> Unit,
    onStartPartTest: (GrammarPart) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val language = uiState.progress.language
    val filteredUnits = uiState.filteredUnits

    if (windowWidthSize == WindowWidthSize.EXPANDED) {
        // Canonical List-Detail Layout for Large Screens / Tablets
        Row(modifier = modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .weight(0.42f)
                    .fillMaxHeight()
            ) {
                ChaptersHeaderAndFilters(
                    language = language,
                    searchQuery = uiState.searchQuery,
                    parts = uiState.parts,
                    selectedPartFilterId = uiState.selectedPartFilterId,
                    onSearchQueryChange = onSearchQueryChange,
                    onSelectPartFilter = onSelectPartFilter,
                    onToggleLanguage = onToggleLanguage
                )

                UnitsList(
                    units = filteredUnits,
                    selectedUnitId = uiState.masterDetailSelectedUnitId,
                    highlightSelection = true,
                    columns = 1,
                    uiState = uiState,
                    onSelectUnit = onSelectUnit,
                    onToggleBookmark = onToggleBookmark,
                    modifier = Modifier.weight(1f)
                )
            }

            VerticalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            val activeUnit = GrammarBookRepository.getUnitById(uiState.masterDetailSelectedUnitId)
                ?: filteredUnits.firstOrNull()
                ?: uiState.allUnits.first()
            val part = GrammarBookRepository.getPartById(activeUnit.partId)

            UnitDetailContent(
                unit = activeUnit,
                part = part,
                language = language,
                themePreference = uiState.progress.themePreference,
                isCompleted = activeUnit.id in uiState.progress.completedUnitIds,
                isBookmarked = activeUnit.id in uiState.progress.bookmarkedUnitIds,
                showInlineHeaderActions = true,
                onToggleCompleted = { onToggleCompleted(activeUnit.id) },
                onToggleBookmark = { onToggleBookmark(activeUnit.id) },
                onNavigateToUnit = onSelectUnit,
                onStartPartTest = onStartPartTest,
                modifier = Modifier
                    .weight(0.58f)
                    .fillMaxHeight()
            )
        }
    } else {
        // Compact (1-col) & Medium (2-col)
        val columns = if (windowWidthSize == WindowWidthSize.MEDIUM) 2 else 1
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .widthIn(max = 900.dp)
                    .fillMaxSize()
            ) {
                ChaptersHeaderAndFilters(
                    language = language,
                    searchQuery = uiState.searchQuery,
                    parts = uiState.parts,
                    selectedPartFilterId = uiState.selectedPartFilterId,
                    onSearchQueryChange = onSearchQueryChange,
                    onSelectPartFilter = onSelectPartFilter,
                    onToggleLanguage = onToggleLanguage
                )

                UnitsList(
                    units = filteredUnits,
                    selectedUnitId = null,
                    highlightSelection = false,
                    columns = columns,
                    uiState = uiState,
                    onSelectUnit = onSelectUnit,
                    onToggleBookmark = onToggleBookmark,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun ChaptersHeaderAndFilters(
    language: AppLanguage,
    searchQuery: String,
    parts: List<GrammarPart>,
    selectedPartFilterId: String?,
    onSearchQueryChange: (String) -> Unit,
    onSelectPartFilter: (String?) -> Unit,
    onToggleLanguage: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = if (language == AppLanguage.ARABIC) "فصول وملخصات الكتاب" else "Book Chapters & Summaries",
                style = MaterialTheme.typography.headlineSmall.forLanguage(language),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            LanguageToggleChip(
                language = language,
                onToggle = onToggleLanguage
            )
        }

        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            singleLine = true,
            shape = RoundedCornerShape(14.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(
                        onClick = { onSearchQueryChange("") },
                        modifier = Modifier.minimumInteractiveComponentSize()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Clear search"
                        )
                    }
                }
            },
            placeholder = {
                Text(
                    text = formatBilingualText(
                        if (language == AppLanguage.ARABIC) {
                            "ابحث عن قاعدة أو زمن أو رقم وحدة (مثل Unit 15)..."
                        } else {
                            "Search rule, tense, or unit (e.g. Unit 15)..."
                        },
                        language
                    ),
                    style = MaterialTheme.typography.bodyMedium.forLanguage(language)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .testTag("chapters_search_input")
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item(key = "filter_all") {
                FilterChip(
                    selected = selectedPartFilterId == null,
                    onClick = { onSelectPartFilter(null) },
                    label = {
                        Text(
                            text = if (language == AppLanguage.ARABIC) "كل الفصول" else "All Parts",
                            style = MaterialTheme.typography.labelLarge.forLanguage(language)
                        )
                    },
                    modifier = Modifier.minimumInteractiveComponentSize()
                )
            }
            items(items = parts, key = { it.id }) { part ->
                FilterChip(
                    selected = selectedPartFilterId == part.id,
                    onClick = {
                        onSelectPartFilter(if (selectedPartFilterId == part.id) null else part.id)
                    },
                    label = {
                        Text(
                            text = formatBilingualText(
                                "${part.number}. " + if (language == AppLanguage.ARABIC) part.titleAr else part.titleEn,
                                language
                            ),
                            style = MaterialTheme.typography.labelLarge.forLanguage(language),
                            maxLines = 1
                        )
                    },
                    modifier = Modifier.minimumInteractiveComponentSize()
                )
            }
        }
    }
}

@Composable
private fun UnitsList(
    units: List<GrammarUnitSummary>,
    selectedUnitId: String?,
    highlightSelection: Boolean,
    columns: Int,
    uiState: GrammarUiState,
    onSelectUnit: (String) -> Unit,
    onToggleBookmark: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val language = uiState.progress.language

    if (units.isEmpty()) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.SearchOff,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(48.dp)
                )
                Text(
                    text = if (language == AppLanguage.ARABIC) "لم نجد وحدات مطابقة لبحثك" else "No matching grammar units found",
                    style = MaterialTheme.typography.titleMedium.forLanguage(language),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        return
    }

    val chunkedUnits = units.chunked(columns)
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            count = chunkedUnits.size,
            key = { rowIdx -> "units_row_${chunkedUnits[rowIdx].first().id}" }
        ) { rowIdx ->
            val rowUnits = chunkedUnits[rowIdx]
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
                        isBookmarked = unit.id in uiState.progress.bookmarkedUnitIds,
                        isSelected = highlightSelection && unit.id == selectedUnitId,
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
        item(key = "bottom_spacer") {
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}
