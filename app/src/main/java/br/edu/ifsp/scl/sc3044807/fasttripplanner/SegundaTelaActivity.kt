package br.edu.ifsp.scl.sc3044807.fasttripplanner

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SegundaTelaActivity : AppCompatActivity() {

    private var numeroDias: Int = 0
    private var destino: String = ""
    private var orcamento: Double = 0.0
    private lateinit var btnCalcular: Button
    private lateinit var btnVoltar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda_tela)

        numeroDias = intent.getIntExtra("Dias",0)
        orcamento = intent.getDoubleExtra("Orçamento",0.0)
        destino = intent.getStringExtra("Destino")



    }
}