package com.example.andersen_homework2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "Hello World")

        try {
            val x = 5 / 0
        } catch (e: Throwable) {
            Log.e("MainActivity", "${e.message}")
        }
        Log.i("MainActivity", "log - i")
        Log.v("MainActivity", "log - v")
        Log.w("MainActivity", "log - w")
        Log.wtf("MainActivity", "log - wtf")
    }
}



