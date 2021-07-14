package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.note.R
import com.example.notes.Activity.InsertNotesActivity
import com.example.notes.ViewModel.NotesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newNotesBTN.setOnClickListener {
            startActivity(Intent(this@MainActivity,InsertNotesActivity::class.java))
        }
        var notesViewModel = NotesViewModel(application)
        notesViewModel.allNotes.observe(this, androidx.lifecycle.Observer{notes->
            Log.i("getdata",notes.toString())
        })
    }
}