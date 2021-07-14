package com.example.notes.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.Model.Note

@Dao
interface NotesDAO {
    @Insert
    suspend fun insertNotes(note: Note)

    @Update
    suspend fun updateNotes(note: Note)

    @Query("DELETE FROM notes_info WHERE id=:id")
    suspend fun deleteNotes(id:Int)

    @Query("SELECT * FROM Notes_info")
    fun getNote() : LiveData<List<Note>>
}