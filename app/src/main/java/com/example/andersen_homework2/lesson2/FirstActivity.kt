package com.example.andersen_homework2.lesson2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.andersen_homework2.R

class FirstActivity : AppCompatActivity() {
    private lateinit var messageEditText: EditText
    private lateinit var mReplyTextView: TextView
    private lateinit var mReplyHeadTextView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        Log.d(LOG_TAG, "-------")
        Log.d(LOG_TAG, "onCreate")
        val intent = intent
        val message = intent.getStringExtra(SecondActivity.REPLY)
        mReplyTextView = findViewById(R.id.text_message_replay)
        button = findViewById(R.id.sendToSecond)
        mReplyTextView.text = message
        messageEditText = findViewById(R.id.firstActivityEditText)
        mReplyHeadTextView = findViewById(R.id.text_header_replay)
        button.setOnClickListener {
            changeToSecondActivity()
        }
    }

    private val resultContracts =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { it ->
            if (it.resultCode == Activity.RESULT_OK) {
                val intent = it.data
                val accessMessage = intent?.getStringExtra(SecondActivity.REPLY)
                mReplyTextView.text = accessMessage.toString()
            }
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

    private fun changeToSecondActivity() {
        Log.d("FirstActivity", "Button clicked!")
        val text = messageEditText.text.toString()
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(MESSAGE, text)
        resultContracts.launch(intent)
    }

    companion object {
        const val MESSAGE = "Key"
        private val LOG_TAG = FirstActivity::class.java.simpleName
    }
}



