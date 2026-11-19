# SVG en HTML: guía práctica

SVG significa **Scalable Vector Graphics**. Es un formato de imagen vectorial basado en XML: en lugar de guardar píxeles, guarda formas, líneas, curvas y colores. Por eso se puede ampliar sin perder calidad y se puede modificar con CSS.

En este proyecto se usa SVG para el logo, el favicon, los iconos del tema y los iconos de los botones. No hace falta JavaScript ni una librería externa.

## Contenido

1. Cómo funciona un SVG
2. Formas de incluir SVG en HTML
3. Ejemplos mínimos
4. Anatomía de un SVG
5. Formas básicas
6. El atributo `d` y los paths
7. Estilos con CSS
8. Sprites con `symbol` y `use`
9. Accesibilidad
10. SVG externo y máscaras CSS
11. Gradientes, `defs` y `clipPath`
12. Animaciones
13. Errores típicos
14. Cómo se usa en ShitNotes
15. Ejercicios
16. Chuleta rápida
17. Recursos

---

## 1. Cómo funciona un SVG

Un SVG tiene un sistema de coordenadas propio:

```text
(0,0) ─────────────► x
  │
  │
  │
  ▼
  y
```

El origen está arriba a la izquierda. La `x` crece hacia la derecha y la `y` hacia abajo.

La pieza clave es `viewBox`:

```html
<svg viewBox="0 0 24 24">
  ...
</svg>
```

`viewBox="0 0 24 24"` significa:

- el dibujo ocupa un lienzo interno de 24 unidades de ancho;
- 24 unidades de alto;
- la esquina superior izquierda del lienzo es `(0, 0)`.

Después, el SVG se puede mostrar a cualquier tamaño:

```html
<svg viewBox="0 0 24 24" width="16" height="16">...</svg>
<svg viewBox="0 0 24 24" width="24" height="24">...</svg>
<svg viewBox="0 0 24 24" width="48" height="48">...</svg>
```

Los tres dibujan lo mismo. Cambia el tamaño de presentación, no la geometría.

### `viewBox` frente a `width` y `height`

| Atributo | Para qué sirve |
|---|---|
| `viewBox` | Define el sistema de coordenadas interno y qué parte del dibujo se ve. |
| `width` / `height` | Definen el tamaño con el que se muestra el SVG. |

Si pones `width` y `height` pero no `viewBox`, el dibujo no escala bien. Si pones `viewBox` pero no `width` ni `height`, el navegador le dará un tamaño por defecto. Lo más seguro es usar los tres, o `viewBox` y tamaño desde CSS.

```css
.icon {
  width: 24px;
  height: 24px;
}
```

### `preserveAspectRatio`

Por defecto, el SVG mantiene la proporción y se centra:

```html
<svg viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet">
```

`meet` significa que se ve todo el dibujo. `slice` significa que se recorta para cubrir todo el espacio. Para iconos, normalmente no hace falta tocarlo.

---

## 2. Formas de incluir SVG en HTML

Hay varias formas. No todas sirven para lo mismo.

| Forma | Ejemplo | Ventajas | Limitaciones | Cuándo usarla |
|---|---|---|---|---|
| SVG en línea | `<svg>...</svg>` | CSS completo, `currentColor`, animaciones, accesibilidad | Más HTML | Iconos que cambian de color o se animan |
| `<img>` | `<img src="logo.svg" alt="...">` | Simple, cacheable, `alt` | No se puede cambiar el color interno con CSS | Logo, ilustraciones, imágenes |
| Fondo CSS | `background-image: url("icono.svg")` | No ensucia el HTML | No es accesible ni seleccionable | Patrones y decoración |
| `<object>` | `<object data="icono.svg">` | Documento separado | Más complejo; no necesario para iconos | Casos muy concretos |
| `<iframe>` | `<iframe src="icono.svg">` | Aislamiento total | Pesado y poco práctico | No recomendado para iconos |
| Sprite | `<symbol>` + `<use>` | Reutiliza muchos iconos | Hay que cuidar los `id` | Muchos iconos en una página |
| Máscara CSS | `mask: url("icono.svg")` | Colorea un SVG externo | Técnica algo más avanzada | Icono externo que debe cambiar de color |

### 2.1. SVG en línea

El SVG forma parte del HTML. Es la opción más flexible.

```html
<svg class="icon" viewBox="0 0 24 24" width="24" height="24" aria-hidden="true" focusable="false">
  <path d="M20 6 9 17l-5-5"
        fill="none"
        stroke="currentColor"
        stroke-width="1.75"
        stroke-linecap="round"
        stroke-linejoin="round"/>
</svg>
```

Con CSS puedes cambiar su color:

```css
.icon {
  color: var(--text);
}

.icon:hover {
  color: var(--accent);
}
```

`currentColor` hace que el trazo use el color de texto del elemento. Es la técnica más útil para iconos.

### 2.2. SVG con `<img>`

```html
<img src="assets/logo.svg" alt="Logotipo de ShitNotes" width="48" height="48">
```

Ventajas:

- el archivo se puede cachear;
- el HTML queda limpio;
- `alt` resuelve la accesibilidad.

Limitación importante: **el CSS de la página no entra dentro del SVG**. No puedes cambiar el color de sus partes con `color`, `fill` o `stroke` desde fuera. Si el SVG tiene colores propios, se quedan como están.

### 2.3. SVG como fondo CSS

```css
.hero {
  background-image: url("../assets/patron.svg");
  background-repeat: repeat;
  background-size: 48px 48px;
}
```

La ruta es relativa al archivo CSS, no al HTML. Si el CSS está en `css/styles.css`, `../assets/patron.svg` sube un nivel y entra en `assets`.

Este uso es para decoración. El SVG no aparece en el árbol de accesibilidad y no se puede seleccionar.

### 2.4. SVG como favicon

```html
<link rel="icon" href="assets/favicon.svg" type="image/svg+xml">
```

El archivo debe incluir `xmlns`:

```html
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64">
  ...
</svg>
```

### 2.5. SVG en línea frente a `<img>`

| Necesidad | SVG en línea | `<img src="...">` |
|---|---|---|
| Cambiar color con CSS | Sí | No |
| Usar `currentColor` | Sí | No |
| Animar partes | Sí | No |
| Cachear el archivo | No | Sí |
| HTML más limpio | No | Sí |
| Accesibilidad con `alt` | Hay que hacerlo a mano | Sí, con `alt` |

Regla práctica:

- **Logo e ilustraciones con colores propios:** `<img>`.
- **Iconos de interfaz que cambian de color:** SVG en línea.
- **Muchos iconos repetidos:** sprite con `<symbol>`.

---

## 3. Ejemplos mínimos

### Icono de check en línea

```html
<button class="icon-button" type="button" aria-label="Confirmar">
  <svg class="icon" viewBox="0 0 24 24" width="24" height="24" aria-hidden="true" focusable="false">
    <path d="M20 6 9 17l-5-5"
          fill="none"
          stroke="currentColor"
          stroke-width="1.75"
          stroke-linecap="round"
          stroke-linejoin="round"/>
  </svg>
</button>
```

```css
.icon-button {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  padding: 8px;
  color: var(--text);
  background: var(--surface);
  border: 1px solid var(--border);
  border-radius: 8px;
  cursor: pointer;
}

.icon-button:hover {
  color: var(--accent);
}

.icon {
  display: block;
  width: 24px;
  height: 24px;
}
```

### Logo externo

```html
<a class="brand" href="index.html" aria-label="ShitNotes, ir al editor">
  <img class="brand-logo" src="assets/logo.svg" alt="" width="48" height="48">
</a>
```

El `alt` está vacío porque el enlace ya tiene `aria-label`. Si el logo no estuviera dentro de un enlace con texto alternativo, usarías un `alt` descriptivo.

### Icono de tema en línea

```html
<svg class="theme-icon" viewBox="0 0 24 24" aria-hidden="true" focusable="false">
  <path d="M20.5 14.5A8.5 8.5 0 0 1 9.5 3.5 8.5 8.5 0 1 0 20.5 14.5Z"
        fill="none"
        stroke="currentColor"
        stroke-width="1.75"
        stroke-linecap="round"
        stroke-linejoin="round"/>
</svg>
```

```css
.theme-icon {
  width: 16px;
  height: 16px;
  color: var(--muted);
}

.theme-toggle:checked + .theme-label .theme-icon {
  color: var(--accent);
}
```

---

## 4. Anatomía de un SVG

Un SVG completo puede tener esta estructura:

```html
<svg xmlns="http://www.w3.org/2000/svg"
     viewBox="0 0 24 24"
     width="24"
     height="24"
     role="img"
     aria-labelledby="titulo-icono">
  <title id="titulo-icono">Copia al portapapeles</title>
  <desc>Dos hojas de papel superpuestas.</desc>

  <g fill="none" stroke="currentColor" stroke-width="1.75">
    <rect x="9" y="9" width="11" height="11" rx="2"/>
    <path d="M5 15H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a2 2 0 0 1 2 2v1"/>
  </g>
</svg>
```

### Elementos principales

| Elemento | Función |
|---|---|
| `<svg>` | Raíz del dibujo. |
| `<g>` | Agrupa elementos para aplicarles estilos o transformaciones. |
| `<defs>` | Define recursos reutilizables: gradientes, símbolos, recortes. |
| `<title>` | Título accesible del SVG. |
| `<desc>` | Descripción larga. |
| `<path>` | Forma más flexible: líneas y curvas. |
| `<rect>` | Rectángulo. |
| `<circle>` | Círculo. |
| `<ellipse>` | Elipse. |
| `<line>` | Línea recta. |
| `<polyline>` | Línea formada por varios puntos. |
| `<polygon>` | Figura cerrada formada por varios puntos. |
| `<text>` | Texto dentro del SVG. |
| `<use>` | Reutiliza un elemento definido con `id`. |

### Atributos de presentación

Se pueden poner como atributos del SVG o como propiedades CSS:

```html
<path fill="none" stroke="currentColor" stroke-width="1.75"/>
```

```css
path {
  fill: none;
  stroke: currentColor;
  stroke-width: 1.75;
}
```

Los atributos de presentación tienen menor prioridad que el CSS. Si algo no cambia, revisa si hay un `style` en línea o una regla CSS más específica.

### `fill` y `stroke`

- `fill` rellena el interior.
- `stroke` dibuja el borde.
- `fill="none"` deja el interior vacío.
- `stroke="currentColor"` usa el color de texto actual.

Icono relleno:

```html
<svg viewBox="0 0 24 24" aria-hidden="true">
  <path d="..." fill="currentColor"/>
</svg>
```

Icono de trazo:

```html
<svg viewBox="0 0 24 24" aria-hidden="true">
  <path d="..." fill="none" stroke="currentColor" stroke-width="1.75"/>
</svg>
```

No mezcles ambos estilos sin querer: un icono de trazo con `fill` negro puede quedar como una mancha.

### Propiedades de trazo

| Propiedad | Efecto |
|---|---|
| `stroke-width` | Grosor del trazo. |
| `stroke-linecap` | Forma de los extremos: `butt`, `round`, `square`. |
| `stroke-linejoin` | Forma de las esquinas: `miter`, `round`, `bevel`. |
| `stroke-dasharray` | Convierte el trazo en guiones. |
| `stroke-dashoffset` | Desplaza los guiones; útil para animaciones. |
| `stroke-opacity` | Transparencia solo del trazo. |
| `fill-opacity` | Transparencia solo del relleno. |
| `opacity` | Transparencia de todo el elemento. |

---

## 5. Formas básicas

### Rectángulo

```html
<rect x="10" y="10" width="40" height="20" rx="6" fill="#1e1e22" stroke="#29292e"/>
```

- `x`, `y`: esquina superior izquierda.
- `width`, `height`: tamaño.
- `rx`, `ry`: radio de las esquinas.

### Círculo

```html
<circle cx="12" cy="12" r="9" fill="none" stroke="currentColor" stroke-width="1.75"/>
```

- `cx`, `cy`: centro.
- `r`: radio.

### Elipse

```html
<ellipse cx="12" cy="12" rx="10" ry="6" fill="currentColor"/>
```

### Línea

```html
<line x1="4" y1="12" x2="20" y2="12" stroke="currentColor" stroke-width="1.75"/>
```

### Polilínea

```html
<polyline points="4,18 9,13 13,16 20,6"
          fill="none"
          stroke="currentColor"
          stroke-width="1.75"/>
```

### Polígono

```html
<polygon points="12,2 22,22 2,22" fill="currentColor"/>
```

---

## 6. El atributo `d` y los paths

`<path>` es la forma más potente. Su atributo `d` contiene una secuencia de comandos.

```html
<path d="M20 6 9 17l-5-5" fill="none" stroke="currentColor" stroke-width="1.75"/>
```

### Comandos principales

| Comando | Nombre | Qué hace |
|---|---|---|
| `M` | Move to | Mueve el cursor a un punto sin dibujar. |
| `L` | Line to | Dibuja una línea hasta un punto. |
| `H` | Horizontal line | Línea horizontal. |
| `V` | Vertical line | Línea vertical. |
| `C` | Cubic Bézier | Curva cúbica. |
| `S` | Smooth cubic | Curva cúbica suave. |
| `Q` | Quadratic Bézier | Curva cuadrática. |
| `T` | Smooth quadratic | Curva cuadrática suave. |
| `A` | Arc | Arco. |
| `Z` | Close path | Cierra el trazado. |

Las mayúsculas son coordenadas absolutas. Las minúsculas son relativas al punto anterior.

### Ejemplo: triángulo

```html
<path d="M12 2 L22 22 L2 22 Z" fill="currentColor"/>
```

También se puede escribir sin repetir `L`:

```html
<path d="M12 2 22 22 2 22Z" fill="currentColor"/>
```

### Ejemplo: check

```html
<path d="M20 6 9 17l-5-5"
      fill="none"
      stroke="currentColor"
      stroke-width="1.75"
      stroke-linecap="round"
      stroke-linejoin="round"/>
```

Lectura:

- `M20 6`: empieza en `(20, 6)`.
- `9 17`: al no haber comando, se interpreta como `L9 17`.
- `l-5-5`: línea relativa al punto anterior: resta 5 a `x` y 5 a `y`.

### Ejemplo: casa

```html
<path d="M3 11 12 3l9 8v10H3z"
      fill="none"
      stroke="currentColor"
      stroke-width="1.75"
      stroke-linejoin="round"/>
```

### Cómo leer un icono de Lucide o Feather

Los iconos de Lucide suelen tener este aspecto:

```html
<svg xmlns="http://www.w3.org/2000/svg"
     width="24"
     height="24"
     viewBox="0 0 24 24"
     fill="none"
     stroke="currentColor"
     stroke-width="2"
     stroke-linecap="round"
     stroke-linejoin="round">
  <path d="M20 6 9 17l-5-5"/>
</svg>
```

Para integrarlo en el proyecto:

1. copia el `<svg>`;
2. conserva `viewBox="0 0 24 24"`;
3. añade `class="icon"`;
4. añade `aria-hidden="true"` y `focusable="false"` si es decorativo;
5. ajusta `stroke-width` a `1.75` si quieres el mismo grosor que el resto;
6. controla el tamaño con CSS o con `width` y `height`.

### Herramientas para crear paths

No hace falta escribir curvas a mano. Puedes usar:

- **Inkscape**: editor libre de vectores.
- **Figma**: muy cómodo para iconos y prototipos.
- **Illustrator**: estándar profesional.
- **Boxy SVG**: editor sencillo en el navegador.
- **Lucide** y **Feather**: iconos ya preparados para copiar.
- **SVGOMG**: para limpiar y optimizar SVG exportados.

---

## 7. Estilos con CSS

Cuando el SVG está en línea, forma parte del DOM y se puede seleccionar como cualquier otro elemento.

```css
.icon {
  display: block;
  width: 24px;
  height: 24px;
  color: var(--text);
  transition: color 0.2s ease;
}

.icon path {
  stroke-width: 1.75;
}

.icon-button:hover .icon {
  color: var(--accent);
}

.icon-button:focus-visible .icon {
  color: var(--accent);
}
```

### `currentColor`

`currentColor` es el color de texto actual del elemento. Es la forma más limpia de hacer iconos que heredan el color.

```html
<svg class="icon" viewBox="0 0 24 24" aria-hidden="true">
  <path d="..." fill="none" stroke="currentColor"/>
</svg>
```

```css
.icon {
  color: var(--muted);
}

.icon:hover {
  color: var(--accent);
}
```

### Variables CSS dentro del SVG

```html
<svg viewBox="0 0 24 24" aria-hidden="true">
  <circle cx="12" cy="12" r="9" fill="var(--accent)"/>
</svg>
```

Funciona en SVG en línea. No funciona igual en un SVG cargado con `<img>`.

### `fill` y `stroke` desde CSS

```css
.icon-fill {
  fill: currentColor;
  stroke: none;
}

.icon-stroke {
  fill: none;
  stroke: currentColor;
  stroke-width: 1.75;
}
```

### Transformaciones

```css
.icon {
  transform-origin: center;
  transition: transform 0.2s ease;
}

.icon-button:hover .icon {
  transform: scale(1.1);
}
```

Para que una transformación sobre una parte del SVG se comporte como esperas, puede hacer falta:

```css
.icon path {
  transform-box: fill-box;
  transform-origin: center;
}
```

### `vector-effect`

Si el SVG se escala mucho, el trazo también se escala. Puedes evitarlo:

```html
<path d="..." stroke="currentColor" stroke-width="1.75" vector-effect="non-scaling-stroke"/>
```

---

## 8. Sprites con `symbol` y `use`

Si repites muchos iconos, un sprite evita duplicar el código.

```html
<svg class="svg-sprite" aria-hidden="true">
  <symbol id="icon-copy" viewBox="0 0 24 24">
    <g fill="none" stroke="currentColor" stroke-width="1.75" stroke-linecap="round" stroke-linejoin="round">
      <rect x="9" y="9" width="11" height="11" rx="2"/>
      <path d="M5 15H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a2 2 0 0 1 2 2v1"/>
    </g>
  </symbol>

  <symbol id="icon-trash" viewBox="0 0 24 24">
    <g fill="none" stroke="currentColor" stroke-width="1.75" stroke-linecap="round" stroke-linejoin="round">
      <path d="M3 6h18"/>
      <path d="M8 6V4h8v2"/>
      <path d="M19 6l-1 14H6L5 6"/>
      <path d="M10 11v6M14 11v6"/>
    </g>
  </symbol>
</svg>
```

```css
.svg-sprite {
  position: absolute;
  width: 0;
  height: 0;
  overflow: hidden;
}
```

Uso:

```html
<button class="icon-button" type="button" aria-label="Copiar nota">
  <svg class="icon" viewBox="0 0 24 24" aria-hidden="true">
    <use href="#icon-copy"></use>
  </svg>
</button>
```

Ventajas:

- un solo bloque de definiciones;
- los iconos se reutilizan;
- `currentColor` funciona a través de `<use>`;
- el HTML de cada botón queda corto.

Cuidados:

- los `id` deben ser únicos en toda la página;
- si el sprite se oculta con `display: none`, algunos navegadores antiguos pueden fallar; usar `position: absolute; width: 0; height: 0` es más seguro;
- para un sprite externo, `href="iconos.svg#icon-copy"` puede tener restricciones según el navegador y el protocolo. Para un proyecto local con Live Server, lo más seguro es el sprite en línea.

---

## 9. Accesibilidad

Un SVG puede ser decorativo o informativo. No es lo mismo.

### SVG decorativo

Si el icono acompaña a un texto o a un botón que ya tiene nombre accesible:

```html
<button type="button" aria-label="Borrar nota">
  <svg viewBox="0 0 24 24" aria-hidden="true" focusable="false">
    <path d="..." fill="none" stroke="currentColor"/>
  </svg>
</button>
```

- `aria-hidden="true"` oculta el SVG al lector de pantalla.
- `focusable="false"` evita que algunos navegadores antiguos lo incluyan en el orden de tabulación.
- El botón tiene `aria-label`, así que el usuario sabe qué hace.

Si el botón tiene texto visible, no hace falta `aria-label`:

```html
<button type="button">
  <svg viewBox="0 0 24 24" aria-hidden="true" focusable="false">...</svg>
  Copiar
</button>
```

### SVG informativo

Si el SVG es la única información:

```html
<svg viewBox="0 0 24 24" role="img" aria-labelledby="titulo-check">
  <title id="titulo-check">Tarea completada</title>
  <path d="M20 6 9 17l-5-5" fill="none" stroke="currentColor"/>
</svg>
```

También puedes usar `aria-label` directamente:

```html
<svg viewBox="0 0 24 24" role="img" aria-label="Tarea completada">
  ...
</svg>
```

### `<img>` externo

```html
<img src="assets/logo.svg" alt="Logotipo de ShitNotes" width="48" height="48">
```

Si el logo está dentro de un enlace que ya tiene `aria-label`, el `alt` puede ir vacío para no repetir información.

### Reglas rápidas

1. Si el icono no aporta información nueva, `aria-hidden="true"`.
2. Si el icono es la única información, `role="img"` y `<title>` o `aria-label`.
3. Si el icono está en un botón sin texto, el botón necesita `aria-label`.
4. No pongas texto importante solo dentro de un SVG.
5. Comprueba el contraste del color del icono.
6. Si animas, respeta `prefers-reduced-motion`.

---

## 10. SVG externo y máscaras CSS

Un SVG cargado con `<img>` no se puede recolorear desde el CSS de la página. Si necesitas un archivo externo y quieres que herede el color, usa una máscara CSS:

```css
.icon-mask {
  display: inline-block;
  width: 24px;
  height: 24px;
  background-color: currentColor;
  mask: url("../assets/icono.svg") center / contain no-repeat;
  -webkit-mask: url("../assets/icono.svg") center / contain no-repeat;
}
```

```html
<span class="icon-mask" aria-hidden="true"></span>
```

La máscara usa la forma del SVG y el color de fondo del elemento. Es útil para iconos monocromos externos.

Limitaciones:

- el SVG debe ser una silueta clara;
- no funciona bien con iconos multicolor;
- en algunos contextos puede necesitar `-webkit-mask`;
- el elemento no tiene contenido accesible; añade texto o `aria-label` en el control que lo contiene.

---

## 11. Gradientes, `defs` y `clipPath`

### Gradiente lineal

```html
<svg viewBox="0 0 24 24" aria-hidden="true">
  <defs>
    <linearGradient id="gradiente-acento" x1="0" y1="0" x2="1" y2="1">
      <stop offset="0" stop-color="#ff5555"/>
      <stop offset="1" stop-color="#50fa7b"/>
    </linearGradient>
  </defs>
  <rect width="24" height="24" rx="6" fill="url(#gradiente-acento)"/>
</svg>
```

### Recorte con `clipPath`

```html
<svg viewBox="0 0 24 24" aria-hidden="true">
  <defs>
    <clipPath id="recorte-circulo">
      <circle cx="12" cy="12" r="10"/>
    </clipPath>
  </defs>
  <rect width="24" height="24" fill="#ff5555" clip-path="url(#recorte-circulo)"/>
</svg>
```

Cuidado con los `id`: si pegas el mismo SVG dos veces en la misma página, los `id` se duplican y las referencias pueden apuntar al elemento equivocado. En ese caso, cambia los `id` o usa un sprite.

---

## 12. Animaciones

### Transición de color

```css
.icon {
  color: var(--muted);
  transition: color 0.2s ease;
}

.icon-button:hover .icon {
  color: var(--accent);
}
```

### Trazo que se dibuja

```html
<svg class="icon-draw" viewBox="0 0 24 24" aria-hidden="true">
  <path d="M20 6 9 17l-5-5"
        pathLength="1"
        fill="none"
        stroke="currentColor"
        stroke-width="1.75"
        stroke-linecap="round"
        stroke-linejoin="round"/>
</svg>
```

```css
.icon-draw path {
  stroke-dasharray: 1;
  stroke-dashoffset: 1;
}

.icon-draw:hover path {
  animation: dibujar 0.6s ease forwards;
}

@keyframes dibujar {
  to {
    stroke-dashoffset: 0;
  }
}
```

`pathLength="1"` normaliza la longitud del trazo para que la animación funcione igual en distintos iconos.

### Movimiento reducido

```css
@media (prefers-reduced-motion: reduce) {
  .icon-draw:hover path {
    animation: none;
  }

  .icon {
    transition: none;
  }
}
```

---

## 13. Errores típicos

| Problema | Causa probable | Solución |
|---|---|---|
| El SVG no se ve | Falta `fill` o `stroke`, o el color es igual al fondo | Añade `fill="currentColor"` o `stroke="currentColor"` |
| El icono sale enorme | No hay `width`, `height` ni CSS de tamaño | Añade tamaño con atributos o CSS |
| El icono sale diminuto | `viewBox` con coordenadas muy grandes y tamaño pequeño | Revisa `viewBox` o ajusta el tamaño |
| `viewBox` no funciona | Está escrito `viewbox` | Usa `viewBox` con mayúscula en la B |
| El SVG externo no cambia de color | `<img>` aísla el SVG del CSS | Usa SVG en línea o una máscara CSS |
| `currentColor` no cambia nada | El SVG está en `<img>` o el color no está definido | Usa SVG en línea y define `color` |
| El trazo se corta | El dibujo llega justo al borde del `viewBox` | Amplía el `viewBox` o usa `overflow: visible` |
| Los `id` chocan | Varios SVG con el mismo `id` | Usa `id` únicos o un sprite |
| El icono tiene un hueco raro debajo | El SVG es inline y se alinea con la línea base | `display: block` o `vertical-align: middle` |
| El SVG no carga como favicon | Falta `xmlns` o la ruta es incorrecta | Añade `xmlns` y revisa la ruta |
| El HTML se rompe al cerrar el SVG | Se usó `<svg />` de forma incorrecta | Usa `<svg>...</svg>` con cierre explícito |
| El icono se ve borroso | Es una imagen raster, no un SVG | Usa SVG o exporta a mayor resolución |

### Sobre `<svg />`

En HTML, los elementos SVG pueden usar cierre automático en algunos casos, pero para evitar problemas usa siempre:

```html
<svg>...</svg>
```

No uses `<svg />` como si fuera un `<img />`.

### Sobre `xmlns`

- En un archivo `.svg` independiente, `xmlns="http://www.w3.org/2000/svg"` es necesario.
- En un SVG en línea dentro de HTML5, suele ser opcional, pero incluirlo no molesta y evita problemas si luego copias el archivo.

### Sobre el tamaño

Los atributos `width` y `height` del SVG no son lo mismo que el tamaño en CSS. Si quieres que un icono sea siempre de 24 px:

```css
.icon {
  width: 24px;
  height: 24px;
}
```

Si quieres que se adapte al contenedor:

```css
.icon-responsive {
  width: 100%;
  height: auto;
}
```

---

## 14. Cómo se usa en ShitNotes

### Logo

Archivo: `assets/logo.svg`

Uso:

```html
<img class="brand-logo" src="assets/logo.svg" alt="" width="48" height="48">
```

Es un SVG externo porque el logo tiene colores propios y no necesita cambiar con el tema. El enlace que lo contiene tiene `aria-label`, por eso el `alt` está vacío.

### Favicon

Archivo: `assets/favicon.svg`

Uso:

```html
<link rel="icon" href="assets/favicon.svg" type="image/svg+xml">
```

### Iconos del tema

Están en línea dentro del switch. Usan `currentColor` para heredar el color del texto y cambiar con el tema.

```html
<svg class="theme-icon" viewBox="0 0 24 24" aria-hidden="true" focusable="false">
  <path d="M20.5 14.5A8.5 8.5 0 0 1 9.5 3.5 8.5 8.5 0 1 0 20.5 14.5Z"
        fill="none"
        stroke="currentColor"
        stroke-width="1.75"
        stroke-linecap="round"
        stroke-linejoin="round"/>
</svg>
```

### Iconos de acciones

Para los futuros botones de copiar y borrar, usa SVG en línea:

```html
<button class="icon-button" type="button" aria-label="Copiar nota">
  <svg class="icon" viewBox="0 0 24 24" aria-hidden="true" focusable="false">
    <rect x="9" y="9" width="11" height="11" rx="2"
          fill="none" stroke="currentColor" stroke-width="1.75"
          stroke-linecap="round" stroke-linejoin="round"/>
    <path d="M5 15H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a2 2 0 0 1 2 2v1"
          fill="none" stroke="currentColor" stroke-width="1.75"
          stroke-linecap="round" stroke-linejoin="round"/>
  </svg>
</button>
```

### Checklist para cada icono

- [ ] Tiene `viewBox`.
- [ ] Tiene tamaño definido con atributos o CSS.
- [ ] Usa `fill="none"` y `stroke="currentColor"` si es de trazo.
- [ ] Mantiene el mismo `stroke-width` que los demás iconos.
- [ ] Tiene `aria-hidden="true"` y `focusable="false"` si es decorativo.
- [ ] El botón que lo contiene tiene `aria-label` si no tiene texto.
- [ ] Se ve bien a 16, 24 y 48 px.
- [ ] Se ve bien en tema oscuro y claro.
- [ ] No duplica `id` con otro SVG de la página.
- [ ] No depende de JavaScript.

---

## 15. Ejercicios

1. Crea un icono de check en línea de 24 × 24 con `currentColor` y haz que cambie a rojo al pasar el ratón.
2. Crea un icono de papelera con dos o tres `path` y úsalo en un botón con `aria-label="Borrar nota"`.
3. Convierte el check en un archivo `.svg` externo y compruébalo con `<img>`. Intenta cambiar su color con CSS y explica por qué no funciona.
4. Crea un sprite con tres iconos: copiar, borrar y ajustes. Úsalos en tres botones.
5. Añade un SVG informativo con `role="img"` y `<title>`, y compruébalo con el inspector de accesibilidad del navegador.
6. Crea un favicon SVG y enlázalo desde el `<head>`.
7. Crea un rectángulo con un gradiente lineal y otro con un `clipPath` circular.
8. Anima un check con `stroke-dashoffset` y desactiva la animación con `prefers-reduced-motion`.

---

## 16. Chuleta rápida

### Icono de trazo en línea

```html
<svg class="icon" viewBox="0 0 24 24" width="24" height="24" aria-hidden="true" focusable="false">
  <path d="M20 6 9 17l-5-5"
        fill="none"
        stroke="currentColor"
        stroke-width="1.75"
        stroke-linecap="round"
        stroke-linejoin="round"/>
</svg>
```

### Icono relleno en línea

```html
<svg class="icon" viewBox="0 0 24 24" width="24" height="24" aria-hidden="true" focusable="false">
  <path d="..." fill="currentColor"/>
</svg>
```

### Archivo SVG externo

```html
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
  <path d="..." fill="currentColor"/>
</svg>
```

### CSS base para iconos

```css
.icon {
  display: block;
  width: 24px;
  height: 24px;
  color: var(--text);
  transition: color 0.2s ease;
}

.icon-button:hover .icon {
  color: var(--accent);
}
```

### Botón con icono y texto

```html
<button class="button" type="button">
  <svg class="icon" viewBox="0 0 24 24" aria-hidden="true" focusable="false">
    <path d="..." fill="none" stroke="currentColor" stroke-width="1.75"/>
  </svg>
  Copiar
</button>
```

### Botón solo con icono

```html
<button class="icon-button" type="button" aria-label="Copiar nota">
  <svg class="icon" viewBox="0 0 24 24" aria-hidden="true" focusable="false">
    <path d="..." fill="none" stroke="currentColor" stroke-width="1.75"/>
  </svg>
</button>
```

### Sprite

```html
<svg class="svg-sprite" aria-hidden="true">
  <symbol id="icon-check" viewBox="0 0 24 24">
    <path d="M20 6 9 17l-5-5"
          fill="none" stroke="currentColor" stroke-width="1.75"
          stroke-linecap="round" stroke-linejoin="round"/>
  </symbol>
</svg>

<svg class="icon" viewBox="0 0 24 24" aria-hidden="true" focusable="false">
  <use href="#icon-check"></use>
</svg>
```

### Máscara CSS

```css
.icon-mask {
  width: 24px;
  height: 24px;
  background-color: currentColor;
  mask: url("../assets/icono.svg") center / contain no-repeat;
}
```

### Atributos que conviene recordar

```text
viewBox="0 0 24 24"     sistema de coordenadas
width="24" height="24"  tamaño de presentación
fill="none"             sin relleno
fill="currentColor"     relleno con el color del texto
stroke="currentColor"   borde con el color del texto
stroke-width="1.75"     grosor del borde
stroke-linecap="round"  extremos redondeados
stroke-linejoin="round" esquinas redondeadas
aria-hidden="true"      decorativo para lectores de pantalla
focusable="false"       fuera del orden de tabulación
role="img"              informativo
```

---

## 17. Recursos

- MDN: SVG element reference  
  https://developer.mozilla.org/es/docs/Web/SVG/Element
- MDN: SVG paths tutorial  
  https://developer.mozilla.org/es/docs/Web/SVG/Tutorial/Paths
- MDN: SVG accessibility  
  https://developer.mozilla.org/es/docs/Web/Accessibility/ARIA/Roles/img_role
- Lucide Icons  
  https://lucide.dev/
- Feather Icons  
  https://feathericons.com/
- Inkscape  
  https://inkscape.org/
- SVGOMG  
  https://jakearchibald.github.io/svgomg/

---

## Resumen

Si solo te llevas una idea, que sea esta:

> Para iconos de interfaz que cambian de color, usa **SVG en línea** con `fill="none"`, `stroke="currentColor"` y `aria-hidden="true"`. Para el logo y las imágenes con colores propios, usa `<img src="...">`.

Con eso ya puedes construir todos los iconos de ShitNotes sin JavaScript y sin librerías externas.
