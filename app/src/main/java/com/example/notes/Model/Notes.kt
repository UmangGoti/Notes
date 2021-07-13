package com.example.notes.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes_info")
data class Notes (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "note_title")
    val noteTitel:String,
    @ColumnInfo(name = "note_subtitle")
    val noteSubtitke:String,
    @ColumnInfo(name = "note_date")
    val noteDate:String,
    @ColumnInfo(name = "note")
    val note:String,
    @ColumnInfo(name = "note_priority")
    val notePriority:String,

)