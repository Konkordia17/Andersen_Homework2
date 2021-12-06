package com.example.andersen_homework2.lesson2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.andersen_homework2.R
import com.example.andersen_homework2.lesson1.HelloToastFragment

class SayHelloActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_say_hello)
        val bundle = intent.extras
        val message = bundle!!.getString(HelloToastFragment.MESSAGE)
        textView = findViewById(R.id.countTextView)
        textView.text = message
    }
}