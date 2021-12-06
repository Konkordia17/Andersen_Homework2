package com.example.andersen_homework2.lesson2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.andersen_homework2.R
import com.example.andersen_homework2.databinding.FragmentCounterBinding

class CounterFragment : Fragment(R.layout.fragment_counter) {
    private lateinit var binding: FragmentCounterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCounterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState?.getInt("count") == null) {
            binding.countTextView.text = "0"
        } else {
            binding.countTextView.text = savedInstanceState.getInt("count").toString()
        }
        binding.countButton.setOnClickListener {
            count()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", binding.countTextView.text.toString().toInt());
    }

    fun count() {
        var firstValue: Int = binding.countTextView.text.toString().toInt()
        val newValue = ++firstValue
        binding.countTextView.text = newValue.toString()
    }
}
