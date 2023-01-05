package com.messieyawo.com.artbook.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.messieyawo.com.artbook.roomdb.Art
import com.messieyawo.com.artbook.roomdb.ArtDao

@Database(entities = [Art::class],version = 1)
abstract class ArtDatabase : RoomDatabase() {
    abstract fun artDao() : ArtDao
}
