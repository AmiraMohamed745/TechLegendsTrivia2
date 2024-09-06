package com.example.techlegendstrivia.model

import androidx.annotation.StringRes
import com.example.techlegendstrivia.R

enum class Level(
    @StringRes val displayNameRes: Int,
    val skips: Int,
    @StringRes val skipsWarning: Int,
    val helps: Int,
    @StringRes val helpsWarning: Int,) {
    EASY(
        displayNameRes = R.string.easy_level,
        skips = 5,
        skipsWarning = R.string.easy_skips_warning,
        helps = 3,
        helpsWarning = R.string.easy_helps_warning
    ),
    MEDIUM(
        displayNameRes = R.string.medium_level,
        skips = 3,
        skipsWarning = R.string.medium_skips_warning,
        helps = 2,
        helpsWarning = R.string.medium_helps_warning
    ),
    ADVANCED(
        displayNameRes = R.string.advanced_level,
        skips = 1,
        skipsWarning = R.string.advanced_skips_warning,
        helps = 1,
        helpsWarning = R.string.advanced_helps_warning
    )
}




