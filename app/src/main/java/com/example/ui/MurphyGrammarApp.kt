package com.example.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.GrammarBookRepository
import com.example.model.AppLanguage
import com.example.model.MainTab
import com.example.model.WindowWidthSize
import com.example.ui.components.windowWidthSizeFromDp
import com.example.ui.screens.ChaptersScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.PracticeScreen
import com.example.ui.screens.SavedScreen
import com.example.ui.screens.UnitDetailScreen
import com.example.ui.theme.MurphyGrammarTheme
import com.example.viewmodel.GrammarViewModel

private data class NavDestination(
    val tab: MainTab,
    val labelAr: String,
    val labelEn: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val testTag: String
)

private val navDestinations = listOf(
    NavDestination(
        tab = MainTab.HOME,
        labelAr = "الرئيسية",
        labelEn = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        testTag = "nav_home"
    ),
    NavDestination(
        tab = MainTab.CHAPTERS,
        labelAr = "الفصول",
        labelEn = "Chapters",
        selectedIcon = Icons.AutoMirrored.Filled.MenuBook,
        unselectedIcon = Icons.AutoMirrored.Outlined.MenuBook,
        testTag = "nav_chapters"
    ),
    NavDestination(
        tab = MainTab.PRACTICE,
        labelAr = "تمارين",
        labelEn = "Practice",
        selectedIcon = Icons.Filled.Quiz,
        unselectedIcon = Icons.Outlined.Quiz,
        testTag = "nav_practice"
    ),
    NavDestination(
        tab = MainTab.SAVED,
        labelAr = "المحفوظات",
        labelEn = "Saved",
        selectedIcon = Icons.Filled.Bookmark,
        unselectedIcon = Icons.Outlined.BookmarkBorder,
        testTag = "nav_saved"
    )
)

@Composable
fun MurphyGrammarApp(
    viewModel: GrammarViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val language = uiState.progress.language
    val layoutDirection = if (language == AppLanguage.ARABIC) LayoutDirection.Rtl else LayoutDirection.Ltr

    MurphyGrammarTheme(themePreference = uiState.progress.themePreference) {
        CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
            BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                val windowWidthSize = windowWidthSizeFromDp(maxWidth)
                val isExpanded = windowWidthSize == WindowWidthSize.EXPANDED
                val activeDetailUnit = uiState.activeDetailUnitId?.let { GrammarBookRepository.getUnitById(it) }

                if (activeDetailUnit != null && !isExpanded) {
                    UnitDetailScreen(
                        unit = activeDetailUnit,
                        language = language,
                        themePreference = uiState.progress.themePreference,
                        isCompleted = activeDetailUnit.id in uiState.progress.completedUnitIds,
                        isBookmarked = activeDetailUnit.id in uiState.progress.bookmarkedUnitIds,
                        onBack = { viewModel.closeUnitDetail() },
                        onToggleCompleted = { viewModel.toggleUnitCompleted(activeDetailUnit.id) },
                        onToggleBookmark = { viewModel.toggleBookmark(activeDetailUnit.id) },
                        onToggleLanguage = { viewModel.toggleLanguage() },
                        onNavigateToUnit = { nextId -> viewModel.openUnit(nextId, isExpandedLayout = false) },
                        onStartPartTest = { part -> viewModel.startPartQuiz(part) }
                    )
                } else {
                    val useRail = windowWidthSize != WindowWidthSize.COMPACT

                    Scaffold(
                        contentWindowInsets = WindowInsets.safeDrawing,
                        containerColor = MaterialTheme.colorScheme.background,
                        bottomBar = {
                            if (!useRail) {
                                NavigationBar(
                                    containerColor = MaterialTheme.colorScheme.surface
                                ) {
                                    navDestinations.forEach { dest ->
                                        val selected = uiState.selectedTab == dest.tab
                                        NavigationBarItem(
                                            selected = selected,
                                            onClick = { viewModel.selectTab(dest.tab) },
                                            icon = {
                                                Icon(
                                                    imageVector = if (selected) dest.selectedIcon else dest.unselectedIcon,
                                                    contentDescription = if (language == AppLanguage.ARABIC) dest.labelAr else dest.labelEn
                                                )
                                            },
                                            label = {
                                                Text(
                                                    text = if (language == AppLanguage.ARABIC) dest.labelAr else dest.labelEn,
                                                    fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                                                    maxLines = 1
                                                )
                                            },
                                            modifier = Modifier.testTag(dest.testTag)
                                        )
                                    }
                                }
                            }
                        }
                    ) { innerPadding ->
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                        ) {
                            if (useRail) {
                                NavigationRail(
                                    containerColor = MaterialTheme.colorScheme.surface,
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .windowInsetsPadding(WindowInsets(0))
                                ) {
                                    Spacer(modifier = Modifier.weight(0.15f))
                                    navDestinations.forEach { dest ->
                                        val selected = uiState.selectedTab == dest.tab
                                        NavigationRailItem(
                                            selected = selected,
                                            onClick = { viewModel.selectTab(dest.tab) },
                                            icon = {
                                                Icon(
                                                    imageVector = if (selected) dest.selectedIcon else dest.unselectedIcon,
                                                    contentDescription = if (language == AppLanguage.ARABIC) dest.labelAr else dest.labelEn
                                                )
                                            },
                                            label = {
                                                Text(
                                                    text = if (language == AppLanguage.ARABIC) dest.labelAr else dest.labelEn,
                                                    fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                                                    maxLines = 1
                                                )
                                            },
                                            modifier = Modifier.testTag(dest.testTag)
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                                VerticalDivider(
                                    modifier = Modifier.width(1.dp),
                                    color = MaterialTheme.colorScheme.outlineVariant
                                )
                            }

                            Box(modifier = Modifier.weight(1f).fillMaxHeight()) {
                                Crossfade(
                                    targetState = uiState.selectedTab,
                                    label = "main_tab_crossfade"
                                ) { tab ->
                                    when (tab) {
                                        MainTab.HOME -> HomeScreen(
                                            uiState = uiState,
                                            windowWidthSize = windowWidthSize,
                                            onToggleLanguage = { viewModel.toggleLanguage() },
                                            onContinueUnit = { id -> viewModel.openUnit(id, isExpandedLayout = isExpanded) },
                                            onOpenPart = { partId -> viewModel.openPartInChapters(partId) },
                                            onStartMixedQuiz = { viewModel.startMixedQuiz() }
                                        )
                                        MainTab.CHAPTERS -> ChaptersScreen(
                                            uiState = uiState,
                                            windowWidthSize = windowWidthSize,
                                            onSearchQueryChange = { viewModel.updateSearchQuery(it) },
                                            onSelectPartFilter = { viewModel.selectPartFilter(it) },
                                            onSelectUnit = { id -> viewModel.openUnit(id, isExpandedLayout = isExpanded) },
                                            onToggleBookmark = { id -> viewModel.toggleBookmark(id) },
                                            onToggleCompleted = { id -> viewModel.toggleUnitCompleted(id) },
                                            onToggleLanguage = { viewModel.toggleLanguage() },
                                            onStartPartTest = { part -> viewModel.startPartQuiz(part) }
                                        )
                                        MainTab.PRACTICE -> PracticeScreen(
                                            uiState = uiState,
                                            windowWidthSize = windowWidthSize,
                                            onStartMixedQuiz = { viewModel.startMixedQuiz() },
                                            onStartUnstudiedQuiz = { viewModel.startUnstudiedQuiz() },
                                            onStartPartQuiz = { part -> viewModel.startPartQuiz(part) },
                                            onRetryCurrentQuiz = { viewModel.retryCurrentQuiz() },
                                            onSelectOption = { idx -> viewModel.selectQuizOption(idx) },
                                            onAdvanceQuiz = { viewModel.advanceQuiz() },
                                            onExitQuiz = { viewModel.exitQuiz() },
                                            onToggleLanguage = { viewModel.toggleLanguage() }
                                        )
                                        MainTab.SAVED -> SavedScreen(
                                            uiState = uiState,
                                            windowWidthSize = windowWidthSize,
                                            onSelectUnit = { id -> viewModel.openUnit(id, isExpandedLayout = isExpanded) },
                                            onToggleBookmark = { id -> viewModel.toggleBookmark(id) },
                                            onSetLanguage = { lang -> viewModel.setLanguage(lang) },
                                            onSetTheme = { theme -> viewModel.setThemePreference(theme) },
                                            onResetProgress = { viewModel.resetProgress() },
                                            onBrowseChapters = { viewModel.selectTab(MainTab.CHAPTERS) }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
