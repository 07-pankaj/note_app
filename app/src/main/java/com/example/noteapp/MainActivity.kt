package com.example.noteapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), noteonclick {

    private lateinit var nviewmodel : noteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycle = findViewById<RecyclerView>(R.id.recycle_view)
        recycle.layoutManager = LinearLayoutManager(this)
        val adapater = listadapter(this)
        recycle.adapter = adapater

        nviewmodel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(noteViewModel::class.java)
        nviewmodel.allnotes.observe(this, { list->
            list?.let {
                adapater.updata(it)
            }
        })


    }

    override fun onclick(note: noterecord) {
        nviewmodel.delete(note)
    }

    fun addnote(view: View) {
        val intent = Intent(this,noteadding::class.java)
        startActivityForResult(intent,2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 2)
        {
            if(resultCode == RESULT_OK)
            {
                var text = data?.getStringExtra("result")
                if (text != null) {
                    text = text.capitalize()
                }
                nviewmodel.insert(noterecord(text!!))
            }
        }
    }
}