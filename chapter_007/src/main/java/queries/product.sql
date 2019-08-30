create database test1;

\c test1;

create table type (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL
);

create table product (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(50) NOT NULL,
	type_id INT REFERENCES type(id) NOT NULL,
	expiration_date DATE NOT NULL,
	price VARCHAR(50) NOT NULL
);

insert into type (name) values ('Cheese');
insert into type (name) values ('Ice_Cream');
insert into type (name) values ('Milk');
insert into type (name) values ('Meat');
insert into type (name) values ('Cheese');
insert into type (name) values ('Vegetables');
insert into type (name) values ('Bread');
insert into type (name) values ('Drinks');
insert into type (name) values ('Fish');


insert into product (id, name, type_id, expiration_date, price) values (1, 'Cheese - Havarti, Salsa', 1, '2019-06-12', '4.06');
insert into product (id, name, type_id, expiration_date, price) values (2, 'Bread - Crusty Italian Poly', 7, '2018-11-06', '5.66');
insert into product (id, name, type_id, expiration_date, price) values (3, 'Huck White Towels',  7, '2019-08-18', '4.62');
insert into product (id, name, type_id, expiration_date, price) values (4, 'Lamb Rack - Ontario', 4, '2019-05-25', '4.91');
insert into product (id, name, type_id, expiration_date, price) values (5, 'Muffin Hinge - 211n',  7, '2019-11-21', '6.50');
insert into product (id, name, type_id, expiration_date, price) values (6, 'The Pop Shoppe - Lime Rickey', 8, '2018-12-19', '0.76');
insert into product (id, name, type_id, expiration_date, price) values (7, 'Flour - Chickpea', 7, '2019-06-29', '9.60');
insert into product (id, name, type_id, expiration_date, price) values (8, 'Molasses - Fancy', 2, '2019-04-18', '0.06');
insert into product (id, name, type_id, expiration_date, price) values (9, 'Wine - Ruffino Chianti Classico', 8, '2019-01-02', '0.55');
insert into product (id, name, type_id, expiration_date, price) values (10, 'Lamb Rack - Ontario', 4, '2019-07-30', '2.81');
insert into product (id, name, type_id, expiration_date, price) values (11, 'Trueblue - Blueberry', 6, '2018-08-07', '6.41');
insert into product (id, name, type_id, expiration_date, price) values (12, 'Extract - Vanilla,artificial', 3, '2019-01-14', '6.58');
insert into product (id, name, type_id, expiration_date, price) values (13, 'Cheese - Sheep Milk', 1, '2019-04-14', '3.80');
insert into product (id, name, type_id, expiration_date, price) values (14, 'Bread - Bistro White', 7, '2019-01-29', '3.37');
insert into product (id, name, type_id, expiration_date, price) values (15, 'Beer - Moosehead', 8, '2019-05-30', '7.80');
insert into product (id, name, type_id, expiration_date, price) values (16, 'Cheese - Mascarpone', 1, '2019-09-02', '7.24');
insert into product (id, name, type_id, expiration_date, price) values (17, 'Truffle - Peelings', 6, '2019-01-01', '2.05');
insert into product (id, name, type_id, expiration_date, price) values (18, 'Tuna - Bluefin', 9, '2019-01-25', '7.40');
insert into product (id, name, type_id, expiration_date, price) values (19, 'Wine - Sawmill Creek Autumn', 8, '2019-11-12', '9.32');
insert into product (id, name, type_id, expiration_date, price) values (20, 'Spoon - Soup, Plastic', 2, '2019-03-26', '1.71');
insert into product (id, name, type_id, expiration_date, price) values (21, 'Ham - Black Forest', 4, '2019-04-17', '8.31');
insert into product (id, name, type_id, expiration_date, price) values (22, 'Wine - Tio Pepe Sherry Fino', 8, '2019-09-27', '5.09');
insert into product (id, name, type_id, expiration_date, price) values (23, 'Muffin Mix - Blueberry', 7, '2019-04-29', '2.52');
insert into product (id, name, type_id, expiration_date, price) values (24, 'Beer - Camerons Auburn', 8, '2019-11-14', '4.58');
insert into product (id, name, type_id, expiration_date, price) values (25, 'Tea - Decaf Lipton', 8, '2019-08-08', '2.11');
insert into product (id, name, type_id, expiration_date, price) values (26, 'Pepper - Chillies, Crushed', 8, '2019-05-31', '4.01');
insert into product (id, name, type_id, expiration_date, price) values (27, 'Marjoram - Dried, Rubbed', 2, '2019-08-04', '1.25');
insert into product (id, name, type_id, expiration_date, price) values (28, 'Crush - Cream Soda', 8, '2018-11-07', '0.83');
insert into product (id, name, type_id, expiration_date, price) values (29, 'Lamb - Rack', 4, '2018-11-27', '3.91');
insert into product (id, name, type_id, expiration_date, price) values (30, 'Nantucket Pine Orangebanana', 6, '2019-07-11', '9.53');
insert into product (id, name, type_id, expiration_date, price) values (31, 'Wine - Cave Springs Dry Riesling', 8, '2019-10-27', '1.72');
insert into product (id, name, type_id, expiration_date, price) values (32, 'Salt - Kosher', 7, '2019-07-31', '4.99');
insert into product (id, name, type_id, expiration_date, price) values (33, 'Arctic Char - Fresh, Whole', 3, '2018-08-19', '9.10');
insert into product (id, name, type_id, expiration_date, price) values (34, 'Chinese Foods - Chicken', 4, '2018-12-12', '6.57');
insert into product (id, name, type_id, expiration_date, price) values (35, 'Tofu - Soft', 2, '2018-09-09', '4.33');
insert into product (id, name, type_id, expiration_date, price) values (36, 'Wine - Pinot Noir Latour', 8, '2019-07-06', '7.75');
insert into product (id, name, type_id, expiration_date, price) values (37, 'Walkers Special Old Whiskey', 8, '2019-09-18', '9.57');
insert into product (id, name, type_id, expiration_date, price) values (38, 'Dc - Sakura Fu', 2, '2018-11-05', '7.06');
insert into product (id, name, type_id, expiration_date, price) values (39, 'Sprouts - Alfalfa', 2, '2019-04-12', '2.61');
insert into product (id, name, type_id, expiration_date, price) values (40, 'Oil - Sesame', 1, '2019-10-04', '4.78');
insert into product (id, name, type_id, expiration_date, price) values (41, 'Cookies - Oreo, 4 Pack', 7, '2018-11-08', '5.69');
insert into product (id, name, type_id, expiration_date, price) values (42, 'Cleaner - Comet', 3, '2019-08-15', '4.75');
insert into product (id, name, type_id, expiration_date, price) values (43, 'Carrots - Jumbo', 6, '2019-10-18', '2.46');
insert into product (id, name, type_id, expiration_date, price) values (44, 'Lamb Leg - Bone - In Nz', 4, '2019-01-20', '9.70');
insert into product (id, name, type_id, expiration_date, price) values (45, 'Cookies - Assorted', 7, '2018-08-19', '9.51');
insert into product (id, name, type_id, expiration_date, price) values (46, 'Devonshire Cream', 1, '2018-12-28', '3.06');
insert into product (id, name, type_id, expiration_date, price) values (47, 'Longos - Lasagna Veg', 6, '2019-01-07', '9.24');
insert into product (id, name, type_id, expiration_date, price) values (48, 'Mustard - Seed', 6, '2018-11-10', '5.41');
insert into product (id, name, type_id, expiration_date, price) values (49, 'Crackers - Soda / Saltins', 8, '2019-05-14', '7.82');
insert into product (id, name, type_id, expiration_date, price) values (50, 'Olives - Nicoise', 6, '2019-05-28', '0.28');
insert into product (id, name, type_id, expiration_date, price) values (51, 'Soup - Knorr, Classic Can. Chili', 8, '2019-07-28', '4.09');
insert into product (id, name, type_id, expiration_date, price) values (52, 'Beer - Blue Light', 8, '2018-12-09', '0.31');
insert into product (id, name, type_id, expiration_date, price) values (53, 'Nut - Walnut, Pieces', 6, '2019-02-01', '6.68');
insert into product (id, name, type_id, expiration_date, price) values (54, 'Beets - Golden', 4, '2019-06-06', '3.76');
insert into product (id, name, type_id, expiration_date, price) values (55, 'Piping Jelly - All Colours', 2, '2018-08-20', '4.28');
insert into product (id, name, type_id, expiration_date, price) values (56, 'Bread Bowl Plain', 7, '2019-04-26', '3.05');
insert into product (id, name, type_id, expiration_date, price) values (57, 'Vodka - Lemon, Absolut', 8, '2019-01-19', '6.80');
insert into product (id, name, type_id, expiration_date, price) values (58, 'Lamb - Racks, Frenched', 4, '2018-12-17', '3.19');
insert into product (id, name, type_id, expiration_date, price) values (59, 'Salmon - Whole, 4 - 6 Pounds', 9, '2018-09-20', '8.47');
insert into product (id, name, type_id, expiration_date, price) values (60, 'Milk - Buttermilk', 3, '2018-11-16', '5.76');
insert into product (id, name, type_id, expiration_date, price) values (61, 'Water - Aquafina Vitamin', 8, '2018-09-01', '3.66');
insert into product (id, name, type_id, expiration_date, price) values (62, 'Stock - Veal, White', 9, '2019-11-18', '1.04');
insert into product (id, name, type_id, expiration_date, price) values (63, 'Cabbage - Nappa', 6, '2019-09-21', '6.50');
insert into product (id, name, type_id, expiration_date, price) values (64, 'Dc - Sakura Fu', 5, '2019-04-02', '9.16');
insert into product (id, name, type_id, expiration_date, price) values (65, 'Yogurt - Cherry, 175 Gr', 2, '2019-03-10', '8.23');
insert into product (id, name, type_id, expiration_date, price) values (66, 'Carrots - Purple, Organic', 6,'2018-11-21', '0.54');
insert into product (id, name, type_id, expiration_date, price) values (67, 'Chinese Foods - Chicken Wing', 4, '2019-08-22', '0.19');
insert into product (id, name, type_id, expiration_date, price) values (68, 'Pork - Backfat', 4, '2018-10-26', '8.98');
insert into product (id, name, type_id, expiration_date, price) values (69, 'Campari', 8, '2019-02-06', '7.96');
insert into product (id, name, type_id, expiration_date, price) values (70, 'Pur Value', 2, '2019-06-14', '3.26');
insert into product (id, name, type_id, expiration_date, price) values (71, 'Salmon - Canned', 9, '2018-08-05', '2.73');
insert into product (id, name, type_id, expiration_date, price) values (72, 'Ecolab - Hobart Upr Prewash Arm', 2, '2019-11-24', '5.50');
insert into product (id, name, type_id, expiration_date, price) values (73, 'Tray - Foam, Square 4 - S', 2, '2019-04-04', '1.82');
insert into product (id, name, type_id, expiration_date, price) values (74, 'Cake Circle, Foil, Scallop', 2,'2019-08-26', '7.83');
insert into product (id, name, type_id, expiration_date, price) values (75, 'Container - Foam Dixie 12 Oz', 9, '2018-11-08', '1.64');
insert into product (id, name, type_id, expiration_date, price) values (76, 'Beer - Maudite', 8,'2019-01-12', '8.80');
insert into product (id, name, type_id, expiration_date, price) values (77, 'Beets', 4, '2019-04-08', '4.65');
insert into product (id, name, type_id, expiration_date, price) values (78, 'Tamarillo', 9, '2019-06-03', '1.59');
insert into product (id, name, type_id, expiration_date, price) values (79, 'Longos - Chicken Caeser Salad', 4, '2019-04-22', '8.13');
insert into product (id, name, type_id, expiration_date, price) values (80, 'Olives - Stuffed', 6, '2019-04-02', '7.95');
insert into product (id, name, type_id, expiration_date, price) values (81, 'Fond - Chocolate', 2, '2019-01-16', '5.39');
insert into product (id, name, type_id, expiration_date, price) values (82, 'Foil - 4oz Custard Cup', 9, '2019-10-10', '0.04');
insert into product (id, name, type_id, expiration_date, price) values (83, 'Artichoke - Hearts, Canned', 6, '2019-10-16', '8.84');
insert into product (id, name, type_id, expiration_date, price) values (84, 'Pie Pecan', 7, '2019-08-12', '5.66');
insert into product (id, name, type_id, expiration_date, price) values (85, 'Table Cloth 54x54 White', 9, '2019-10-26', '9.55');
insert into product (id, name, type_id, expiration_date, price) values (86, 'Chocolate - Semi Sweet', 6, '2018-12-08', '0.39');
insert into product (id, name, type_id, expiration_date, price) values (87, 'Pasta - Lasagna Noodle, Frozen', 6, '2018-12-15', '2.20');
insert into product (id, name, type_id, expiration_date, price) values (88, 'Bread Base - Toscano', 7, '2019-01-28', '1.81');
insert into product (id, name, type_id, expiration_date, price) values (89, 'Tomatoes', 6, '2018-09-11', '7.10');
insert into product (id, name, type_id, expiration_date, price) values (90, 'Lamb - Ground', 4, '2018-11-08','2.08');
insert into product (id, name, type_id, expiration_date, price) values (91, 'Potatoes - Purple, Organic', 6, '2018-10-30', '2.17');
insert into product (id, name, type_id, expiration_date, price) values (92, 'Bandage - Flexible Neon', 9, '2018-10-06', '3.03');
insert into product (id, name, type_id, expiration_date, price) values (93, 'Garam Masala Powder', 7, '2019-11-15', '1.54');
insert into product (id, name, type_id, expiration_date, price) values (94, 'Mushroom Morel Fresh', 6, '2019-04-04', '4.71');
insert into product (id, name, type_id, expiration_date, price) values (95, 'Loaf Pan - 2 Lb, Foil', 4, '2019-04-26', '0.80');
insert into product (id, name, type_id, expiration_date, price) values (96, 'Cheese Cheddar Processed', 1, '2019-04-02', '3.89');
insert into product (id, name, type_id, expiration_date, price) values (97, 'Ecolab Silver Fusion', 6,'2019-04-28', '2.85');
insert into product (id, name, type_id, expiration_date, price) values (98, 'Juice - Lagoon Mango', 8,'2019-02-23', '1.44');
insert into product (id, name, type_id, expiration_date, price) values (99, 'Tarragon - Fresh', 1, '2019-07-26', '9.30');
insert into product (id, name, type_id, expiration_date, price) values (100, 'Tart - Butter Plain Squares', 1, '2019-07-15', '3.20');
