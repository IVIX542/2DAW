const campo = document.getElementById("nombre");
const comprobar = document.getElementById("comprobar");

campo.oninput = function (e) {
    if(e.target.value.length == 0) {
        comprobar.innerHTML = "";
    } else if(e.target.value.length < 3) {
        comprobar.innerHTML = "Nombre demasiado corto";
    } else if (e.target.value.length >= 3) {
        comprobar.innerHTML = "Nombre válido";
    }
}