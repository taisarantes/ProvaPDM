package com.example.prova

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prova.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        getExtra()

    }

    private fun initListeners() {
        binding.buttonNext.setOnClickListener {
            val intent = Intent(this, MainActivityB::class.java)
            intent.putExtra("msgA", "Mensagem da Activity A");
            startActivity(intent);
        }
    }

    private fun getExtra(){
        if(intent.hasExtra("msgC")) {
            val msgC = intent.getStringExtra("msgC")
            Toast.makeText(this, msgC, Toast.LENGTH_SHORT).show()
        }
    }
}