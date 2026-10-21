/* Bloque 1: Asignaciones y Operadores Avanzados */

// Operadores de asignación lógica (||= y ??=)
let configuracion = null;
console.log(configuracion);

let modoOscuro = false;

configuracion ??= {tema : 'claro'};
console.log(configuracion); // {tema : claro}

modoOscuro ||= true;
console.log(modoOscuro); // true
/**
 * En la variable configuración cambia de null al string porque la asignación inicial es
 * null. Si es null, coge la segunda opción.
 * 
 * En la variable de modoOscuro cambia a true porque la asignación inicial es false.
 * Como es un falsy, coge la segunda asignación.
 */

// Desestructuración avanzada de objetos
let empleado = {
    id: 104,
    datosPersonales: {
        nombre: "Sofía",
        puesto: "Diseñadora"
    }
};

// Asignamos el contenido de nombre a nombreEmpleado
empleado.datosPersonales.nombreEmpleado = empleado.datosPersonales.nombre;

// Eliminamos nombre, ya no es necesario
delete empleado.datosPersonales.nombre;

console.log(
`Nombre del empleado: ${empleado.datosPersonales.nombreEmpleado}.
Puesto: ${empleado.datosPersonales.puesto}.`
);

