package es.rafapuig.pmdm.lorempicsum.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// https://picsum.photos/id/0/info

@Serializable
data class ImageInfoDto(
    @SerialName("id") val id: Int,
    @SerialName("width") val width: Int,
    @SerialName("height") val height: Int,
    @SerialName("url") val url: String,
    @SerialName("author") val author: String
)
