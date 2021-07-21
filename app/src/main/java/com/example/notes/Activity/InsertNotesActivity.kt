package com.example.notes.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.note.R
import com.example.notes.Model.Note
import com.example.notes.ViewModel.NotesViewModel
import kotlinx.android.synthetic.main.activity_insert_notes.*
import java.text.SimpleDateFormat
import java.util.*

class InsertNotesActivity : AppCompatActivity() {
    private var priority = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_notes)
        var notesViewModel = NotesViewModel(application)

        redPriority.setOnClickListener {
            redPriority.setImageResource(R.drawable.ic_baseline_done_24)
            yellowPriority.setImageResource(0)
            greenPriority.setImageResource(0)
            aquamarinePriority.setImageResource(0)
            bluePriority.setImageResource(0)
            violetPriority.setImageResource(0)
            pinkPriority.setImageResource(0)
            setPriority(7)
        }

        yellowPriority.setOnClickListener {
            redPriority.setImageResource(0)
            yellowPriority.setImageResource(R.drawable.ic_baseline_done_24)
            greenPriority.setImageResource(0)
            aquamarinePriority.setImageResource(0)
            bluePriority.setImageResource(0)
            violetPriority.setImageResource(0)
            pinkPriority.setImageResource(0)
            setPriority(6)
        }

        greenPriority.setOnClickListener {
            redPriority.setImageResource(0)
            yellowPriority.setImageResource(0)
            greenPriority.setImageResource(R.drawable.ic_baseline_done_24)
            aquamarinePriority.setImageResource(0)
            bluePriority.setImageResource(0)
            violetPriority.setImageResource(0)
            pinkPriority.setImageResource(0)
            setPriority(5)
        }

        aquamarinePriority.setOnClickListener {
            redPriority.setImageResource(0)
            yellowPriority.setImageResource(0)
            greenPriority.setImageResource(0)
            aquamarinePriority.setImageResource(R.drawable.ic_baseline_done_24)
            bluePriority.setImageResource(0)
            violetPriority.setImageResource(0)
            pinkPriority.setImageResource(0)
            setPriority(4)
        }

        bluePriority.setOnClickListener {
            redPriority.setImageResource(0)
            yellowPriority.setImageResource(0)
            greenPriority.setImageResource(0)
            aquamarinePriority.setImageResource(0)
            bluePriority.setImageResource(R.drawable.ic_baseline_done_24)
            violetPriority.setImageResource(0)
            pinkPriority.setImageResource(0)
            setPriority(3)
        }

        violetPriority.setOnClickListener {
            redPriority.setImageResource(0)
            yellowPriority.setImageResource(0)
            greenPriority.setImageResource(0)
            aquamarinePriority.setImageResource(0)
            bluePriority.setImageResource(0)
            violetPriority.setImageResource(R.drawable.ic_baseline_done_24)
            pinkPriority.setImageResource(0)
            setPriority(2)
        }

        pinkPriority.setOnClickListener {
            redPriority.setImageResource(0)
            yellowPriority.setImageResource(0)
            greenPriority.setImageResource(0)
            aquamarinePriority.setImageResource(0)
            bluePriority.setImageResource(0)
            violetPriority.setImageResource(0)
            pinkPriority.setImageResource(R.drawable.ic_baseline_done_24)
            setPriority(1)
        }

        val now = Date().time
        val formatter = SimpleDateFormat("MMMM dd, yyyy HH:mm", Locale.getDefault())
        val result = formatter.format(now)
        addNotes.setOnClickListener {
            if (titleET.text.isNotBlank() && subtitleET.text.isNotBlank() && notesET.text.isNotBlank()) {
                notesViewModel.insert(
                    Note(
                        id = 0,
                        noteTitel = titleET.text.toString(),
                        noteSubtitle = subtitleET.text.toString(),
                        noteDate = result,
                        note = notesET.text.toString(),
                        notePriority = getPriority()
                    )
                )
                Toast.makeText(this, "Note Inserted Successfully 🙂", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Insert Valid Notes info 🙂", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setPriority(priority: Int) {
        this.priority = priority
    }

    private fun getPriority(): Int {
        return priority
    }


}