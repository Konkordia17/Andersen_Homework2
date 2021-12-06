package com.example.andersen_homework2.lesson1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.andersen_homework2.R
import com.example.andersen_homework2.databinding.FragmentHelloToastBinding
import com.example.andersen_homework2.lesson2.SayHelloActivity

class HelloToastFragment : Fragment(R.layout.fragment_hello_toast) {
    private val viewModel: HelloToastViewModel by viewModels()
    private lateinit var binding: FragmentHelloToastBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHelloToastBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        if (viewModel.liveData.value == null) {
            viewModel.setValue(binding.countTextView.text.toString())
        }
        binding.toastButton.setOnClickListener {
            toast("Hello Toast!")
        }
        binding.countButton.setOnClickListener {
            viewModel.setValue(binding.countTextView.text.toString())
            viewModel.count()
        }

        binding.HelloButton?.setOnClickListener {
            transferDataToActivity()
        }
    }

    private fun transferDataToActivity() {
        val text = viewModel.liveData.value.toString()
        val intent = Intent(requireContext(), SayHelloActivity::class.java)
        val bundle = Bundle()
        bundle.putString(MESSAGE, text)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun observe() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            binding.countTextView.text = it
        }
    }

    private fun toast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val MESSAGE = "Key"
    }
}