package com.example.andersen_homework2.lesson1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.andersen_homework2.R
import com.example.andersen_homework2.databinding.FragmentHelloWorldBinding

class HelloWorldFragment : Fragment(R.layout.fragment_hello_world) {
    private lateinit var binding: FragmentHelloWorldBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHelloWorldBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        binding.helloWorldTextView.text = "Hello World!"
        binding.nextToHelloToastFragment.setOnClickListener {
            navigate(R.id.action_helloWorldFragment_to_helloToastFragment)
        }
        binding.nextToHelloConstraintFragment.setOnClickListener {
            navigate(R.id.action_helloWorldFragment_to_helloConstraintFragment)
        }
        binding.nextToScrollingTextFragment.setOnClickListener {
            navigate(R.id.action_helloWorldFragment_to_scrollingTextFragment)
        }
        binding.nextToFirstActvity.setOnClickListener {
            navigate(R.id.action_helloWorldFragment_to_firstActivity)
        }
        binding.nextToCounterFragment.setOnClickListener {
            navigate(R.id.action_helloWorldFragment_to_counterFragment)
        }
        binding.nextToImplicitIntents.setOnClickListener {
            navigate(R.id.action_helloWorldFragment_to_implicitIntentsActivity)
        }
        binding.nextToThreeButtonFragment.setOnClickListener {
            navigate(R.id.action_helloWorldFragment_to_threeButtonActivity)
        }
        binding.nextToShoppingList.setOnClickListener {
            navigate(R.id.action_helloWorldFragment_to_shoppingListActivity2)
        }
    }

    private fun navigate(id: Int) {
        findNavController().navigate(id)
    }
}