package com.example.notes.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notes.Database.NotesDB
import com.example.notes.Model.Note
import com.example.notes.Repository.NotesRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NotesRepository
    val allNotes: LiveData<List<Note>>
    val allHighToLow: LiveData<List<Note>>
    val allLowToHigh: LiveData<List<Note>>

    init {
        val notesDB = NotesDB.getDatabase(application)
        repository = NotesRepository(notesDB.notesDAO())
        allNotes = repository.getAllNotes
        allHighToLow = repository.getHighToLow
        allLowToHigh = repository.getLowToHigh
    }

    fun insert(note: Note) = GlobalScope.launch {
        repository.insert(note)
    }

    fun upadate(note: Note) = GlobalScope.launch {
        repository.update(note)
    }

    fun delete(id: Int) = GlobalScope.launch {
        repository.delete(id)
    }

}