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

const btnCIE = document.getElementById("boton-con-info-evento");

btnCIE.addEventListener("click", (evento) => {
    console.log(evento.type)
});

const miInput = document.getElementById("dato1");
const parrafoSalida = document.getElementById("salida");
const formulario = document.getElementById("formulario");

miInput.oninput = function (evento){
    parrafoSalida.innerHTML = evento.target.value;
}

const bnEnviar = document.getElementById("enviar");
bnEnviar.addEventListener("click", (evento) => {
    evento.preventDefault(); // desactiva el submit
    console.log("No se envía el formulario");
    if(miInput.value == "") {
        alert("El campo 1 está vacío");
    } else {
        console.log("Enviar los datos");
        formulario.requestSubmit();
    }
})