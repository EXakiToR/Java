CREATE TABLE currencies(
    num_code smallint,
    name character varying(30),
    char_code character varying(4),
    rate numeric(12,4)
);
CREATE TABLE entities(
    uuid varchar(100) PRIMARY KEY,
    category varchar(100),
    created_at varchar(100),
    read_at varchar(100),
    updated_at varchar(100),
    deleted_at varchar(100)    
);
CREATE TABLE products(
    id integer PRIMARY KEY,
    name character varying(100),
    image character varying(200)
);
CREATE TABLE dummy_entities(
    uuid varchar(100) PRIMARY KEY REFERENCES entities(uuid),
    name varchar(100)
);