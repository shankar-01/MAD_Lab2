package com.example.lab2task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Page2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)
    }
    fun goback(v: View){
        finish();
    }
}