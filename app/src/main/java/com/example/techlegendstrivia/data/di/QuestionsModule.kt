package com.example.techlegendstrivia.data.di

import com.example.techlegendstrivia.data.QuestionsDataSource
import com.example.techlegendstrivia.data.QuestionsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QuestionsModule {
    @Provides
    @Singleton
    fun provideQuestionsDataSource(): QuestionsDataSource {
        return QuestionsDataSource()
    }

    @Provides
    @Singleton
    fun provideQuestionsRepository(questionsDataSource: QuestionsDataSource): QuestionsRepository {
        return QuestionsRepository(questionsDataSource)

    }
}