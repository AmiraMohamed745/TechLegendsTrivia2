package com.example.techlegendstrivia.model

import androidx.annotation.StringRes

data class Question(
    @StringRes val question: Int,
    @StringRes val multipleChoices: List<Int>,
    @StringRes val correctAnswer: Int
)