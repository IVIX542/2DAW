# 📚 2DAW - Desarrollo de Aplicaciones Web

¡Bienvenido/a al repositorio central de mi formación en **2º de Desarrollo de Aplicaciones Web (2DAW)**! Este espacio organiza la teoría, ejercicios prácticos, proyectos y entregas del curso académico.

---

## 🛠️ Tecnologías y Herramientas Principales

* **Frontend:** HTML5, CSS3, JavaScript (ES6+).
* **Backend:** Node.js, Express.js.
* **Control de Versiones:** Git y GitHub.
* **Entornos de Desarrollo:** Visual Studio Code.

---

# Convención de Commits — 2DAW

Este repositorio sigue un estándar híbrido basado en **Conventional Commits** adaptado para identificar de un vistazo el módulo, la naturaleza del cambio y el proyecto o archivo correspondiente.

## Estructura base

```text
[ASIGNATURA] tipo(ámbito): descripción breve en infinitivo
```

> **Nota:** Si el commit corresponde a apuntes o ejercicios generales sin un proyecto o archivo concreto, se omite el paréntesis: `[DI] docs: añadir apuntes de teoría 2.2 y 3.1`. Si se modifica un archivo en la raíz que afecta a todo el curso, se omite el prefijo de asignatura: `docs(README.md): actualizar guía de commits`.

---

## 1. Prefijos de Asignatura / Módulo

| Prefijo | Carpeta | Contenido |
| :--- | :--- | :--- |
| **`[CL]`** | `Cliente` | Desarrollo Web en Entorno Cliente |
| **`[DI]`** | `Despliegue` | Despliegue de Aplicaciones Web |
| **`[EX]`** | `Express_js` | Backend con Node.js y Express |
| **`[IN]`** | `Interfaces` | Diseño de Interfaces Web |
| **`[PY]`** | `Python` | Programación en Python |
| **`[RE]`** | `React` | Desarrollo Frontend con React |
| **`[SE]`** | `Servidor` | Desarrollo Web en Entorno Servidor |

---

## 2. Tipos de Commit

| Tipo | Cuándo usarlo | Ejemplo |
| :--- | :--- | :--- |
| **`feat`** | Nueva funcionalidad, ejercicio o práctica. | `[SE] feat(gestion_alumnos): traducir templates al español` |
| **`fix`** | Corrección de un error o fallo en el código. | `[CL] fix(selectores): corregir validación en apartado C` |
| **`style`** | Cambios visuales o de formato (CSS, indentación) sin alterar lógica. | `[IN] style(portfolio): ajustar breakpoints del menú móvil` |
| **`refactor`** | Reestructuración de código sin cambiar su comportamiento. | `[EX] refactor(routing): separar controladores de req.query` |
| **`docs`** | Apuntes de teoría, comentarios o cambios en `README.md`. | `[DI] docs: añadir apuntes de teoría 2.2 y 3.1` |
| **`chore`** | Configuración, estructura de carpetas o tareas de mantenimiento. | `[RE] chore(my-react-proyect): configurar estructura inicial` |

---

## 3. Cómo referenciar proyectos y archivos

No se escriben rutas completas (Git ya registra la ruta exacta de cada archivo modificado). El formato del `(ámbito)` depende del contexto:

* **Dentro de un proyecto:** Se mantiene el nombre del proyecto entre paréntesis (en minúsculas con `snake_case` o `kebab-case`) y se menciona el archivo en la descripción.
  * `[SE] fix(gestion_alumnos): corregir validación de DNI en alumnos.php`
  * `[RE] feat(my-react-proyect): añadir estado de contador en App.jsx`
  * *Si existen dos archivos con el mismo nombre dentro del proyecto, se indica su carpeta inmediata:* `corregir enlaces en admin/index.html`.
* **Archivo suelto o de configuración:** Se escribe el nombre del archivo con su extensión directamente dentro del paréntesis.
  * `[EX] feat(server.js): añadir ejemplo de parámetros con req.query`
  * `[CL] feat(selectores.html): completar ejercicios del apartado C`

---

## 4. Reglas de escritura y GitHub Desktop

1. **Campo `Summary` completo:** En GitHub Desktop, toda la línea principal (`[ASIGNATURA] tipo(ámbito): descripción`) debe ir junta en **`Summary (required)`**. El campo **`Description`** se deja vacío salvo que sea necesario detallar cambios complejos en varios párrafos.
2. **Verbo en infinitivo:** Usar *añadir*, *corregir*, *traducir* o *completar* en lugar de pasado o gerundio, evitando redundancias con el tipo (por ejemplo, escribir `feat(gestion_alumnos): añadir perfiles` en vez de `añadir creación de perfiles`).
3. **Formato limpio:** La descripción empieza en minúscula tras los dos puntos y **no lleva punto final**.
4. **Longitud máxima:** Mantener la línea principal por debajo de los **72 caracteres** para evitar recortes (`...`) en GitHub.
5. **Commits atómicos:** Hacer commits separados por carpeta/asignatura y agrupar una única tarea lógica por commit.

---

## 5. Comandos útiles para filtrar el historial

```bash
# Ver todos los commits de una asignatura concreta
git log --oneline --grep="^[SE]"

# Ver todos los errores corregidos en el curso
git log --oneline --grep="fix("

# Ver el historial de un proyecto específico
git log --oneline --grep="(gestion_alumnos)"
```

## 📌 Autor
* **Alumno de 2DAW** — Iván López Benítez
