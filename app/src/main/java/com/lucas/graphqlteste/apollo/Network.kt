package com.lucas.graphqlteste.apollo

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

private val GRAPHQL_ENDPOINT: String = "https://hasura.io/learn/graphql"


class Network {

    private fun setupApollo(): ApolloClient? {
        val log: HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(log)
            .addInterceptor {
                val original = it.request()
                val builder = original.newBuilder().method(original.method, original.body)
                //builder.header("Authorization", authHeader)
                it.proceed(builder.build())
            }
            .build()

        return ApolloClient
            .builder()
            .serverUrl(GRAPHQL_ENDPOINT).build()
    }
}