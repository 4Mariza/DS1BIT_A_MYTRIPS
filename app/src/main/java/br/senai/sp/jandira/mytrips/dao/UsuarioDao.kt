package br.senai.sp.jandira.mytrips.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.mytrips.model.Usuario

@Dao
interface UsuarioDao {
        @Insert
        fun salvar(usuario: Usuario): Long

        @Query("SELECT * FROM tbl_usuario WHERE email=:email AND senha=:senha")
        fun logar(email:String, senha:String):Boolean

        @Query("SELECT * FROM tbl_usuario WHERE id = :id")
        fun buscarUsuarioPeloId(id: Long): Usuario

}