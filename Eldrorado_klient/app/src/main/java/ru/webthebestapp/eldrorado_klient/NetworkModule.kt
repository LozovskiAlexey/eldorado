package ru.webthebestapp.eldrorado_klient

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class NetworkModule {
    private val baseUrl = ""
    private val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }
    private val contentType = "application/json".toMediaType()

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory(contentType))
}