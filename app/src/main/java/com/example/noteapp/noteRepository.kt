package com.example.noteapp

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class noteRepository(private val noteDAO:noteDAO) {

val allnote : LiveData<List<noterecord>> = noteDAO.getallnotes()

    suspend fun insert(noterecord: noterecord)
    {
        noteDAO.insert(noterecord)
    }

    suspend fun delete(noterecord: noterecord)
    {
        noteDAO.delete(noterecord)
    }

}