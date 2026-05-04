package br.edu.ifsp.scl.sc3044807.fasttripplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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

        val tvDias = findViewById<TextView>(R.id.tvDias)
        val tvDestino = findViewById<TextView>(R.id.tvDestino)
        val tvValorFinal = findViewById<TextView>(R.id.tvValorFinal)
        val tvHospedagem = findViewById<TextView>(R.id.tvTipoHospedagem)
        val tvPasseios = findViewById<TextView>(R.id.tvPasseio)
        val tvTransporte = findViewById<TextView>(R.id.tvTransportes)
        val tvAlimentacao = findViewById<TextView>(R.id.tvAlimentacao)
        val tvOrcamento = findViewById<TextView>(R.id.tvOrcamento)

        tvDias.text = "Duração: $numeroDias dias"
        tvDestino.text = "Destino: $destino"
        tvOrcamento.text = "Orçamento: $orcamento"
        tvHospedagem.text = "Tipo de Hospedagem: $classificacaoHospedagem"
        tvValorFinal.text = "Total: R$$valorFinal"
        tvTransporte.text = "Transporte: ${if (transporte) "Incluso" else "Não selecionado"}"
        tvAlimentacao.text = "Alimentação: ${if (alimentacao) "Incluso" else "Não selecionado"}"
        tvPasseios.text = "Passeios: ${if (passeios) "Incluso" else "Não selecionado"}"

        val btnReiniciar = findViewById<Button>(R.id.btnReiniciar)

        btnReiniciar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }


    }
}