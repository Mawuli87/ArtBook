package com.messieyawo.com.artbook.repo

import androidx.lifecycle.LiveData

import com.messieyawo.com.artbook.model.ImageResponse
import com.messieyawo.com.artbook.roomdb.Art
import com.messieyawo.com.artbook.utils.Resource

import retrofit2.Response

interface ArtRepositoryInterface {

    suspend fun insertArt(art : Art)

    suspend fun deleteArt(art: Art)

    fun getArt() : LiveData<List<Art>>

    suspend fun searchImage(imageString : String) : Resource<ImageResponse>

}