package br.edu.ifsp.scl.sc3044807.fasttripplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etDestino = findViewById<EditText>(R.id.etDestino)
        val etNumDias = findViewById<EditText>(R.id.etDias)
        val etOrcament = findViewById<EditText>(R.id.etOrcamento)
        val bntAvancar = findViewById<Button>(R.id.buttonAvancar)

        bntAvancar.setOnClickListener {
            val destino = etDestino.text.toString();
            val dias = etNumDias.text.toString();
            val orcamento = etOrcament.text.toString();

            if(destino.isNotEmpty() && dias.isNotEmpty() && orcamento.isNotEmpty()){
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