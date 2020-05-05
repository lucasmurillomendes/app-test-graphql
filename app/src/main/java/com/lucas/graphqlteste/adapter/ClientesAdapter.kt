package com.lucas.graphqlteste.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apollographqlandroid.BuscaClienteQuery
import com.lucas.graphqlteste.R
import kotlinx.android.synthetic.main.clientes_adapter.view.*

class ClientesAdapter(
    private val listaClientes: MutableList<BuscaClienteQuery.Cliente>
) :
    RecyclerView.Adapter<ClientesAdapter.ClienteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.clientes_adapter, parent, false)
        return ClienteViewHolder(view)
    }

    override fun getItemCount(): Int = listaClientes.size

    override fun onBindViewHolder(viewHolder: ClienteViewHolder, position: Int) {
        viewHolder.bindView(listaClientes[position])
    }

    class ClienteViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val nome = itemView.nome
        private val cpf = itemView.cpf

        fun bindView(cliente: BuscaClienteQuery.Cliente) {
            nome.text = cliente.nome()
            cpf.text = cliente.cpf()
        }
    }
}