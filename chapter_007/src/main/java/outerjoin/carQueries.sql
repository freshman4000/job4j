--1. Вывести список всех машин и все привязанные к ним детали.
SELECT c.make, t.name, b.name, e.name
FROM car as c
LEFT JOIN transmission as t
ON c.trans_id = t.id
LEFT JOIN car_body as b
ON c.body_id = b.id
LEFT JOIN engine as e
ON c.engine_id = e.id;

--2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.

--v.1 не очень красивый вывод - но быстрое время выполнения
SELECT t.name AS transmission,
       b.name AS body_type,
       e.name AS engine_type
FROM car AS c
FULL JOIN transmission AS t
ON c.trans_id = t.id
FULL JOIN car_body AS b
ON c.body_id = b.id
FULL JOIN engine AS e
ON c.engine_id = e.id
WHERE c.make IS NULL;

--v.2 Красивый вывод в одну колонку...но 3 select & 3 union
SELECT t.name AS details_that_are_not_used
FROM car AS c
FULL JOIN transmission AS t
ON c.trans_id = t.id
WHERE c.make is NULL
UNION
SELECT b.name AS details_that_are_not_used
FROM car AS c
FULL JOIN car_body AS b
ON c.body_id = b.id
WHERE c.make is NULL
UNION
SELECT e.name AS details_that_are_not_used
FROM car AS c
FULL JOIN engine AS e
ON c.engine_id = e.id
WHERE c.make is NULL;

