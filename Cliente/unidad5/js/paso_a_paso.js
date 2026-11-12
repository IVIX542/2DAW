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
            break;
        case 10:
            numElemento++;
            recolocar();
            creaPaso("Tabla y lista recolocadas.");
            // break;
        case 11:
            numElemento++;
            estilizarPagina();
            creaPaso("Aplicar estilos a la página y al botón.");
            break;
        case 12:
            numElemento++;
            estilizarTabla();
            creaPaso("Aplicar estilos a la tabla.");
            // break;
        case 13:
            numElemento++;
            estilizarLista();
            creaPaso("Aplicar estilos a la lista.");
            break;
        case 14:
            numElemento++;
            creaPaso("Elemento uno lista.");
            // break;
        case 15:
            numElemento++;
            creaPaso("Elemento dos lista.");
            // break;
        // Añade aquí los casos siguientes.
    }

    console.log(`Paso ${numElemento}`);
}

function estilizarLista() {
    document.querySelector("#divMensajes h2").classList.add(
        "mb-2", "text-xl", "font-semibold"
    );

    mensajes.classList.add(
        "space-y-1", 
        "[&>li:last-child]:font-semibold",
        "[&>li:last-child]:text-indigo-700"
    );
}

function estilizarTabla() {
    contenedor.classList.add("oferflow-x-auto");
    tabla.classList.add("w-full", "border-collapse", "text-sm");
    tabla.querySelector("thead").classList.add("bg-indigo-100");

    tabla.querySelectorAll("th, td").forEach(celda => {

        celda.classList.add("border", "border-slate-300", "p-2", "text-left");
    });

    tabla.querySelectorAll("tbody tr").forEach(fila => {
        fila.classList.add("even:bg-stale-50"); // even
    })
}

function estilizarPagina() {
    // añadir estilos al body
    document.body.classList.add("mx-auto", "max-w-5xl", "p-6");

    // añadir estilos al primer h1
    document.querySelector("h1").classList.add("mb-4", "text-3xl", "font-bold");

    // añadir estilos al botón
    botonCrear.classList.add("mb-6", "rounded-lg", "bg-indigo-700", "px-4", "py-2","font-semibold", "text-white", "hover:bg-indigo-800","disabled:opacity-50");

}

function recolocar() {
    // crear el nuevo div, para contener la tabla y la lista
    const zona = document.createElement("div");

    // recuperar la lista
    const zonaLista = document.getElementById("divMensajes");

    // añadimos zona delante de "divMensajes", variable zona
    zonaLista.before(zona);

    // añadimos como hijo la lista
    zona.appendChild(zonaLista);
    // añadimos como hijo el contenedor de la tabla
    zona.appendChild(contenedor);

    // modificamos el aspecto para colocar la lista al lado de la tabla
    zona.classList.add("grid", "grid-cols-1", "md:grid-cols-2", "gap-6");


}

function cargarTailwind() {
    // Creamos un elemento script
    const script = document.createElement("script");

    // Añadimos ese contenido al src del script
    script.src = "https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4";

    // Deshabilitamos el botón
    botonCrear.disabled = true;

    // Carga correcta
    script.addEventListener("load", () => {
        mensajes.classList.add("list-[upper-roman]", "list-inside");
        creaPaso("Se ha cargado TailWind CSS.");
        botonCrear.disabled = false;
    });
    
    // Carga dio error
    script.addEventListener("error", () => {
        script.remove();
        numElemento--;
        botonCrear.disabled = false;
        alert("No se pudo cargar TailWind. Vuelve a pulsar el botón Crear.");
    });

    // Añadimos el script al DOM en el head
    document.head.appendChild(script);
}

function borrarBorde() {
    // tabla.classList.remove("table_borde");

    tabla.classList.toggle("table_borde")
}

function ponerBorde() {
    crearNodoEstiloTabla();

    tabla.classList.toggle("table_borde");
}

function crearNodoEstiloTabla() {
    const estiloBorde = document.createElement("style");

    // estiloBorde.textContent = ".table_borde {border: 2px solid black; border-radius: 5px;}"
    
    const claseTexto = document.createTextNode(".table_borde {border: 2px solid black; border-radius: 5px;}");
    estiloBorde.appendChild(claseTexto);

    document.head.appendChild(estiloBorde);
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