package com.messieyawo.com.artbook.api

import com.messieyawo.com.artbook.model.ImageResponse
import com.messieyawo.com.artbook.utils.Util.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {
    @GET("/api/")
    suspend fun imageSearch(
            @Query("q") searchQuery: String,
            @Query("key") apiKey : String = API_KEY
    ) : Response<ImageResponse>
}