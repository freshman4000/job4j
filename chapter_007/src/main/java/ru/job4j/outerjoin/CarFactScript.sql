CREATE DATABASE test2;

\c test2;

CREATE TABLE transmission(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(50)
);

CREATE TABLE car_body(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(50)
);

CREATE TABLE engine(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(50)
);

CREATE TABLE car(
    id SERIAL PRIMARY KEY NOT NULL,
    make VARCHAR(50) NOT NULL,
    trans_id INT REFERENCES transmission(id) NOT NULL,
    body_id INT REFERENCES car_body(id) NOT NULL,
    engine_id INT REFERENCES engine(id) NOT NULL
);

INSERT INTO transmission(name) VALUES ('mechanic');
INSERT INTO transmission(name) VALUES('automatic');

INSERT INTO car_body(name) VALUES('sedan');
INSERT INTO car_body(name) VALUES('hatchback');
INSERT INTO car_body(name) VALUES('universal');
INSERT INTO car_body(name) VALUES('truck');

INSERT INTO engine(name) VALUES('electric');
INSERT INTO engine(name) VALUES('diesel');
INSERT INTO engine(name) VALUES('petrol');

INSERT INTO car(trans_id, make, body_id, engine_id) VALUES(1, 'Jeep', 4, 2);
INSERT INTO car(trans_id, make, body_id, engine_id) VALUES(2, 'BMW', 1, 3);
INSERT INTO car(trans_id, make, body_id, engine_id) VALUES(2, 'Tesla', 2, 1);
INSERT INTO car(trans_id, make, body_id, engine_id) VALUES(2, 'Mercedes', 4, 2);
