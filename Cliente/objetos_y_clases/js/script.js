// Clases

class Persona {

    constructor(nombre, edad) {
        this._nombre = nombre; // El guión bajo indica una propiedad "Privada".
        this._edad = edad;
    }

    /* Se hacen getters y setters */
    get nombre() {
        return this._nombre;
    }

    saludar(texto) {
        console.log(`Hola, soy ${this._nombre} y tengo ${this._edad} años. ${texto}`);
    }

}

let p1 = new Persona("Ana", 33);
let p2 = new Persona("Juan", 23);

class Estudiante extends Persona {

    constructor(nombre, edad, curso) {
        super(nombre, edad);
        this.curso = curso;
    }

}

let est1 = new Estudiante("Juan", 18, "DAW");
let est2 = new Estudiante("Ana", 19, "ASIR");

est1.saludar("¿Que tal?");

/* Estático */

class Matematicas {
    static suma(a, b){
        return a + b;
    }
}

console.log(Matematicas.suma(1, 2));
