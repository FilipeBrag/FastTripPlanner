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

        //Recebe os valores da tela anterior
        val numeroDias = intent.getIntExtra("Dias",0)
        val orcamento = intent.getDoubleExtra("Orçamento",0.0)
        val destino = intent.getStringExtra("Destino")
        val valorFinal = intent.getDoubleExtra("Valor Final",0.0)
        val classificacaoHospedagem = intent.getStringExtra("Hospedagem")
        val passeios = intent.getBooleanExtra("Passeios",false)
        val alimentacao = intent.getBooleanExtra("Alimentação",false)
        val transporte = intent.getBooleanExtra("Transporte",false)

        //Conecta os textViews com as variaveis do codigo
        val tvDias = findViewById<TextView>(R.id.tvDias)
        val tvDestino = findViewById<TextView>(R.id.tvDestino)
        val tvValorFinal = findViewById<TextView>(R.id.tvValorFinal)
        val tvHospedagem = findViewById<TextView>(R.id.tvTipoHospedagem)
        val tvPasseios = findViewById<TextView>(R.id.tvPasseio)
        val tvTransporte = findViewById<TextView>(R.id.tvTransportes)
        val tvAlimentacao = findViewById<TextView>(R.id.tvAlimentacao)
        val tvOrcamento = findViewById<TextView>(R.id.tvOrcamento)
        val btnReiniciar = findViewById<Button>(R.id.btnReiniciar)

        //Passa os valores recebidos para as variaveis linkadas com XML para que possa ser mostrado
        tvDias.text = "Duração: $numeroDias dias"
        tvDestino.text = "Destino: $destino"
        tvOrcamento.text = "Orçamento: $orcamento"
        tvHospedagem.text = "Tipo de Hospedagem: $classificacaoHospedagem"
        tvValorFinal.text = "Total: R$$valorFinal"
        tvTransporte.text = "Transporte: ${if (transporte) "Incluso" else "Não selecionado"}"
        tvAlimentacao.text = "Alimentação: ${if (alimentacao) "Incluso" else "Não selecionado"}"
        tvPasseios.text = "Passeios: ${if (passeios) "Incluso" else "Não selecionado"}"

        //Botão que enviar um intent vazia, voltando a pagina inicial sem nenhum tipo de dado
        btnReiniciar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }


    }
}
