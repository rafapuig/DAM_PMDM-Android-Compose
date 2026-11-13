package es.rafapuig.pmdm.previewsdemo.tags.model

import androidx.compose.ui.graphics.Color

data class Tag(
    val name: String,
    val color: Color
)

val tags = listOf(
    Tag("Acción", Color.Red),
    Tag("Aventura", Color.LightGray),
    Tag("Drama", Color.Green),
    Tag("Comedia", Color.Yellow),
    Tag("Terror", Color.Magenta),
    Tag("Ciencia Ficción", Color.Cyan),
    Tag("Fantasía", Color.Gray),
    Tag("Misterio", Color.Red),
    Tag("Suspense", Color.DarkGray),
    Tag("Animación", Color.LightGray),
    Tag("Musical", Color.Green),
    Tag("Romántica", Color.Yellow),
    Tag("Western", Color.Magenta),
)

