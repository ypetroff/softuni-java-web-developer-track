create schema online_store;
use online_store;
drop schema online_store;

-- 01. Table Design
CREATE TABLE brands (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) UNIQUE NOT NULL
);

CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) UNIQUE NOT NULL
);

CREATE TABLE reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    content TEXT,
    rating DECIMAL(10 , 2 ) NOT NULL,
    picture_url VARCHAR(80) NOT NULL,
    published_at DATETIME NOT NULL
);

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    price DECIMAL(19 , 2 ) NOT NULL,
    quantity_in_stock INT,
    description TEXT,
    brand_id INT NOT NULL,
    category_id INT NOT NULL,
    review_id INT,
    CONSTRAINT fk_products_brands FOREIGN KEY (brand_id)
        REFERENCES brands (id),
    CONSTRAINT fk_products_categories FOREIGN KEY (category_id)
        REFERENCES categories (id),
    CONSTRAINT fk_products_reviews FOREIGN KEY (review_id)
        REFERENCES reviews (id)
);

CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    phone VARCHAR(30) UNIQUE NOT NULL,
    address VARCHAR(60) NOT NULL,
    discount_card BIT(1) NOT NULL DEFAULT 0
);

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_datetime DATETIME NOT NULL,
    customer_id INT NOT NULL,
    CONSTRAINT fk_orders_customers FOREIGN KEY (customer_id)
        REFERENCES customers (id)
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
 insert into reviews (content, rating, picture_url, published_at)
 SELECT
substring(description, 1, 15),
 price / 8,
 reverse(name),
 '2010-10-10'
 from products
 where id >= 5;
 
 -- 03. Update
UPDATE products 
SET 
    quantity_in_stock = quantity_in_stock - 5
WHERE
    quantity_in_stock BETWEEN 60 AND 70;
    
-- 04. Delete
DELETE FROM customers 
WHERE
    id NOT IN (SELECT 
        customer_id
    FROM
        orders);
        
-- 05. Categories
select * from categories
order by name desc;

-- 06. Quantity
SELECT 
    id, brand_id, name, quantity_in_stock
FROM
    products
WHERE
    price > 1000 AND quantity_in_stock < 30
ORDER BY quantity_in_stock , id;

-- 07. Review
SELECT 
    id, content, rating, picture_url, published_at
FROM
    reviews
WHERE
    content LIKE 'My%'
        AND CHAR_LENGTH(content) > 61
ORDER BY rating DESC;

-- 08. First customers
SELECT 
    CONCAT_WS(' ', c.first_name, c.last_name) AS full_name,
    c.address,
    o.order_datetime AS order_date
FROM
    customers AS c
        JOIN
    orders AS o ON c.id = o.customer_id
WHERE
    YEAR(order_datetime) <= 2018
ORDER BY full_name DESC;

-- 09. Best categories
SELECT 
    COUNT(p.category_id) AS items_count,
    c.name,
    SUM(p.quantity_in_stock) as total_quantity
FROM
    categories AS c
        JOIN
    products AS p ON c.id = p.category_id
GROUP BY  c.name
ORDER BY items_count desc, total_quantity
LIMIT 5;

-- 10. Extract client cards count
delimiter $$
create function udf_customer_products_count(name VARCHAR(30))
returns int
deterministic
begin
declare id_of_client int;
set id_of_client := (select id from customers where first_name = name);
return (select count(*) from orders as o 
join orders_products as op
on  o.id = op.order_id
where o.customer_id = id_of_client);
end $$
delimiter ;

drop function udf_customer_products_count;

-- 11. Reduce price
delimiter $$
create procedure udp_reduce_price (category_name VARCHAR(50))
begin
declare id_of_category int;
set id_of_category := (select id from categories where name = category_name);
update products as p
join reviews as r
on p.review_id = r.id
set p.price = p.price - p.price * 0.3
where p.category_id = id_of_category and r.rating < 4; 
end $$
delimiter ;
