package com.example.mathfungame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
//    activity
    lateinit var addBtn: Button
    lateinit var subBtn: Button
    lateinit var mulBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        addBtn = findViewById(R.id.add)
        subBtn = findViewById(R.id.sub)
        mulBtn = findViewById(R.id.multiply)

//add button click
        addBtn.setOnClickListener {
val intent= Intent(this,GameActivity::class.java)
            startActivity(intent)
        }

//        sub button click
        subBtn.setOnClickListener {  }
//multiplication btn click
        mulBtn.setOnClickListener {  }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}