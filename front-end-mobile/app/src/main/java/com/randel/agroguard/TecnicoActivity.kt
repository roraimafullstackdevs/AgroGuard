package com.randel.agroguard

import com.randel.agroguard.Viewmodel.TecnicoViewModel
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.randel.agroguard.Data.Model.Tecnico

class TecnicoActivity : AppCompatActivity() {
    private val tecnicoViewModel: TecnicoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tecnico)

        val tecnicoIdEditText = findViewById<EditText>(R.id.editTextTecnicoId)
        val nomeEditText = findViewById<EditText>(R.id.editTextNome)
        val creaEditText = findViewById<EditText>(R.id.editTextCrea)
        val cpfEditText = findViewById<EditText>(R.id.editTextCpf)
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val senhaEditText = findViewById<EditText>(R.id.editTextSenha)
        val instituicaoEditText = findViewById<EditText>(R.id.editTextInstituicao)
        val messageTextView = findViewById<TextView>(R.id.textViewMessage)

        val addButton = findViewById<Button>(R.id.buttonAddTecnico)
        val updateButton = findViewById<Button>(R.id.buttonUpdateTecnico)
        val deleteButton = findViewById<Button>(R.id.buttonDeleteTecnico)

        tecnicoViewModel.messageLiveData.observe(this, Observer { message ->
            messageTextView.text = message
        })

        addButton.setOnClickListener {
            val tecnico = Tecnico(
                id = 0,
                nome = nomeEditText.text.toString(),
                crea = creaEditText.text.toString(),
                cpf = cpfEditText.text.toString(),
                email = emailEditText.text.toString(),
                senha = senhaEditText.text.toString(),
                instituicao = instituicaoEditText.text.toString()
            )
            tecnicoViewModel.addTecnico(tecnico)
        }

        updateButton.setOnClickListener {
            val id = tecnicoIdEditText.text.toString().toInt()
            val tecnico = Tecnico(
                id = id,
                nome = nomeEditText.text.toString(),
                crea = creaEditText.text.toString(),
                cpf = cpfEditText.text.toString(),
                email = emailEditText.text.toString(),
                senha = senhaEditText.text.toString(),
                instituicao = instituicaoEditText.text.toString()
            )
            tecnicoViewModel.updateTecnico(id, tecnico)
        }

        deleteButton.setOnClickListener {
            val id = tecnicoIdEditText.text.toString().toInt()
            tecnicoViewModel.deleteTecnico(id)
        }

        tecnicoViewModel.fetchAllTecnicos()
    }
}
