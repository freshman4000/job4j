--1. Вывести список всех машин и все привязанные к ним детали.
SELECT c.make, t.name, b.name, e.name
FROM car AS c
LEFT JOIN transmission AS t
ON c.trans_id = t.id
LEFT JOIN car_body AS b
ON c.body_id = b.id
LEFT JOIN engine AS e
ON c.engine_id = e.id;

--2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.

--for transmission
SELECT t.name FROM car AS c
RIGHT JOIN transmission AS t
ON c.trans_id = t.id
WHERE c.make IS NULL;

--for car_body
SELECT b.name FROM car AS c
RIGHT JOIN car_body AS b
ON c.body_id = b.id
WHERE c.make IS NULL;

--for engine
SELECT e.name FROM car AS c
RIGHT JOIN engine AS e
ON c.engine_id = e.id
WHERE c.make IS NULL;