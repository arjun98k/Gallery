package com.example.fragment1

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)

        fun replaceFrameWithFragment(frag: Fragment){
            val fragment = supportFragmentManager.beginTransaction()
            fragment.replace(R.id.frame, frag).commit()
        }

        button.setOnClickListener {
            replaceFrameWithFragment(clock_fragment())
        }
        button2.setOnClickListener {
            replaceFrameWithFragment(padhaifragment())
        }

    }
}