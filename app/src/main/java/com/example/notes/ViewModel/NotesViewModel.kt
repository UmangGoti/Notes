package com.example.notes.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notes.Database.NotesDB
import com.example.notes.Model.Note
import com.example.notes.Repository.NotesRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NotesViewModel(application: Application): AndroidViewModel(application) {

    private val repository: NotesRepository
    val allNotes: LiveData<List<Note>>

    init {
        val notesDB = NotesDB.getDatabase(application)
        repository = NotesRepository(notesDB.notesDAO())
        allNotes = repository.getAllNotes
    }
    fun insert(note: Note) = GlobalScope.launch{
        repository.insert(note)
    }

}