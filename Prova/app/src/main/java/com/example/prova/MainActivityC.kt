package com.example.prova

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prova.databinding.ActivityMainCBinding

class MainActivityC : AppCompatActivity() {

    private lateinit var binding: ActivityMainCBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        getExtra()
    }

    private fun initListeners() {
        binding.buttonNextC.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("msgC", "Mensagem C");
            startActivity(intent);
        }
    }

    private fun getExtra(){
        if(intent.hasExtra("msgB")) {
            val msgB = intent.getStringExtra("msgB")
            Toast.makeText(this, msgB, Toast.LENGTH_SHORT).show()
        }
    }
}