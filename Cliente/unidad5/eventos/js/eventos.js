let contador = 0;

function saludar() {
    contador++;
	console.log("evento click desde saludar ---> " + contador);
}
function saludar1() {
    contador++;
	console.log("evento click desde saludar1 <--- " + contador);
}

const cabecerah1 = document.getElementById("cabecera");

cabecerah1.ondblclick = saludar;

const btnAEL = document.getElementById("boton-con-AEL");

btnAEL.addEventListener("click", saludar);
btnAEL.addEventListener("click", saludar1);
btnAEL.addEventListener("click", () => {
    console.log("Desde la función flecha")
});