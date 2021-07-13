package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDAO {
    @Insert
    suspend fun insertContact(notes: Notes)

    @Update
    suspend fun updateContact(notes: Notes)

    @Query("DELETE FROM notes_info WHERE id=:id")
    suspend fun deleteContact(id:Int)

    @Query("SELECT * FROM Notes_info")
    fun getContact() : LiveData<List<Notes>>
}