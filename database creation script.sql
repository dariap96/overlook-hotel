CREATE DATABASE overlook
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.UTF-8'
    LC_CTYPE = 'en_US.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE SCHEMA IF NOT EXISTS public
    AUTHORIZATION postgres;

COMMENT ON SCHEMA public
    IS 'standard public schema';

GRANT ALL ON SCHEMA public TO PUBLIC;

GRANT ALL ON SCHEMA public TO postgres;

CREATE SEQUENCE IF NOT EXISTS public.user_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.user_id_seq
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.users
(
    name character varying(20) COLLATE pg_catalog."default",
    surname character varying(20) COLLATE pg_catalog."default",
    bday date,
    login character varying(20) COLLATE pg_catalog."default" NOT NULL,
    password character varying(20) COLLATE pg_catalog."default" NOT NULL,
    email character varying(20) COLLATE pg_catalog."default" NOT NULL,
    id integer NOT NULL DEFAULT nextval('user_id_seq'::regclass),
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT email UNIQUE (email),
    CONSTRAINT login UNIQUE (login)
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;

ALTER SEQUENCE public.user_id_seq OWNED BY public.users.id;

CREATE SEQUENCE IF NOT EXISTS public.role_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER TABLE IF EXISTS public.roles
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.roles
(
    id integer NOT NULL DEFAULT nextval('role_id_seq'::regclass),
    role character varying COLLATE pg_catalog."default",
    CONSTRAINT roles_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;

ALTER SEQUENCE public.role_id_seq OWNED BY public.roles.id;

CREATE SEQUENCE IF NOT EXISTS public.users_roles_role_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.users_roles_role_id_seq
    OWNER TO postgres;

CREATE SEQUENCE IF NOT EXISTS public.users_roles_user_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.users_roles_user_id_seq
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.users_roles
(
    user_id integer NOT NULL DEFAULT nextval('users_roles_user_id_seq'::regclass),
    role_id integer NOT NULL DEFAULT nextval('users_roles_role_id_seq'::regclass),
    CONSTRAINT users_roles_pkey PRIMARY KEY (user_id, role_id),
    CONSTRAINT role_id_fkey FOREIGN KEY (role_id)
        REFERENCES public.roles (id) MATCH FULL
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    CONSTRAINT user_id_fkey FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH FULL
        ON UPDATE CASCADE
        ON DELETE SET NULL
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users_roles
    OWNER to postgres;

ALTER SEQUENCE public.users_roles_role_id_seq OWNED BY public.users_roles.role_id;

ALTER SEQUENCE public.users_roles_user_id_seq OWNED BY public.users_roles.user_id;
