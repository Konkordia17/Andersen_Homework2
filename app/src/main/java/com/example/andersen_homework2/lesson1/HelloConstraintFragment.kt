package com.example.andersen_homework2.lesson1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.andersen_homework2.R
import com.example.andersen_homework2.databinding.FragmentHelloConstraintBinding

class HelloConstraintFragment : Fragment(R.layout.fragment_hello_constraint) {
    private lateinit var binding: FragmentHelloConstraintBinding
    private val viewModel: HelloConstraintViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHelloConstraintBinding
            .inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        if (viewModel.liveData.value == null) {
            viewModel.setValue(binding.countTextViewCH.text.toString())
        }
        binding.buttonToastCH.setOnClickListener {
            toast("Hello Constraint!")
        }
        binding.countButtonCH.setOnClickListener {
            viewModel.setValue(binding.countTextViewCH.text.toString())
            viewModel.count()
        }
        binding.zeroButton.setOnClickListener {
            viewModel.setZero()
        }
    }

    private fun toast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    private fun observe() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            binding.countTextViewCH.text = it
            binding.zeroButton.isEnabled = !it.equals("0")
            if (it.toInt() % 2 == 0) {
                binding.countButtonCH.setBackgroundColor(
                    resources.getColor(R.color.red)
                )
            } else binding.countButtonCH.setBackgroundColor(resources.getColor(R.color.purple_700))

        }
    }
}

