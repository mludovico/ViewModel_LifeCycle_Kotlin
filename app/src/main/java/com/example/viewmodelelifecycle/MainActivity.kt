package com.example.viewmodelelifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDados()
        initListeners()
    }

    private fun initDados() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.mContador.observe(this, Observer { valor->
            dataEdit.setText(valor)
        })
    }

    private fun initListeners() {
        dataButton.setOnClickListener {
            mViewModel.Contador()
        }
        showButton.setOnClickListener {
            Toast.makeText(this, "Valor contador: ${mViewModel.mContador.value}", Toast.LENGTH_SHORT).show()
        }
    }

}