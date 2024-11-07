package com.randel.agroguard


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tecnicoButton = findViewById<Button>(R.id.buttonParaActivityTecnico)
        val ocorrenciaButton = findViewById<Button>(R.id.buttonParaActivityOcorrencia)

        tecnicoButton.setOnClickListener {
            val intent = Intent(this, TecnicoActivity::class.java)
            startActivity(intent)
        }

        ocorrenciaButton.setOnClickListener {
            val intent = Intent(this, OcorrenciaActivity::class.java)
            startActivity(intent)
        }
    }
}
