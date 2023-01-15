create schema restaurant_db;
use restaurant_db;
drop schema restaurant_db;


CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) UNIQUE NOT NULL,
    type VARCHAR(30) NOT NULL,
    price DECIMAL(10 , 2 ) NOT NULL
);

CREATE TABLE clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL,
    card VARCHAR(50),
    review TEXT
);

CREATE TABLE tables (
    id INT AUTO_INCREMENT PRIMARY KEY,
    floor INT NOT NULL,
    reserved TINYINT(1),
    capacity INT NOT NULL
);

CREATE TABLE waiters (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(50),
    salary DECIMAL(10 , 2 )
);

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    table_id INT NOT NULL,
    waiter_id INT NOT NULL,
    order_time TIME NOT NULL,
    payed_status TINYINT(1),
    CONSTRAINT fk_orders_tables FOREIGN KEY (table_id)
        REFERENCES tables (id),
    CONSTRAINT fk_orders_waiters FOREIGN KEY (waiter_id)
        REFERENCES waiters (id)
);

CREATE TABLE orders_clients (
    order_id INT,
    client_id INT,
    CONSTRAINT fk_oc_orders FOREIGN KEY (order_id)
        REFERENCES orders (id),
    CONSTRAINT fk_oc_clients FOREIGN KEY (client_id)
        REFERENCES clients (id)
);

CREATE TABLE orders_products (
    order_id INT,
    product_id INT,
    CONSTRAINT fk_op_orders FOREIGN KEY (order_id)
        REFERENCES orders (id),
    CONSTRAINT fk_op_products FOREIGN KEY (product_id)
        REFERENCES products (id)
);

-- 02. Insert
insert into products (name, type, price)
select
concat_ws(' ', last_name, 'specialty'),
'Cocktail',
ceil(salary * 0.01)
from waiters
WHERE id > 6;

-- 03. Update
UPDATE orders 
SET 
    table_id = table_id - 1
WHERE
    id BETWEEN 12 AND 23;

-- 04. Delete
DELETE FROM waiters 
WHERE
    id NOT IN (SELECT 
        waiter_id
    FROM
        orders);
        
-- 05. Clients
SELECT 
    *
FROM
    clients
ORDER BY birthdate DESC , id DESC;

-- 06. Birthdate
SELECT 
    first_name, last_name, birthdate, review
FROM
    clients
WHERE
    card IS NULL
        AND YEAR(birthdate) BETWEEN 1978 AND 1993
ORDER BY last_name DESC , id
LIMIT 5;

-- 07. Accounts
SELECT 
    CONCAT(last_name,
            first_name,
            CHAR_LENGTH(first_name),
            'Restaurant') AS 'username',
    REVERSE(SUBSTRING(email, 2, 12)) AS 'password'
FROM
    waiters
WHERE
    salary IS NOT NULL
ORDER BY `password` DESC;

-- 08. Top from menu
SELECT 
    p.id, p.name, COUNT(op.order_id) AS 'count'
FROM
    products AS p
        JOIN
    orders_products AS op ON p.id = op.product_id
GROUP BY id
HAVING `count` >= 5
ORDER BY `count` DESC , p.name;

-- 09. Availability
SELECT 
    t.id AS 'table_id',
    t.capacity,
    COUNT(oc.client_id) AS 'count_clients',
    CASE
        WHEN t.capacity < COUNT(o.table_id) THEN 'Extra seats'
        WHEN t.capacity = COUNT(o.table_id) THEN 'Full'
        ELSE 'Free seats'
    END AS availability
FROM
    tables AS t
        JOIN
    orders AS o ON t.id = o.table_id
        JOIN
    orders_clients AS oc ON o.id = order_id
WHERE
    floor = 1
GROUP BY t.id
ORDER BY t.id DESC; 

-- 10. Extract bill
delimiter $$
create function udf_client_bill(full_name VARCHAR(50))
returns decimal(19, 2)
DETERMINISTIC
begin
declare id_c int;
set id_c := (select id from clients where concat_ws(' ', first_name, last_name) = full_name);
return (select sum(p.price) from orders_clients as oc 
join orders_products as op 
on oc.order_id = op.order_id 
join products as p
on op.product_id = p.id
where oc.client_id = id_c);
end $$
delimiter ;

-- 11. Happy hour
delimiter $$
create procedure udp_happy_hour (type VARCHAR(50))
begin
update products as p
set p.price = p.price - p.price * 0.2
where p.type = type and price >= 10;
end $$
delimiter ;

drop procedure udp_happy_hour;
set sql_safe_updates = 0;