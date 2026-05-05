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

        //Recebe os dados da tela anterior
        numeroDias = intent.getIntExtra("Dias",0)
        orcamento = intent.getDoubleExtra("Orçamento",0.0)
        destino = intent.getStringExtra("Destino").toString()

        cbTransporte = findViewById<CheckBox>(R.id.cbTransporte)
        cbPasseio = findViewById<CheckBox>(R.id.cbPasseio)
        cbAlimentacao = findViewById<CheckBox>(R.id.cbAlimentacao)

        rdHospedagem = findViewById<RadioGroup>(R.id.rdHospedagem)

        btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnVoltar = findViewById<Button>(R.id.btnVoltar)

        //Botão calcular que chama a função calcular, posteriormente busca o texto da opção em hospedagem e cria a intent
        btnCalcular.setOnClickListener {
            val valorFinal = calcular()

            val selectedId = rdHospedagem.checkedRadioButtonId
            val selectValue = findViewById<RadioButton>(selectedId)
            val nomeHospedagem = selectValue?.text?.toString() ?: "Economica"

            //Intent que vai passar os dados para a proxima tela, envia todos os dados previos e o valor final
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

        //Botão que finaliza essa tela e volta para a anterior
        btnVoltar.setOnClickListener { finish() }

    }

    //Função para salvar uma instancia previa
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("TipoHospedagem", rdHospedagem.checkedRadioButtonId)
        outState.putBoolean("Transporte", cbTransporte.isChecked)
        outState.putBoolean("Alimentação", cbAlimentacao.isChecked)
        outState.putBoolean("Passeios", cbPasseio.isChecked)
    }

    //Função para atribuir os dados quando/se a página for recarregada
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        rdHospedagem.check(savedInstanceState.getInt("TipoHospedagem"))
        cbTransporte.isChecked = savedInstanceState.getBoolean("Transporte")
        cbAlimentacao.isChecked = savedInstanceState.getBoolean("Alimentação")
        cbPasseio.isChecked = savedInstanceState.getBoolean("Passeios")
    }

    //Função que usa a logica fornecida no slide, e retorna o valor final quando chamada
    fun calcular(): Double {
        var custoBase: Double = numeroDias*orcamento;

        //Verifica qual é o tipo de hospedagem e fornece o valor referente
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
