package br.com.dev.searchapp.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dev.searchapp.controller.RepoController
import br.com.dev.searchapp.controller.UIController
import br.com.dev.searchapp.controller.UserController
import br.com.dev.searchapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var nomeUsuario: EditText
    private lateinit var btnConfirmar: Button
    private lateinit var listaRepositories: RecyclerView
    private lateinit var userController: UserController
    private lateinit var repoController: RepoController
    private lateinit var uiController: UIController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        userController = UserController(this)
        repoController = RepoController(this)
        uiController = UIController(this, listaRepositories)
        userController.loadUserToField(nomeUsuario)
        setupListeners()
    }

    private fun setupView() {
        nomeUsuario = findViewById(R.id.et_nome_usuario)
        btnConfirmar = findViewById(R.id.btn_confirmar)
        listaRepositories = findViewById(R.id.rv_lista_repositories)
        listaRepositories.layoutManager = LinearLayoutManager(this)
    }

    private fun setupListeners() {
        btnConfirmar.setOnClickListener {

            var usuario = nomeUsuario.text.toString().trim()

            if (usuario.isBlank()) {
                Toast.makeText(this, "Digite um nome de usuario", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            userController.saveUser(usuario)
            repoController.loadRepos(
                usuario,
                onSuccess = { repos ->
                    uiController.updateList(repos)
                },
                onError = {
                    Toast.makeText(this, "Erro ao carregar repositórios", Toast.LENGTH_SHORT).show()
                }
            )

        }
    }

}