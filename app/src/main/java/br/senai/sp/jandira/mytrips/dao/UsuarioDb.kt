package br.senai.sp.jandira.mytrips.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.mytrips.model.Usuario

@Database(entities = [Usuario::class], version = 1)
abstract class UsuarioDb : RoomDatabase(){

    abstract fun UsuarioDao():UsuarioDao

    companion object{
        private lateinit var instancia: UsuarioDb

        fun getBancoDeDados(context: Context):UsuarioDb{
            instancia = Room
                .databaseBuilder(
                    context,
                    UsuarioDb::class.java,
                    "db_usuarios"
                )
                .allowMainThreadQueries()//permite que possa chamar o banco de dados no mesmo processo de controle da interface grafica
                .fallbackToDestructiveMigration()//nao faz migracao, se tiver uma versao nova ele destroi a velha
                .build()

            return instancia
        }
    }
}