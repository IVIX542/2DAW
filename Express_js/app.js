import express from "express";

const app = express();
const PORT = 3000;

app.get('/', (req, res) => {
    res.send('Hola desde Express.js con ES Modules!');
});

app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`);
});

/**
 * Ejemplo práctico req.query
 * ruta: http://localhost:3000/saludo?nombre=Ana
 */
app.get('/saludo', (req, res) => {
    const nombre = req.query.nombre || 'Invitado';
    res.send('Hola, ${nombre}');
});