package com.example.andersen_homework2.lesson2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.andersen_homework2.databinding.ActivityProductListBinding

class ProductListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bread.setOnClickListener { setProductToList("Хлеб") }
        binding.cheese.setOnClickListener { setProductToList("Сыр") }
        binding.cucumbers.setOnClickListener { setProductToList("Огурцы") }
        binding.eggs.setOnClickListener { setProductToList("Яйца") }
        binding.fish.setOnClickListener { setProductToList("Рыба") }
        binding.meat.setOnClickListener { setProductToList("Мясо") }
        binding.milk.setOnClickListener { setProductToList("Молоко") }
        binding.oil.setOnClickListener { setProductToList("Масло") }
        binding.sausage.setOnClickListener { setProductToList("Колбаса") }
        binding.tomato.setOnClickListener { setProductToList("Помидоры") }
    }

    private fun setProductToList(text: String) {
        val intent = Intent()
        intent.putExtra(MESSAGE, text)
        setResult(RESULT_OK, intent)
        finish()
    }

    companion object {
        const val MESSAGE = "Key"
    }
}