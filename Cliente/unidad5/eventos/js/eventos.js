let contador = 0;

function saludar() {
    contador++;
	console.log("evento click " + contador);
}

const cabecerah1 = document.getElementById("cabecera");

cabecerah1.ondblclick = saludar;