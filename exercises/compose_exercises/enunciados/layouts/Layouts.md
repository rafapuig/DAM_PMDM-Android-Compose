# Práctica: MeasureLab – El sistema de medición de Jetpack Compose

## 1. Objetivos

En esta práctica aprenderás a construir interfaces mediante los layouts básicos de Jetpack Compose y a controlar el tamaño y la distribución de sus elementos.

El objetivo principal es comprender cómo funciona el proceso de medición de los composables y cómo intervienen los modificadores en dicho proceso.

Al finalizar la práctica deberás ser capaz de:

- Utilizar `Box`, `Row` y `Column` para organizar elementos.
- Comprender cómo se transmiten las restricciones de tamaño entre un padre y sus hijos.
- Entender cómo se determina el tamaño final de un composable.
- Utilizar modificadores para establecer dimensiones y limitar el espacio disponible.
- Comprender por qué el orden de los modificadores puede cambiar el resultado.
- Distribuir el espacio disponible entre varios elementos.
- Utilizar `BoxWithConstraints` para crear interfaces adaptables.
- Diferenciar entre el tamaño solicitado por un composable y el tamaño que finalmente puede adoptar.

## 2. Organización del proyecto

Crea un proyecto Android con Jetpack Compose y Material 3.

La aplicación se llamará **MeasureLab**.

La pantalla principal tendrá diferentes secciones, cada una dedicada a un conjunto de experimentos.

Organiza el código mediante composables reutilizables. No debes implementar toda la práctica dentro de una única función.

Para facilitar la observación de los resultados:

- Utiliza colores de fondo diferentes para distinguir los contenedores.
- Utiliza bordes para identificar los límites de los composables.
- Añade etiquetas que indiquen las dimensiones solicitadas y las propiedades utilizadas.
- Evita que los elementos queden ocultos o fuera de la pantalla.

La pantalla principal debe permitir desplazarse verticalmente para acceder a todos los experimentos.

---

# PARTE 1. Comprender el proceso de medición

## 3. ¿Quién decide el tamaño?

Antes de empezar a utilizar los diferentes modificadores, debes comprender cómo se determina el tamaño de los composables.

En Jetpack Compose, el proceso de medición se basa en el intercambio de restricciones y dimensiones entre los elementos de la jerarquía.

De forma simplificada, el proceso es el siguiente:

1. Un composable recibe unas restricciones de tamaño de su padre.
2. Cuando necesita medir a sus hijos, les transmite unas restricciones.
3. Cada hijo determina el tamaño que puede adoptar respetando esas restricciones.
4. Los hijos comunican al padre sus dimensiones medidas.
5. El padre determina su propio tamaño y posiciona a sus hijos.

Las restricciones establecen los tamaños mínimo y máximo que puede adoptar un elemento.

Por ejemplo, un hijo podría recibir las siguientes restricciones:

- Ancho mínimo: 0 dp.
- Ancho máximo: 300 dp.
- Alto mínimo: 0 dp.
- Alto máximo: 200 dp.

Esto significa que el hijo podrá adoptar cualquier tamaño dentro de esos límites.

### Ejercicio 1.1. Un padre y varios hijos

Construye un `Column` que contenga tres elementos `Box`.

Cada elemento tendrá:

- Un color de fondo diferente.
- Un tamaño solicitado diferente.
- Un texto que indique sus dimensiones.

Utiliza los siguientes tamaños:

| Elemento | Ancho | Alto |
|---|---:|---:|
| Primero | 120 dp | 80 dp |
| Segundo | 180 dp | 100 dp |
| Tercero | 240 dp | 120 dp |

El `Column` debe tener un ancho máximo de 300 dp.

**Antes de ejecutar la aplicación, responde:**

1. ¿Qué tamaño tendrá cada uno de los tres hijos?
2. ¿Qué ancho tendrá el `Column`?
3. ¿Qué ocurriría si el tercer elemento solicitase un ancho de 400 dp?
4. ¿El tamaño del padre depende del tamaño de sus hijos?

Ejecuta el programa y comprueba tus respuestas.

### Ejercicio 1.2. El padre tiene un tamaño limitado

Repite el ejercicio anterior, pero esta vez establece un tamaño de 200 × 250 dp para el `Column`.

Mantén las dimensiones solicitadas por los hijos.

**Antes de ejecutar la aplicación, responde:**

1. ¿Podrán los hijos adoptar los tamaños solicitados?
2. ¿Qué ocurrirá con el ancho del tercer elemento?
3. ¿Qué ocurrirá con la altura total de los tres elementos?
4. ¿Qué diferencias observas respecto al ejercicio anterior?

Presta especial atención a la diferencia entre el tamaño solicitado por un hijo y el tamaño que finalmente puede adoptar.

### Ejercicio 1.3. Visualización de los límites

Modifica los ejemplos anteriores para que se puedan distinguir claramente:

- El espacio ocupado por el padre.
- El espacio ocupado por cada hijo.
- Los límites de cada elemento.

Utiliza `background`, `border` y `padding` para visualizar las diferentes áreas.

No debes utilizar imágenes para representar los contenedores: los colores y los bordes deben permitir identificar la estructura real del layout.

---

# PARTE 2. Modificadores relacionados con el tamaño

## 4. Experimentando con las dimensiones

En esta parte trabajarás con los modificadores que permiten establecer o limitar las dimensiones de los composables.

### Ejercicio 2.1. size, width y height

Crea una sección con varios elementos `Box` que permitan comparar los siguientes modificadores:

- `size`
- `width`
- `height`

Utiliza diferentes combinaciones de dimensiones.

Por ejemplo:

- Un elemento con `size(120.dp)`.
- Un elemento con `size(120.dp, 80.dp)`.
- Un elemento con `width(180.dp)`.
- Un elemento con `height(100.dp)`.

Coloca todos los elementos dentro de un contenedor que tenga unas dimensiones conocidas.

Comprueba cómo se comporta cada modificador cuando el padre dispone de espacio suficiente.

### Ejercicio 2.2. fillMaxSize y fillMaxWidth

Crea varios ejemplos que permitan observar el funcionamiento de:

- `fillMaxSize()`
- `fillMaxWidth()`
- `fillMaxHeight()`

Realiza los experimentos dentro de contenedores con dimensiones conocidas.

Comprueba qué ocurre cuando:

- El padre tiene un tamaño fijo.
- El padre ocupa todo el espacio disponible.
- El padre tiene unas dimensiones limitadas.

**Responde:** ¿Qué significa realmente ocupar todo el espacio disponible? ¿Es lo mismo que ocupar toda la pantalla?

### Ejercicio 2.3. wrapContentSize

Construye un `Box` de 300 × 200 dp que contenga un elemento más pequeño.

Experimenta con:

- `wrapContentSize()`.
- `wrapContentSize(Alignment.Center)`.
- `wrapContentSize(Alignment.TopStart)`.
- `wrapContentSize(Alignment.BottomEnd)`.

Comprueba cómo cambia la posición del contenido.

A continuación, compara los resultados con los obtenidos utilizando `fillMaxSize()`.

### Ejercicio 2.4. requiredSize

Este ejercicio es especialmente importante.

Crea un contenedor de 200 × 150 dp y coloca en su interior un elemento que solicite un tamaño superior mediante `requiredSize`.

Prueba diferentes dimensiones, por ejemplo:

- 250 × 100 dp.
- 300 × 200 dp.
- 400 × 250 dp.

Observa qué ocurre con el elemento y con el tamaño de su padre.

**Responde:**

1. ¿Qué diferencia existe entre `size` y `requiredSize`?
2. ¿Puede un hijo adoptar un tamaño superior al máximo permitido por las restricciones que recibe?
3. ¿Qué tamaño considera el padre que tiene su hijo?
4. ¿Qué ocurre visualmente cuando el hijo supera los límites del padre?

### Ejercicio 2.5. widthIn, heightIn y sizeIn

Crea diferentes elementos que permitan experimentar con:

- `widthIn`
- `heightIn`
- `sizeIn`

Establece límites mínimos y máximos para las dimensiones.

Por ejemplo:

- Ancho mínimo de 100 dp.
- Ancho máximo de 250 dp.
- Alto mínimo de 50 dp.
- Alto máximo de 150 dp.

Prueba a combinar estos modificadores con `size`, `width` y `height`.

Comprueba qué sucede cuando las dimensiones solicitadas quedan fuera de los límites establecidos.

### Ejercicio 2.6. aspectRatio

Construye varios elementos con diferentes proporciones utilizando `aspectRatio`.

Prueba, como mínimo, estas proporciones:

- 1:1.
- 4:3.
- 16:9.
- 3:4.

Coloca los elementos dentro de contenedores de diferentes dimensiones.

Comprueba cómo se determina la dimensión que no has especificado directamente.

---

# PARTE 3. El orden de los modificadores

## 5. ¿Importa el orden?

Los modificadores de Compose se aplican en el orden en el que aparecen en la cadena.

Esto puede modificar las restricciones que recibe un elemento y, por tanto, el tamaño que termina adoptando.

### Ejercicio 3.1. Padding y size

Crea dos elementos `Box` y aplica los siguientes modificadores:

**Elemento A:**

    Modifier
        .padding(16.dp)
        .size(100.dp)

**Elemento B:**

    Modifier
        .size(100.dp)
        .padding(16.dp)

Coloca ambos dentro de un contenedor y utiliza colores diferentes para visualizar los resultados.

**Responde:**

1. ¿Tienen ambos elementos el mismo tamaño exterior?
2. ¿Qué tamaño tiene el área interior de cada uno?
3. ¿Por qué cambia el resultado al modificar el orden?
4. ¿Qué espacio ocupa cada elemento dentro del padre?

### Ejercicio 3.2. Combinaciones de modificadores

Realiza nuevos experimentos combinando:

- `padding` y `fillMaxWidth`.
- `padding` y `fillMaxSize`.
- `size` y `background`.
- `background` y `padding`.
- `widthIn` y `width`.
- `size` y `requiredSize`.

En cada caso, crea dos versiones cambiando el orden de los modificadores.

No basta con mostrar los resultados: debes explicar qué diferencias se producen y por qué.

---

# PARTE 4. El layout Box

## 6. Superposición y alineación

El layout `Box` permite colocar varios elementos en la misma área, superponiéndolos y controlando su alineación.

### Ejercicio 4.1. Elementos superpuestos

Construye un `Box` de 300 × 300 dp.

Coloca en su interior cuatro elementos de diferentes tamaños y colores.

Cada elemento debe tener una alineación diferente:

- `Alignment.TopStart`.
- `Alignment.TopEnd`.
- `Alignment.BottomStart`.
- `Alignment.BottomEnd`.

Añade un quinto elemento centrado.

Comprueba cómo se posicionan los hijos sin modificar el tamaño del contenedor.

### Ejercicio 4.2. matchParentSize

Crea un `Box` que contenga:

- Un elemento decorativo que determine el tamaño del contenedor.
- Un segundo elemento que ocupe todo el espacio del padre mediante `matchParentSize()`.
- Un tercer elemento de tamaño reducido situado en el centro.

Compara el comportamiento de `matchParentSize()` con `fillMaxSize()`.

**Responde:** ¿Qué diferencia existe entre ambos modificadores cuando se utilizan dentro de un `Box`?

### Ejercicio 4.3. El tamaño del Box depende de sus hijos

Construye un `Box` que no tenga un tamaño explícito.

Introduce varios hijos con diferentes dimensiones.

Experimenta modificando el tamaño de los hijos y observa cómo cambia el tamaño del padre.

A continuación, añade un hijo que utilice `matchParentSize()`.

Comprueba qué ocurre con el tamaño del `Box`.

---

# PARTE 5. Los layouts Row y Column

## 7. Distribución horizontal y vertical

En esta parte trabajarás con la distribución de elementos mediante `Row` y `Column`.

### Ejercicio 5.1. Row y Arrangement

Crea una sección que muestre varios `Row` con tres elementos de diferentes dimensiones.

Experimenta con los siguientes valores de `horizontalArrangement`:

- `Arrangement.Start`.
- `Arrangement.Center`.
- `Arrangement.End`.
- `Arrangement.SpaceBetween`.
- `Arrangement.SpaceAround`.
- `Arrangement.SpaceEvenly`.

Mantén constante el tamaño del contenedor para poder comparar los resultados.

### Ejercicio 5.2. Column y Arrangement

Repite el ejercicio anterior utilizando `Column`.

En este caso experimentarás con `verticalArrangement`:

- `Arrangement.Top`.
- `Arrangement.Center`.
- `Arrangement.Bottom`.
- `Arrangement.SpaceBetween`.
- `Arrangement.SpaceAround`.
- `Arrangement.SpaceEvenly`.

Comprueba cómo se distribuyen los elementos cuando el contenedor tiene más espacio del necesario.

### Ejercicio 5.3. Alignment

Experimenta con:

- `horizontalAlignment` de `Column`.
- `verticalAlignment` de `Row`.

Construye ejemplos en los que los hijos tengan diferentes dimensiones.

Comprueba cómo se alinean los elementos cuando sus tamaños no coinciden.

### Ejercicio 5.4. El modificador weight

El modificador `weight` permite distribuir el espacio disponible entre los hijos de un `Row` o un `Column`.

Construye un `Row` que ocupe todo el ancho disponible y contenga tres elementos.

Asigna los siguientes pesos:

- Primer elemento: `weight(1f)`.
- Segundo elemento: `weight(2f)`.
- Tercer elemento: `weight(1f)`.

Comprueba cómo se distribuye el espacio entre ellos.

A continuación, realiza los siguientes experimentos:

1. Cambia los pesos a 1, 1 y 1.
2. Cambia los pesos a 1, 3 y 2.
3. Introduce un cuarto elemento sin `weight`, con un ancho fijo.
4. Añade `padding` a algunos elementos.
5. Repite los experimentos utilizando un `Column`.

**Responde:**

- ¿Qué significa el peso de un elemento?
- ¿Sobre qué espacio se calcula su proporción?
- ¿Qué ocurre cuando algunos hijos tienen un tamaño fijo?
- ¿Qué sucede si se modifica el tamaño disponible del padre?

---

# PARTE 6. BoxWithConstraints

## 8. Diseñando layouts adaptables

`BoxWithConstraints` permite conocer las restricciones que recibe un composable y utilizar esa información para decidir cómo organizar su contenido.

Entre sus propiedades encontrarás:

- `minWidth`
- `maxWidth`
- `minHeight`
- `maxHeight`

Estas dimensiones se expresan en dp.

### Ejercicio 6.1. Consultar las restricciones

Construye un `BoxWithConstraints` que muestre en pantalla:

- El ancho mínimo disponible.
- El ancho máximo disponible.
- El alto mínimo disponible.
- El alto máximo disponible.

Coloca el componente dentro de diferentes contenedores.

Por ejemplo:

- Un `Box` de 200 × 150 dp.
- Un `Box` de 350 × 250 dp.
- Un `Box` que ocupe todo el ancho disponible.

Comprueba cómo cambian las restricciones recibidas.

### Ejercicio 6.2. Layout adaptable

Crea un composable llamado `AdaptivePanel`.

Debe recibir una colección de tres elementos que representen información diferente.

El componente tendrá que modificar su distribución dependiendo del ancho disponible:

- Cuando el ancho máximo sea inferior a 400 dp, los elementos se organizarán verticalmente.
- Cuando el ancho máximo sea igual o superior a 400 dp, los elementos se organizarán horizontalmente.

Utiliza `BoxWithConstraints` para decidir qué layout debes utilizar.

### Ejercicio 6.3. El mismo componente en diferentes espacios

Utiliza el componente `AdaptivePanel` del ejercicio anterior en tres contenedores diferentes:

1. Un contenedor de 300 dp de ancho.
2. Un contenedor de 500 dp de ancho.
3. Un contenedor que ocupe todo el ancho disponible.

Comprueba cómo cambia la distribución sin modificar el código interno de `AdaptivePanel`.

**Responde:** ¿Por qué resulta útil que un composable pueda adaptar su contenido a las restricciones que recibe de su padre?

---

# PARTE 7. Reto final: Dashboard adaptable

## 9. Construye una pantalla de información

Para finalizar, construye una pequeña pantalla de dashboard utilizando los layouts y modificadores que has trabajado.

La pantalla debe contener los siguientes elementos:

### Cabecera

Una cabecera con:

- Un título.
- Un subtítulo.
- Un pequeño indicador de estado.

Utiliza `Row` y `Column` para organizar los elementos.

### Tarjetas de información

Incluye tres tarjetas con información diferente.

Cada tarjeta debe contener:

- Un título.
- Un valor numérico destacado.
- Una descripción.
- Un elemento decorativo.

Utiliza `Box`, `Row` y `Column` para organizar el contenido.

### Panel de estadísticas

Añade un panel que contenga cuatro indicadores.

Utiliza `weight` para distribuir el espacio entre ellos.

### Adaptación del dashboard

El dashboard debe adaptarse a las restricciones recibidas:

- Cuando disponga de poco ancho, las tarjetas se organizarán verticalmente.
- Cuando disponga de suficiente ancho, las tarjetas se organizarán horizontalmente.
- Los indicadores del panel deben distribuirse correctamente en ambos casos.

Utiliza `BoxWithConstraints` para implementar la adaptación.

### Requisitos del reto

- No utilices tamaños fijos innecesarios.
- Evita que los textos o elementos se salgan de sus contenedores.
- Utiliza `weight` cuando tenga sentido distribuir el espacio disponible.
- Utiliza `aspectRatio` para mantener proporciones en los elementos decorativos.
- Utiliza `widthIn`, `heightIn` o `sizeIn` cuando necesites limitar las dimensiones.
- Comprueba el comportamiento del dashboard dentro de contenedores de diferentes tamaños.

---

# PARTE 8. Preguntas de comprensión

## 10. Comprueba lo que has aprendido

Responde razonadamente a las siguientes preguntas:

1. ¿Qué información contienen las restricciones que recibe un composable?
2. ¿Quién proporciona las restricciones iniciales de un layout?
3. ¿Qué información devuelve un hijo al padre después de ser medido?
4. ¿Puede un hijo adoptar un tamaño superior al máximo indicado por las restricciones que recibe?
5. ¿Qué diferencia existe entre `size` y `requiredSize`?
6. ¿Por qué dos cadenas de modificadores con los mismos elementos pueden producir resultados diferentes si cambia su orden?
7. ¿Qué diferencia existe entre `fillMaxSize` y `wrapContentSize`?
8. ¿Qué diferencia existe entre `matchParentSize` y `fillMaxSize` dentro de un `Box`?
9. ¿Para qué sirve `weight` y en qué layouts puede utilizarse?
10. ¿Qué información proporciona `BoxWithConstraints`?
11. ¿El tamaño de un padre tiene que ser necesariamente igual al tamaño de sus hijos?
12. ¿Qué ocurre cuando un hijo solicita más espacio del que su padre puede proporcionarle?

---

# 11. Entrega

Entrega el proyecto completo de Android Studio.

El proyecto debe incluir:

- Todos los composables desarrollados durante la práctica.
- Los experimentos de medición y dimensiones.
- Los ejemplos de `Box`, `Row` y `Column`.
- Los ejemplos de `BoxWithConstraints`.
- El dashboard adaptable.
- Un documento breve con las respuestas a las preguntas de comprensión.

En los experimentos de medición y modificadores, incluye también las predicciones realizadas antes de ejecutar cada ejemplo y explica las diferencias encontradas.

# 12. Criterios de evaluación

| Apartado | Puntuación |
|---|---:|
| Comprensión del proceso de medición | 1,5 |
| Modificadores de tamaño y restricciones | 2,0 |
| Orden y combinación de modificadores | 1,0 |
| Utilización de Box y sus modificadores | 1,0 |
| Utilización de Row y Column | 1,5 |
| Distribución del espacio mediante weight | 0,5 |
| Utilización de BoxWithConstraints | 1,0 |
| Dashboard adaptable | 1,0 |
| Preguntas de comprensión y explicaciones | 0,5 |
| **Total** | **10 puntos** |

## Consideraciones finales

El objetivo de esta práctica no es memorizar los modificadores ni conseguir que los elementos aparezcan en una posición determinada.

Debes comprender cómo se relacionan las dimensiones de los composables, qué restricciones reciben y cómo influyen los modificadores en el proceso de medición.

En los ejercicios de predicción se valorará especialmente la capacidad de explicar el resultado antes de ejecutar el código.

**Recuerda: en Jetpack Compose, el tamaño que solicita un composable y el tamaño que finalmente adopta no tienen por qué coincidir.**