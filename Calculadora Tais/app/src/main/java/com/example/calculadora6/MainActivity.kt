package com.example.calculadora6

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcular.setOnClickListener {
            val num1 = binding.num1.text.toString().toDouble()
            val num2 = binding.num2.text.toString().toDouble()
            var resultado = 0.0

            val operacaoId = obterOperacaoSelecionada() ?: "0"
            when(operacaoId){
                binding.soma.id -> {
                    resultado = soma(num1, num2)
                }
                binding.subtracao.id -> {
                    resultado = subtracao(num1, num2)
                }
                binding.multiplicacao.id -> {
                    resultado = multiplicacao(num1, num2)
                }
                else -> {
                    if (num2 == 0.0) {
                        Toast.makeText(this, "Não é possível dividir por 0"
                            , Toast.LENGTH_SHORT).show()
                    } else {
                        resultado = divisao(num1, num2)
                    }
                }
            }

            binding.resultado.text = String.format("%.2f", resultado)
        }

    }

    private fun soma(num1: Double, num2: Double): Double {
        return num1 + num2
    }

    private fun subtracao(num1: Double, num2: Double): Double {
        return num1 - num2
    }

    private fun multiplicacao(num1: Double, num2: Double): Double {
        return num1 * num2
    }

    private fun divisao(num1: Double, num2: Double): Double {
        return num1 / num2
    }

    private fun obterOperacaoSelecionada(): Int? {
        val radioGroupOperacoes = binding.radioGroup1
        val checkedId = radioGroupOperacoes.checkedRadioButtonId

        return if (checkedId == -1) {
            null
        } else {
            radioGroupOperacoes.findViewById<RadioButton>(checkedId).id
        }
    }
}