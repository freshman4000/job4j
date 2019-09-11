CREATE DATABASE xxx;

\c xxx;

CREATE TABLE company ( id integer NOT NULL, name character varying, CONSTRAINT company_pkey PRIMARY KEY (id) );
INSERT INTO company (id, name) VALUES (1, 'google');
INSERT INTO company (id, name) VALUES (2, 'facebook');
INSERT INTO company (id, name) VALUES (3, 'air-b-n-b');
INSERT INTO company (id, name) VALUES (4, 'tesla');
INSERT INTO company (id, name) VALUES (5, 'apple');
INSERT INTO company (id, name) VALUES (6, 'netflix');
INSERT INTO company (id, name) VALUES (7, 'amazon');

CREATE TABLE person ( id integer NOT NULL, name character varying, company_id integer, CONSTRAINT person_pkey PRIMARY KEY (id) );
INSERT INTO person (id, name, company_id) VALUES (1, 'Larry', 1);
INSERT INTO person (id, name, company_id) VALUES (2, 'Sergey', 1);
INSERT INTO person (id, name, company_id) VALUES (3, 'Mark', 2);
INSERT INTO person (id, name, company_id) VALUES (4, 'Bryan', 3);
INSERT INTO person (id, name, company_id) VALUES (5, 'Joe', 3);
INSERT INTO person (id, name, company_id) VALUES (6, 'Natan', 3);
INSERT INTO person (id, name, company_id) VALUES (7, 'Ilon', 4);
INSERT INTO person (id, name, company_id) VALUES (8, 'Tim', 5);
INSERT INTO person (id, name, company_id) VALUES (9, 'Steve', 5);
INSERT INTO person (id, name, company_id) VALUES (10, 'Rid', 6);
INSERT INTO person (id, name, company_id) VALUES (11, 'Mark', 6);
INSERT INTO person (id, name, company_id) VALUES (12, 'Jeff', 7);

-- names of all persons that are NOT in the company with id = 5
SELECT p.name FROM person as p LEFT JOIN company as c ON c.id = p.company_id WHERE c.id<>5;

-- company name for each person
SELECT c.name, p.name FROM company as c RIGHT JOIN person as p ON c.id = p.company_id;

-- Select the name of the company with the maximum number of persons + number of persons in this company
SELECT c.name, count(*) FROM person AS p LEFT JOIN company AS c ON p.company_id = c.id GROUP BY c.name ORDER BY count DESC LIMIT 1;