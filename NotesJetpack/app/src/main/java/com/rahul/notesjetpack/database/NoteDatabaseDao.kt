package com.rahul.notesjetpack.database

import androidx.room.*
import com.rahul.notesjetpack.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * from note_tbl")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * from note_tbl where id = :id")
    suspend fun getNoteById(id: String): Note

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE from note_tbl")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

}