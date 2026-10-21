// Ejercicio 1: Números del 1 a 10
console.log("---------- Ejercicio 1 ----------");

for(let i = 1; i <=10; i++){
    console.log(i);
}

// Ejercicio 2: Suma de números
console.log("---------- Ejercicio 2 ----------");

let i = 1
let resul = 0;
while( i <= 5){
    resul += i;
    i++;
}
console.log(resul);

// Ejercicio 3: Tabla de multiplicar
console.log("---------- Ejercicio 3 ----------");

let num = parseInt(prompt("Introduce un número entero: "));

for(let i = 1; i <= 10; i++){
    console.log(`${num} x ${i} = ${num * i}`);
}

// Ejercicio 4: Cuenta atrás
console.log("---------- Ejercicio 4 ----------");
i = 10;
while(i >= 1){
    console.log(i);
    i--;
}

// Ejercicio 5: Al menos una vez
console.log("---------- Ejercicio 5 ----------");
let numero = 15;
do{
    console.log(numero);
} while(numero < 10);

// Ejercicio 6: Array de frutas
console.log("---------- Ejercicio 6 ----------");
let frutas = ["Manzana", "Pera", "Melón", "Sandía", "Fresa"]

for(let fruta of frutas){
    console.log(fruta);
}

// Ejercicio 7: Propiedades de un objeto
console.log("---------- Ejercicio 7 ----------");


let persona = {
    nombre : "Ivan",
    edad : 19,
    ciudad : "Madrid"
}

for(let propiedad in persona){
    console.log(`${propiedad} : ${persona[propiedad]}`);
}

// Ejercicio 8: Números pares
console.log("---------- Ejercicio 8 ----------");

for(let i = 1; i <=20; i+=2){
    console.log(i+1);
}

// Ejercicio 9: Salta un número
console.log("---------- Ejercicio 9 ----------");

for(let i = 1; i <=10; i++){

    if(i == 5){
        continue;
    }

    console.log(i);
}

// Ejercicio 10: Detener un bucle
console.log("---------- Ejercicio 10 ----------");

for(let i = 1; i <= 10; i++){
    if(i == 7){
        break;
    }
    console.log(i);
}

// Ejercicio 11: Lista en HTML
console.log("---------- Ejercicio 11 ----------");

console.log("<ul>");
for(let i = 1; i <= 5; i++){
    console.log(`\t<li>${i}</li>`);
}
console.log("</ul>");

// Ejercicio 12: Números aleatorios hasta acertar

console.log("---------- Ejercicio 12 ----------");
let numero1 = parseInt(Math.floor(Math.random()*10)+1);
let contador = 0;

while(numero1 != 7){
    contador++;
    if(contador > 10000){
        console.log("Ejecución detenida: Posible bucle infinito");
        break;
    }
}

console.log(`Ha salido el número 7 en el intento número ${contador}`)
