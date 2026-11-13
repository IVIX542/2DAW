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

/* D.  querySelector() */
const r16 = document.querySelector("#lema");
const r17 = document.querySelector(".disponible");
const r18 = document.querySelector("#libro-js h3");
const r19 = document.querySelector("input[name='correo']");
const r20 = document.querySelector("a[href^='https://']"); // utilizamos "^" para indicar que empieza por x
const r21 = document.querySelector("#presentacion p:nth-of-type(2)");
const r22 = document.querySelector("#lista-recursos li:first-child");
const r23 = document.querySelector("#tabla-prestamos tbody tr:nth-of-type(2) td:first-child");

/* E. querySelectorAll() */
const r24 = document.querySelectorAll("#menu-principal a");
const r25 = document.querySelectorAll("#presentacion>p");
const r26 = document.querySelectorAll(".tarjeta[data-categoria = 'web']");
const r27 = document.querySelectorAll("a[href$='.pdf']"); // utilizamos "$" para indicar que acaba por x
const r28 = document.querySelectorAll("input[required]");
const r29 = document.querySelectorAll("#tabla-prestamos tbody tr[data-estado = 'pendiente']");
const r30 = document.querySelectorAll("button:not([disabled])");