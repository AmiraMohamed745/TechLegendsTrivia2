package com.example.techlegendstrivia.ui.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.techlegendstrivia.data.QuestionsRepository
import com.example.techlegendstrivia.model.Level
import com.example.techlegendstrivia.ui.ui.state.MAX_QUESTION_NUMBER
import com.example.techlegendstrivia.ui.ui.state.TriviaUiState
import com.example.techlegendstrivia.ui.ui.view.dialog.AlertDialogPropertiesForGameOver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.techlegendstrivia.ui.ui.view.dialog.AlertDialogPropertiesForSkipAndHelp
import com.example.techlegendstrivia.ui.ui.view.dialog.AlertDialogSkipAndHelp


@HiltViewModel
class TriviaViewModel @Inject constructor(
    private val questionsRepository: QuestionsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TriviaUiState())
    val uiState: StateFlow<TriviaUiState> = _uiState.asStateFlow()

    init {
        loadQuestion()
    }

    fun skipQuestion() {
        val skipTimesAvailable = _uiState.value.skipTimes
        if (skipTimesAvailable > 0) {
            loadQuestion()
            _uiState.update {
                it.copy(skipTimes = it.skipTimes - 1)
            }
        } else {
            showSkipAndHelpAlertDialog(AlertDialogSkipAndHelp.SKIP)
        }
    }

    fun useHelp() {
        val helpTimesAvailable = _uiState.value.helpTimes
        if (helpTimesAvailable > 0) {
            getCorrectAnswerForHelp()
            _uiState.update {
                it.copy(helpTimes = it.helpTimes - 1)
            }
        } else {
            showSkipAndHelpAlertDialog(AlertDialogSkipAndHelp.HELP)
        }
    }

    private fun showSkipAndHelpAlertDialog(dialogType: AlertDialogSkipAndHelp) {
        val currentLevel = _uiState.value.currentLevel
        _uiState.update { triviaUiState ->
            triviaUiState.copy(
                showAlertDialogSkipAndHelp = true,
                alertDialogPropertiesForSkipAndHelp = AlertDialogPropertiesForSkipAndHelp(
                    dialogType = dialogType,
                    level = currentLevel,
                    title = dialogType.title,
                    text = when (dialogType) {
                        AlertDialogSkipAndHelp.SKIP -> currentLevel.skipsWarning
                        AlertDialogSkipAndHelp.HELP -> currentLevel.helpsWarning
                    },
                    icon = dialogType.icon
                )
            )
        }
    }

    private fun showGameOverAlertDialog() {
        _uiState.update { triviaUiState ->
            triviaUiState.copy(
                showAlertDialogGameOver = true,
                alertDialogPropertiesForGameOver = AlertDialogPropertiesForGameOver(
                    score = triviaUiState.score
                )
            )
        }
    }

    private fun getCorrectAnswerForHelp() {
        val currentQuestion = _uiState.value.currentQuestion
        currentQuestion?.let {
            checkAnswer(it.correctAnswer)
        }
    }

    fun checkAnswer(answer: Int) {
        viewModelScope.launch {
            evaluateAnswer(answer)
            _uiState.update { it.copy(isAnswerSelected = true) }
            delay(1300)
            _uiState.update { it.copy(isQuestionVisible = false) }
            getScore(answer)
            setQuestionCounter()
            delay(1000)
            loadQuestion()
            _uiState.update { it.copy(isAnswerSelected = false, isQuestionVisible = true) }
        }
    }

    private fun evaluateAnswer(answer: Int) {
        val currentQuestion = _uiState.value.currentQuestion
        val correctAnswer = currentQuestion?.correctAnswer
        val isCorrect = answer == currentQuestion?.correctAnswer
        val highlightedCorrectAnswer =
            if (isCorrect) null else correctAnswer
        val correctAnswerImage = currentQuestion?.let {
            questionsRepository.getImageForAnswer(it.correctAnswer)
        } ?: _uiState.value.correctAnswerImage

        _uiState.update { triviaUiState ->
            triviaUiState.copy(
                isAnswerCorrect = isCorrect,
                selectedAnswer = answer,
                highlightedCorrectAnswer = highlightedCorrectAnswer,
                correctAnswerImage = correctAnswerImage
            )
        }
    }

    private fun setQuestionCounter() {
        val questionerCounter = _uiState.value.questionCounter
        if (questionerCounter < MAX_QUESTION_NUMBER) {
            _uiState.update { triviaUiState ->
                triviaUiState.copy(
                    questionCounter = triviaUiState.questionCounter + 1
                )
            }
        }
    }

    fun loadQuestion() {
        val currentLevel = _uiState.value.currentLevel
        val question = questionsRepository.getQuestionForLevel(currentLevel)
        if (question == null) {
            showGameOverAlertDialog()
        } else {
            _uiState.update { triviaUiState ->
                triviaUiState.copy(currentQuestion = question)
            }
        }
    }

    fun setLevel(level: Level) {
        _uiState.update { triviaUiState ->
            triviaUiState.copy(
                currentLevel = level,
                skipTimes = level.skips,
                helpTimes = level.helps
            )
        }
    }

    fun dismissAlertDialog() {
        _uiState.update {
            it.copy(
                showAlertDialogSkipAndHelp = false,
                alertDialogPropertiesForSkipAndHelp = null,
                showAlertDialogGameOver = false,
                alertDialogPropertiesForGameOver = null
            )
        }
    }

    private fun getScore(answer: Int) {
        val currentQuestion = _uiState.value.currentQuestion
        val correctAnswer = currentQuestion?.correctAnswer
        if (answer == correctAnswer) {
            _uiState.update { triviaUiState ->
                triviaUiState.copy(
                    score = triviaUiState.score + 0.5f
                )
            }
        }
    }


    fun resetGame() {

    }

    fun exitApp() {

    }
}


