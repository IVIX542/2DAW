/* 1. Localizamos las tarjetas y las columnas */
const tarjetas = document.querySelectorAll(".tarea");
const columnas = document.querySelectorAll(".columna");

console.log("Tarjetas:", tarjetas.length);
console.log("Columnas:", columnas.length);

/* 2. Identificamos las tarjetas que arrastamos */
tarjetas.forEach(tarjeta => {
    tarjeta.addEventListener("dragstart", evento => {
        evento.dataTransfer.setData("text/plain", tarjeta.id);
        console.log("Arrastrando:", tarjeta.id);
    });
});

/* 3. Permitimos soltar para mover la tarjeta */
columnas.forEach(columna => {
    columna.addEventListener("dragover", evento => {
        evento.preventDefault();
    });

    columna.addEventListener("drop", evento => {
        evento.preventDefault();
        const id = evento.dataTransfer.getData("text/plain");
        const tarjeta = document.getElementById(id);

        if (tarjeta && tarjeta.matches(".tarea")) {
            columna.appendChild(tarjeta);
        }
    });
});

/* 4. Mostrar qué columna recibirá la tarea */
function quitarResaltado(columna) {
    columna.classList.remove("ring-2", "ring-blue-600");
}

tarjetas.forEach(tarjeta => {
    tarjeta.addEventListener("dragstart", () => {
        tarjeta.classList.add("opacity-50");
    });

    tarjeta.addEventListener("dragend", () => {
        tarjeta.classList.remove("opacity-50");
        columnas.forEach(quitarResaltado);
    });
});

columnas.forEach(columna => {
    columna.addEventListener("dragover", () => {
        columna.classList.add("ring-2", "ring-blue-600");
    });

    columna.addEventListener("dragleave", evento => {
        if (!columna.contains(evento.relatedTarget)) {
            quitarResaltado(columna);
        }
    });

    columna.addEventListener("drop", () => {
        quitarResaltado(columna);
    });
});
