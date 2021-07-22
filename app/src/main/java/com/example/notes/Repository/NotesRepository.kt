package com.example.notes.Repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.notes.Dao.NotesDAO
import com.example.notes.Model.Note

class NotesRepository(private val notesDAO: NotesDAO) {


    val getAllNotes: LiveData<List<Note>> = notesDAO.getNote()
    val getHighToLow: LiveData<List<Note>> = notesDAO.highToLow()
    val getLowToHigh: LiveData<List<Note>> = notesDAO.lowToHigh()

    suspend fun insert(note: Note) {
        notesDAO.insertNotes(note)
    }

    suspend fun update(note: Note) {
        notesDAO.updateNotes(note)
    }

    suspend fun delete(id: Int) {
        notesDAO.deleteNotes(id)
    }

}