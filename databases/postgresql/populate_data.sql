--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

-- Started on 2024-12-10 19:46:04

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
-- TOC entry 4865 (class 0 OID 16389)
-- Dependencies: 217
-- Data for Name: Recipe; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Recipe" (recipe_id, recipe_name, instructions) FROM stdin;
1	Vegetable Stir-fry	1. Wash and chop cabbage, carrot, and ginger into thin strips. 2. Heat oil in a pan, add garlic and stir until fragrant. 3. Add vegetables and stir-fry for 5–7 minutes. 4. Add soy sauce and salt, mix well, and serve.
2	Chicken Curry	1. Marinate chicken with turmeric, chili powder, and salt. 2. Heat oil, sauté chopped onion, garlic, and ginger until golden. 3. Add diced tomato and spices (coriander, cumin). Cook into a paste. 4. Add chicken and water; simmer until cooked. Serve hot.
3	Potato Salad	1. Boil and cube potatoes. Set aside to cool. 2. Dice onion and cucumber finely. 3. Mix potatoes with mayonnaise, salt, pepper, onion, and cucumber. 4. Chill before serving.
4	Ginger Lemon Tea	1. Boil 2 cups of water and add grated ginger. 2. Let it simmer for 5 minutes. 3. Add freshly squeezed lemon juice and honey. Strain before serving.
5	Pumpkin Soup	1. Peel and dice pumpkin, onion, and garlic. 2. Sauté onion and garlic in butter. 3. Add pumpkin, water, and a pinch of salt. Boil until soft. 4. Blend until smooth, then add cream. Serve warm.
6	Garlic Butter Chicken	1. Marinate chicken with minced garlic, salt, and pepper. 2. Heat butter in a pan and sear chicken on both sides. 3. Cover and cook for 15 minutes until tender. Serve hot.
7	Tomato Egg Scramble	1. Beat 2 eggs with salt and pepper. 2. Sauté diced tomato and onion in oil. 3. Add eggs and stir gently until cooked. Serve as breakfast or a side dish.
8	Cucumber Salad	1. Slice cucumber, onion, and carrot thinly. 2. Mix vinegar, sugar, and salt to create a dressing. 3. Toss vegetables in the dressing and let it chill for 10 minutes.
9	Vegetable Soup	1. Dice cabbage, carrot, onion, and tomato. 2. Boil water or broth and add vegetables. 3. Season with salt, pepper, and herbs. Simmer for 20 minutes.
10	Mashed Potato	1. Peel and boil potatoes until soft. 2. Mash with butter, milk, salt, and pepper until smooth. 3. Serve as a side dish.
11	Chicken Stir-fry	1. Slice chicken into strips and chop ginger, garlic, and onion. 2. Heat oil, add garlic and ginger, then add chicken. 3. Add soy sauce, stir-fry for 10 minutes, and serve.
12	Butter Garlic Pasta	1. Cook pasta as per instructions. 2. Heat butter in a pan, add minced garlic, and sauté until golden. 3. Toss cooked pasta with garlic butter and grated cheese.
13	Veggie Wrap	1. Chop cucumber, cabbage, and carrot. 2. Spread hummus or mayonnaise on a tortilla. 3. Add vegetables, wrap tightly, and serve.
14	Cauliflower Rice	1. Grate cauliflower into rice-sized pieces. 2. Sauté chopped onion and garlic in oil. 3. Add cauliflower and cook for 5–7 minutes. Season and serve.
15	Lemon Chicken	1. Marinate chicken with lemon juice, minced garlic, and olive oil. 2. Bake at 200°C for 20–25 minutes. Serve with veggies.
16	Pumpkin Risotto	1. Cook rice in broth with sautéed pumpkin, onion, and garlic. 2. Stir in butter and grated cheese before serving.
17	Tomato Basil Soup	1. Simmer chopped tomato and onion in water. 2. Blend the mixture, add fresh basil leaves, and season with salt.
18	Veggie Fried Rice	1. Chop carrot, cabbage, onion, and ginger. 2. Sauté vegetables, then add cooked rice and soy sauce. 3. Stir-fry for 5 minutes.
19	Potato Cheese Bake	1. Layer boiled potatoes with grated cheese in a baking dish. 2. Bake at 180°C for 15 minutes or until golden.
20	Garlic Bread	1. Spread minced garlic mixed with butter on bread slices. 2. Toast in an oven until crispy.
21	Chicken Salad	1. Dice boiled chicken, onion, and cucumber. 2. Toss with a dressing of mayonnaise, mustard, and salt.
22	Creamy Pumpkin Pasta	1. Cook pasta as per instructions. 2. Mix cooked pasta with pumpkin puree, cream, and minced garlic. Heat and serve.
23	Spicy Chicken Wings	1. Marinate chicken wings with minced garlic, chillies, and spices. 2. Bake at 220°C for 25 minutes or until crispy.
24	Cheese Tomato Sandwich	1. Layer cheese and sliced tomato between bread slices. 2. Toast until golden and serve warm.
25	Milkshake	1. Blend milk with sugar, your choice of fruit (banana, strawberry), and ice cubes. 2. Serve chilled.
\.


--
-- TOC entry 4867 (class 0 OID 16401)
-- Dependencies: 219
-- Data for Name: Recipe_Items; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Recipe_Items" (recipe_id, allingredient_id) FROM stdin;
1	{6,3,9,7}
2	{2,5,7,9,12}
3	{11,15,1}
5	{13,15,7}
6	{7,4,1}
7	{8,12,15}
8	{1,15,3}
9	{6,3,15,12}
10	{11,16,4}
11	{2,9,7}
12	{4,7,5}
13	{1,6,3}
14	{10,15,7}
15	{2,7,41}
16	{13,39,15,7,4}
17	{12,15}
4	{9,41}
18	{3,6,15,9,39}
19	{11,5}
20	{7,40,4}
21	{2,15,1}
22	{13,36,7}
23	{2,7,14}
24	{5,12,40}
25	{16}
\.


--
-- TOC entry 4869 (class 0 OID 16415)
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


-- Completed on 2024-12-10 19:46:05

--
-- PostgreSQL database dump complete
--

