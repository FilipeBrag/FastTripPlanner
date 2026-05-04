package br.edu.ifsp.scl.sc3044807.fasttripplanner

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TerceiraTelaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_terceira_tela)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val numeroDias = intent.getIntExtra("Dias",0)
        val orcamento = intent.getDoubleExtra("Orçamento",0.0)
        val destino = intent.getStringExtra("Destino")
        val valorFinal = intent.getDoubleExtra("Valor Final",0.0)
        val classificacaoHospedagem = intent.getStringExtra("Hospedagem")
        val passeios = intent.getBooleanExtra("Passeios",false)
        val alimentacao = intent.getBooleanExtra("Alimentação",false)
        val transporte = intent.getBooleanExtra("Transporte",false)




    }
}