package io.askhole.database.models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
abstract class AskholeDAO {

    @Query("SELECT * FROM question")
    abstract fun getAllQuestions(): LiveData<List<Question>>


    @Query("SELECT * FROM question_set")
    abstract fun getAllQuestionSets(): LiveData<List<QuestionSet>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertQuestions(questions: List<Question>) : LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertQuestion(questions: Question) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertQuestionSet(questionSet: QuestionSet) : Long


}