package com.example.andersen_homework2.lesson2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.andersen_homework2.R
import com.example.andersen_homework2.databinding.ActivityThreeButtonBinding

class ThreeButtonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThreeButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreeButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.firstButton.setOnClickListener {
            putDataToScrollingText(
                resources.getString(R.string.article_title),
                resources.getString(R.string.article_subtitle),
                resources.getString(R.string.article_text)
            )
        }
        binding.secondButton.setOnClickListener {
            putDataToScrollingText(
                resources.getString(R.string.article_title2),
                resources.getString(R.string.article_subtitle2),
                resources.getString(R.string.article_text2)
            )
        }
        binding.thirdButton.setOnClickListener {
            putDataToScrollingText(
                resources.getString(R.string.article_title3),
                resources.getString(R.string.article_subtitle3),
                resources.getString(R.string.article_text3)
            )
        }
    }

    private fun putDataToScrollingText(title: String, subtitle: String, text: String) {
        val intent = Intent(this, ThreeTextsActivity::class.java)
        intent.putExtra(TITLE, title)
        intent.putExtra(SUBTITLE, subtitle)
        intent.putExtra(ARTICLE, text)
        startActivity(intent)
    }

    companion object {
        const val ARTICLE = "Key"
        const val TITLE = "TITLE"
        const val SUBTITLE = "SUB"

    }
}