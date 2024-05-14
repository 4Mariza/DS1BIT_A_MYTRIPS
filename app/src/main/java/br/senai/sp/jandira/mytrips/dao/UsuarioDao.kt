package br.senai.sp.jandira.mytrips.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.mytrips.model.Usuario

@Dao
interface UsuarioDao {
        @Insert
        fun salvar(usuario: Usuario): Long

        @Query("SELECT * FROM tbl_usuario ORDER BY nome ASC")
        fun listarTodosOsUsuarios(): List<Usuario>

        @Query("SELECT * FROM tbl_usuario WHERE id = :id")
        fun buscarUsuarioPeloId(id: Long): Usuario

}