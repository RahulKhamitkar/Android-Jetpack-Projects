package com.rahul.notesjetpack.database

import DateConverter
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rahul.notesjetpack.model.Note
import com.rahul.notesjetpack.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}