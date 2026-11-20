-- Insertamos dos alumnos
INSERT INTO alumnos (nombre, apellidos)
VALUES ('Laura', 'Pérez García'),
               ('Marcos', 'Ruiz Torres');

-- Insertamos notas para Laura (id_alumno = 1)
INSERT INTO notas (asignatura, calificacion, id_alumno)
VALUES ('Matemáticas', 8.5, 1),
               ('Historia', 9.0, 1);

-- Insertamos notas para Marcos (id_alumno = 2)
INSERT INTO notas (asignatura, calificacion, id_alumno)
VALUES ('Lengua', 7.5, 2);

-- Insertar asignaturas
INSERT INTO asignaturas (nombre, curso)
VALUES
    ('Desarrollo Web en Entorno Servidor', '2º DAW'),
    ('Desarrollo Web en Entorno Cliente', '2º DAW'),
    ('Despliegue de Aplicaciones Web', '2º DAW'),
    ('Diseño de Interfaces Web', '2º DAW');