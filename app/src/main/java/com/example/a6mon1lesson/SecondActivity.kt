package com.example.a6mon1lesson

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a6mon1lesson.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }
    private fun initClicker() {
        val text = intent.getStringExtra("result")
        with(binding) {
            edText.setText(text)
            btnBack.setOnClickListener {
                val resultText = edText.text.toString().trim()
                if (text?.isNotEmpty() == true){
                    val intent = Intent().apply {
                        putExtra("result",resultText)
                    }
                    setResult(RESULT_OK,intent)
                }
                finish()
            }
        }
    }
}