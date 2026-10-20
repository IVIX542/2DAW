
console.log("Ejercicio 1:");

let libro = {
    titulo : "Quijote",
    autor : "Cervantes",
    publicado : 2026,
    
    mostrarInfo : function() {
        console.log(`El libro ${this.titulo} fue escrito por ${this.autor} en el año ${this.publicado}`);
    }
};

libro.mostrarInfo();

console.log("Ejercicio 2:");

let persona = {
    nombre : "Luis",
    edad : 28
};

console.log(persona);

persona.profesion = "Desarrollador";
persona.edad = 29;
delete persona.nombre;

console.log(persona);


console.log("Ejercicio 3:");

let alumno = {
    nombre : "Ana",
    curso : "JavaScript",
    nota : 9
};

for(let atributo in alumno) {
    console.log(`${atributo} : ${alumno[atributo]}`);
}

console.log("Ejercicio 4:");

console.log(Object.values(alumno));

for(let entrada of Object.entries(alumno)){
    console.log(`${entrada[0]} : ${entrada[1]}`)
}

console.log("Ejercicio 5:");

class Coche {

    constructor(marca, modelo, velocidad){
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = velocidad;
    }

    acelerar(cantidad) {
        this.velocidad += cantidad;
    }
    frenar(cantidad) {
        this.velocidad -= cantidad;
    }
    mostrarVelocidad() {
        console.log(`La velocidad actual es de ${this.velocidad} km/h`);
    }
}

let coche = new Coche("Seat", "Ibiza", 120);

coche.acelerar(50);
coche.frenar(20);
coche.mostrarVelocidad();

