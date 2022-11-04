--
-- PostgreSQL database dump
--

-- Dumped from database version 15.0 (Debian 15.0-1.pgdg110+1)
-- Dumped by pg_dump version 15.0 (Debian 15.0-1.pgdg110+1)

--
-- Data for Name: users; Type: TABLE DATA; Schema:  Owner: postgres
--

INSERT INTO users (id, name) VALUES (1, 'Tom');
INSERT INTO users (id, name) VALUES (2, 'Tina');
INSERT INTO users (id, name) VALUES (3, 'Rina');


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema:  Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 3, true);


--
-- Data for Name: post; Type: TABLE DATA; Schema:  Owner: postgres
--

INSERT INTO post (id, content, title, author_id) VALUES (1, 'This is a post 3 sita!', 'Post 5', 1);
INSERT INTO post (id, content, title, author_id) VALUES (2, 'This is a post 3 sita!', 'Post 5', 1);
INSERT INTO post (id, content, title, author_id) VALUES (3, 'This is a post 3 sita!', 'Post 5', 1);
INSERT INTO post (id, content, title, author_id) VALUES (4, 'This is a post 3 sita!', 'Post 5', 1);
INSERT INTO post (id, content, title, author_id) VALUES (5, 'This is a post 3 sita!', 'Post 5', 1);
INSERT INTO post (id, content, title, author_id) VALUES (6, 'This is a post 3 sita!', 'Post 5', 2);
INSERT INTO post (id, content, title, author_id) VALUES (7, 'This is a post 3 sita!', 'Post 5', 2);
INSERT INTO post (id, content, title, author_id) VALUES (8, 'This is a post 3 sita!', 'Post 5', 2);
INSERT INTO post (id, content, title, author_id) VALUES (9, 'This is a post 3 sita!', 'Post 5', 2);
INSERT INTO post (id, content, title, author_id) VALUES (10, 'This is a post 3 sita!', 'Post 5', 2);
INSERT INTO post (id, content, title, author_id) VALUES (11, 'This is a post 3 sita!', 'Post 5', 2);
INSERT INTO post (id, content, title, author_id) VALUES (12, 'This is a post 3 sita!', 'Post 5', 2);
INSERT INTO post (id, content, title, author_id) VALUES (13, 'This is a post 3 sita!', 'Post 5', 2);
INSERT INTO post (id, content, title, author_id) VALUES (14, 'This is a post 3 sita!', 'Post 5', 2);
INSERT INTO post (id, content, title, author_id) VALUES (15, 'This is a post 3 sita!', 'Post 5', 3);
INSERT INTO post (id, content, title, author_id) VALUES (16, 'This is a post 3 sita!', 'Post 5', 3);
INSERT INTO post (id, content, title, author_id) VALUES (17, 'This is a post 3 sita!', 'Post 5', 3);
INSERT INTO post (id, content, title, author_id) VALUES (18, 'This is a post 3 sita!', 'Post 5', 3);
INSERT INTO post (id, content, title, author_id) VALUES (19, 'This is a post 3 sita!', 'Post 5', 3);
INSERT INTO post (id, content, title, author_id) VALUES (20, 'This is a post 3 sita!', 'Post 5', 3);
INSERT INTO post (id, content, title, author_id) VALUES (21, 'This is a post 3 sita!', 'Post 5', 3);
INSERT INTO post (id, content, title, author_id) VALUES (22, 'This is a post 3 sita!', 'Post 5', 3);
INSERT INTO post (id, content, title, author_id) VALUES (23, 'This is a post 3 sita!', 'Post 5', 3);
INSERT INTO post (id, content, title, author_id) VALUES (24, 'This is a post 3 sita!', 'Post 5', 3);
INSERT INTO post (id, content, title, author_id) VALUES (25, 'This is a post 3 sita!', 'Post 5', 3);


--
-- Name: post_id_seq; Type: SEQUENCE SET; Schema:  Owner: postgres
--

SELECT pg_catalog.setval('public.post_id_seq', 25, true);


--
-- PostgreSQL database dump complete
--