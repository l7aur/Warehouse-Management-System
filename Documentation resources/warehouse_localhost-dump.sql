--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
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
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    name character varying(200) NOT NULL,
    phone_number character varying(12) NOT NULL,
    address character varying(200) NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.client OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.client ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000
    CACHE 1
);


--
-- Name: log; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.log (
    order_id integer,
    price integer NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.log OWNER TO postgres;

--
-- Name: log_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.log ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.log_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."order" (
    client_id integer NOT NULL,
    product_id integer NOT NULL,
    id integer NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE public."order" OWNER TO postgres;

--
-- Name: order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."order" ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    name character varying(200) NOT NULL,
    stock integer NOT NULL,
    id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Name: product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.product ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000
    CACHE 1
);


--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client (name, phone_number, address, id) FROM stdin;
Jean Craiovean	+40799199199	Str. Craiova Nr. 1	6
Mitica Dragomir	+40756511111	Str. Afost Nr. 12	7
Popescu Ion	+40792123345	Str. Alba Nr. 99	8
Ana Matei	+40789765209	Str. ChampsElysees Nr. 1	15
Marginean Joian	+40787187781	Str. Aici Nr. 3	16
Joian Itu	+40767123123	Str. Acolo Nr. 3	17
Aaaa Baaa	+40767611116	Str. Aici Nr. 3	20
Michael Brown	+40722561094	Str. Vilelor Nr. 12	21
Ion Panciu	+40789675120	Str. Moldovei Nr. 7	25
Dumitru Bulbuc	+40756422132	Str. Veche Nr. 8A	27
Cosmin Tianu	+40756540002	Str. Afa Nr. 123	29
Juju Iancul	+40756540002	Str. Putna Nr. 5	33
Coxma Razvy	+40745677744	Str. Alexandru Nr. 4	34
\.


--
-- Data for Name: log; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.log (order_id, price, id) FROM stdin;
3	100	2
10	500	4
10	500	5
23	21	7
24	21	8
29	6741	13
36	4500	15
37	3000	16
\.


--
-- Data for Name: order; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."order" (client_id, product_id, id, quantity) FROM stdin;
6	9	3	12
6	9	4	122
6	9	5	200
17	9	6	300
17	9	7	300
8	9	8	50
8	9	9	50
6	9	10	100
8	9	11	2
6	10	12	400
6	10	13	400
6	9	14	1000
6	9	15	1000
6	10	16	100
6	10	17	100
15	11	19	100
33	12	20	50
17	12	21	300
34	12	22	100
16	12	23	100
16	12	24	100
33	12	29	321
27	16	36	50
34	14	37	50
\.


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (name, stock, id, price) FROM stdin;
Mere	0	9	5
Banane	0	10	10
Portocale	905	11	13
Pere	1000	12	21
Afine	450	14	60
Zmeura	100	16	90
\.


--
-- Name: client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.client_id_seq', 34, true);


--
-- Name: log_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.log_id_seq', 16, true);


--
-- Name: order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_id_seq', 37, true);


--
-- Name: product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_id_seq', 16, true);


--
-- Name: client client_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pk PRIMARY KEY (id);


--
-- Name: log log_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.log
    ADD CONSTRAINT log_pk PRIMARY KEY (id);


--
-- Name: order order_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."order"
    ADD CONSTRAINT order_pk PRIMARY KEY (id);


--
-- Name: product product_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pk PRIMARY KEY (id);


--
-- Name: log log_log__fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.log
    ADD CONSTRAINT log_log__fk FOREIGN KEY (order_id) REFERENCES public."order"(id);


--
-- Name: order order_order__fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."order"
    ADD CONSTRAINT order_order__fk FOREIGN KEY (client_id) REFERENCES public.client(id);


--
-- Name: order order_order__fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."order"
    ADD CONSTRAINT order_order__fk_2 FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- PostgreSQL database dump complete
--

