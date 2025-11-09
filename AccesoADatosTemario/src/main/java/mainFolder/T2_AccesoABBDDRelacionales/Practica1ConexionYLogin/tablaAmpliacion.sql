--Tabla de registros

CREATE TABLE registros (

	id SERIAL PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	categoria VARCHAR(50),
	valoracion NUMERIC (3,1),
	id_user INTEGER NOT NULL

);

--Foreign key de los usuarios (Solo el usuario propietario de un registro podra editarlo o borrarlo).
ALTER TABLE IF EXISTS public.registros
    ADD CONSTRAINT id_user FOREIGN KEY (id_user)
    REFERENCES public.usuarios (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;