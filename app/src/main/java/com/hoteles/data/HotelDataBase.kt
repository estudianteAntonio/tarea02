package com.hoteles.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hoteles.model.Hotel

@Database(entities = [Hotel::class], version = 1, exportSchema = false)
abstract class HotelDataBase:RoomDatabase() {
    abstract fun hotelDao() : HotelDao

    companion object{

        @Volatile
        private var INSTANCE: HotelDataBase? = null



    }
}