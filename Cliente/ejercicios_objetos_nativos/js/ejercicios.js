/* Bloque 1 */
/* Ejercicio 1 */
function ejercicioString() {
    
    
    let frase = prompt("Escribe una frase");
    document.body.innerHTML += "<p>Frase: " + frase + "</p>";
    document.body.innerHTML += "<p>La frase tiene " + frase.length + " caracteres.</p>";
    document.body.innerHTML += "<p>La frase en mayúsculas: " + frase.toUpperCase() + "</p>";
    
    let lista_palabras = frase.split(" ");
    let salida = "<ul>";
    
    for(palabra of lista_palabras) {
        salida += "<li>" + palabra + "</li>";
    }
    
    salida += "</ul>";
    document.body.innerHTML += salida;
}

/* Ejercicio 2 */
function ejercicioNumber() {
    
    // Cadena
    let cadena = "123.456";
    document.body.innerHTML += "<p> Cadena original: " + cadena + "</p>";
    
    // Cadena a número float
    let numeroFloat = Number.parseFloat(cadena);
    document.body.innerHTML += "<p> Número decimal: " + numeroFloat + "</p>";
    
    // Número float von un decimal (.toFixed(1))
    let numeroFloat1 = numeroFloat.toFixed(1);
    document.body.innerHTML += "<p> Número con un solo decimal: " + numeroFloat1 + "</p>";
    
    // Convertir el número 255 a HEX con .toString(16)
    let numeroHEX = Number(255).toString(16);
    document.body.innerHTML += "<p> Número 255 en HEX: " + numeroHEX + "</p>";
}

/* Ejercicio 3 */
function ejercicioMath() {
    
    // Generamos número aleatorio entre 1 y 10
    let numeroRandom = Math.floor((Math.random() * 10)+1);
    document.body.innerHTML += "<p> Número random: " + numeroRandom + "</p>";
    
    // Calculamos la raíz cuadrada de 81 (Math.sqrt(81))
    let r_cuadrada = Math.sqrt(81);
    document.body.innerHTML += "<p> Raíz cuadrada de 81: " + r_cuadrada + "</p>";
    
    // Calculamos el área de un círculo de radio 5 usando Math.PI
    let area_circulo = Math.PI * (5**2);
    document.body.innerHTML += "<p> Área decírculo con radio 5: " + area_circulo + "</p>";
    
}

/* Ejercicio 4 */
function ejercicioDate() {
    
    // Creamos un objeto con la fecha actual con new Date()
    let fecha = new Date();
    document.body.innerHTML += "<p>Fecha sin formato: " + fecha + "</p>";
    
    // Le damos formato "dd/MM/yyyy"
    let fecha_formateada = fecha.getDate() + "/" + fecha.getMonth() + "/" + fecha.getFullYear();
    document.body.innerHTML += "<p>Fecha con formato: " + fecha_formateada + "</p>";
    
    // Averiguamos qué día de la semana cayó el 1 de enero del año 2000
    let fecha2 = new Date(2000, 0, 1); // año : 2000 - mes : enero - día : 1
    
    // Nos devuelve el día de la semana(0:domingo, 1:lunes, 2:martes, 3:miércoles, 4:jueves, 5:viernes, 6:sábado)
    let dia_semana = fecha2.getDay();
    
    // Array con los días de la semana formato yanqui
    const dias_semana = ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];
    
    // Imprimimos el día correspondiente al índice de la variable "dia_semana"
    document.body.innerHTML += "<p>Día de la semana del 1 de enero del año 2000: " + dias_semana[dia_semana] + "</p>";
    
}

/* Bloque 2 */
/* Ejercicio 1 */

function mostrarNombre() {
    
    // Pedimos el nombre por un prompt
    let nombre = prompt("Escribe tu nombre");
    
    // Imprimimos un saludo personalizado en un h1
    document.body.innerHTML += `<h1>Hola, ${nombre}</h1>`;
}

/* Ejercicio 2 */
function cambiarColor() {
    
    // Creamos el array con los colores
    let colores = ["red", "green", "blue", "lightblue", "yellow", "SlateBlue", "Tomato", "Violet", "Gray"];

    // Número aleatorio de 0 a la longitud del array
    let indice = Math.floor(Math.random() * colores.length);

    // Imprimimos por consola el color, para ver cuál se elige
    console.log(colores[indice]);
    
    // Cambiamos el color de fondo al color en la posición indicada por el índice
    document.body.style.backgroundColor = colores[indice];
}