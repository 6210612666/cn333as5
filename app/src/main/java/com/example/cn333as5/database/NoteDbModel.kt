package com.example.cn333as5.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "color_id") val colorId: Long,
    @ColumnInfo(name = "tag_id") val tagId: Long,
    @ColumnInfo(name = "in_trash") val isInTrash: Boolean
) {
    companion object {
        val DEFAULT_NOTES = listOf(
            NoteDbModel(1, "Shoppee express", "Content 1",  1, 2,false),
            NoteDbModel(2, "Jane", "Content 2",  2, 2,false),
            NoteDbModel(3, "Ploy", "Content 3",  3, 2,false),
            NoteDbModel(4, "Petch", "Content 4", 4,2, false),
            NoteDbModel(5, "P.somchai", "Content 5",  5, 3,false),
            NoteDbModel(6, "somsri", "Content 6", 6, 3,false),
            NoteDbModel(7, "Time", "Content 7", 7, 3,false),
            NoteDbModel(8, "Ja", "Content 8",  8, 3,false),
            NoteDbModel(9, "Mint", "Content 9",  9, 4,false),
            NoteDbModel(10, "Pink", "Content 10",  10, 4,false),
            NoteDbModel(11, "Pon", "Content 11",  11, 4,false),
            NoteDbModel(12, "Nee", "Content 12",  12, 4,false)
        )
    }
}
