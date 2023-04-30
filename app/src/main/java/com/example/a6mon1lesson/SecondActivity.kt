package com.example.a6mon1lesson

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a6mon1lesson.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = intent.getStringExtra(MA_SA_TEXT)
        binding.edit1.setText(text)
        initListener()

    }

    private fun initListener() {
        binding.btn1.setOnClickListener {
            intent.putExtra(MA_SA_TEXT, binding.edit1.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
