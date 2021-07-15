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

class NotesAdapter(context: Context, notes: List<Note>) : RecyclerView.Adapter<NotesAdapter.NotesViewModelClass>() {
    private var context: Context
    private var notes = emptyList<Note>()
    private var searchnotes = emptyList<Note>()
    inner class NotesViewModelClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ntitle:TextView
        var nsubtitle:TextView
        var ndatetime:TextView
        var npriority:View
        init {
            ntitle = itemView.findViewById(R.id.titleTV)
            nsubtitle = itemView.findViewById(R.id.subtitleTV)
            ndatetime = itemView.findViewById(R.id.datetimeTV)
            npriority = itemView.findViewById(R.id.priorityView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewModelClass {
        val view : View = LayoutInflater.from(parent.context).inflate(
            R.layout.note_item,parent,false
        )
        return NotesViewModelClass(view )
    }

    override fun onBindViewHolder(holder: NotesViewModelClass, position: Int) {
        holder.ntitle.text = notes[position].noteTitel.toString()
        holder.nsubtitle.text = notes[position].noteSubtitle.toString()
        holder.ndatetime.text = notes[position].noteDate.toString()
        if(notes[position].notePriority == 1){
            holder.npriority.setBackgroundResource(R.drawable.green_circle)
        }else if (notes[position].notePriority == 2){
            holder.npriority.setBackgroundResource(R.drawable.blue_circle)
        }else{
            holder.npriority.setBackgroundResource(R.drawable.red_circle)
        }
        holder.itemView.setOnClickListener {
            var intent = Intent(context,UpdateNotesActivity::class.java)
            intent.putExtra("Idi",notes[position].id.toString())
            intent.putExtra("Title",notes[position].noteTitel.toString())
            intent.putExtra("SubTitle",notes[position].noteSubtitle.toString())
            intent.putExtra("Notei",notes[position].note.toString())
            intent.putExtra("priorityi",notes[position].notePriority.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
        notifyDataSetChanged()
    }
    init {
        this.context = context
        this.notes = notes
        searchnotes = ArrayList<Note>(notes)
    }

    public fun SearchNotes(filter : List<Note>){
        this.notes = filter
        notifyDataSetChanged()
    }
}