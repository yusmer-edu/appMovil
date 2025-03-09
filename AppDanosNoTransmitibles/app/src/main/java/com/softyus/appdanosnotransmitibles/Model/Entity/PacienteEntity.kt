package com.softyus.appdanosnotransmitibles.Model.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "paciente")
data class PacienteEntity(
    @PrimaryKey(autoGenerate = true) val IdPaciente: Int=0,
    val nombre: String,
    val apellido: String,
    val historialClinico: String,
    val medicamento: String,
    val dni: Int,
    val telefono: Int,
    val domicilio: String
)
