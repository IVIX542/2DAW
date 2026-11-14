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
