package com.softyus.appdanosnotransmitibles.Model.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey (autoGenerate = true) val idUser: Int = 0,
    val correo: String,
    val password: String
)
