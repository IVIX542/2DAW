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