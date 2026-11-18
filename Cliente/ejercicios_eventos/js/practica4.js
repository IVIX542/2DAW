// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

const cuenta = document.getElementById("cuenta");
let contador = 0

cuenta.innerHTML = contador;

window.addEventListener("keydown", (e) => { // keydown -> tecla presionada
    if(e.key === 'ArrowUp') { // ArrowUp -> flecha arriba
        contador++;
        cuenta.innerHTML = contador;
    } else if (e.key === 'ArrowDown') { // ArrowDown-> flecha abajo
        contador--;
        cuenta.innerHTML = contador;
    }
});