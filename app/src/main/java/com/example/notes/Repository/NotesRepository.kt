package com.example.notes.Repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.notes.Dao.NotesDAO
import com.example.notes.Database.NotesDB
import com.example.notes.Model.Notes

class NotesRepository {
    lateinit var notesDAO:NotesDAO
    lateinit var getAllNotes:LiveData<List<Notes>>

    fun NotesRepository(application: Application){
        var database:NotesDB = NotesDB.getDatabase(application)
        notesDAO = database.notesDAO()
        getAllNotes = notesDAO.getNotes()
    }

    fun insertNotes(notes: Notes){
        notesDAO.insertNotes(notes)
    }

    fun deleteNotes(id:Int){
        notesDAO.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        notesDAO.updateNotes(notes)
    }
}