package br.senai.sp.jandira.mytrips.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.Viagem
import java.time.LocalDate

class ViagemRepository {
    @Composable
    fun listarTodasAsViagens(): List<Viagem>{

        //val viagens = listOf<>()
        val viagemLondres = Viagem()
        viagemLondres.id = 1
        viagemLondres.destino = "Londres"
        viagemLondres.descricao = "Londres, capital da Inglaterra e do Reino Unido, é uma cidade do século 21 com uma história que remonta à era romana."
        viagemLondres.dataChegada = LocalDate.of(2019,2,18)
        viagemLondres.dataPartida = LocalDate.of(2019, 2,21)
        viagemLondres.imagem = painterResource(id = R.drawable.london)

        val viagemPorto = Viagem()
        viagemPorto.id = 2
        viagemPorto.destino = "Porto"
        viagemPorto.descricao = " Porto é uma cidade costeira no noroeste de Portugal conhecida pelas pontes imponentes e pela produção de vinho do Porto."
        viagemPorto.dataChegada = LocalDate.of(2022,3,18)
        viagemPorto.dataPartida = LocalDate.of(2022, 4,21)
        viagemPorto.imagem =  painterResource(id = R.drawable.porto)

        val viagemChile = Viagem()
        viagemChile.id = 3
        viagemChile.destino = "Chile"
        viagemChile.descricao = " O Chile é um país de território comprido e estreito que se estende pelo extremo oeste da América do Sul, com mais de 6.000 km de litoral ao longo do Oceano Pacífico. "
        viagemChile.dataChegada = LocalDate.of(2024,6,27)
        viagemChile.dataPartida = LocalDate.of(2024, 7,4)
        viagemChile.imagem = painterResource(id = R.drawable.chile)

        val viagemCoreiaDoSul = Viagem()
        viagemCoreiaDoSul.id = 4
        viagemCoreiaDoSul.destino = "Coréia do Sul"
        viagemCoreiaDoSul.descricao = "A Coreia do Sul, uma nação do Leste da Ásia localizada na metade sul da Península da Coreia, compartilha uma das fronteiras mais militarizadas do mundo com a Coreia do Norte."
        viagemCoreiaDoSul.dataChegada = LocalDate.of(2023,1,16)
        viagemCoreiaDoSul.dataPartida = LocalDate.of(2024, 1,22)
        viagemCoreiaDoSul.imagem = painterResource(id = R.drawable.southkorea)

        val viagens = listOf(viagemLondres,viagemPorto,viagemChile, viagemCoreiaDoSul)

        return viagens
    }
}