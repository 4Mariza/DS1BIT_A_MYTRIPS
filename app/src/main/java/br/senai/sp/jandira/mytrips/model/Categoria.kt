package br.senai.sp.jandira.mytrips.model

import androidx.compose.ui.graphics.painter.Painter

data class Categoria(
    var id: Int = 0,
    var categoria: String = "",
    var icone: Painter? = null
)
