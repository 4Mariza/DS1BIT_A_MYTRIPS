package br.senai.sp.jandira.mytrips

import java.time.LocalDate

fun simplificarData(dataCompleta: LocalDate): String{
    val dia = "${dataCompleta.dayOfMonth}"
    val mes = "${dataCompleta.month}".substring(0..2)
    return "$dia $mes"
}
