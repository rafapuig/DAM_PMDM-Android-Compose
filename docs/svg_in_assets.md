# Cómo utilizar imágenes SVG almacenadas en assets con Jetpack Compose

Si tienes un archivo SVG dentro de `assets/`, no puedes utilizarlo directamente con `Image` de Jetpack Compose mediante `painterResource()` ni mediante `ImageVector.vectorResource()`.

Android no interpreta SVG de forma nativa. Tienes varias alternativas.

## 1. Convertir el SVG a Bitmap en tiempo de ejecución

Puedes utilizar una biblioteca que permita interpretar SVG, como **AndroidSVG**.

Añade la dependencia:

```kotlin
implementation("com.caverock:androidsvg:1.4")
```

Después puedes cargar el SVG desde `assets` y convertirlo a Bitmap:

```kotlin
val svg = SVG.getFromAsset(context.assets, "images/logo.svg")

val bitmap = Bitmap.createBitmap(
    512,
    512,
    Bitmap.Config.ARGB_8888
)

svg.renderToCanvas(Canvas(bitmap))
```

Y mostrarlo en Compose:

```kotlin
Image(
    bitmap = bitmap.asImageBitmap(),
    contentDescription = "Logo"
)
```

Necesitarás los imports correspondientes:

```kotlin
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.asImageBitmap
import com.caverock.androidsvg.SVG
```

## 2. Utilizar Coil con soporte SVG

Si ya utilizas Coil para cargar imágenes, puedes añadir su módulo SVG.

Añade las dependencias:

```kotlin
implementation("io.coil-kt.coil3:coil-compose:3.3.0")
implementation("io.coil-kt.coil3:coil-svg:3.3.0")
```

Puedes cargar el SVG desde `assets` con `AsyncImage`:

```kotlin
AsyncImage(
    model = ImageRequest.Builder(LocalContext.current)
        .data("file:///android_asset/images/logo.svg")
        .decoderFactory(SvgDecoder.Factory())
        .build(),
    contentDescription = "Logo"
)
```

## 3. ¿Qué alternativa elegir?

| Situación | Solución |
|---|---|
| SVG sencillo y estático | Vector Drawable |
| SVG complejo que quieres conservar en assets | AndroidSVG |
| Aplicación que ya utiliza Coil | Coil con módulo SVG |
| Imagen que no necesita escalarse | Convertir a WebP o PNG |

## Conclusión

Si estás trabajando con Jetpack Compose y quieres conservar los SVG en `assets`, una buena opción es utilizar **Coil con su módulo SVG**.

Te permite cargarlos directamente sin tener que implementar manualmente la conversión a Bitmap.