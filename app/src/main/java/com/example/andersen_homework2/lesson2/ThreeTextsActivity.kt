package com.example.andersen_homework2.lesson2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.andersen_homework2.databinding.ActivityThreeTextBinding

class ThreeTextsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThreeTextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreeTextBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        binding.titleTextView.text = intent.getStringExtra(ThreeButtonActivity.TITLE)
        binding.subtitleTextView.text = intent.getStringExtra(ThreeButtonActivity.SUBTITLE)
        binding.articleTextView.text = intent.getStringExtra(ThreeButtonActivity.ARTICLE)

    }

}