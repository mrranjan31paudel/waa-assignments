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
INSERT INTO users (id, name) VALUES (4, 'ADMIN');


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema:  Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 4, true);


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

INSERT INTO comment (id, name, post_id) VALUES (1, 'This is first 1 comment', 1);
INSERT INTO comment (id, name, post_id) VALUES (2, 'This is first 2 comment', 2);
INSERT INTO comment (id, name, post_id) VALUES (3, 'This is first 3 comment', 3);
INSERT INTO comment (id, name, post_id) VALUES (4, 'This is first 4 comment', 4);
INSERT INTO comment (id, name, post_id) VALUES (5, 'This is first 5 comment', 5);
INSERT INTO comment (id, name, post_id) VALUES (6, 'This is first 6 comment', 6);
INSERT INTO comment (id, name, post_id) VALUES (7, 'This is first 7 comment', 7);
INSERT INTO comment (id, name, post_id) VALUES (8, 'This is first 8 comment', 8);
INSERT INTO comment (id, name, post_id) VALUES (9, 'This is first 9 comment', 9);
INSERT INTO comment (id, name, post_id) VALUES (10, 'This is first 10 comment', 10);
INSERT INTO comment (id, name, post_id) VALUES (11, 'This is first 11 comment', 11);
INSERT INTO comment (id, name, post_id) VALUES (12, 'This is first 12 comment', 12);
INSERT INTO comment (id, name, post_id) VALUES (13, 'This is first 13 comment', 13);
INSERT INTO comment (id, name, post_id) VALUES (14, 'This is first 14 comment', 14);
INSERT INTO comment (id, name, post_id) VALUES (15, 'This is first 15 comment', 15);
INSERT INTO comment (id, name, post_id) VALUES (16, 'This is first 16 comment', 16);
INSERT INTO comment (id, name, post_id) VALUES (17, 'This is first 17 comment', 17);
INSERT INTO comment (id, name, post_id) VALUES (18, 'This is first 18 comment', 18);
INSERT INTO comment (id, name, post_id) VALUES (19, 'This is first 19 comment', 19);
INSERT INTO comment (id, name, post_id) VALUES (20, 'This is first 20 comment', 20);
INSERT INTO comment (id, name, post_id) VALUES (21, 'This is first 21 comment', 21);
INSERT INTO comment (id, name, post_id) VALUES (22, 'This is first 22 comment', 22);
INSERT INTO comment (id, name, post_id) VALUES (23, 'This is first 23 comment', 23);
INSERT INTO comment (id, name, post_id) VALUES (24, 'This is first 24 comment', 24);
INSERT INTO comment (id, name, post_id) VALUES (25, 'This is first 25 comment', 25);
INSERT INTO comment (id, name, post_id) VALUES (26, 'This is first 26 comment', 25);
INSERT INTO comment (id, name, post_id) VALUES (27, 'This is first 27 comment', 9);
INSERT INTO comment (id, name, post_id) VALUES (28, 'This is first 28 comment', 8);
INSERT INTO comment (id, name, post_id) VALUES (29, 'This is first 29 comment', 7);
INSERT INTO comment (id, name, post_id) VALUES (30, 'This is first 30 comment', 4);
INSERT INTO comment (id, name, post_id) VALUES (31, 'This is first 31 comment', 3);
INSERT INTO comment (id, name, post_id) VALUES (32, 'This is first 32 comment', 1);
INSERT INTO comment (id, name, post_id) VALUES (33, 'This is first 33 comment', 2);

SELECT pg_catalog.setval('public.comment_id_seq', 33, true);