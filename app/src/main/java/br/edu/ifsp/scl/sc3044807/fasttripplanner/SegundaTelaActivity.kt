package br.edu.ifsp.scl.sc3044807.fasttripplanner

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SegundaTelaActivity : AppCompatActivity() {

    private var numeroDias: Int = 0
    private var destino: String = ""
    private var orcamento: Double = 0.0

    private lateinit var cbTransporte: CheckBox
    private lateinit var cbAlimentacao: CheckBox
    private lateinit var cbPasseio: CheckBox

    private lateinit var rdHospedagem: RadioGroup

    private lateinit var tvHospedagem: TextView

    private lateinit var btnCalcular: Button
    private lateinit var btnVoltar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda_tela)

        numeroDias = intent.getIntExtra("Dias",0)
        orcamento = intent.getDoubleExtra("Orçamento",0.0)
        destino = intent.getStringExtra("Destino")

        cbTransporte = findViewById<CheckBox>(R.id.cbTransporte)
        cbPasseio = findViewById<CheckBox>(R.id.cbPasseio)
        cbAlimentacao = findViewById<CheckBox>(R.id.cbAlimentacao)

        tvHospedagem = findViewById<TextView>(R.id.tvHospedagem)
        rdHospedagem = findViewById<RadioGroup>(R.id.rdHospedagem)

        btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnVoltar = findViewById<Button>(R.id.btnVoltar)


    }
}