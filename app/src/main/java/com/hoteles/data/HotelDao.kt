package com.hoteles.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hoteles.model.Hotel

@Dao
interface HotelDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHotel(hotel: Hotel)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateHotel(hotel: Hotel)

    @Delete
    suspend fun deleteHotel(hotel: Hotel)

    @Query("SELECT * FROM HOTEL")
    fun getAllData() : LiveData<List<Hotel>>

}
