package com.example.onboardingscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import com.example.onboardingscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setContentView(R.layout.activity_main)
        // Hide the title bar
        supportActionBar?.hide()
    }
    fun onClick(view: View) {
        when (view.id) {
            R.id.button8 -> {
                val intent =
                    Intent(this, OnboardingExample4Activity::class.java)
                startActivity(intent)
            }
        }
        }
}