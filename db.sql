SET MODE postgresql;

CREATE DATABASE wildlife;

\c wildlife

CREATE TABLE animalRangers(
id serial PRIMARY KEY,
name varchar
);

CREATE TABLE animals(
id serial PRIMARY KEY,
name varchar,
health varchar,
age varchar,
type varchar
);

CREATE TABLE sightings(
id serial PRIMARY KEY,
animalname varchar,
location varchar,
timestamp timestamp,
rangerid int
);