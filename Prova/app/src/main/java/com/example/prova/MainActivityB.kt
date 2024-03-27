package com.example.prova

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prova.databinding.ActivityMainBBinding

class MainActivityB : AppCompatActivity() {

    private lateinit var binding: ActivityMainBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        getExtra()
    }

    private fun initListeners() {
        binding.buttonNextB.setOnClickListener {
            val intent = Intent(this, MainActivityC::class.java)
            intent.putExtra("msgB", "Mensagem B");
            startActivity(intent);
        }
    }

    private fun getExtra(){
        if(intent.hasExtra("msgA")) {
            val msgC = intent.getStringExtra("msgA")
            Toast.makeText(this, msgC, Toast.LENGTH_SHORT).show()
        }
    }
}