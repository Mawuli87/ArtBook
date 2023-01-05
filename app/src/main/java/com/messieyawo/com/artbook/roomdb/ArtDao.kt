package com.messieyawo.com.artbook.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*
import com.messieyawo.com.artbook.roomdb.Art

@Dao
interface ArtDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArt(art : Art)

    @Delete
    suspend fun deleteArt(art: Art)

    @Query("SELECT * FROM arts")
    fun observeArts(): LiveData<List<Art>>

}