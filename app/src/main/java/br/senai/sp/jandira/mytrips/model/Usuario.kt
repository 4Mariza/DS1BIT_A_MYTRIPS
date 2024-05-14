package br.senai.sp.jandira.mytrips.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_usuario")
data class Usuario(
    @PrimaryKey(autoGenerate = true) var id:Long = 0,
    var nome: String = "",
    var telefone:String = "",
    var email: String = "",
    var senha: String = "",
    @ColumnInfo(name = "is_maior_de_idade") var isMaior:Boolean = false
)



