package com.example.noteapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class noteViewModel(application: Application): AndroidViewModel(application) {

     val allnotes : LiveData<List<noterecord>>
     private val repository : noteRepository


    init {
        val database_dao = noteRoomDatabase.getDatabase(application).noteDao()
         repository = noteRepository(database_dao)
        allnotes = repository.allnote

    }

    fun insert(note : noterecord) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }


    fun delete(note:noterecord) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(note)
    }



}