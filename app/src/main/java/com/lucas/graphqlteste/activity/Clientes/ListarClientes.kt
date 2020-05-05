package com.lucas.graphqlteste.activity.Clientes

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apollographqlandroid.BuscaClienteQuery
import com.lucas.graphqlteste.R
import com.lucas.graphqlteste.activity.base.BaseActivity
import com.lucas.graphqlteste.adapter.ClientesAdapter
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_listar_clientes.*
import kotlinx.android.synthetic.main.include_toolbar.*

class ListarClientes : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_clientes)

        Logger.addLogAdapter(AndroidLogAdapter())

        setupToolbar(toolbarMain, R.string.title_listar_clientes,true)

        val viewModel: ListarClientesViewModel = ViewModelProviders.of(this).get(
            ListarClientesViewModel::class.java)

        setupObservers(viewModel)
    }

    private fun setupObservers(viewModel: ListarClientesViewModel){
        viewModel.clienteLiveData.observe(this, Observer {
            it?.let {listaClientes ->
                with(recycler_clientes){
                    layoutManager =
                        LinearLayoutManager(this@ListarClientes, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = ClientesAdapter(listaClientes as MutableList<BuscaClienteQuery.Cliente>)
                }
            }
        })
    }
}
