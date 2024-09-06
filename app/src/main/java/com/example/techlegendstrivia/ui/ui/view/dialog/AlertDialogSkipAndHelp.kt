package com.example.techlegendstrivia.ui.ui.view.dialog

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.techlegendstrivia.R

enum class AlertDialogSkipAndHelp(@StringRes val title: Int, val icon: ImageVector) {
    SKIP(title = R.string.no_more_skips, icon = Icons.Default.SkipNext),
    HELP(title = R.string.no_more_helps, icon = Icons.AutoMirrored.Filled.Help)
}
