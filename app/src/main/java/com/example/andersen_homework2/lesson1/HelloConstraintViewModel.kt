package com.example.andersen_homework2.lesson1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HelloConstraintViewModel : ViewModel() {
    private val countLiveData = MutableLiveData<String>()
    val liveData: LiveData<String>
        get() = countLiveData

    fun count() {
        var firstValue: Int = countLiveData.value.toString().toInt()
        val newValue = ++firstValue
        countLiveData.value = newValue.toString()
    }

    fun setValue(text: String) {
        countLiveData.value = text
    }

    fun setZero() {
        countLiveData.value = "0"
    }
}
