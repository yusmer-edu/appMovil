package com.softyus.appdanosnotransmitibles.Model.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.softyus.appdanosnotransmitibles.Model.Entity.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun insertar(usuario: UserEntity)

    @Delete
    suspend fun eliminar(usuario: UserEntity)

    @Update
    suspend fun actualizar(usuario: UserEntity)

    //Recupera la lista de datos en tiempo real
    @Query("SELECT * FROM user")
    fun obtenerUser(): LiveData<List<UserEntity>>
}