package br.edu.ifsp.scl.sc3044807.fasttripplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
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

    private lateinit var tvHospedagem: TextView
    private lateinit var rdHospedagem: RadioGroup

    private lateinit var btnCalcular: Button
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda_tela)

        numeroDias = intent.getIntExtra("Dias",0)
        orcamento = intent.getDoubleExtra("Orçamento",0.0)
        destino = intent.getStringExtra("Destino").toString()

        cbTransporte = findViewById<CheckBox>(R.id.cbTransporte)
        cbPasseio = findViewById<CheckBox>(R.id.cbPasseio)
        cbAlimentacao = findViewById<CheckBox>(R.id.cbAlimentacao)

        tvHospedagem = findViewById<TextView>(R.id.tvHospedagem)
        rdHospedagem = findViewById<RadioGroup>(R.id.rdHospedagem)

        btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnVoltar = findViewById<Button>(R.id.btnVoltar)

        btnCalcular.setOnClickListener {
            var valorFinal = calcular()

            val selectedId = rdHospedagem.checkedRadioButtonId
            val selectValue = findViewById<RadioButton>(selectedId)
            val nomeHospedagem = selectValue?.text?.toString() ?: "Economica"

            val intent = Intent(this, TerceiraTelaActivity::class.java).apply {
                putExtra("Valor Final",valorFinal)
                putExtra("Dias",numeroDias)
                putExtra("Orçamento",orcamento)
                putExtra("Destino", destino)
                putExtra("Hospedagem",nomeHospedagem)
                putExtra("Transporte",cbTransporte.isChecked)
                putExtra("Alimentação",cbTransporte.isChecked)
                putExtra("Passeios", cbPasseio.isChecked)
            }
            startActivity(intent)
        }

        btnVoltar.setOnClickListener { finish() }

    }

    fun calcular(): Double {
        var custoBase: Double = numeroDias*orcamento;

        val hospedagem = when (rdHospedagem.checkedRadioButtonId){
            R.id.rbEconomica -> 1.0
            R.id.rbConforto -> 1.5
            R.id.rbLuxo -> 2.2
            else -> 1.0
        }
        custoBase *= hospedagem;
        if(cbTransporte.isChecked) custoBase += 300.0;
        if(cbAlimentacao.isChecked) custoBase += (50.0*numeroDias)
        if(cbPasseio.isChecked) custoBase += (120.0*numeroDias)

        return custoBase;
    }
}