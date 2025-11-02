--Create of the database for this activity.
CREATE DATABASE "Actividad2T2"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

GO

--Creation of the table author.
CREATE TABLE public.author
(
    id bigint NOT NULL,
    name character(45) NOT NULL,
    points double precision NOT NULL,
    rank bigint NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.author
    OWNER to postgres;

GO

--Creation of the table comment.
CREATE TABLE public.comment
(
    id bigint NOT NULL,
    type_comment bigint NOT NULL,
    description character(45) NOT NULL,
    created_at date NOT NULL,
    author_id bigint NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT author_id FOREIGN KEY (author_id)
        REFERENCES public.author (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public.comment
    OWNER to postgres;

GO

INSERT INTO author (id,name, points, rank)
VALUES (1,'NachoTest',10.0,1);