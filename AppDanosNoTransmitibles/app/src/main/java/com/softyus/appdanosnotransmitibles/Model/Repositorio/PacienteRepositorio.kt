package com.softyus.appdanosnotransmitibles.Model.Repositorio

import androidx.lifecycle.LiveData
import com.softyus.appdanosnotransmitibles.Model.Dao.PacienteDao
import com.softyus.appdanosnotransmitibles.Model.Entity.PacienteEntity

class PacienteRepositorio(private val pacienteDao: PacienteDao) {

    val listaPacientes: LiveData<List<PacienteEntity>> = pacienteDao.obtenerPacientes()

    suspend fun isertarPacientes(paciente: PacienteEntity){
        pacienteDao.insertarPaciente(paciente)
    }

    suspend fun eliminarPaciente(paciente: PacienteEntity){
        pacienteDao.eliminarPaciente(paciente)
    }

    suspend fun actualizarPaciente(paciente: PacienteEntity){
        pacienteDao.actaulizarPaciente(paciente)
    }

}