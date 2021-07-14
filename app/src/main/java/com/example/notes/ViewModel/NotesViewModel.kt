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
//    var notesRepository: NotesRepository? = null
//    var getallNote:LiveData<List<Note>>? = null
//
//    constructor(application: Application):super(application){
//        notesRepository = NotesRepository(application)
//        getallNote = notesRepository?.getAllNote
//    }
//
//    fun insertNote(note: Note){
//        notesRepository!!.insertNotes(note)
//    }
//    fun deleteNote(id:Int){
//        notesRepository!!.deleteNotes(id)
//    }
//    fun updateNote(note: Note){
//        notesRepository!!.updateNotes(note)
}