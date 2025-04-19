package com.example.galleryapp

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.galleryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var imageViews: List<ImageView>
    private var currentImage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Enable edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.hide()
        val textView = binding.textView
        var names = arrayOf("Rohit","Virat","Dhoni")

        // Store image views in a list
        imageViews = listOf(binding.pic0, binding.pic1, binding.pic2)

        // Show the first image
        updateImageVisibility()

        // Previous button click
        binding.imgbt2previous.setOnClickListener {
            currentImage = (imageViews.size + currentImage - 1) % imageViews.size
            textView.text = names[currentImage]
            updateImageVisibility()
        }

        // Next button click
        binding.imgbt2next.setOnClickListener {
            currentImage = (currentImage + 1) % imageViews.size
            textView.text = names[currentImage]
            updateImageVisibility()
        }
    }

    private fun updateImageVisibility() {
        imageViews.forEachIndexed { index, imageView ->
            imageView.alpha = if (index == currentImage) 1f else 0f
        }
    }
}
