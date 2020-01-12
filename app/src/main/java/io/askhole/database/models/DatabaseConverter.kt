package io.askhole.database.models

import androidx.room.TypeConverter

class DatabaseConverter {


    @TypeConverter
    fun toQuestionType(integer: Int): Question.QuestionType? {
        return Question.QuestionType.values().find { it.ordinal == integer }
    }

    @TypeConverter
    fun fromQuestionType(questionType: Question.QuestionType): Int {
        return questionType.ordinal
    }

    @TypeConverter
    fun toSetType(integer: Int): QuestionSet.SetType? {
        return QuestionSet.SetType.values().find { it.ordinal == integer }
    }

    @TypeConverter
    fun fromSetType(setType: QuestionSet.SetType): Int {
        return setType.ordinal
    }
}