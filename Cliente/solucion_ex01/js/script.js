/* Bucles */
console.log("----------Bucles----------");

let numeros = [-1,0,10,-5,0];

let i = 0;

while(i < numeros.length) {
    
    // Apartado 1
    if(numeros[i] === 0) {
        console.log("No se analiza el 0");
        i++;
        continue;
    }

    // Apartado 2
    if(numeros[i] > 0) {
        console.log("El número es positivo");
    } else {
        console.log("El número es negativo");

        // Apartado 3
        for(let j = 1; j <= Math.abs(numeros[i]); j++) {
            console.log(j);

            if(j === 3) {
                console.log("Contador intermedio");
            }
        }
    }
    
    console.log(`Número analizado: ${numeros[i]}`);

    i++;
}
// Sale del while cuando i alcanza 5, en este caso.

/* Conjuntos */
console.log("---------Conjuntos---------");

let conjuntoNombres = new Set();

conjuntoNombres.add("Ana");
conjuntoNombres.add("Luis");
conjuntoNombres.add("Marta");
conjuntoNombres.add("Ana"); // No se almacena, ya existe dentro del conjunto. No da error
conjuntoNombres.add("Pedro");

console.log(conjuntoNombres.size);
conjuntoNombres.delete("Luis");
console.log(conjuntoNombres.has("Ana"));

for(let nombre of conjuntoNombres) {
    console.log(nombre);
}

let arrayNombres = [...conjuntoNombres];
console.log(arrayNombres);

/* Clases */
console.log("----------Clases----------");

// Apartado 1
console.log("-----Apartado 1-----");

class Smartwatch {
    constructor(marca, modelo, bateria) {
        this.marca = marca;
        this.modelo = modelo;
        this.bateria = bateria;
    }

    mostrarEstado() {
        console.log(`El smartwatch ${this.marca}, modelo ${this.modelo} tiene ${this.bateria} % de batería.`);
    }
}

let reloj1 = new Smartwatch("Apple", "Watch 16", 85);
let reloj2 = new Smartwatch("Samsung", "WatchABC", 70);

reloj1.mostrarEstado();
reloj2.mostrarEstado();

// Apartado 2
console.log("-----Apartado 2-----");

class ReelojDeportivo extends Smartwatch {
    constructor(marca, modelo, bateria, modo) {
        super(marca, modelo, bateria);
        this.modo = modo;
    }

    iniciarEntrenamiento() {
        console.log(`Empezar entreno en modo: ${this.modo}.`);
    }
}

let garmin = new ReelojDeportivo("Garmin", "vivoactive3", 95, "series");

garmin.mostrarEstado();
garmin.iniciarEntrenamiento();