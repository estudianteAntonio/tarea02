package com.hoteles.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.hoteles.data.HotelDataBase
import com.hoteles.model.Hotel
import com.hoteles.repository.HotelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HotelViewModel(application: Application): AndroidViewModel(application) {

    private val repository: HotelRepository

    val getAllData: LiveData <List<Hotel>>

    init{
        val hotelDao = HotelDataBase.getDataBase(application).hotelDao()
        repository = HotelRepository(hotelDao)
        getAllData = repository.getAllData
    }

    fun addHotel(hotel: Hotel){
        viewModelScope.launch(Dispatchers.IO){
            repository.addHotel(hotel)
        }
    }
    fun updateHotel(hotel: Hotel){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateHotel(hotel)
        }
    }
    fun deleteHotel(hotel: Hotel){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteHotel(hotel)
        }
    }
}