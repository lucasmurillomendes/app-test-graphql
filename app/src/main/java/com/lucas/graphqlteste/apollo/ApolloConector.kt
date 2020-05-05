package com.lucas.graphqlteste.apollo

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

object ApolloConector {

    private const val BASE_URL = "https://agenda-pets.herokuapp.com/v1/graphql"

    fun setupApollo(): ApolloClient {
        val okHttpClient = OkHttpClient.Builder().build()
        return ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttpClient)
            .build()
    }

}