CREATE TABLE socios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    dni VARCHAR(10) NOT NULL UNIQUE,
    telefono VARCHAR(15),
    email VARCHAR(100),
    cuota_pagada BOOLEAN DEFAULT FALSE,
    fecha_alta DATE NOT NULL
);