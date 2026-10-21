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
    nick: "CyberCoder",
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

switch (operacion) {
    case "+":
        console.log(num1 + num2);
        break;
    case "-":
        console.log(num1 - num2);
        break;
    case "*":
        console.log(num1 * num2);
        break;
    case "/":
        console.log(num1 / num2);
        break;
    default:
        console.log("Operador no válido.");
}

// Operador ternario
let temperatura = 25;

let estado = temperatura >= 25 ? "Hace calor" : "Hace fresco";

console.log(estado);

/* Bloque 3: Bucles y control de flujo */

// Bucle "for" básico y pares.
for (let i = 1; i <= 20; i++) {
    if (i % 2 == 0) {
        console.log(i);
    }
}

// Validación con do...while
let intentos = 0;

do {
    intentos++;
} while (intentos < 3);

console.log(`Intentos: ${intentos}`); // Intentos = 3. Peimero ejecuta, luego comprueba.

// Uso de break y continue
for (let i = 1; i <= 10; i++) {
    if (i == 4) { continue };
    if (i == 8) { break };
    console.log(i);
}

/* Bloque 4: Funciones en JavaScript */

// Tipos de funciones (Declarada, Expresada y Flecha)
function sumarDeclarada(n1, n2) { return (n1 + n2) };

let sumarExpresada = function (n1, n2) { return (n1 + n2) };

let sumarFlecha = (n1, n2) => { return (n1 + n2) };

console.log(`Función suma Declarada:\n${sumarDeclarada}\nResultado: ${sumarDeclarada(1, 2)}`);
console.log(`Función suma Expresada:\nContenido: ${sumarExpresada}\nResultado: ${sumarExpresada(1, 2)}`);
console.log(`Función suma Flecha:\nContenido: ${sumarFlecha}\nResultado: ${sumarFlecha(1, 2)}`);

// Funciones nativas y de objetos (Math y String)
function setMayusculas(texto) {
    console.log(texto.toUpperCase());
    return texto.length > 5 ? true : false;
};
console.log(setMayusculas("hola"));

/* Bloque 5: Colecciones: Arrays, Set y Map */

// Transformaciones en arrays (map, filter, reduce)
let numeros = [2, 4, 6, 8, 10];
console.log(`Números: ${numeros}`);

// - map
let numeros_cuadrados = numeros.map((n) => n ** 2);
console.log(`Números al cuadrado: ${numeros_cuadrados}`);

// - filter
let numeros_mayores_cinco = numeros.filter((n) => n > 5);
console.log(`Números mayores de 5: ${numeros_mayores_cinco}`);

// - reduce
let numeros_total = numeros.reduce((i, n) => i + n, 0);
console.log(`Suma total: ${numeros_total}`);

// Operaciones con Set (Valores Únicos)
let lista = ["pera", "manzana", "pera", "kiwi", "manzana", "plátano"];

let lista_limpia = new Set(lista);
let arr_lista_limpia = [...lista_limpia]; // Pasamos el set a array
console.log(`Lista sin repetidos: ${arr_lista_limpia}`);

// Gestión de datos con Map
let stockProductos = new Map();

stockProductos.set("camisetas", 15);
stockProductos.set("pantalones", 8);
stockProductos.set("zapatos", 4);

console.log(`Hay zapatos?: ${stockProductos.has("zapatos")}`);
console.log(`Hay ${stockProductos.get("camisetas")} camisetas`);

for (let [producto, cantidad] of stockProductos) {
    console.log(`Producto : ${producto}\nCantidad : ${cantidad}`);
}

/* Bloque 6: Objetos y Clases */

// Objeto literal y métodos
let cuentaBancaria = {
    titular : "Iván",
    saldo : Number(1000.0),

    ingresar : function(cantidad) {
        this.saldo += Number(cantidad);
    },

    retirar : function(cantidad) {
        this.saldo -= Number(cantidad);
    }
}

console.log(`Saldo inicial: ${cuentaBancaria.saldo}`);

cuentaBancaria.ingresar(500.20);
cuentaBancaria.retirar(5.05);

console.log(`Saldo final: ${cuentaBancaria.saldo}`);

// Creación de clases
class Rectangulo {
    constructor(ancho, alto) {
        this.ancho = Number(ancho);
        this.alto = Number(alto);
    }

    calcularArea = function() {
        return (this.ancho * this.alto);
    }

    calcularPerimetro = function() {
        return (2 * (this.ancho + this.alto));
    }
}

let rect1 = new Rectangulo(4,2);

console.log(`Área del rectángulo: ${rect1.calcularArea()} cm².`);
console.log(`Perímetro del rectángulo: ${rect1.calcularPerimetro()} cm.`);

