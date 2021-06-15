package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class noteadding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_noteadding)

    }

    fun savenote(view: View) {
        val edittext:EditText = findViewById(R.id.textenter)
        val text = edittext.text.toString()
        val resultintent = Intent()
        if (text.isEmpty())
        {
            resultintent.putExtra("result",text)
            setResult(RESULT_CANCELED,resultintent)
        }
        else{
            resultintent.putExtra("result",text)
            setResult(RESULT_OK,resultintent)
        }
        finish()
    }
}