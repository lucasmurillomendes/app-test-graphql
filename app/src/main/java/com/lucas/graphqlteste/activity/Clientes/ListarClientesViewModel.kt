package com.lucas.graphqlteste.activity.Clientes

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.apollographqlandroid.BuscaClienteQuery
import com.lucas.graphqlteste.apollo.ApolloConector

class ListarClientesViewModel : ViewModel() {

    val clienteLiveData: MutableLiveData<List<BuscaClienteQuery.Cliente>> = MutableLiveData()

    init {
        getClientes()
    }

    fun getClientes() {
        ApolloConector.setupApollo().query(
            BuscaClienteQuery.builder().build()
        )
            .enqueue(object : ApolloCall.Callback<BuscaClienteQuery.Data>() {
                override fun onResponse(response: Response<BuscaClienteQuery.Data>) {
                    val clientes: MutableList<BuscaClienteQuery.Cliente> = mutableListOf()
                    response.data?.let { it ->
                        for (result in it.Clientes()) {
                            clientes.add(result)
                        }

                    }
                    clienteLiveData.postValue(clientes)
                    Log.d("LISTA", clientes.toString())
                }

                override fun onFailure(e: ApolloException) {

                }

            })
    }


}