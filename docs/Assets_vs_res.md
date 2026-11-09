# Diferencias entre `assets/` y `res/` en Android Studio

En Android Studio, la diferencia fundamental entre las carpetas `assets/` y `res/` es cómo Android gestiona los archivos que contienen y cómo accedemos a ellos desde el código.

Ambas sirven para incluir recursos dentro de la aplicación, pero tienen propósitos diferentes.

## 1. Carpeta `res/`

Contiene los recursos que Android reconoce y gestiona automáticamente.

Su principal característica es que **Android genera identificadores para los recursos**, accesibles mediante la clase `R`.

Por ejemplo:

```kotlin
val image = R.drawable.logo
val title = R.string.app_name
val color = R.color.primary
```

Su estructura habitual es:

```text
app/
 └── src/
     └── main/
         └── res/
             ├── drawable/
             ├── mipmap/
             ├── layout/
             ├── values/
             │   ├── strings.xml
             │   ├── colors.xml
             │   └── themes.xml
             ├── raw/
             └── font/
```

Algunos de sus directorios más importantes:

| Directorio | Contenido |
|---|---|
| `drawable/` | Imágenes y recursos gráficos XML. |
| `mipmap/` | Iconos de la aplicación. |
| `layout/` | Diseños XML de interfaces tradicionales. |
| `values/` | Strings, colores, dimensiones, estilos, etc. |
| `raw/` | Archivos multimedia y otros archivos sin procesar. |
| `font/` | Tipografías. |

### Ventajas de `res/`

- Acceso mediante identificadores `R`.
- Posibilidad de ofrecer diferentes versiones según idioma, densidad de pantalla, orientación, tamaño, etc.
- Integración con el sistema de recursos de Android.
- Posibilidad de utilizar referencias entre recursos.

Por ejemplo, podemos tener:

```text
res/
 ├── drawable/
 │    └── logo.png
 ├── drawable-hdpi/
 │    └── logo.png
 └── drawable-xhdpi/
      └── logo.png
```

Android seleccionará automáticamente la imagen adecuada según las características del dispositivo.

## 2. Carpeta `assets/`

Contiene archivos que Android incluye en el APK como archivos normales, sin procesarlos ni asignarles identificadores `R`.

Su estructura puede ser completamente libre:

```text
app/
 └── src/
     └── main/
         └── assets/
             ├── data/
             │    ├── countries.json
             │    └── users.json
             ├── html/
             │    └── help.html
             ├── fonts/
             │    └── custom_font.ttf
             └── documents/
                  └── manual.pdf
```

Para acceder a ellos utilizamos `AssetManager`.

Por ejemplo, para leer un JSON:

```kotlin
val json = assets.open("data/countries.json")
    .bufferedReader()
    .use { it.readText() }
```

También podemos acceder desde `AssetManager` a sus nombres:

```kotlin
val files = assets.list("data")
```

### Características de `assets/`

- No genera identificadores en `R`.
- Permite organizar archivos en subdirectorios libremente.
- Los archivos se conservan con sus nombres y estructura.
- Accedemos a ellos mediante `AssetManager`.
- No ofrece automáticamente variantes según idioma, densidad de pantalla, etc.

## 3. Comparación directa

| Característica | `res/` | `assets/` |
|---|---|---|
| Genera identificadores `R` | Sí | No |
| Admite subdirectorios | Limitados y específicos | Sí, libremente |
| Acceso | Mediante `R` | Mediante `AssetManager` |
| Variantes por configuración | Sí | No |
| Procesamiento de recursos | Sí | No |
| Referencias entre recursos | Sí | No |
| Uso habitual | Recursos de interfaz | Archivos y datos de la aplicación |

## 4. ¿Cuándo utilizar cada una?

### Utiliza `res/` cuando...

- Necesites imágenes para la interfaz.
- Quieras definir colores, dimensiones o textos.
- Necesites traducciones.
- Quieras diferentes versiones de una imagen según la densidad de pantalla.
- Necesites fuentes o animaciones como recursos Android.

### Utiliza `assets/` cuando...

- Tengas archivos JSON o XML que quieras leer.
- Incluyas documentos PDF.
- Necesites archivos HTML para mostrar en un WebView.
- Incluyas bases de datos precargadas.
- Necesites archivos organizados en una estructura de directorios propia.

## 5. Una diferencia importante: `res/raw` frente a `assets`

Esta es una cuestión interesante que suele generar dudas.

Imagina que quieres incluir un archivo JSON con información de países.

### Opción A: `res/raw/countries.json`

```kotlin
val json = resources.openRawResource(R.raw.countries)
    .bufferedReader()
    .use { it.readText() }
```

### Opción B: `assets/countries.json`

```kotlin
val json = assets.open("countries.json")
    .bufferedReader()
    .use { it.readText() }
```

Ambas opciones permiten leer el contenido del archivo. Sin embargo:

- `res/raw` es adecuado cuando quieres incluir archivos como recursos Android y acceder a ellos mediante `R.raw`.
- `assets` es más apropiado cuando necesitas una estructura de archivos libre, con subdirectorios y nombres arbitrarios.

## Conclusión

**Una regla sencilla para recordar:**

Si es un recurso que Android debe reconocer y gestionar, utiliza `res`.

Si es un archivo que tu aplicación necesita leer directamente, normalmente utiliza `assets`.