--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

-- Started on 2024-12-12 09:18:44

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
-- TOC entry 217 (class 1259 OID 16431)
-- Name: user_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_details (
    "userID" character varying(75),
    password character varying(225)
);


ALTER TABLE public.user_details OWNER TO postgres;

--
-- TOC entry 4839 (class 0 OID 16431)
-- Dependencies: 217
-- Data for Name: user_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_details ("userID", password) FROM stdin;
user-1	$2b$12$7jvP/TksuRVSw8drHVbrdusHbqnRbzZ0GXAuXIe6JEd/zSnufABtS
user-2	$2b$12$sIgTn5MrQYzfC81uToXNl.dcMJHDdMsLeIch1RzyTixDSSnKjMF6e
user-3	$2b$12$SiOgx2IlXwRga1YAQmVRRuzw9EdK/RedV194OnanKb/AC.RXNxdeO
user-4	$2b$12$FlTF0Sx63zNevi3dv4WJAuI4jsXVnfxw9SSXq2BWFLnzVnzo7bEYe
user-5	$2b$12$yNSB3OUVOG7j8lPWLMNFg.xLVRrIQK8NR1TmWeMxWl1Rq87fqX9EW
\.


-- Completed on 2024-12-12 09:18:44

--
-- PostgreSQL database dump complete
--

