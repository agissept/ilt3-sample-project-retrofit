package com.example.il3sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.il3sample.databinding.ActivityMainBinding
import com.example.il3sample.retrofit.RetrofitActivity
import com.example.il3sample.retrofitwithcoroutine.RetrofitWithCoroutineActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRetrofit.setOnClickListener {
            startActivity(Intent(this, RetrofitActivity::class.java))
        }

        binding.btnRetrofitCoroutine.setOnClickListener {
            startActivity(Intent(this, RetrofitWithCoroutineActivity::class.java))
        }

    }

}