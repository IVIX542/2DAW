console.log("----- Método reduce() -----");

let notas = [7, 8, 9, 5, 10];

// Sumar todos los elementos con reduce
let suma = notas.reduce((acum, nota) => acum + nota, 0);

// Calcular la media
let media = suma / notas.length;

console.log(`La nota media es: ${media}`);

console.log("----- Método filter() -----");

let numeros = [3, 7, 12, 18, 25, 30];

let pares = numeros.filter(num => num % 2 === 0);

console.log(pares); // [12, 18, 30]

console.log("----- Método map() -----");

let base = [2, 4, 6, 8];

let dobles = base.map(num => num * 2);

console.log(dobles); // [4, 8, 12, 16]

console.log("----- Método sort() -----");

let nombres = ["Carlos", "Ana", "Beatriz", "Daniel"];
console.log("Lista original:", nombres);

nombres.sort(); // Orden alfabético
console.log("Lista ordenada:", nombres);

nombres.reverse(); // Orden inverso
console.log("Lista inversa:", nombres);

console.log("----- Método join() -----");

let frutas = ["manzana", "pera", "plátano"];

let texto = frutas.join(", ");
console.log(`Hoy compré: ${texto}.`);

console.log("----- Métodos push() y pop() -----");

let cesta = [];

// Añadir con push()
cesta.push("leche");
cesta.push("pan", "huevos");

console.log(cesta); // ["leche", "pan", "huevos"]

// Eliminar el último elemento con pop()
let eliminado = cesta.pop();
console.log(`Quité: ${eliminado}`); // Quité: huevos
console.log(cesta); // ["leche", "pan"]

console.log("----- Combinar arrays y -----\n"
            + "---- eliminar duplicados ----");

let a = [1, 2, 3];
let b = [3, 4, 5];

// Unir los arrays
let combinados = a.concat(b);

// Eliminar duplicados usando Set
let sinDuplicados = [...new Set(combinados)];

console.log(sinDuplicados); // [1, 2, 3, 4, 5]






