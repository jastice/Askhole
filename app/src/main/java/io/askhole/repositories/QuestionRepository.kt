package io.askhole.repositories

import android.content.Context
import androidx.lifecycle.MutableLiveData
import io.askhole.database.models.AskholeDatabase
import io.askhole.database.models.Question


class QuestionRepository(val applicationContext: Context) : Repository() {

    private val database = AskholeDatabase.getInstance(applicationContext)
    val questionList = database.getAllQuestions()

    override fun invalidate() {
        (questionList as MutableLiveData).postValue(null)
    }

    fun insertQuestions(questions: List<Question>, callback: ((Boolean?) -> Unit)?) {
        database.insertAllQuestions(questions, callback)
    }
}