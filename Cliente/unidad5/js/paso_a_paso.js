let numElemento = 1; // pasos
let tabla; // tabla que crearemos

// Elementos del DOM que pillamos por su iid
const botonCrear = document.getElementById("crear");
const contenedor = document.getElementById("contenedor");
const mensajes = document.getElementById("mensajes");

// Constantes
const NUM_FILAS = 7;
const NUM_COLS = 3;

// Función que realiza una acción dependiendo del paso en el que estemos
function creaSiguiente() {
    

    switch (numElemento) {
        case 1:
            numElemento++;
            crearTabla(); // llama a crearTabla
            creaPaso("Se ha creado la tabla."); // escribe un paso en el DOM
            // break;
        case 2:
            numElemento++;
            crearCabeceraTabla();
            creaPaso("Se ha creado la cabecera de la tabla.");
            // break;
        case 3:
            numElemento++;
            crearFilaCabeceraTabla();
            creaPaso("Se ha creado la fila de la cabecera de la tabla.");
            // break;
        case 4:
            numElemento++;
            crearCuerpoTabla();
            creaPaso("Se ha creado el cuerpo de la tabla.");
            // break;
        case 5:
            numElemento++;
            crearFilasCuerpoTabla();
            creaPaso("Se ha creado las filas en el cuerpo de la tabla.");
            // break;
        case 6:
            numElemento++;
            crearCeldasDatos();
            creaPaso("Se ha creado las columnas de las filas en el cuerpo de la tabla.");
            // break;
        case 7:
            numElemento++;
            ponerBorde();
            creaPaso("Se ha añadido borde a la tabla.");
            // break;
        case 8:
            numElemento++;
            borrarBorde();
            creaPaso("Se ha quitado borde a la tabla.");
            // break;
        case 9:
            numElemento++;
            cargarTailwind();
            creaPaso("Se ha cargado TailWind.");
            // break;
        // Añade aquí los casos siguientes.
    }

    console.log(`Paso ${numElemento}`);
}

function cargarTailwind() {
    const script = document.createElement("script");

    script.src = "https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4";
    botonCrear.disabled = true;

    script.addEventListener("load", () => {
        mensajes.classList.add("list-[upper-roman]", "list-inside");
        creaPaso("Se ha cargado TailWind CSS.");
        botonCrear.disabled = false;
    });

    script.addEventListener("error", () => {
        script.remove();
        numElemento--;
        botonCrear.disabled = false;
        alert("No se pudo cargar TailWind. Vuelve a pulsar el botón Crear.");
    });

    document.head.appendChild(script);
}

function borrarBorde() {
    tabla.classList.remove("table_borde");
}

function ponerBorde() {
    const estiloBorde = document.createElement("style");

    estiloBorde.textContent = ".table_borde {border: 2px solid black; border-radius: 5px;}"

    document.head.appendChild(estiloBorde);

    tabla.classList.add("table_borde");
}

function crearCeldasDatos() {
    // recuperar todas las filas del tbody -> querySelectorAll 'tbody tr'
    const filas = document.querySelectorAll("tbody tr");

    console.log(filas);

    //forEach por cada fila
    let contFila = 1;
    for(let fila of filas) {
        
        // for para crear los td
        for(let i = 1; i <= NUM_COLS; i++) {
            const celda = document.createElement("td");
            celda.textContent = `F: ${contFila} - C: ${i}`;
            fila.appendChild(celda);

        }
        contFila++;
    }
}

function crearFilasCuerpoTabla() {

    const cuerpo = tabla.querySelector("tbody");

    for(let fila = 1; fila <= NUM_FILAS; fila ++) {
        cuerpo.appendChild(document.createElement("tr"));
    }


}

function crearCuerpoTabla() {
    const cuerpo = document.createElement("tbody");
    tabla.appendChild(cuerpo);
}

function crearFilaCabeceraTabla() {

    // creo la fila
    const fila = document.createElement("tr");

    for (let columna = 1; columna <= NUM_COLS; columna++) {
        const celda = document.createElement("th");
        celda.scope = "col";
        celda.textContent = "Cabecera " + columna;
        fila.appendChild(celda);
    }
    tabla.querySelector("thead").appendChild(fila); 

}

function crearCabeceraTabla() {
    const cabecera = document.createElement("thead");
    tabla.appendChild(cabecera);
}

function crearTabla() {
    tabla = document.createElement("table"); // asigna un elemento "table" a la variable tabla
    tabla.id = "mitabla"; // añade un id al elemento "table"
    contenedor.appendChild(tabla); // añade la tabla al DOM
}

function creaPaso(mensaje) {
    const item = document.createElement("li"); // asigna un elemento "li" a item
    item.textContent = mensaje; // Añade como contenido del "li" el mensaje
    mensajes.appendChild(item);
}

botonCrear.addEventListener("click", creaSiguiente);