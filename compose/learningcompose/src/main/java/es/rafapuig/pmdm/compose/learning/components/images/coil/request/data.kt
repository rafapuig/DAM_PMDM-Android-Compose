package es.rafapuig.pmdm.compose.learning.components.images.coil.request

import android.content.ContentUris
import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import es.rafapuig.pmdm.compose.learning.R
import es.rafapuig.pmdm.compose.learning.TAG
import java.io.File

private fun Context.buildImageRequest(
    block: (ImageRequest.Builder.() -> Unit)
) = ImageRequest.Builder(this).apply { block() }.build()

/**
 * 1. URL de internet
 *
 * Para que funcione se necesita tener configurado:
 * - el componente de red correspondiente
 * (por ejemplo, coil-network-okhttp o coil-network-ktor)
 * - y el permiso INTERNET
 */

val Context.urlRequest
    get() = buildImageRequest {
        val imageUrl = "https://picsum.photos/1220/2712"
        data(imageUrl)
    }


/**
 * 2. Recurso drawable
 * Se puede utilizar el identificador de un recurso drawable R.drawable.*
 */

val Context.resourceRequest
    get() = buildImageRequest {
        val drawableResId = R.drawable.spain_badge
        data(drawableResId)
    }


/**
 * 3. Recurso de assets
 * Se puede cargar una imagen almacenada en src/main/assets
 */
val Context.assetRequest
    get() =
        ImageRequest.Builder(this)
            .data("file:///android_asset/images/strawberries-1200x1200.jpg")
            .build()

/**
 * 4. Archivos del dispositivo
 * Puedes utilizar un objeto File
 *
 * Listar los archivos:
 * adb shell run-as es.rafapuig.pmdm.compose.learning ls -l files
 *
 * Para descargarla en el ordenador:
 * adb exec-out run-as es.rafapuig.pmdm.compose.learning cat files/photo.jpg > photo.jpg
 *
 * Para copiarla al almacenamiento privado desde el ordenador:
 * adb shell run-as es.rafapuig.pmdm.compose.learning mkdir -p files
 * adb push photo.jpg /data/local/tmp/photo.jpg
 * adb shell run-as es.rafapuig.pmdm.compose.learning cp /data/local/tmp/photo.jpg files/photo.jpg
 *
 */
val Context.fileRequest
    get() = let { context ->
        buildImageRequest {
            val file = File(context.filesDir, "photo.jpg")
            Log.i(TAG, file.absolutePath)
            data(file)
        }
    }


private fun loadPhotoIntoDevice(context: Context) {

    context.assets.open("images/strawberries-1200x1200.jpg").use { input ->
        context.openFileOutput("photo.jpg", Context.MODE_PRIVATE).use { output ->
            input.copyTo(output)
        }
    }

    val file = context.getFileStreamPath("photo.jpg")

    Log.d(TAG, "Existe: ${file.exists()}")
    Log.d(TAG, "Tamaño: ${file.length()} bytes")
    Log.d(TAG, "Ruta: ${file.absolutePath}")

    Log.d(TAG, "Paquete ${context.packageName}")
    Log.d(TAG, "Directorio: ${context.filesDir.absolutePath}")
    Log.d(TAG, "Contenido: ${context.fileList().contentToString()}")


}

private fun deletePhoto(context: Context) {
    context.fileList()
        .asList()
        .filter { it.endsWith(".jpg") }
        .forEach { fileName ->
            context.deleteFile(fileName)
        }
}


/**
 * 5. URI del dispositivo
 * Puedes utilizar un objeto Uri
 *
 * Es especialmente útil para imágenes procedentes de:
 * - Galería.
 * - Cámara.
 * - Selector de documentos.
 * - Proveedores de contenido (ContentProvider).
 */


val Context.uriRequest
    get() = buildImageRequest {
        val uri = "content://media/external/images/media/1".toUri() // No funciona
        data(uri)
    }


/**
 * También puedes utilizar URI de archivos:
 */

val Context.uriFileRequest
    get() = let { context ->
        context.buildImageRequest {
            val file = File(context.filesDir, "photo.jpg")
            data(Uri.fromFile(file))
        }
    }


/**
 * 6. Bitmap
 * Puedes proporcionar directamente un Bitmap
 * En este caso no necesitas que Coil obtenga ni decodifique la imagen desde un origen externo
 */

val Context.bitmapRequest
    get() = let { context ->
        context.buildImageRequest {
            val bitmap = BitmapFactory.decodeResource(
                context.resources,
                R.drawable.levante_ud_logo
            )
            data(bitmap)
        }
    }

/**
 * La forma en Composables de obtener un bitmap
 */
val bitmapRequest
    @Composable
    get() = with(LocalContext.current) {
        val bitmap = ImageBitmap.imageResource(R.drawable.levante_ud_logo)
        buildImageRequest {
            data(bitmap)
        }
    }

/**
 * 7. Drawable
 * También puedes proporcionar un objeto Drawable
 */

val Context.drawableRequest
    get() = let { context ->
        context.buildImageRequest {
            val drawable =
                context.getDrawable(R.drawable.levante_ud_logo)
            data(drawable)
        }
    }


@Composable
fun DataDemo(
    request: ImageRequest,
    modifier: Modifier = Modifier
) {
    AsyncImage(model = request, contentDescription = null)
}

@Preview
@Composable
private fun UrlDataPreview() {
    DataDemo(LocalContext.current.urlRequest)
}

@Preview
@Composable
private fun ResourceDataPreview() {
    DataDemo(LocalContext.current.resourceRequest)
}

@Preview
@Composable
private fun AssetDataPreview() {
    DataDemo(LocalContext.current.assetRequest)
}

@Preview
@Composable
private fun FileDataPreview() {
    val context = LocalContext.current

    LaunchedEffect(true) {
        loadPhotoIntoDevice(context)
    }

    DataDemo(context.fileRequest)

    SideEffect {
        deletePhoto(context)
    }
}

@Preview
@Composable
private fun UriDataPreview() {
    DataDemo(LocalContext.current.uriRequest)
}

@Preview
@Composable
private fun UriFileDataPreview() {
    DataDemo(LocalContext.current.uriFileRequest)
}

@Preview
@Composable
private fun BitmapFileDataPreview() {
    DataDemo(LocalContext.current.bitmapRequest)
}

@Preview
@Composable
private fun DrawableFileDataPreview() {
    DataDemo(LocalContext.current.drawableRequest)
}
