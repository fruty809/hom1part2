package com.example.a6mon1lesson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.mon6hom12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val activityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                binding.edit.setText(result.data?.getStringExtra(MA_SA_TEXT))
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener()

    }

    private fun initListener() {
        binding.btn.setOnClickListener{
            if (binding.edit.text.isEmpty()){
                Toast.makeText(this, "Вы не ввели текст", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(MA_SA_TEXT,binding.edit.text.toString())
                activityLauncher.launch(intent)
            }
        }
    }

    companion object{
        const val MA_SA_TEXT = "MA_SA_TEXT"
    }
}
