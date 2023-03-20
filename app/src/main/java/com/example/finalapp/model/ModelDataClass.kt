package com.example.finalapp.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.quotable.io/quotes/"

data class Success(val quotes: List<ModelDataClass>)
data class ModelDataClass(
    var id: String,
    var content: String,
    var author: String
)

interface QuoteApi {
    @GET("random?limit=1")
    suspend fun getQuote(): List<ModelDataClass>

    companion object {
        var quotesService: QuoteApi? = null

        fun getInstance(): QuoteApi {
            if (quotesService === null) {
                quotesService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(QuoteApi::class.java)
            }
            return quotesService!!
        }
    }
}