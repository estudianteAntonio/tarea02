package com.hoteles.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "hotel")
data class Hotel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "e-mail")
    val email: String?,
    @ColumnInfo(name = "telefono")
    val telefono: String?,
    @ColumnInfo(name = "direccion")
    val direccion: String?,
) : Parcelable
