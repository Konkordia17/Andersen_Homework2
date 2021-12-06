package com.example.andersen_homework2.lesson1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.andersen_homework2.R
import com.example.andersen_homework2.databinding.FragmentScrollingTextBinding

class ScrollingTextFragment : Fragment(R.layout.fragment_scrolling_text) {
    private lateinit var binding: FragmentScrollingTextBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScrollingTextBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}