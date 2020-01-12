package io.askhole.database.models

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.askhole.BuildConfig

@Database(entities = [Question::class, QuestionSet::class], version = 1, exportSchema = true)
@TypeConverters(DatabaseConverter::class)
abstract class AskholeDatabase : RoomDatabase() {

    abstract fun dao(): AskholeDAO

    companion object {

        private var INSTANCE: AskholeDatabase? = null

        fun getInstance(applicationContext: Context): AskholeDatabase {
            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder(
                    applicationContext,
                    AskholeDatabase::class.java,
                    "askhole-db"
                ).apply {

                    if (BuildConfig.DEBUG) {
                        this.fallbackToDestructiveMigration()
                    }

                }.build()
            }

            return INSTANCE!!
        }

    }

    fun getAllQuestions(): LiveData<List<Question>> {
        return dao().getAllQuestions()
    }

    fun insertAllQuestions(questions: List<Question>, callback: ((Boolean?) -> Unit)? = null) {
        GeneralDatabaseAsyncTask<List<Question>, Boolean>(
            { dao().insertQuestions(questions).firstOrNull() == 1L},
            callback
        ).execute()
    }
}

private open class GeneralDatabaseAsyncTask<T, U>(
    private val method: ((T?) -> U),
    private val callback: ((U?) -> Unit)?
) : AsyncTask<T, Void, U>() {

    override fun doInBackground(vararg params: T?): U? {
        return method.invoke(params.firstOrNull())
    }

    override fun onPostExecute(result: U?) {
        callback?.invoke(result)
    }

}