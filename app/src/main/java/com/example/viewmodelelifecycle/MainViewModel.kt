package com.example.viewmodelelifecycle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var mContador = MutableLiveData<String>().apply { value = contador.toString() }
    private var contador: Int = 0

    private fun validate() {
        if (contador > 5)
            contador = 0
        setMContador()
    }

    private fun setMContador() {
        mContador.value = contador.toString()
    }

    fun Contador() {
        contador++
        validate()
    }
}