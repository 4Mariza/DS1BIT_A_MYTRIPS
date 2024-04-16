package br.senai.sp.jandira.mytrips.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.Categoria

class CategoriaRepository {
    @Composable
    fun listarTodasAsCategorias(): List<Categoria>{

        val categoriaMountain = Categoria()
        categoriaMountain.id = 1
        categoriaMountain.categoria = "Mountain"
        categoriaMountain.icone = painterResource(id = R.drawable.moutain_icon)

        val categoriaSnow= Categoria()
        categoriaSnow.id = 2
        categoriaSnow.categoria = "Snow"
        categoriaSnow.icone = painterResource(id = R.drawable.snow)

        val categoriaBeach = Categoria()
        categoriaBeach.id = 3
        categoriaBeach.categoria = "Beach"
        categoriaBeach.icone = painterResource(id = R.drawable.beach)

        val categorias = listOf(categoriaMountain,categoriaSnow,categoriaBeach)

        return  categorias
    }
}