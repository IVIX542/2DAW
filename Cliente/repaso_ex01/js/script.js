/* Bloque 1: Asignaciones, Operadores y Tipos */

// Operaciones de asignación compuesta
let puntos = 50;

puntos += 15;

puntos -= 10;

puntos *= 2;
console.log(`Puntos finales: ${puntos}`);

// Desestructuración de arrays y objetos
let colores = ["rojo", "verde", "azul"];

let primer_color = colores[0];
let tercer_color = colores[2];

console.log(`Primer color: ${primer_color}. Tercer color: ${tercer_color}`);

let usuario = {
    nick : "CyberCoder",
    nivel: 5
};

let nick_usuario = usuario.nick;
let nivel_usuario = usuario.nivel;

console.log(`Nick: ${nick_usuario}`);
console.log(`Nivel: ${nivel_usuario}`);

// Operadores lógicos y cortocircuito
let res1 = "JavaScript" && 50; // Devuelve: 50
let res2 = null || "Por defecto"; // Devuelve: Por defecto
let res3 = 0 ?? 10; // Devuelve: 0

/**
 * La primera operación devuelve 50 porque "JavaScript" es truthy, por lo que continúa
 *  su camino y devuelve el valor de la derecha.
 * La segunda operación devuelve "Por defecto" porque null es falsy, si el primer valor
 *  fuese truthy, devolvería el primero.
 * La tercera operación devuelve 0 porque el valor de la izquierda no es null, en caso
 *  contrario devolvería el valor de la derecha.
 */

console.log(res1);
console.log(res2);
console.log(res3);

/* Bloque 2: Condicionales */

// Calificación de notas (if...else if...else)
let nota = 4.5;
/*
if(nota >= 9) {
    alert("Sobresaliente");
} else if(nota >= 7 && nota < 9) {
    alert("Notable");
} else if (nota >= 5 && nota < 7) {
    alert("Aprobado");
} else if(nota < 5) {
    alert("Suspenso");
}
*/

// Calculadora con switch
let num1 = 1;
let num2 = 2;
let operacion = "+";

switch(operacion) {
    case "+":
        console.log(num1+num2);
        break;
    case "-":
        console.log(num1-num2);
        break;
    case "*":
        console.log(num1*num2);
        break;
    case "/":
        console.log(num1/num2);
        break;
    default:
        console.log("Operador no válido.");
}

// Operador ternario
let temperatura = 25;

let estado = temperatura >= 25 ? "Hace calor" : "Hace fresco";

console.log(estado);

/* Bloque 3: Bucles y control de flujo */
