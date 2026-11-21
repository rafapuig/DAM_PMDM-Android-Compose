package es.rafapuig.pmdm.lorempicsum.domain.model

data class ImageInfo(
    val id: Int,
    val width: Int,
    val height: Int,
    val url: String,
    val author: String
)

val ImageInfo.aspectRatio: Float
    get() = width.toFloat() / height.toFloat()


