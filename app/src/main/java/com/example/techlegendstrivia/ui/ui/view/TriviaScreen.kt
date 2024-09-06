package com.example.techlegendstrivia.ui.ui.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.StarHalf
import androidx.compose.material.icons.automirrored.outlined.HelpOutline
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.SkipNext
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.techlegendstrivia.R
import com.example.techlegendstrivia.model.Level
import com.example.techlegendstrivia.model.Question
import com.example.techlegendstrivia.ui.theme.Dimens
import com.example.techlegendstrivia.ui.ui.viewmodel.TriviaViewModel
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TriviaScreen(triviaViewModel: TriviaViewModel = viewModel()) {
    val triviaUiState by triviaViewModel.uiState.collectAsStateWithLifecycle()

    if (triviaUiState.showAlertDialogSkipAndHelp) {
        triviaUiState.alertDialogPropertiesForSkipAndHelp?.let {
            AlertDialog(
                onDismissRequest = { triviaViewModel.dismissAlertDialog() },
                onDismissMessage = R.string.okay_got_it,
                onConfirmation = { triviaViewModel.dismissAlertDialog() },
                onConfirmMessage = R.string.reset_game,
                dialogTitle = it.title,
                dialogText = it.text,
                additionalDialogText = "",
                icon = it.icon
            )
        }
    }

    val formattedScore = String.format(Locale.getDefault(), "%.1f", triviaUiState.score)
    if (triviaUiState.showAlertDialogGameOver) {
        triviaUiState.alertDialogPropertiesForGameOver?.let {
            AlertDialog(
                onDismissRequest = { triviaViewModel.dismissAlertDialog() },
                onDismissMessage = R.string.reset_game,
                onConfirmation = { triviaViewModel.dismissAlertDialog() },
                onConfirmMessage = R.string.exit,
                dialogTitle = it.title,
                dialogText = it.text,
                additionalDialogText = formattedScore,
                icon = it.icon
            )
        }
    }


    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(bottom = Dimens.large),
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(Dimens.medium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LevelSegmentedControl(
                levels = Level.entries,
                currentLevel = triviaUiState.currentLevel,
                onLevelSelected = { selectedLevel ->
                    triviaViewModel.setLevel(selectedLevel)
                    triviaViewModel.loadQuestion()
                }
            )
            QuestionCounterCard(questionCounter = triviaUiState.questionCounter)

            triviaUiState.currentQuestion?.let {
                QuestionCard(
                    question = it,
                    image = triviaUiState.correctAnswerImage,
                    imageDescription = R.string.correct_answer_image_description,
                    isAnswerSelected = triviaUiState.isAnswerSelected,
                    correctAnswer = stringResource(id = triviaUiState.currentQuestion!!.correctAnswer),
                    isVisible = triviaUiState.isQuestionVisible
                )
            }

            TriviaControlButtons(
                onSkipClicked = { triviaViewModel.skipQuestion() },
                onHelpClicked = { triviaViewModel.useHelp() }
            )
            triviaUiState.currentQuestion?.let { currentQuestion ->
                AnswersBlock(
                    question = currentQuestion,
                    selectedAnswer = triviaUiState.selectedAnswer,
                    highlightedCorrectAnswer = triviaUiState.highlightedCorrectAnswer,
                    isAnswerCorrect = triviaUiState.isAnswerCorrect,
                    onAnswerSelected = { choice -> triviaViewModel.checkAnswer(choice) },
                )
            }
            AnswersScore(
                score = triviaUiState.score
            )
        }
    }
}

@Composable
fun LevelSegmentedControl(
    levels: List<Level>,
    currentLevel: Level,
    onLevelSelected: (Level) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray.copy(alpha = 0.1f)),
        horizontalArrangement = Arrangement.Center
    ) {
        levels.forEach { level ->
            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
                    .selectable(
                        selected = (level == currentLevel),
                        onClick = { onLevelSelected(level) }
                    ),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (level == currentLevel) MaterialTheme.colorScheme.primary else Color.Transparent,
                    contentColor = if (level == currentLevel) Color.White else Color.Black.copy(
                        alpha = 0.5f
                    )
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = level.displayNameRes),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = if (level == currentLevel) FontWeight.SemiBold else FontWeight.Normal
                        ),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun QuestionCounterCard(
    questionCounter: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = Dimens.medium, top = Dimens.extraLarge),
        horizontalArrangement = Arrangement.End
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(Dimens.medium))
                .background(color = MaterialTheme.colorScheme.primary)
                .padding(horizontal = Dimens.extraLarge, vertical = Dimens.medium),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$questionCounter/10",
                color = Color.White,
            )
        }
    }
}


@Composable
fun QuestionCard(
    question: Question,
    @DrawableRes image: Int,
    @StringRes imageDescription: Int,
    isAnswerSelected: Boolean,
    correctAnswer: String,
    isVisible: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = Dimens.cardMinHeight, max = Dimens.cardMaxHeight)
            .padding(bottom = Dimens.medium),
        shape = RoundedCornerShape(Dimens.medium),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        ),
        elevation = CardDefaults.cardElevation(Dimens.thin),
        border = BorderStroke(Dimens.hairline, Color.Black.copy(alpha = 0.2f))
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = scaleIn(),
            exit = scaleOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = Dimens.cardMinHeight, max = Dimens.cardMaxHeight),
                contentAlignment = Alignment.Center
            ) {
                if (!isAnswerSelected) {
                    Text(
                        text = stringResource(id = question.question),
                        modifier = Modifier.padding(horizontal = Dimens.medium),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                    )
                } else {
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = stringResource(id = imageDescription, correctAnswer),
                        contentScale = ContentScale.Fit

                    )
                }
            }
        }
    }
}

@Composable
fun TriviaControlButtons(
    onSkipClicked: () -> Unit,
    onHelpClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = Dimens.extraLarge),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TriviaButton(
            btnText = stringResource(R.string.help_btn),
            btnIcon = Icons.AutoMirrored.Outlined.HelpOutline,
            btnIconDescription = stringResource(R.string.help_icon_description),
            onBtnClicked = onHelpClicked,
        )
        TriviaButton(
            btnText = stringResource(R.string.skip_btn),
            btnIcon = Icons.Outlined.SkipNext,
            btnIconDescription = stringResource(R.string.skip_icon_description),
            onBtnClicked = onSkipClicked,
        )
    }
}

@Composable
fun TriviaButton(
    btnText: String,
    btnIcon: ImageVector,
    btnIconDescription: String,
    onBtnClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onBtnClicked,
        modifier = modifier,
        shape = RoundedCornerShape(Dimens.medium),
        border = BorderStroke(Dimens.hairline, Color.Black.copy(alpha = 0.2f)),
        contentPadding = PaddingValues(start = Dimens.large, end = Dimens.medium)
    ) {
        Text(
            text = btnText,
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
        Spacer(Modifier.width(Dimens.medium))
        Icon(
            imageVector = btnIcon,
            contentDescription = btnIconDescription,
            tint = Color.Black,
            modifier = Modifier
                .size(Dimens.iconSmallSize)
                .padding(top = Dimens.thin)
        )
    }
}

@Composable
fun AnswersBlock(
    question: Question,
    selectedAnswer: Int?,
    highlightedCorrectAnswer: Int?,
    isAnswerCorrect: Boolean,
    onAnswerSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {

        val (firstColumnChoices, secondColumnChoices) = question.multipleChoices.chunked(2)

        Column(modifier = Modifier.weight(1f)) {
            firstColumnChoices.forEach { choice ->
                AnswerChoiceCard(
                    answer = choice,
                    selectedAnswer = selectedAnswer,
                    highlightedCorrectAnswer = highlightedCorrectAnswer,
                    isAnswerCorrect = isAnswerCorrect,
                    onAnswerSelected = onAnswerSelected
                )
                Spacer(modifier = Modifier.height(Dimens.medium))
            }
        }

        Spacer(modifier = Modifier.width(Dimens.small))

        Column(modifier = Modifier.weight(1f)) {
            secondColumnChoices.forEach { choice ->
                AnswerChoiceCard(
                    answer = choice,
                    selectedAnswer = selectedAnswer,
                    highlightedCorrectAnswer = highlightedCorrectAnswer,
                    isAnswerCorrect = isAnswerCorrect,
                    onAnswerSelected = onAnswerSelected
                )
                Spacer(modifier = Modifier.height(Dimens.medium))
            }
        }
    }
}


@Composable
fun AnswerChoiceCard(
    answer: Int,
    selectedAnswer: Int?,
    highlightedCorrectAnswer: Int?,
    isAnswerCorrect: Boolean,
    onAnswerSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val isSelected = answer == selectedAnswer
    val isCorrectAnswerHighlighted = answer == highlightedCorrectAnswer

    val defaultCardColor = MaterialTheme.colorScheme.secondary
    var cardColor by remember { mutableStateOf(defaultCardColor) }
    val correctAnswerCardColor = MaterialTheme.colorScheme.tertiary
    val wrongAnswerCardColor = MaterialTheme.colorScheme.error
    cardColor = when {
        isSelected && isAnswerCorrect -> correctAnswerCardColor
        isSelected && !isAnswerCorrect -> wrongAnswerCardColor
        isCorrectAnswerHighlighted -> correctAnswerCardColor
        else -> defaultCardColor
    }

    val defaultTextColor = Color.Black
    var textColor by remember { mutableStateOf(defaultTextColor) }
    textColor = if (isSelected || isCorrectAnswerHighlighted) {
        Color.White
    } else defaultTextColor

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onAnswerSelected(answer) },
        colors = CardDefaults.cardColors(
            containerColor = cardColor,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(Dimens.medium),
        border = BorderStroke(Dimens.hairline, Color.Black.copy(alpha = 0.2f))
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = isSelected,
                onClick = { onAnswerSelected(answer) },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.White
                )
            )
            Text(
                text = stringResource(id = answer),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun AnswersScore(
    score: Float,
    modifier: Modifier = Modifier
) {
    val starsColor = MaterialTheme.colorScheme.surfaceVariant
    Row(
        modifier = modifier.padding(vertical = Dimens.large)
    ) {
        Text(text = stringResource(R.string.score))
        val fullStars = score.toInt()
        val halfStar = (score % 1 != 0f)
        repeat(fullStars) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Full star score",
                tint = starsColor
            )
        }
        if (halfStar) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.StarHalf,
                contentDescription = "Half star score",
                tint = starsColor
            )
        }
    }
}

@Composable
fun AlertDialog(
    onDismissRequest: () -> Unit,
    @StringRes onDismissMessage: Int,
    onConfirmation: () -> Unit,
    @StringRes onConfirmMessage: Int,
    @StringRes dialogTitle: Int,
    @StringRes dialogText: Int,
    additionalDialogText: String,
    icon: ImageVector
) {
    AlertDialog(
        icon = {
            Icon(
                icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        },
        title = { Text(text = stringResource(id = dialogTitle)) },
        text = { Text(text = stringResource(id = dialogText, additionalDialogText)) },
        onDismissRequest = { onDismissRequest() },
        confirmButton = {
            TextButton(onClick = onConfirmation) {
                Text(text = stringResource(onConfirmMessage))
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismissRequest() }) {
                Text(text = stringResource(onDismissMessage))
            }
        }
    )
}



