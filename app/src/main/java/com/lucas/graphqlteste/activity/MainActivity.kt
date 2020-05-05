package com.lucas.graphqlteste.activity

import android.content.Intent
import android.os.Bundle
import com.lucas.graphqlteste.R
import com.lucas.graphqlteste.activity.Clientes.CadastroCliente
import com.lucas.graphqlteste.activity.Clientes.ListarClientes
import com.lucas.graphqlteste.activity.base.BaseActivity
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_toolbar.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Logger.addLogAdapter(AndroidLogAdapter())

        setupToolbar(toolbarMain, R.string.title_listar_clientes)

        cadastrarCliente.setOnClickListener {
            val intent = Intent(this, CadastroCliente::class.java)
            startActivity(intent)
        }

        listarClientes.setOnClickListener {
            val intent = Intent(this, ListarClientes::class.java)
            startActivity(intent)
        }


    }

    }





