
const parrafo1 = document.getElementById("parrafo");
parrafo.textContent = "Hola";

const listaAvisos = document.getElementsByClassName("aviso");

for(const aviso of listaAvisos) {
    aviso.classList.add("destacado");
}

const parrafo2 = document.getElementById("parrafo2");
parrafo2.innerHTML += " con una palabra <strong id='resalto'>resaltada</strong>";

const elementoResalto = document.getElementById("resalto");
console.log(elementoResalto);

const listaParrafos = document.getElementsByTagName("p");
for(const p of listaParrafos) {
    p.classList.add("rojo");
}

const enlace1 = document.querySelector("a");
enlace1.setAttribute("href", "http://thymeleaf.org");

const imagen1 = document.querySelector("img");
imagen1.src="img/foto2.jpg";