package com.softyus.appdanosnotransmitibles.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.softyus.appdanosnotransmitibles.Model.DataBase.PacientesDataBase
import com.softyus.appdanosnotransmitibles.Model.Entity.PacienteEntity
import com.softyus.appdanosnotransmitibles.Model.Repositorio.PacienteRepositorio
import kotlinx.coroutines.launch

class PatientViewModle(application: Application): AndroidViewModel(application) {

    private val repository: PacienteRepositorio
    val listPaciente: LiveData<List<PacienteEntity>>

    init{
        val patientDao = PacientesDataBase.getDatabase(application).pacienteDao()
        repository = PacienteRepositorio(patientDao)
        listPaciente = repository.listaPacientes
    }

    fun insertPatient(patient: PacienteEntity){
        viewModelScope.launch {
            repository.isertarPacientes(patient)
        }
    }

    fun deletePatient(patien: PacienteEntity){
        viewModelScope.launch {
            repository.eliminarPaciente(patien)
        }
    }

    fun updatePatient(patient: PacienteEntity){
        viewModelScope.launch {
            repository.actualizarPaciente(patient)
        }
    }
}