package com.softyus.appdanosnotransmitibles.Model.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.softyus.appdanosnotransmitibles.Model.Dao.PacienteDao
import com.softyus.appdanosnotransmitibles.Model.Dao.UserDao
import com.softyus.appdanosnotransmitibles.Model.Entity.PacienteEntity
import com.softyus.appdanosnotransmitibles.Model.Entity.UserEntity

@Database(
    entities = [UserEntity::class, PacienteEntity::class],
    version = 1
)
abstract class PacientesDataBase: RoomDatabase() {

    abstract fun userData(): UserDao
    abstract fun pacienteDao(): PacienteDao

    companion object{
        @Volatile
        private var INSTANCE: PacientesDataBase? = null

        fun getDatabase(context: Context): PacientesDataBase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PacientesDataBase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}