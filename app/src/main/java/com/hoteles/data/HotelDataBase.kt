package com.hoteles.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hoteles.model.Hotel

@Database(entities = [Hotel::class], version = 1, exportSchema = false)
abstract class HotelDataBase:RoomDatabase() {
    abstract fun hotelDao() : HotelDao

    companion object{
        @Volatile
        private var INSTANCE: HotelDataBase? = null

        fun getDataBase(context: android.content.Context) : HotelDataBase {
            val temp = INSTANCE
            if (temp != null) {
                return temp
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HotelDataBase::class.java,
                    "lugar_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }
}