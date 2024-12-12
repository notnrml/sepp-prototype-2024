--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

-- Started on 2024-12-12 19:12:27

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
-- TOC entry 217 (class 1259 OID 24615)
-- Name: Fridge_Items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Fridge_Items" (
    "User_id" character varying[] NOT NULL,
    allingredient_id integer[] NOT NULL
);


ALTER TABLE public."Fridge_Items" OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 24620)
-- Name: Ingredients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Ingredients" (
    ingredient_id integer NOT NULL,
    name character varying(100) NOT NULL
);


ALTER TABLE public."Ingredients" OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 24623)
-- Name: Recipe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Recipe" (
    recipe_id integer NOT NULL,
    recipe_name character varying(100) NOT NULL,
    instructions character varying(8000) NOT NULL
);


ALTER TABLE public."Recipe" OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 24628)
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
-- TOC entry 221 (class 1259 OID 24633)
-- Name: Recipe_Tags; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Recipe_Tags" (
    recipe_id integer NOT NULL,
    tag character varying(100)[]
);


ALTER TABLE public."Recipe_Tags" OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 24648)
-- Name: user_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_details (
    "userID" character varying(75),
    password character varying(225)
);


ALTER TABLE public.user_details OWNER TO postgres;

--
-- TOC entry 4869 (class 0 OID 24615)
-- Dependencies: 217
-- Data for Name: Fridge_Items; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Fridge_Items" ("User_id", allingredient_id) FROM stdin;
\.


--
-- TOC entry 4870 (class 0 OID 24620)
-- Dependencies: 218
-- Data for Name: Ingredients; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Ingredients" (ingredient_id, name) FROM stdin;
1	Cucumber
2	Chicken
3	Carrot
4	Butter
5	Cheese
6	Cabbage
7	Garlic
8	Egg
9	Ginger
10	Cauliflower
11	Potato
12	Tomato
13	Pumpkin
14	Chillies
15	Onion
16	Milk
17	Yogurt
18	Beef
19	Lamb
20	Fish
21	Shrimp
22	Turkey
23	Pork
24	Bacon
25	Sausage
26	Spinach
27	Broccoli
28	Bell Pepper
29	Zucchini
30	Peas
31	Corn
32	Lettuce
33	Radish
34	Turnip
35	Mushrooms
36	Cream
37	Honey
38	Flour
39	Rice
40	Bread
41	Lemon
\.


--
-- TOC entry 4871 (class 0 OID 24623)
-- Dependencies: 219
-- Data for Name: Recipe; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Recipe" (recipe_id, recipe_name, instructions) FROM stdin;
1	Vegetable Stir-fry	1. Wash and chop cabbage, carrot, and ginger into thin strips. 2. Heat oil in a pan, add garlic and stir until fragrant. 3. Add vegetables and stir-fry for 5–7 minutes. 4. Add soy sauce and salt, mix well, and serve.
2	Chicken Curry	1. Marinate chicken with turmeric, chili powder, and salt. 2. Heat oil, sauté chopped onion, garlic, and ginger until golden. 3. Add diced tomato and spices (coriander, cumin). Cook into a paste. 4. Add chicken and water; simmer until cooked. Serve hot.
3	Potato Salad	1. Boil and cube potatoes. Set aside to cool. 2. Dice onion and cucumber finely. 3. Mix potatoes with mayonnaise, salt, pepper, onion, and cucumber. 4. Chill before serving.
4	Ginger Lemon Tea	1. Boil 2 cups of water and add grated ginger. 2. Let it simmer for 5 minutes. 3. Add freshly squeezed lemon juice and honey. Strain before serving.
5	Pumpkin Soup	1. Peel and dice pumpkin, onion, and garlic. 2. Sauté onion and garlic in butter. 3. Add pumpkin, water, and a pinch of salt. Boil until soft. 4. Blend until smooth, then add cream. Serve warm.
6	Garlic Butter Chicken	1. Marinate chicken with minced garlic, salt, and pepper. 2. Heat butter in a pan and sear chicken on both sides. 3. Cover and cook for 15 minutes until tender. Serve hot.
\.


--
-- TOC entry 4872 (class 0 OID 24628)
-- Dependencies: 220
-- Data for Name: Recipe_Items; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Recipe_Items" (recipe_id, allingredient_id, quantity, unit) FROM stdin;
1	{6,3,9,7}	\N	\N
2	{2,5,7,9,12}	\N	\N
3	{11,15,1}	\N	\N
5	{13,15,7}	\N	\N
6	{7,4,1}	\N	\N
7	{8,12,15}	\N	\N
8	{1,15,3}	\N	\N
9	{6,3,15,12}	\N	\N
10	{11,16,4}	\N	\N
11	{2,9,7}	\N	\N
12	{4,7,5}	\N	\N
13	{1,6,3}	\N	\N
14	{10,15,7}	\N	\N
15	{2,7,41}	\N	\N
16	{13,39,15,7,4}	\N	\N
17	{12,15}	\N	\N
4	{9,41}	\N	\N
18	{3,6,15,9,39}	\N	\N
19	{11,5}	\N	\N
20	{7,40,4}	\N	\N
21	{2,15,1}	\N	\N
22	{13,36,7}	\N	\N
23	{2,7,14}	\N	\N
24	{5,12,40}	\N	\N
25	{16}	\N	\N
\.


--
-- TOC entry 4873 (class 0 OID 24633)
-- Dependencies: 221
-- Data for Name: Recipe_Tags; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Recipe_Tags" (recipe_id, tag) FROM stdin;
1	{Vegetarian,Gluten-Free}
2	{Non-Vegetarian,Gluten-Free}
3	{Vegetarian,Gluten-Free,Dairy-Free}
4	{Vegan,Gluten-Free,Dairy-Free}
5	{Vegetarian,Gluten-Free,Dairy-Free}
6	{Non-Vegetarian,Gluten-Free}
7	{Vegetarian,Gluten-Free}
8	{Vegetarian,Vegan,Gluten-Free}
9	{Vegetarian,Gluten-Free}
10	{Vegetarian,Gluten-Free}
11	{Non-Vegetarian,Gluten-Free}
12	{Vegetarian,Gluten-Free,Dairy-Free}
13	{Vegetarian,Vegan,Gluten-Free}
14	{Vegetarian,Vegan,Gluten-Free}
15	{Non-Vegetarian,Gluten-Free}
16	{Vegetarian,Gluten-Free}
17	{Vegetarian,Gluten-Free}
18	{Vegetarian,Gluten-Free}
21	{Non-Vegetarian,Gluten-Free}
22	{Vegetarian,Gluten-Free}
23	{Non-Vegetarian,Gluten-Free}
24	{Vegetarian,Gluten-Free}
19	{Vegetarian,Gluten-Free}
20	{Vegetarian}
25	{Vegetarian,Gluten-Free}
\.


--
-- TOC entry 4874 (class 0 OID 24648)
-- Dependencies: 222
-- Data for Name: user_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_details ("userID", password) FROM stdin;
user-1	$2b$12$7jvP/TksuRVSw8drHVbrdusHbqnRbzZ0GXAuXIe6JEd/zSnufABtS
user-2	$2b$12$sIgTn5MrQYzfC81uToXNl.dcMJHDdMsLeIch1RzyTixDSSnKjMF6e
user-3	$2b$12$SiOgx2IlXwRga1YAQmVRRuzw9EdK/RedV194OnanKb/AC.RXNxdeO
user-4	$2b$12$FlTF0Sx63zNevi3dv4WJAuI4jsXVnfxw9SSXq2BWFLnzVnzo7bEYe
user-5	$2b$12$yNSB3OUVOG7j8lPWLMNFg.xLVRrIQK8NR1TmWeMxWl1Rq87fqX9EW
\.


--
-- TOC entry 4715 (class 2606 OID 24639)
-- Name: Fridge_Items Fridge_Items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Fridge_Items"
    ADD CONSTRAINT "Fridge_Items_pkey" PRIMARY KEY ("User_id");


--
-- TOC entry 4717 (class 2606 OID 24641)
-- Name: Ingredients Ingredients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Ingredients"
    ADD CONSTRAINT "Ingredients_pkey" PRIMARY KEY (ingredient_id);


--
-- TOC entry 4721 (class 2606 OID 24643)
-- Name: Recipe_Items Recipe_Items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Recipe_Items"
    ADD CONSTRAINT "Recipe_Items_pkey" PRIMARY KEY (recipe_id);


--
-- TOC entry 4723 (class 2606 OID 24645)
-- Name: Recipe_Tags Recipe_Tags_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Recipe_Tags"
    ADD CONSTRAINT "Recipe_Tags_pkey" PRIMARY KEY (recipe_id);


--
-- TOC entry 4719 (class 2606 OID 24647)
-- Name: Recipe Recipe_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Recipe"
    ADD CONSTRAINT "Recipe_pkey" PRIMARY KEY (recipe_id);


-- Completed on 2024-12-12 19:12:27

--
-- PostgreSQL database dump complete
--

