const express = require("express");
const app = express();
const puerto = 3000;

// Ruta GET en la raíz ('/')
// req (Request) - Representa la petición del cliente (parámetros, cabeceras, datos).
// res (Response) - Se utiliza para construir y enviar la respuesta de vuelta.
app.get("/", (req, res) => {
  res.send("¡Hola desde mi servidor Express!");
});

// Inicio del servidor en el puerto 3000
app.listen(puerto, () => {
  console.log(`Servidor ejecutándose en http://localhost:${puerto}`);
});

// ----------------------------------------------------------------------------------

/**
 * Al poner ":" antes de una palabra dentro de una ruta, le indicamos al servidor que
 * esa parte de la UURL es un parámetro variable.
 * Express captura los valores de las variables en re.params.
 */
app.get("/usuario/:nombre", (req, res) => {
    const nombreUsuario = req.params.nombre;

    // Le enviamos los datos en formato json al cliente
    res.json({
        mensaje: `¡Hola, ${nombreUsuario}!`,
        origrn: "Node.js + Express"
    });
});

/**
 * Hacer que el servidor responda con un JSON mostrando el producto consultado.
 */
app.get("/producto/:categoria/:id", (req, res) => {
    
    // Capturamos los parámetros de la URL
    const categoria = req.params.categoria;
    const id = req.params.id;

    // Enviamos el JSON como Response
    res.json({
        categoria: `${categoria}`,
        id: `${id}`
    });

});

/**
 * Escribe una ruta "/buscar" que:
 * 1. Reciba los parámetros de consulta "termino" y "limite"
 * 2. Responda con un JSON utilizando "res.json()" que devuelva esos dos datos
 *    recibidos en "req.query"
 */

