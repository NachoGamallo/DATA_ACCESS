CREATE DATABASE "AppsMoviles"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

GO

CREATE TABLE app (

	id SERIAL PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	desarrollador VARCHAR(100),
	categoria VARCHAR (50),
	descargas INT,
	valoracion DECIMAL(3,1),
	fecha_publicacion DATE

);