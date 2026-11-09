let numElemento = 0;
let tabla;

const botonCrear = document.getElementById("crear");
const contenedor = document.getElementById("contenedor");
const mensajes = document.getElementById("mensajes");

const numFilas = 7;
const numCols = 3;

function creaSiguiente() {
    numElemento++;

    switch (numElemento) {
        case 1:
            crearTabla();
            creaPaso("Se ha creado la tabla.");
            break;

        // Añade aquí los casos siguientes.
    }
}

function crearTabla() {
    tabla = document.createElement("table");
    tabla.id = "mitabla";
    contenedor.appendChild(tabla);
}

function creaPaso(mensaje) {
    const item = document.createElement("li");
    item.textContent = mensaje;
    mensajes.appendChild(item);
}

botonCrear.addEventListener("click", creaSiguiente);