package br.senai.sp.jandira.mytrips.repository

import android.content.Context
import br.senai.sp.jandira.mytrips.dao.UsuarioDb
import br.senai.sp.jandira.mytrips.model.Usuario

class UsuarioRepository(context: Context) {
    private val db = UsuarioDb.getBancoDeDados(context).UsuarioDao()

    fun salvar(usuario: Usuario) : Long{
        return db.salvar(usuario)
    }

    fun validarLogin(email:String, senha:String): Boolean{
        return db.logar(email, senha)
    }

    fun buscarUsuarioPeloId(id: Long): Usuario {
        return db.buscarUsuarioPeloId(id)
    }
}