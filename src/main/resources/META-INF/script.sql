-- Table: public.padrone

-- DROP TABLE public.padrone;

CREATE SCHEMA public;

CREATE TABLE IF NOT EXISTS public.autore
(
    id integer NOT NULL,
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    cognome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    eta integer NOT NULL,
    CONSTRAINT autore_pkey PRIMARY KEY (autore_id)
)

TABLESPACE pg_default;

ALTER TABLE public.autore
    OWNER to postgres;

TABLESPACE pg_default;

-- Table: public.cane

-- DROP TABLE public.cane;

CREATE TABLE IF NOT EXISTS public.libro
(
    libroId integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    titolo character varying(50) COLLATE pg_catalog."default" NOT NULL,
    numeroPagine integer NOT NULL,
    autore autore,
    CONSTRAINT libro_pkey PRIMARY KEY (libro_id)
)

TABLESPACE pg_default;

ALTER TABLE public.libro
    OWNER to postgres;



--sequences
-- SEQUENCE: public.autore_sequence

-- DROP SEQUENCE public.autore_sequence;

CREATE SEQUENCE public.autore_sequence
    INCREMENT 1
    START 10
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.autore_sequence
    OWNER TO postgres;




-- SEQUENCE: public.libro_sequence

-- DROP SEQUENCE public.libro_sequence;

CREATE SEQUENCE public.libro_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.libro_sequence
    OWNER TO postgres;