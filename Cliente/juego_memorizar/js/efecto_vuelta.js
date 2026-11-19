// Recuperamos los elementos del DOM.
const carta1 = document.getElementById("carta1");
const interior1 = document.getElementById("interior1");

const carta2 = document.getElementById("carta2");
const interior2 = document.getElementById("interior2");

const carta3 = document.getElementById("carta3");
const interior3 = document.getElementById("interior3");

const carta4 = document.getElementById("carta4");
const interior4 = document.getElementById("interior4");

const carta5 = document.getElementById("carta5");
const interior5 = document.getElementById("interior5");

const carta6 = document.getElementById("carta6");
const interior6 = document.getElementById("interior6");

// Registramos el evento click.
carta1.addEventListener("click", function () {

    // Alternamos la rotación.
    const descubierta = interior1.classList.toggle("rotate-y-180");

    // Actualizamos el estado accesible del botón.
    carta1.setAttribute("aria-pressed", String(descubierta));

});

// Registramos el evento click.
carta2.addEventListener("click", function () {

    // Alternamos la rotación.
    const descubierta = interior2.classList.toggle("rotate-y-180");

    // Actualizamos el estado accesible del botón.
    carta2.setAttribute("aria-pressed", String(descubierta));

});

// Registramos el evento click.
carta3.addEventListener("click", function () {

    // Alternamos la rotación.
    const descubierta = interior3.classList.toggle("rotate-y-180");

    // Actualizamos el estado accesible del botón.
    carta3.setAttribute("aria-pressed", String(descubierta));

});

// Registramos el evento click.
carta4.addEventListener("click", function () {

    // Alternamos la rotación.
    const descubierta = interior4.classList.toggle("rotate-y-180");

    // Actualizamos el estado accesible del botón.
    carta4.setAttribute("aria-pressed", String(descubierta));

});

// Registramos el evento click.
carta5.addEventListener("click", function () {

    // Alternamos la rotación.
    const descubierta = interior5.classList.toggle("rotate-y-180");

    // Actualizamos el estado accesible del botón.
    carta5.setAttribute("aria-pressed", String(descubierta));

});

// Registramos el evento click.
carta6.addEventListener("click", function () {

    // Alternamos la rotación.
    const descubierta = interior6.classList.toggle("rotate-y-180");

    // Actualizamos el estado accesible del botón.
    carta6.setAttribute("aria-pressed", String(descubierta));

});