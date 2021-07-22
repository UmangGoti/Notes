package com.example.notes.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.note.R
import com.example.notes.Activity.UpdateNotesActivity
import com.example.notes.Model.Note

class NotesAdapter(private var context: Context, notes: List<Note>) :
    RecyclerView.Adapter<NotesAdapter.NotesViewModelClass>() {
    private var notes = emptyList<Note>()
    private var searchnotes = emptyList<Note>()

    inner class NotesViewModelClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ntitle: TextView = itemView.findViewById(R.id.titleTV)
        var nsubtitle: TextView = itemView.findViewById(R.id.subtitleTV)
        var ndatetime: TextView = itemView.findViewById(R.id.datetimeTV)
        var npriority: View = itemView.findViewById(R.id.priorityView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewModelClass {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.note_item, parent, false
        )
        return NotesViewModelClass(view)
    }

    override fun onBindViewHolder(holder: NotesViewModelClass, position: Int) {
        holder.ntitle.text = notes[position].noteTitle
        holder.nsubtitle.text = notes[position].noteSubtitle
        holder.ndatetime.text = notes[position].noteDate
        when (notes[position].notePriority) {
            1 -> holder.npriority.setBackgroundResource(R.drawable.fuchsia_pink_circle)
            2 -> holder.npriority.setBackgroundResource(R.drawable.violet_circle)
            3 -> holder.npriority.setBackgroundResource(R.drawable.blue_circle)
            4 -> holder.npriority.setBackgroundResource(R.drawable.aquamarine_circle)
            5 -> holder.npriority.setBackgroundResource(R.drawable.green_circle)
            6 -> holder.npriority.setBackgroundResource(R.drawable.yellow_circle)
            7 -> holder.npriority.setBackgroundResource(R.drawable.red_circle)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(context, UpdateNotesActivity::class.java)
            intent.putExtra("Idi", notes[position].id.toString())
            intent.putExtra("Title", notes[position].noteTitle)
            intent.putExtra("SubTitle", notes[position].noteSubtitle)
            intent.putExtra("Note", notes[position].note)
            intent.putExtra("priority", notes[position].notePriority.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    init {
        this.notes = notes
        searchnotes = ArrayList<Note>(notes)
    }

    fun searchNotes(filter: List<Note>) {
        this.notes = filter
        notifyDataSetChanged()
    }
}