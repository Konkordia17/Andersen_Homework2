package com.example.andersen_homework2.lesson2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.andersen_homework2.R


class SecondActivity : AppCompatActivity() {
    lateinit var replayEditText: EditText
    lateinit var textView: TextView
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "-------")
        Log.d(LOG_TAG, "onCreate")
        setContentView(R.layout.activity_second)
        val intent = intent
        val message = intent.getStringExtra(FirstActivity.MESSAGE)
        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message
        replayEditText = findViewById(R.id.secondActivityEditText)
        button = findViewById(R.id.buttonSecond)
        button.setOnClickListener {
            returnReply()
        }
    }

    private fun returnReply() {
        val replayText = replayEditText.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(REPLY, replayText)
        setResult(RESULT_OK, replyIntent)
        Log.d(LOG_TAG, "End SecondActivity")
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

    companion object {
        const val REPLY = "REPLY"
        private val LOG_TAG = SecondActivity::class.java.simpleName
    }
}