const btn = document.getElementById("cambiar-mensaje");
const parrafo = document.getElementById("parrafo");

let estado = false;

btn.addEventListener("click", () => {
    estado = !estado;

    estado? parrafo.innerHTML = "Hola" : parrafo.innerHTML = "Adios";
});