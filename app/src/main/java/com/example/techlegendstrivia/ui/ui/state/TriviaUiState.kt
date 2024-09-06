package com.example.techlegendstrivia.ui.ui.state

import com.example.techlegendstrivia.R
import com.example.techlegendstrivia.model.Level
import com.example.techlegendstrivia.model.Question
import com.example.techlegendstrivia.ui.ui.view.dialog.AlertDialogPropertiesForGameOver
import com.example.techlegendstrivia.ui.ui.view.dialog.AlertDialogPropertiesForSkipAndHelp

const val MAX_QUESTION_NUMBER: Int = 10

data class TriviaUiState(
    val currentLevel: Level = Level.EASY,
    val currentQuestion: Question? = null,
    val selectedAnswer: Int? = null,
    val highlightedCorrectAnswer: Int? = null,
    val isAnswerSelected: Boolean = false,
    val isAnswerCorrect: Boolean = false,
    val correctAnswerImage: Int = R.drawable.image_placeholder,
    val isQuestionVisible: Boolean = true,
    val skipTimes: Int = currentLevel.skips,
    val helpTimes: Int = currentLevel.helps,
    val showAlertDialogSkipAndHelp: Boolean = false,
    val alertDialogPropertiesForSkipAndHelp: AlertDialogPropertiesForSkipAndHelp? = null,
    val showAlertDialogGameOver: Boolean = false,
    val alertDialogPropertiesForGameOver: AlertDialogPropertiesForGameOver? = null,
    val questionCounter: Int = 0,
    val score: Float = 0.0f
)

