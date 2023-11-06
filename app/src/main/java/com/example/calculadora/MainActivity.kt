package com.example.calculadora

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var conta: TextView
    private lateinit var resultado: TextView



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        conta = findViewById(R.id.conta)
        resultado = findViewById(R.id.resultado)

        findViewById<TextView>(R.id.zero).setOnClickListener {acrescentarExpressao2(string = "0", limpar_dados3 = true)}
        findViewById<TextView>(R.id.um).setOnClickListener {acrescentarExpressao2(string = "1", limpar_dados3 = true)}
        findViewById<TextView>(R.id.dois).setOnClickListener {acrescentarExpressao2(string = "2", limpar_dados3 = true)}
        findViewById<TextView>(R.id.tres).setOnClickListener {acrescentarExpressao2(string = "3", limpar_dados3 = true)}
        findViewById<TextView>(R.id.quatro).setOnClickListener {acrescentarExpressao2(string = "4", limpar_dados3 = true)}
        findViewById<TextView>(R.id.cinco).setOnClickListener {acrescentarExpressao2(string = "5", limpar_dados3 = true)}
        findViewById<TextView>(R.id.seis).setOnClickListener {acrescentarExpressao2(string = "6", limpar_dados3 = true)}
        findViewById<TextView>(R.id.sete).setOnClickListener {acrescentarExpressao2(string = "7", limpar_dados3 = true)}
        findViewById<TextView>(R.id.oito).setOnClickListener {acrescentarExpressao2(string = "8", limpar_dados3 = true)}
        findViewById<TextView>(R.id.nove).setOnClickListener {acrescentarExpressao2(string = "9", limpar_dados3 = true)}
        findViewById<TextView>(R.id.ponto).setOnClickListener {acrescentarExpressao2(string = ".", limpar_dados3 = true)}
        findViewById<TextView>(R.id.parenteses).setOnClickListener {acrescentarExpressao2(string = "()", limpar_dados3 = true)}


        findViewById<TextView>(R.id.somar).setOnClickListener {acrescentarExpressao2(string = "+", limpar_dados3 = false)}
        findViewById<TextView>(R.id.subtrair).setOnClickListener {acrescentarExpressao2(string = "-", limpar_dados3 = false)}
        findViewById<TextView>(R.id.divisao).setOnClickListener {acrescentarExpressao2(string = "/", limpar_dados3 = false)}
        findViewById<TextView>(R.id.multiplicar).setOnClickListener {acrescentarExpressao2(string = "*", limpar_dados3 = false)}
        findViewById<TextView>(R.id.porcentagem).setOnClickListener {acrescentarExpressao2(string = "%", limpar_dados3 = false)}


        findViewById<TextView>(R.id.limpar).setOnClickListener {
            conta.text = ""
            resultado.text = ""
        }

        findViewById<TextView>(R.id.apagar).setOnClickListener {
            val string = conta.text.toString()

            if (string.isNotBlank()) {
                conta.text = string.substring(0, string.length-1)
            }

            resultado.text = ""
        }

        findViewById<TextView>(R.id.igual).setOnClickListener{
            try {
                val conta = ExpressionBuilder(conta.text.toString()).build()

                val resultado2 = conta.evaluate()

                val longResult = resultado2.toLong()

                if(resultado2 == longResult.toDouble()){
                    resultado.text = longResult.toString()
                }else
                    resultado.text = resultado2.toString()

            }catch (e: Exception){
                resultado.text = "Error"
            }
        }
    }

    private fun acrescentarExpressao2(string: String, limpar_dados3: Boolean){

        if (resultado.text.isNotEmpty()){
            conta.text = ""
        }

        if (limpar_dados3){
            resultado.text = ""
            conta.append(string)
        }

        else{
            conta.append(resultado.text)
            conta.append(string)
            resultado.text = ""
        }

    }
}