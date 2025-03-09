package com.softyus.appdanosnotransmitibles.Model.Repositorio

import androidx.lifecycle.LiveData
import com.softyus.appdanosnotransmitibles.Model.Dao.UserDao
import com.softyus.appdanosnotransmitibles.Model.Entity.UserEntity

class UsuarioRepositorio(private val userDao: UserDao) {
    val listaUsuarios: LiveData<List<UserEntity>> = userDao.obtenerUser()

    //para insertar usuario nuevos
    suspend fun insertarUser(usuario: UserEntity){
        userDao.insertar(usuario)
    }

    suspend fun actualizarUser(usuario: UserEntity){
        userDao.actualizar(usuario)
    }

    suspend fun eliminarUser(usuario: UserEntity){
        userDao.eliminar(usuario)
    }
}