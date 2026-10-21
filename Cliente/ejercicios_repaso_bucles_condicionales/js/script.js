console.log("--------- Ejercicio 1 ---------");
console.log("--- Números pares e impares ---");

for(let i = 1; i <= 20; i++){
    if(i % 2 == 0){
        console.log( i+ " es par.");
    } else {
        console.log(i+ " es impar.");
    }
}

console.log("------------ Ejercicio 2 ------------");
console.log("--- Contar aprobados y suspensos ----");

let notas = [4, 7, 9, 3, 5, 10];

let aprobados = 0;
let suspensos = 0;
for(let nota of notas){
    nota >= 5? aprobados++ : suspensos ++;
}
console.log(`Aprobados: ${aprobados}`);
console.log(`Suspensos: ${suspensos}`);

console.log("------------ Ejercicio 3 ------------");
console.log("----- Suma de números positivos -----");

const numerosEnteros = [10, -5, 200, -35, 1, -99, 42, 0];
let resul = 0;

for(let numero of numerosEnteros){
    if(numero > 0){
        resul += numero;
    }
}

console.log(`La suma es: ${resul}`);

console.log("------------ Ejercicio 4 ------------");
console.log("----- Juego de adivinar número ------");

let aleatorio = Math.floor(Math.random() * 10) + 1;
let num_usuario = Number(prompt("Adivina el número (1-10): "));

while(num_usuario != aleatorio){
    num_usuario = Number(prompt("Número incorrecto, prueba otra vez (1-10): "));
}

console.log(`Lo has adivinado, el número era: ${aleatorio}`);

console.log("------------- Ejercicio 5 -------------");
console.log("- Tabla de multiplicar con condición --");


let numero = Number(prompt("Introduce un número entero:"));

for(let i = 1; i <= 10; i++){
    console.log(`${numero} x ${i} = ${numero * i}`);
    if((numero * i) > 50){
        console.log("Resultado alto.");
    };
}


console.log("------------- Ejercicio 6 -------------");
console.log("------- Clasificación de edades -------");

let edades = [8, 11, 12, 17, 18, 35, 64, 65, 80];
let cat_edad = "";

for(let edad of edades){
    
    if (edad < 12) {
        cat_edad = "Niño";
    } else if (edad <= 17) {
        cat_edad = "Adolescente";
    } else if (edad <= 64) {
        cat_edad = "Adulto";
    } else {
        cat_edad = "Mayor";
    }
    console.log(`La edad ${edad} pertenece a la categoría ${cat_edad}`);
}


console.log("------------- Ejercicio 7 -------------");
console.log("------ Lista de números filtrados -----");

for(let i = 1; i<=30; i++){
    if(i % 3 == 0){
        continue;
    }
    if(i == 25){
        break;
    }
    console.log(i);
}

console.log("------------- Ejercicio 8 -------------");
console.log("--- Cálculo de descuento progresivo ---");

const importes = [40, 60, 120, 80];

for(let importe of importes){
    if(importe < 50){
        console.log(`Importe original: ${importe}`);
        console.log(`Importe con descuento: ${importe}`);
    } else if(importe >= 50 && importe <= 100){
        console.log(`Importe original: ${importe}`);
        importe = importe - (importe * 0.10);
        console.log(`Importe con descuento: ${importe}`);
    } else if(importe > 100){
        console.log(`Importe original: ${importe}`);
        importe = importe - (importe * 0.20);
        console.log(`Importe con descuento: ${importe}`);
    }
}

console.log("------------- Ejercicio 9 -------------");
console.log("------- Números primos hasta 50 -------");

let contador = 0;

for(let i = 1; i <= 50; i++){
    
    contador = 0;
    
    for(let j = 1; j <= i; j++){
        if(i % j == 0){
            contador++;
        }
    }
    
    if( 
        i > 1
        && contador <= 2
    ){
        console.log(`${i} es primo.`);
    }
    
}


console.log("------------- Ejercicio 10 ------------");
console.log("-- Simulación de cajero automático ----");

let saldo = parseFloat(1000);

let salir = false;

console.log(`Dispones de ${saldo} € de saldo inicial.`);

while(!salir){
    // Template literal (pegado a la izquierda)
console.log(
`1. Ingresar dinero
2. Retirar dinero
3. Consultar saldo
4. Salir`
);
    
    let opcion = Number(prompt("Elige una opción (1-4): "));
    
    switch(opcion){
        case 1:
            let ingreso = parseFloat(prompt("Introduce la cantidad a ingresar: "));
            saldo += ingreso;
            console.log(`Saldo después del ingreso: ${saldo} €`);
            break;
        case 2:
            let retiro = parseFloat(prompt("Introduce la cantidad a retirar: "));

            if(saldo >= retiro){
                saldo -= retiro;
                console.log(`Saldo después del retiro: ${saldo} €`);
            } else {
                console.log(`Intentas retirar ${retiro} €, más del saldo que tienes (${saldo} €)`);
            }
            break;
        case 3:
            console.log(`Dispones de ${saldo} € de saldo.`);
            break;
        case 4:
            salir = true;
            break;
        default:
            opcion = Number(prompt("ERROR: Opción incorrecta, indica una nueva: (1-4): "));
        
                
    }

}



