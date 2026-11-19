const fallosEl = document.getElementById("fallos");
const victoriasEl = document.getElementById("victorias");
const btnReseteo = document.getElementById("btn-reseteo");

const cartas = [
  document.getElementById("carta1"),
  document.getElementById("carta2"),
  document.getElementById("carta3"),
  document.getElementById("carta4"),
  document.getElementById("carta5"),
  document.getElementById("carta6")
];

const imagenes = [
  "img/carta1.png", "img/carta1.png",
  "img/carta2.png", "img/carta2.png",
  "img/carta3.png", "img/carta3.png"
];

let fallos = 0;
let victorias = 0;
let parejasEncontradas = 0;
let cartasSeleccionadas = [];
let temporizador = null;

function iniciarPartida() {
  const mezcladas = [...imagenes].sort(function () {
    return Math.random() - 0.5;
  });

  for (let i = 0; i < cartas.length; i++) {
    const carta = cartas[i];
    const interior = carta.querySelector(".interior");
    const imgDelante = carta.querySelector(".delante");

    interior.classList.remove("rotate-y-180");
    carta.setAttribute("aria-pressed", "false");
    carta.disabled = false;
    delete carta.dataset.emparejada;

    carta.dataset.imagen = mezcladas[i];
    imgDelante.src = mezcladas[i];
  }
}

for (let i = 0; i < cartas.length; i++) {
  cartas[i].addEventListener("click", function () {
    seleccionarCarta(cartas[i]);
  });
}

function seleccionarCarta(carta) {
  carta.disabled = true;
  cartasSeleccionadas.push(carta);

  if (cartasSeleccionadas.length === 2) {
    comprobarPareja();
  }
}

function comprobarPareja() {
  for (let i = 0; i < cartas.length; i++) {
    cartas[i].disabled = true;
  }

  const carta1 = cartasSeleccionadas[0];
  const carta2 = cartasSeleccionadas[1];

  if (carta1.dataset.imagen === carta2.dataset.imagen) {
    carta1.dataset.emparejada = "true";
    carta2.dataset.emparejada = "true";
    parejasEncontradas++;
    cartasSeleccionadas = [];

    habilitarRestantes();

    if (parejasEncontradas === 3) {
      victorias++;
      victoriasEl.textContent = victorias;
    }
  } else {
    fallos++;
    fallosEl.textContent = fallos;

    temporizador = setTimeout(function () {
      carta1.querySelector(".interior").classList.remove("rotate-y-180");
      carta2.querySelector(".interior").classList.remove("rotate-y-180");
      carta1.setAttribute("aria-pressed", "false");
      carta2.setAttribute("aria-pressed", "false");

      cartasSeleccionadas = [];
      habilitarRestantes();
    }, 900);
  }
}

function habilitarRestantes() {
  for (let i = 0; i < cartas.length; i++) {
    if (cartas[i].dataset.emparejada !== "true") {
      cartas[i].disabled = false;
    }
  }
}

btnReseteo.addEventListener("click", function () {
  clearTimeout(temporizador);
  fallos = 0;
  parejasEncontradas = 0;
  cartasSeleccionadas = [];
  fallosEl.textContent = fallos;

  for (let i = 0; i < cartas.length; i++) {
    cartas[i].querySelector(".interior").classList.remove("rotate-y-180");
    cartas[i].setAttribute("aria-pressed", "false");
  }

  setTimeout(iniciarPartida, 300);
});

iniciarPartida();