package com.example.notes.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.Model.Notes

@Dao
interface NotesDAO {
    @Insert
    fun insertNotes(notes: Notes)

    @Update
    fun updateNotes(notes: Notes)

    @Query("DELETE FROM notes_info WHERE id=:id")
    fun deleteNotes(id:Int)

    @Query("SELECT * FROM Notes_info")
    fun getNotes() : LiveData<List<Notes>>
}