package com.example.notes.Repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.notes.Dao.NotesDAO
import com.example.notes.Model.Note

class NotesRepository(private val notesDAO: NotesDAO) {


    val getAllNotes: LiveData<List<Note>> = notesDAO.getNote()

    suspend fun insert(note: Note) {
        notesDAO.insertNotes(note)
    }
}