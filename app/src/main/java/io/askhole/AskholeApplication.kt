package io.askhole

import android.app.Application
import android.util.Log
import com.facebook.stetho.Stetho
import io.askhole.database.models.AskholeDatabase
import io.askhole.database.models.Question
import io.askhole.repositories.QuestionRepository

class AskholeApplication : Application() {

    //Stuff to be initialized at application start

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this.applicationContext)
        AskholeDatabase.getInstance(this)
        QuestionRepository(this).insertQuestions(QuestionList.questions.map {
            Question(
                text = it.text,
                type = it.type,
                setId = 1
            )
        }) { Log.d("Test", it.toString()) }
    }

}