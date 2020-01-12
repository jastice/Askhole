package io.askhole.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "question"
    /*,
    foreignKeys = [ForeignKey(
        entity = QuestionSet::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("set_id"),
        onDelete = ForeignKey.CASCADE
    )]*/
)
data class Question(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "text")
    val text: String,
    @ColumnInfo(name = "question_type")
    val type: QuestionType,
    @ColumnInfo(name = "set_id")
    val setId: Long = 0 
) {
    enum class QuestionType {
        GENERIC, SEXY, SAD, EDGY, THOUGHTFUL, PERSONAL, UNCLASSIFIED
    }
}
