package br.edu.ifsp.scl.sc3044807.fasttripplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etDestino: EditText
    private lateinit var etNumDias: EditText
    private lateinit var etOrcament: EditText
    private lateinit var bntAvancar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etDestino = findViewById<EditText>(R.id.etDestino)
        etNumDias = findViewById<EditText>(R.id.etDias)
        etOrcament = findViewById<EditText>(R.id.etOrcamento)
        bntAvancar = findViewById<Button>(R.id.buttonAvancar)

        bntAvancar.setOnClickListener {
            verificarCampos()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("Destino", etDestino.text.toString())
        outState.putString("Orçamento", etOrcament.text.toString())
        outState.putString("Dias", etNumDias.text.toString())

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        etDestino.setText(savedInstanceState.getString("Destino"))
        etOrcament.setText(savedInstanceState.getString("Orçamento"))
        etNumDias.setText(savedInstanceState.getString("Dias"))
    }


    fun verificarCampos(){

        val destino = etDestino.text.toString()
        val dias = etNumDias.text.toString()
        val orcamento = etOrcament.text.toString()

        when {
            destino.isEmpty() -> {
                Toast.makeText(this, "Informe o destino", Toast.LENGTH_SHORT).show()
            }
            dias.isEmpty() -> {
                Toast.makeText(this, "Informe o número de dias", Toast.LENGTH_SHORT).show()
            }
            orcamento.isEmpty() -> {
                Toast.makeText(this, "Informe o orçamento", Toast.LENGTH_SHORT).show()
            }
            dias.toInt() <= 0 -> {
                Toast.makeText(this, "Número de dias deve ser maior que zero", Toast.LENGTH_SHORT).show()
            }
            orcamento.toDouble() <= 0 -> {
                Toast.makeText(this, "Orçamento deve ser maior que zero", Toast.LENGTH_SHORT).show()
            }
            else -> {
                val intent = Intent(this, SegundaTelaActivity::class.java).apply {
                    putExtra("Destino", destino);
                    putExtra("Dias", dias.toInt());
                    putExtra("Orçamento", orcamento.toDouble());
                }
                startActivity(intent)
            }
        }

    }

}