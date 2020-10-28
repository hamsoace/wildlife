CREATE DATABASE wildlife;

\c wildlife

CREATE TABLE locations(
    id SERIAL PRIMARY KEY,
    age INTEGER,
    name VARCHAR,
    health VARCHAR,
    animalRangerId INTEGER,
    locationId INTEGER
);

CREATE TABLE animalRangers(
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    badge INTEGER,
    telephone VARCHAR
);