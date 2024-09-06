package com.example.techlegendstrivia.data

import com.example.techlegendstrivia.model.Level
import com.example.techlegendstrivia.model.Question

class QuestionsRepository(private val questionsDataSource: QuestionsDataSource) {

    fun getQuestionForLevel(level: Level): Question? {
        return questionsDataSource.pickQuestionsRandomly(level)
    }

    fun getImageForAnswer(answer: Int): Int {
        return questionsDataSource.pickImageOfCorrectAnswer(answer)
    }
}