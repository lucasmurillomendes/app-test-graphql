package com.lucas.graphqlteste.activity.Clientes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.apollographqlandroid.InsereMutation
import com.lucas.graphqlteste.R
import com.lucas.graphqlteste.activity.MainActivity
import com.lucas.graphqlteste.activity.base.BaseActivity
import com.lucas.graphqlteste.apollo.ApolloConector
import kotlinx.android.synthetic.main.activity_cadastro_cliente.*
import kotlinx.android.synthetic.main.include_toolbar.*

class CadastroCliente() : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_cliente)

        setupToolbar(toolbarMain, R.string.title_listar_clientes, true)

        buttonCadastrar.setOnClickListener {
            val nome = edit_nome.text.toString()
            val cpf = edit_cpf.text.toString()
            addMutation(cpf, nome)

        }

    }

    private fun addMutation(cpf: String, nome: String){
        val addCliente = InsereMutation
            .builder()
            .cpf(cpf)
            .nome(nome)
            .build()

        ApolloConector.setupApollo()
            .mutate(addCliente)
            .enqueue(object: ApolloCall.Callback<InsereMutation.Data>(){
                override fun onFailure(e: ApolloException) {
                    Toast.makeText(this@CadastroCliente, "Erro ao cadastrar Cliente", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(response: Response<InsereMutation.Data>) {
                    Toast.makeText(this@CadastroCliente, "Cliente: ${nome} cadastrado!", Toast.LENGTH_LONG).show()
                    startPrincipal()
                }
            })

    }

    private fun startPrincipal(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
