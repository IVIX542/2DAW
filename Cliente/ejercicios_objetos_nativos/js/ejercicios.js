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
        salida += "<li> " + palabra + "</li>";
        
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
    let numeroRandom = Math.floor((Math.random() * 10)+1);
    document.body.innerHTML += "<p> Número random: " + numeroRandom + "</p>";
}
