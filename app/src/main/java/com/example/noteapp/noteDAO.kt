package com.example.noteapp

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface noteDAO {

    @Query("SELECT * FROM notes_table order by id ASC")
    fun getallnotes(): LiveData<List<noterecord>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note:noterecord)

    @Delete
    suspend fun delete(note:noterecord)


}

