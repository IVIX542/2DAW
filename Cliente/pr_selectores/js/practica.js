/* A. getElementById() */
const r1 = document.getElementById("titulo-principal");
const r2 = document.getElementById("contenido");
const r3 = document.getElementById("prestamos");
const r4 = document.getElementById("correo");
const r5 = document.getElementById("limpiar");

/* B. getElementsByClassName() */
const r6 = document.getElementsByClassName("tarjeta");
const r7 = document.getElementsByClassName("destacado");
const r8 = document.getElementsByClassName("tarjeta" && "disponible");
const r9 = document.getElementsByClassName("enlace-menu")[1];
const r10 = document.getElementById("presentacion").getElementsByClassName("texto");

/* C. getElementsByTagName() */
const r11 = document.getElementsByTagName("h2");
const r12 = document.getElementsByTagName("img");
const r13 = document.getElementsByTagName("button");
const r14 = document.getElementById("pasos-reserva").getElementsByTagName("li")[2];
const r15 = document.getElementById("tabla-prestamos").getElementsByTagName("td");