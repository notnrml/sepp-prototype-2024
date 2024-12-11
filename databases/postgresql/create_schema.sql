--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

-- Started on 2024-12-09 02:30:52

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 220 (class 1259 OID 16408)
-- Name: Fridge_Items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Fridge_Items" (
    "User_id" character varying[50] NOT NULL,
    allingredient_id integer[] NOT NULL
);


ALTER TABLE public."Fridge_Items" OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16396)
-- Name: Ingredients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Ingredients" (
    ingredient_id integer NOT NULL,
    name character varying(100) NOT NULL
);


ALTER TABLE public."Ingredients" OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16389)
-- Name: Recipe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Recipe" (
    recipe_id integer NOT NULL,
    recipe_name character varying(100) NOT NULL,
    instructions character varying(8000) NOT NULL
);


ALTER TABLE public."Recipe" OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16401)
-- Name: Recipe_Items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Recipe_Items" (
    recipe_id integer NOT NULL,
    allingredient_id integer[] NOT NULL,
    quantity integer,
    unit character varying(50)
);


ALTER TABLE public."Recipe_Items" OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16415)
-- Name: Recipe_Tags; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Recipe_Tags" (
    recipe_id integer NOT NULL,
    tag character varying(100)[]
);


ALTER TABLE public."Recipe_Tags" OWNER TO postgres;

--
-- TOC entry 4868 (class 0 OID 16408)
-- Dependencies: 220
-- Data for Name: Fridge_Items; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Fridge_Items" ("User_id", allingredient_id) FROM stdin;
\.


--
-- TOC entry 4866 (class 0 OID 16396)
-- Dependencies: 218
-- Data for Name: Ingredients; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Ingredients" (ingredient_id, name) FROM stdin;
\.


--
-- TOC entry 4865 (class 0 OID 16389)
-- Dependencies: 217
-- Data for Name: Recipe; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Recipe" (recipe_id, recipe_name, instructions) FROM stdin;
\.


--
-- TOC entry 4867 (class 0 OID 16401)
-- Dependencies: 219
-- Data for Name: Recipe_Items; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Recipe_Items" (recipe_id, allingredient_id, quantity, unit) FROM stdin;
\.


--
-- TOC entry 4869 (class 0 OID 16415)
-- Dependencies: 221
-- Data for Name: Recipe_Tags; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Recipe_Tags" (recipe_id, tag) FROM stdin;
\.


--
-- TOC entry 4717 (class 2606 OID 16414)
-- Name: Fridge_Items Fridge_Items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Fridge_Items"
    ADD CONSTRAINT "Fridge_Items_pkey" PRIMARY KEY ("User_id");


--
-- TOC entry 4713 (class 2606 OID 16400)
-- Name: Ingredients Ingredients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Ingredients"
    ADD CONSTRAINT "Ingredients_pkey" PRIMARY KEY (ingredient_id);


--
-- TOC entry 4715 (class 2606 OID 16407)
-- Name: Recipe_Items Recipe_Items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Recipe_Items"
    ADD CONSTRAINT "Recipe_Items_pkey" PRIMARY KEY (recipe_id);


--
-- TOC entry 4719 (class 2606 OID 16421)
-- Name: Recipe_Tags Recipe_Tags_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Recipe_Tags"
    ADD CONSTRAINT "Recipe_Tags_pkey" PRIMARY KEY (recipe_id);


--
-- TOC entry 4711 (class 2606 OID 16395)
-- Name: Recipe Recipe_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Recipe"
    ADD CONSTRAINT "Recipe_pkey" PRIMARY KEY (recipe_id);


-- Completed on 2024-12-09 02:30:52

--
-- PostgreSQL database dump complete
--

