package com.example.notes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Notes::class],version = 1)
abstract class NotesDB:RoomDatabase() {
    abstract fun notesDAO():NotesDAO

    companion object{
        private var INSTANCE : NotesDB? = null
        fun getDatabase(context: Context) : NotesDB{
            if(INSTANCE==null){
                synchronized(this){
                INSTANCE =Room.databaseBuilder(context.applicationContext,NotesDB::class.java,"notesDB").build()
                }
            }
            return INSTANCE!!
        }
    }
}