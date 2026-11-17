# Práctica: TextLab – Laboratorio de textos con Jetpack Compose

## 1. Objetivo

En esta práctica desarrollarás una aplicación Android utilizando Jetpack Compose cuyo objetivo es mostrar diferentes posibilidades de presentación y personalización de textos.

La aplicación se llamará **TextLab** y funcionará como una pequeña guía visual de tipografía. A través de diferentes secciones aprenderás a trabajar con los estilos de texto de Material 3, fuentes personalizadas, recursos de cadenas, emojis y textos enriquecidos mediante `AnnotatedString`.

El resultado debe ser una pantalla cuidada visualmente, con una organización clara de los contenidos y una presentación coherente.

## 2. Diseño general

La aplicación tendrá una única pantalla desplazable verticalmente.

Organiza el contenido en diferentes secciones. Cada sección debe incluir:

- Un título que identifique el contenido.
- Una breve descripción de lo que se está mostrando.
- Uno o varios ejemplos visuales.

Utiliza tarjetas, separadores, márgenes y colores para conseguir una presentación agradable.

No es necesario implementar navegación, almacenamiento de datos ni conexión a Internet.

## 3. Secciones de la aplicación

### 3.1. Presentación

En la parte superior de la pantalla incluye una cabecera con:

- El nombre de la aplicación: **TextLab**.
- Un subtítulo: *Explora las posibilidades de la tipografía en Jetpack Compose*.
- Un pequeño texto introductorio.

Personaliza los textos utilizando diferentes propiedades de `TextStyle`.

Debes experimentar, como mínimo, con:

- `fontSize`
- `fontWeight`
- `fontStyle`
- `letterSpacing`
- `lineHeight`
- `textAlign`
- `color`

No es necesario utilizar todas estas propiedades en todos los textos.

### 3.2. Tipografía de Material 3

Crea una sección que muestre los diferentes estilos tipográficos proporcionados por Material 3.

Incluye ejemplos de los siguientes estilos:

- `displayLarge`
- `displayMedium`
- `headlineLarge`
- `headlineMedium`
- `titleLarge`
- `titleMedium`
- `bodyLarge`
- `bodyMedium`
- `bodySmall`
- `labelLarge`
- `labelMedium`
- `labelSmall`

Cada ejemplo debe mostrar el nombre del estilo y un texto que permita apreciar sus características.

Los estilos deben obtenerse a través de `MaterialTheme.typography`.

### 3.3. Textos como recursos

Todos los textos que formen parte del contenido de la aplicación deben almacenarse en el archivo `strings.xml`.

Debes utilizar `stringResource()` para obtenerlos desde los composables.

Además, incluye al menos dos recursos de texto que reciban parámetros.

Por ejemplo, un mensaje que muestre el nombre de una persona y otro que indique una puntuación.

No debes escribir directamente las cadenas de texto dentro de los composables cuando puedan definirse como recursos.

### 3.4. Herencia de estilos con LocalTextStyle

Crea una sección para demostrar cómo funciona `LocalTextStyle.current`.

Incluye un ejemplo en el que varios elementos `Text` compartan un estilo definido mediante `CompositionLocalProvider`.

A continuación, muestra cómo puedes personalizar individualmente alguno de esos textos sin modificar el estilo de los demás.

Por último, crea un composable reutilizable que reciba un `TextStyle` y permita combinarlo con el estilo actual de la composición.

El objetivo es comprobar cómo se propagan los estilos y cómo se pueden modificar sin perder las propiedades heredadas.

### 3.5. Fuentes personalizadas

Incorpora al menos dos familias tipográficas diferentes a la aplicación.

Para ello:

1. Añade los archivos de fuentes necesarios al proyecto.
2. Declara las correspondientes instancias de `FontFamily`.
3. Utiliza las fuentes en diferentes ejemplos de texto.
4. Muestra las diferencias entre los estilos normal, negrita y cursiva cuando la familia tipográfica disponga de esas variantes.

Cada ejemplo debe indicar qué fuente está utilizando.

No es suficiente con cambiar el tamaño o el grosor de una fuente del sistema: debes incorporar archivos de fuentes al proyecto.

### 3.6. Emojis

Crea una sección dedicada a mostrar diferentes formas de utilizar emojis en los textos.

Incluye ejemplos de:

- Emojis utilizados de forma independiente.
- Emojis combinados con palabras.
- Textos que incorporen varios emojis.
- Diferentes tamaños de texto con emojis.

Añade también un pequeño ejemplo de valoración mediante estrellas, utilizando emojis para representar la puntuación.

### 3.7. Textos enriquecidos con AnnotatedString

Esta es una de las secciones más importantes de la práctica.

Crea varios ejemplos de textos en los que diferentes fragmentos tengan estilos distintos.

Debes utilizar `AnnotatedString` y `buildAnnotatedString` para construir los textos.

Incluye ejemplos que permitan comprobar el funcionamiento de:

- `SpanStyle`
- `withStyle`
- `fontSize`
- `fontWeight`
- `fontStyle`
- `color`
- `textDecoration`

Los ejemplos deben combinar diferentes estilos dentro de un mismo texto.

Por ejemplo, puedes crear una descripción de un producto en la que aparezcan el nombre, el precio y algunas características destacadas mediante colores y estilos diferentes.

También debes incluir un ejemplo que combine varios párrafos y utilice `ParagraphStyle` para personalizar su presentación.

En este último ejemplo puedes experimentar con:

- Alineación del párrafo.
- Espaciado entre líneas.
- Sangría.
- Otros atributos disponibles de `ParagraphStyle`.

Incluye también algún emoji dentro de un `AnnotatedString`.

**Importante:** no debes resolver esta sección creando varios composables `Text` independientes. Cada ejemplo enriquecido debe construirse como un único texto mediante `AnnotatedString`.

### 3.8. Ficha final

Para finalizar, crea una ficha visual de un personaje ficticio, una película, un videojuego o un producto.

Esta ficha debe reunir los conceptos trabajados durante la práctica:

- Un título destacado.
- Una descripción.
- Una valoración mediante estrellas.
- Una lista de características.
- Fragmentos de texto con estilos diferentes.
- Al menos una fuente personalizada.
- Emojis integrados en el contenido.

Puedes utilizar `AnnotatedString` para enriquecer la descripción y destacar la información más importante.

La ficha debe servir como demostración final de las posibilidades de personalización de textos que ofrece Jetpack Compose.

## 4. Requisitos técnicos

La aplicación debe cumplir los siguientes requisitos:

1. Utilizar Jetpack Compose y Material 3.
2. Organizar la pantalla mediante composables reutilizables.
3. Utilizar `stringResource()` para obtener los textos desde `strings.xml`.
4. Definir y utilizar estilos mediante `TextStyle`.
5. Utilizar `LocalTextStyle.current` y `CompositionLocalProvider`.
6. Incorporar al menos dos familias tipográficas personalizadas.
7. Utilizar `AnnotatedString` y `buildAnnotatedString`.
8. Utilizar tanto `SpanStyle` como `ParagraphStyle`.
9. Permitir el desplazamiento vertical de toda la pantalla.
10. Mantener una presentación visual coherente y cuidada.

## 5. Criterios de evaluación

| Apartado | Puntuación |
|---|---:|
| Presentación y personalización de textos | 1,5 |
| Utilización de la tipografía de Material 3 | 1,0 |
| Gestión de textos mediante recursos | 1,0 |
| Herencia y personalización con LocalTextStyle | 1,5 |
| Incorporación de fuentes personalizadas | 1,0 |
| Utilización de emojis | 0,5 |
| Textos enriquecidos con AnnotatedString y SpanStyle | 2,0 |
| Personalización de párrafos con ParagraphStyle | 1,0 |
| Ficha final | 0,5 |
| **Total** | **10 puntos** |

## 6. Consideraciones finales

- Se valorará especialmente la claridad y organización del código.
- Los ejemplos deben ser suficientemente variados para demostrar que comprendes las propiedades utilizadas.
- Evita repetir ejemplos que únicamente cambien el contenido del texto.
- Utiliza nombres descriptivos para los composables y las variables.
- No concentres toda la implementación en una única función composable.
- La aplicación debe funcionar correctamente y no presentar errores de compilación.

**El objetivo no es simplemente mostrar muchos textos, sino demostrar que sabes controlar su apariencia y presentación utilizando las herramientas que proporciona Jetpack Compose.**