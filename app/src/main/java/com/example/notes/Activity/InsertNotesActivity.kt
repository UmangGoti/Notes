package com.example.notes.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.note.R
import com.example.notes.Model.Note
import com.example.notes.ViewModel.NotesViewModel
import kotlinx.android.synthetic.main.activity_insert_notes.*
import java.util.*

class InsertNotesActivity : AppCompatActivity() {
    private var priority = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_notes)
        var notesViewModel:NotesViewModel = NotesViewModel(application)

        redPriority.setOnClickListener {
            redPriority.setImageResource(R.drawable.ic_baseline_done_24)
            greenPriority.setImageResource(0)
            bluePriority.setImageResource(0)
            setPriority(3)
        }

        bluePriority.setOnClickListener {
            redPriority.setImageResource(0)
            greenPriority.setImageResource(0)
            bluePriority.setImageResource(R.drawable.ic_baseline_done_24)
            setPriority(2)
        }

        greenPriority.setOnClickListener {
            redPriority.setImageResource(0)
            greenPriority.setImageResource(R.drawable.ic_baseline_done_24)
            bluePriority.setImageResource(0)
            setPriority(1)
        }
        
        addNotes.setOnClickListener {
            notesViewModel.insert(Note(
                id = 0,
                noteTitel = titleET.text.toString(),
                noteSubtitle = subtitleET.text.toString(),
                noteDate = Date().toString(),
                note = notesET.text.toString(),
                notePriority = getPriority()
            ))
            finish()
        }

    }
    private fun setPriority(priority:Int){
        this.priority = priority
    }
    private fun getPriority(): Int {
        return priority
    }
}