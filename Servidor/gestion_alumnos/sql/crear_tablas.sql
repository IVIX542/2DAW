-- =======================================
-- Tabla principal: ALUMNOS
-- =======================================
CREATE TABLE alumnos (
    id_alumno INT AUTO_INCREMENT PRIMARY KEY,  -- Identificador único del alumno
    nombre VARCHAR(50) NOT NULL,                -- Nombre del alumno
    apellidos VARCHAR(100) NOT NULL            -- Apellidos del alumno
);


-- =======================================
-- Tabla dependiente: NOTAS
-- =======================================
CREATE TABLE notas (
    id_nota INT AUTO_INCREMENT PRIMARY KEY,    -- Identificador único de la nota
    asignatura VARCHAR(50) NOT NULL,     -- Nombre de la asignatura
    calificacion DECIMAL(4,2) NOT NULL,    -- Nota numérica (ej. 8.50)
    id_alumno INT NOT NULL,                         -- Clave foránea: referencia al alumno
    CONSTRAINT fk_alumno                           -- Definición de la clave foránea
        FOREIGN KEY (id_alumno)
        REFERENCES alumnos(id_alumno)
        ON DELETE CASCADE                       -- Si se borra un alumno, se borran sus notas
        ON UPDATE CASCADE                      -- Si cambia el ID del alumno, se actualiza en notas
);

-- =======================================
-- Tabla dependiente: PERFIL
-- =======================================
CREATE TABLE perfiles (
    id_perfil INT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(100),
    telefono VARCHAR(20),
    foto_url VARCHAR(200),
    id_alumno INT UNIQUE,  -- Cada perfil solo puede pertenecer a un alumno
  CONSTRAINT fk_perfil_alumno
        FOREIGN KEY (id_alumno)
        REFERENCES alumnos(id_alumno)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- =======================================
-- Tabla ASIGNATURAS
-- =======================================
CREATE TABLE asignaturas (
    id_asignatura INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    curso VARCHAR(50)
);

-- =======================================
-- Tabla intermedia ALUMNO_ASIGNATURA
-- =======================================
CREATE TABLE alumno_asignatura (
    id_alumno INT NOT NULL,
    id_asignatura INT NOT NULL,

    -- Clave primaria compuesta
    PRIMARY KEY (id_alumno, id_asignatura),

    -- Claves foráneas
    CONSTRAINT fk_alumno_as
        FOREIGN KEY (id_alumno)
        REFERENCES alumnos(id_alumno)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_asignatura_al
        FOREIGN KEY (id_asignatura)
        REFERENCES asignaturas(id_asignatura)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
