package com.example.notes

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.note.R
import com.example.notes.Activity.InsertNotesActivity
import com.example.notes.Adapter.NotesAdapter
import com.example.notes.Model.Note
import com.example.notes.ViewModel.NotesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    lateinit var notesAdapter: NotesAdapter
    lateinit var filterName:List<Note>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nofilterTv.setBackgroundResource(R.drawable.white_round_corner)
        setFilter(0)
        nofilterTv.setOnClickListener {
            setFilter(0)
            nofilterTv.setBackgroundResource(R.drawable.white_round_corner)
            hightolowTv.setBackgroundResource(R.drawable.black_background)
            lowtohighTv.setBackgroundResource(R.drawable.black_background)
        }
        hightolowTv.setOnClickListener{
            setFilter(1)
            nofilterTv.setBackgroundResource(R.drawable.black_background)
            hightolowTv.setBackgroundResource(R.drawable.white_round_corner)
            lowtohighTv.setBackgroundResource(R.drawable.black_background)
        }
        lowtohighTv.setOnClickListener {
            setFilter(2)
            nofilterTv.setBackgroundResource(R.drawable.black_background)
            hightolowTv.setBackgroundResource(R.drawable.black_background)
            lowtohighTv.setBackgroundResource(R.drawable.white_round_corner)
        }
        newNotesBTN.setOnClickListener {
            startActivity(Intent(this@MainActivity,InsertNotesActivity::class.java))
        }

    }
    private fun setFilter(filter:Int){
        when(filter){
            0 -> NotesViewModel(application).allNotes.observe(this, androidx.lifecycle.Observer { notes->
                loadNotes(notes)
                filterName = notes
            })
            1 -> NotesViewModel(application).allHighToLow.observe(this, androidx.lifecycle.Observer { notes->
                loadNotes(notes)
                filterName = notes
            })
            2 -> NotesViewModel(application).allLowToHigh.observe(this, androidx.lifecycle.Observer { notes->
                loadNotes(notes)
                filterName = notes
            })
        }
    }
    private fun loadNotes(notes: List<Note>) {
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        if (notes.size == 0) {
            emptyList.visibility = View.VISIBLE
        } else {
            emptyList.visibility = View.GONE
        }
        notesAdapter = NotesAdapter(applicationContext, notes)
        recyclerView?.adapter = notesAdapter
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu,menu)
        var menuItem: MenuItem = menu!!.findItem(R.id.searchMenu)
        var searchView = menuItem.actionView as SearchView
        searchView.queryHint = "Search Notes here..."
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(qString: String): Boolean {
                return false
            }
            override fun onQueryTextSubmit(qString: String): Boolean {
                NotesFilter(qString)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }


    private fun NotesFilter(sText:String){
        var filterSearch = ArrayList<Note>()
        for (note:Note in filterName){
            if(note.noteTitel.contains(sText) || note.noteSubtitle.contains(sText)){
                filterSearch.add(note)
            }
        }
        this.notesAdapter.SearchNotes(filterSearch)
    }
}