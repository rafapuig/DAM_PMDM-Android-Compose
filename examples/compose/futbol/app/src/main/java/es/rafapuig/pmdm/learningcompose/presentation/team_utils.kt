package es.rafapuig.pmdm.learningcompose.presentation

import es.rafapuig.pmdm.learningcompose.R
import es.rafapuig.pmdm.learningcompose.domain.atlMadrid
import es.rafapuig.pmdm.learningcompose.domain.barcelonaFC
import es.rafapuig.pmdm.learningcompose.domain.bilbao
import es.rafapuig.pmdm.learningcompose.domain.levanteUD
import es.rafapuig.pmdm.learningcompose.domain.model.Team
import es.rafapuig.pmdm.learningcompose.domain.realMadrid
import es.rafapuig.pmdm.learningcompose.domain.sevillaFC
import es.rafapuig.pmdm.learningcompose.domain.valenciaCF

val Team.badgeId
    get() = when (this) {
        levanteUD -> R.drawable.levante_ud
        realMadrid -> R.drawable.real_madrid
        barcelonaFC -> R.drawable.barcelona
        atlMadrid -> R.drawable.atletico
        valenciaCF -> R.drawable.valencia
        sevillaFC -> R.drawable.sevilla
        bilbao -> R.drawable.bilbao
        else -> throw Exception("Equipo sin escudo")
    }
