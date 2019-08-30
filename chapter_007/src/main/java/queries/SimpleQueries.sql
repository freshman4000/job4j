--1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT * FROM product
WHERE type_id =
(SELECT id FROM type
WHERE name = 'Cheese');
--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT * FROM product
WHERE name LIKE '%ice%';
--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT * FROM product
WHERE expiration_date
BETWEEN '2019-09-01' AND '2019-09-30';
--4. Написать запрос, который выводит самый дорогой продукт.
SELECT * FROM product
WHERE price =
(SELECT MAX(price) FROM product);
--5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT * FROM product
WHERE type_id =
(SELECT id FROM type WHERE name = 'Milk');
--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT * FROM product
WHERE type_id IN
(SELECT id FROM type WHERE name IN ('Milk', 'Cheese'));
--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
SELECT name FROM type
WHERE id IN (
SELECT type_id FROM product
GROUP BY type_id
HAVING COUNT(*) < 10);
--8. Вывести все продукты и их тип.
SELECT a.name, b.name FROM product as a
LEFT JOIN type as b
ON a.type_id = b.id;


