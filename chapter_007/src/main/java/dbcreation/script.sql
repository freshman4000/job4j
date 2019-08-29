CREATE DATABASE tracker;

\c tracker;

CREATE TABLE rules (
	id SERIAL NOT NULL PRIMARY KEY,
	description VARCHAR(2000) NOT NULL
);
CREATE TABLE roles (
	id SERIAL NOT NULL PRIMARY KEY,
	description VARCHAR(2000) NOT NULL
);
CREATE TABLE role_rules (
	id SERIAL NOT NULL PRIMARY KEY,
	id_roles INT REFERENCES roles(id) NOT NULL,
	id_rules INT REFERENCES rules(id) NOT NULL
);
CREATE TABLE users (
	id SERIAL NOT NULL PRIMARY KEY,
	user_name VARCHAR (200) NOT NULL,
	id_roles INT REFERENCES roles(id) NOT NULL
);
CREATE TABLE item_state (
    id SERIAL NOT NULL PRIMARY KEY,
    description VARCHAR (200) NOT NULL
);
CREATE TABLE item_category (
    id SERIAL NOT NULL PRIMARY KEY,
    description VARCHAR (200) NOT NULL
);
CREATE TABLE items (
    id SERIAL NOT NULL PRIMARY KEY,
    id_state INT REFERENCES item_state (id) NOT NULL,
    id_category INT REFERENCES item_category (id) NOT NULL,
    id_user INT REFERENCES users (id) NOT NULL
);
CREATE TABLE item_comments (
    id SERIAL NOT NULL PRIMARY KEY,
    description VARCHAR (2000) NOT NULL,
    id_item INT REFERENCES items (id) NOT NULL
);
CREATE TABLE item_attachments (
    id SERIAL NOT NULL PRIMARY KEY,
    URI_desc VARCHAR (2000) NOT NULL,
    id_item INT REFERENCES items (id) NOT NULL
);

INSERT INTO rules (description) VALUES ('build');
INSERT INTO rules (description) VALUES ('make_report');
INSERT INTO rules (description) VALUES ('check_report');
INSERT INTO rules (description) VALUES ('make_task');
INSERT INTO rules (description) VALUES ('give_task');
INSERT INTO rules (description) VALUES ('receive_customer_calls');
INSERT INTO rules (description) VALUES ('make_shipment');
INSERT INTO rules (description) VALUES ('make_advertisement');

INSERT INTO roles (description) VALUES ('worker');
INSERT INTO roles (description) VALUES ('taskmaster');
INSERT INTO roles (description) VALUES ('office_manager');
INSERT INTO roles (description) VALUES ('product_manager');
INSERT INTO roles (description) VALUES ('marketer');
INSERT INTO roles (description) VALUES ('driver');
INSERT INTO roles (description) VALUES ('director');

INSERT INTO role_rules (id_roles, id_rules) VALUES (1, 1);
INSERT INTO role_rules (id_roles, id_rules) VALUES (1, 2);

INSERT INTO role_rules (id_roles, id_rules) VALUES (2, 4);
INSERT INTO role_rules (id_roles, id_rules) VALUES (2, 3);
INSERT INTO role_rules (id_roles, id_rules) VALUES (2, 5);
INSERT INTO role_rules (id_roles, id_rules) VALUES (2, 2);

INSERT INTO role_rules (id_roles, id_rules) VALUES (3, 2);
INSERT INTO role_rules (id_roles, id_rules) VALUES (3, 6);

INSERT INTO role_rules (id_roles, id_rules) VALUES (4, 2);
INSERT INTO role_rules (id_roles, id_rules) VALUES (4, 3);
INSERT INTO role_rules (id_roles, id_rules) VALUES (4, 4);
INSERT INTO role_rules (id_roles, id_rules) VALUES (4, 5);

INSERT INTO role_rules (id_roles, id_rules) VALUES (5, 2);
INSERT INTO role_rules (id_roles, id_rules) VALUES (5, 8);

INSERT INTO role_rules (id_roles, id_rules) VALUES (6, 2);
INSERT INTO role_rules (id_roles, id_rules) VALUES (6, 7);

INSERT INTO role_rules (id_roles, id_rules) VALUES (7, 3);
INSERT INTO role_rules (id_roles, id_rules) VALUES (7, 4);
INSERT INTO role_rules (id_roles, id_rules) VALUES (7, 5);

INSERT INTO users (user_name, id_roles) VALUES ('us1', 1);
INSERT INTO users (user_name, id_roles) VALUES ('us2', 1);
INSERT INTO users (user_name, id_roles) VALUES ('us3', 1);
INSERT INTO users (user_name, id_roles) VALUES ('us4', 2);
INSERT INTO users (user_name, id_roles) VALUES ('us5', 3);
INSERT INTO users (user_name, id_roles) VALUES ('us6', 4);
INSERT INTO users (user_name, id_roles) VALUES ('us7', 5);
INSERT INTO users (user_name, id_roles) VALUES ('us8', 6);
INSERT INTO users (user_name, id_roles) VALUES ('us9', 7);

INSERT INTO item_state (description) VALUES ('negotiations_with_customer');
INSERT INTO item_state (description) VALUES ('building_in_progress');
INSERT INTO item_state (description) VALUES ('finished');

INSERT INTO item_category (description) VALUES ('basement');
INSERT INTO item_category (description) VALUES ('floor_slab_no_ground');
INSERT INTO item_category (description) VALUES ('floor_slab_on_the_ground');
INSERT INTO item_category (description) VALUES ('column');
INSERT INTO item_category (description) VALUES ('stair_case');
INSERT INTO item_category (description) VALUES ('crossbar');

INSERT INTO items (id_state, id_user, id_category) VALUES (1, 7, 1);
INSERT INTO items (id_state, id_user, id_category) VALUES (1, 7, 2);
INSERT INTO items (id_state, id_user, id_category) VALUES (1, 7, 4);
INSERT INTO items (id_state, id_user, id_category) VALUES (1, 7, 5);

INSERT INTO items (id_state, id_user, id_category) VALUES (2, 1, 2);

INSERT INTO items (id_state, id_user, id_category) VALUES (2, 2, 2);

INSERT INTO items (id_state, id_user, id_category) VALUES (3, 7, 6);

INSERT INTO item_comments (description, id_item) VALUES ('needs_warranty_service', 7);
INSERT INTO item_comments (description, id_item) VALUES ('not paid', 7);
INSERT INTO item_comments (description, id_item) VALUES ('differences_in_project', 5);
INSERT INTO item_comments (description, id_item) VALUES ('waiting_for_concrete', 2);

INSERT INTO item_attachments (URI_desc, id_item) VALUES ('www.monolit_krd.biz/resources/1-23.png', 1);
INSERT INTO item_attachments (URI_desc, id_item) VALUES ('www.monolit_krd.biz/resources/2-78.png', 2);
INSERT INTO item_attachments (URI_desc, id_item) VALUES ('www.monolit_krd.biz/resources/7-war1.png', 7);
INSERT INTO item_attachments (URI_desc, id_item) VALUES ('www.monolit_krd.biz/resources/7-war2.png', 7);