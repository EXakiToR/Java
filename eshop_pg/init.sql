CREATE TABLE currencies
(
    num_code smallint,
    name character varying(30),
    char_code character varying(4),
    rate numeric(12,4)
);
CREATE TABLE products
(
    id integer PRIMARY KEY,
    name character varying(100),
    image character varying(200)
);
CREATE TABLE test();