
console.log("Ejercicio 1:");
let libro = {
    titulo : "Quijote",
    autor : "Cervantes",
    publicado : 2026,

    mostrarInfo : function() {
        console.log(`El libro ${this.titulo} fue escrito por ${this.autor} en el año ${this.publicado}`);
    }
}

libro.mostrarInfo();

