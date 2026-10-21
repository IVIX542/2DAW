let libro = {
    titulo : "El Quijote",
    autor : "Cervantes",
    publicado : 2026,
    mostrarInfo : function() {
        console.log(`El libro ${this.titulo} fue publicado por ${this.autor} en ${this.publicado}`);
    }
}

libro.mostrarInfo();