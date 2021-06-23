package ru.webthebestapp.eldrorado_klient.data

import retrofit2.http.GET
import retrofit2.http.Path

interface BasketApi {
    @GET("client/basket/{clientId}")
    suspend fun getBasket(
        @Path("clientId") clientId: Int
    ) : List<Product>
}