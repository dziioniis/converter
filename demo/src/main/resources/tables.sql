CREATE TABLE public.usr
(
    id bigint NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    username character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT usr_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

CREATE TABLE public.role
(
    user_id bigint NOT NULL,
    roles character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT fkghqm2pia0ngnqyt92adfhq26d FOREIGN KEY (user_id)
        REFERENCES public.usr (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


CREATE TABLE public.exchange
(
    id bigint NOT NULL,
    value_of_initial_currency double precision NOT NULL,
    count integer NOT NULL,
    data character varying(255) COLLATE pg_catalog."default",
    getting_currency_name character varying(255) COLLATE pg_catalog."default",
    initial_currency_name character varying(255) COLLATE pg_catalog."default",
    sum_of_converting integer NOT NULL,
    CONSTRAINT exchange_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

CREATE TABLE public.currency
(
    id bigint NOT NULL,
    char_code character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    nominal integer NOT NULL,
    num_code integer NOT NULL,
    value double precision,
    CONSTRAINT currency_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;
