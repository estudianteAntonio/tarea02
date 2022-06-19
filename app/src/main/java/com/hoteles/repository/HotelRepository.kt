package com.hoteles.repository

import androidx.lifecycle.LiveData
import com.hoteles.data.HotelDao
import com.hoteles.model.Hotel

class HotelRepository(private val hotelDao: HotelDao) {

    suspend fun addHotel(hotel: Hotel){
        hotelDao.addHotel(hotel)
    }

    suspend fun updateHotel(hotel: Hotel){
        hotelDao.updateHotel(hotel)
    }

    suspend fun deleteHotel(hotel: Hotel){
        hotelDao.deleteHotel(hotel)
    }

    val getAllData : LiveData<List<Hotel>> = hotelDao.getAllData()
}