package com.example.andersen_homework2.lesson2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.andersen_homework2.databinding.ActivityShoppingListBinding

class ShoppingListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.chooseButton.setOnClickListener { chooseProduct() }
        checkSaveInstanceState(savedInstanceState)
        binding.searchProductButton.setOnClickListener {
            searchProductShop()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("1", binding.item1.text.toString())
        outState.putString("2", binding.item2.text.toString())
        outState.putString("3", binding.item3.text.toString())
        outState.putString("4", binding.item4.text.toString())
        outState.putString("5", binding.item5.text.toString())
        outState.putString("6", binding.item6.text.toString())
        outState.putString("7", binding.item7.text.toString())
        outState.putString("8", binding.item8.text.toString())
        outState.putString("9", binding.item9.text.toString())
        outState.putString("10", binding.item10.text.toString())
    }

    private fun chooseProduct() {
        val intent = Intent(this, ProductListActivity::class.java)
        getProduct.launch(intent)
    }

    private fun checkSaveInstanceState(savedInstanceState: Bundle?) {
        getEmptySaveIS(savedInstanceState)
    }

    private fun getEmptySaveIS(savedInstanceState: Bundle?) {
        binding.item1.text = savedInstanceState?.getString("1") ?: ""
        binding.item2.text = savedInstanceState?.getString("2") ?: ""
        binding.item3.text = savedInstanceState?.getString("3") ?: ""
        binding.item4.text = savedInstanceState?.getString("4") ?: ""
        binding.item5.text = savedInstanceState?.getString("5") ?: ""
        binding.item6.text = savedInstanceState?.getString("6") ?: ""
        binding.item7.text = savedInstanceState?.getString("7") ?: ""
        binding.item8.text = savedInstanceState?.getString("8") ?: ""
        binding.item9.text = savedInstanceState?.getString("9") ?: ""
        binding.item10.text = savedInstanceState?.getString("10") ?: ""
    }

    private fun getEmptyTextView(): TextView? {

        return when {
            binding.item1.text.isBlank() -> binding.item1
            binding.item2.text.isBlank() -> binding.item2
            binding.item3.text.isBlank() -> binding.item3
            binding.item4.text.isBlank() -> binding.item4
            binding.item5.text.isBlank() -> binding.item5
            binding.item6.text.isBlank() -> binding.item6
            binding.item7.text.isBlank() -> binding.item7
            binding.item8.text.isBlank() -> binding.item8
            binding.item9.text.isBlank() -> binding.item9
            binding.item10.text.isBlank() -> binding.item10
            else -> null
        }
    }

    private val getProduct =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { it ->
            if (it.resultCode == Activity.RESULT_OK) {
                val intent = it.data
                val accessMessage = intent?.getStringExtra(ProductListActivity.MESSAGE)
                val textView = getEmptyTextView()
                textView?.let {
                    it.text = accessMessage
                }
            }
        }

    private fun searchProductShop() {
        val loc = binding.searchProductEditText.text.toString()
        val addressUri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "магазин не найден", Toast.LENGTH_SHORT).show()
        }
    }
}
