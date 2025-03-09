package com.softyus.appdanosnotransmitibles.Model.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.softyus.appdanosnotransmitibles.Model.Entity.PacienteEntity

@Dao
interface PacienteDao {

    @Insert
    suspend fun insertarPaciente(paciente: PacienteEntity)

    @Delete
    suspend fun eliminarPaciente(paciente: PacienteEntity)

    @Update
    suspend fun actaulizarPaciente(paciente: PacienteEntity)

    //seleccionar todos los datos de la base de datos de paciente
    @Query("SELECT * FROM paciente")
    fun obtenerPacientes(): LiveData<List<PacienteEntity>>
}