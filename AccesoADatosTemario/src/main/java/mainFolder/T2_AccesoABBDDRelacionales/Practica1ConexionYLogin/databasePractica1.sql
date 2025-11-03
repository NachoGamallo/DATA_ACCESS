--BBDD
CREATE DATABASE practica
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

GO

--Tabla de usuarios.
CREATE TABLE usuarios (

	id SERIAL PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL UNIQUE,
	password VARCHAR(100) NOT NULL

);

GO

--Usuarios por defecto.
INSERT INTO usuarios (nombre, password) VALUES
('admin','1234'),
('nacho','abcd'),
('maria','pass');
