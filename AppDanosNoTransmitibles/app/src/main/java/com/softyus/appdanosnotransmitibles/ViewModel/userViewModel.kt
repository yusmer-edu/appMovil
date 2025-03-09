package com.softyus.appdanosnotransmitibles.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.softyus.appdanosnotransmitibles.Model.Dao.UserDao
import com.softyus.appdanosnotransmitibles.Model.DataBase.PacientesDataBase
import com.softyus.appdanosnotransmitibles.Model.Entity.UserEntity
import com.softyus.appdanosnotransmitibles.Model.Repositorio.UsuarioRepositorio
import kotlinx.coroutines.coroutineScope

class userViewModel(application: Application): AndroidViewModel(application) {

    private val repository: UsuarioRepositorio
    val listUser: LiveData<List<UserEntity>>

    init {
        val userDao = PacientesDataBase.getDatabase(application).userData()
        repository = UsuarioRepositorio(userDao)
        listUser = repository.listaUsuarios
    }

    fun insertUser(user: UserEntity) {
        viewModelScope.launch{
            repository.insertarUser(user)
        }
    }

    fun updateUser(user: UserEntity){
        viewModelScope.launch{
            repository.actualizarUser(user)
        }
    }

    fun deletePaciente(user: UserEntity){
        viewModelScope.launch{
            repository.eliminarUser(user)
        }
    }

}