package com.example.notes.Activity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Toast
import com.example.note.R
import com.example.note.R.id.deleteM
import com.example.notes.Model.Note
import com.example.notes.ViewModel.NotesViewModel
import kotlinx.android.synthetic.main.activity_update_notes.*
import kotlinx.android.synthetic.main.delete_dialogbox.*
import java.text.SimpleDateFormat
import java.util.*

class UpdateNotesActivity : AppCompatActivity() {
    private var priority = 1
    private lateinit var id: String
    private lateinit var title: String
    private lateinit var subTitle: String
    private lateinit var note: String
    private lateinit var priorities: String
    private lateinit var notesViewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_notes)

        notesViewModel = NotesViewModel(application)

        id = intent.getStringExtra("Idi")!!
        title = intent.getStringExtra("Title")!!
        subTitle = intent.getStringExtra("SubTitle")!!
        note = intent.getStringExtra("Note")!!
        priorities = intent.getStringExtra("priority")!!

        when (priorities) {
            "1" -> uppinkPriority.setImageResource(R.drawable.ic_baseline_done_24)
            "2" -> upvioletPriority.setImageResource(R.drawable.ic_baseline_done_24)
            "3" -> upbluePriority.setImageResource(R.drawable.ic_baseline_done_24)
            "4" -> upaquamarinePriority.setImageResource(R.drawable.ic_baseline_done_24)
            "5" -> upgreenPriority.setImageResource(R.drawable.ic_baseline_done_24)
            "6" -> upyellowPriority.setImageResource(R.drawable.ic_baseline_done_24)
            "7" -> upredPriority.setImageResource(R.drawable.ic_baseline_done_24)
        }

        upredPriority.setOnClickListener {
            upredPriority.setImageResource(R.drawable.ic_baseline_done_24)
            upyellowPriority.setImageResource(0)
            upgreenPriority.setImageResource(0)
            upaquamarinePriority.setImageResource(0)
            upbluePriority.setImageResource(0)
            upvioletPriority.setImageResource(0)
            uppinkPriority.setImageResource(0)
            setPriority(7)
        }

        upyellowPriority.setOnClickListener {
            upredPriority.setImageResource(0)
            upyellowPriority.setImageResource(R.drawable.ic_baseline_done_24)
            upgreenPriority.setImageResource(0)
            upaquamarinePriority.setImageResource(0)
            upbluePriority.setImageResource(0)
            upvioletPriority.setImageResource(0)
            uppinkPriority.setImageResource(0)
            setPriority(6)
        }

        upgreenPriority.setOnClickListener {
            upredPriority.setImageResource(0)
            upyellowPriority.setImageResource(0)
            upgreenPriority.setImageResource(R.drawable.ic_baseline_done_24)
            upaquamarinePriority.setImageResource(0)
            upbluePriority.setImageResource(0)
            upvioletPriority.setImageResource(0)
            uppinkPriority.setImageResource(0)
            setPriority(5)
        }

        upaquamarinePriority.setOnClickListener {
            upredPriority.setImageResource(0)
            upyellowPriority.setImageResource(0)
            upgreenPriority.setImageResource(0)
            upaquamarinePriority.setImageResource(R.drawable.ic_baseline_done_24)
            upbluePriority.setImageResource(0)
            upvioletPriority.setImageResource(0)
            uppinkPriority.setImageResource(0)
            setPriority(4)
        }

        upbluePriority.setOnClickListener {
            upredPriority.setImageResource(0)
            upyellowPriority.setImageResource(0)
            upgreenPriority.setImageResource(0)
            upaquamarinePriority.setImageResource(0)
            upbluePriority.setImageResource(R.drawable.ic_baseline_done_24)
            upvioletPriority.setImageResource(0)
            uppinkPriority.setImageResource(0)
            setPriority(3)
        }

        upvioletPriority.setOnClickListener {
            upredPriority.setImageResource(0)
            upyellowPriority.setImageResource(0)
            upgreenPriority.setImageResource(0)
            upaquamarinePriority.setImageResource(0)
            upbluePriority.setImageResource(0)
            upvioletPriority.setImageResource(R.drawable.ic_baseline_done_24)
            uppinkPriority.setImageResource(0)
            setPriority(2)
        }

        uppinkPriority.setOnClickListener {
            upredPriority.setImageResource(0)
            upyellowPriority.setImageResource(0)
            upgreenPriority.setImageResource(0)
            upaquamarinePriority.setImageResource(0)
            upbluePriority.setImageResource(0)
            upvioletPriority.setImageResource(0)
            uppinkPriority.setImageResource(R.drawable.ic_baseline_done_24)
            setPriority(1)
        }

        uptitleET.setText(title)
        upsubtitleET.setText(subTitle)
        upnotesET.setText(note)

        val now = Date().time
        val formatter = SimpleDateFormat("MMMM dd, yyyy HH:mm", Locale.getDefault())
        val result = formatter.format(now)
        upaddNotes.setOnClickListener {
            if (uptitleET.text.isNotBlank() && upsubtitleET.text.isNotBlank() && upnotesET.text.isNotBlank()) {
                notesViewModel.update(
                    Note(
                        id = id.toInt(),
                        noteTitle = uptitleET.text.toString(),
                        noteSubtitle = upsubtitleET.text.toString(),
                        noteDate = result,
                        note = upnotesET.text.toString(),
                        notePriority = getPriority()
                    )
                )
                Toast.makeText(this, "Note Update Successfully 🙂", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Insert Valid Notes info 😕", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun setPriority(priority: Int) {
        this.priority = priority
    }

    private fun getPriority(): Int {
        return priority
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.delete_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == deleteM) {
            showDialog()
        }
        return true
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.setBackgroundDrawableResource(R.drawable.round_corner)
        dialog.setContentView(R.layout.delete_dialogbox)
        dialog.yesbutton.setOnClickListener {
            delete()
            Toast.makeText(this, "Note Delete Successfully 🙂", Toast.LENGTH_SHORT).show()
            finish()
        }
        dialog.nobutton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun delete() {
        notesViewModel.delete(id.toInt())
    }
}