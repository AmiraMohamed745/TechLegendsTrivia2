package com.example.techlegendstrivia.ui.ui.view.dialog

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.techlegendstrivia.R
import com.example.techlegendstrivia.model.Level

data class AlertDialogPropertiesForSkipAndHelp(
    val dialogType: AlertDialogSkipAndHelp,
    val level: Level,
    @StringRes val title: Int,
    @StringRes val text: Int,
    val icon: ImageVector
)

data class AlertDialogPropertiesForGameOver(
    val score: Float,
    @StringRes val title: Int = R.string.game_over,
    @StringRes val text: Int = R.string.game_over_final_score,
    val icon: ImageVector = Icons.Default.EmojiEvents
)