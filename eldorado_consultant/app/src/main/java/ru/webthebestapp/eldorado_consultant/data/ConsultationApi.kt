package ru.webthebestapp.eldorado_consultant.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import ru.webthebestapp.eldorado_consultant.data.Basket
import ru.webthebestapp.eldorado_consultant.data.ConsultantStatistic
import ru.webthebestapp.eldorado_consultant.data.ConsultationClient
import ru.webthebestapp.eldorado_consultant.data.Product

interface ConsultationApi {

    //getting customer data
    @GET("client/{consultantId}/{clientId}")
    suspend fun getConsultation(
        @Path("consultantId") consultantId: Int,
        @Path("clientId") clientId: Int
    ): ConsultationClient

    //add product to basket
    @GET("consultation/{consultationId}/{productId}")
    suspend fun getProduct(
        @Path("consultationId") consultationId:Int,
        @Path("productId") productId: Int
    ): Product

    //send basket to client id, amount
    @POST("client/{consultationId}")
    suspend fun sendBasket(@Body products: Map<Int,Int>)

    //set tags to client
    @POST("client/tags/{clientId}")
    suspend fun setClientTags(@Body tags: List<String>)

    //get consultant statistics
    @GET("statistics/{consultantId}")
    suspend fun getConsultantStatistics(
        @Path("consultantId") consultationId:Int
    ) : ConsultantStatistic

}