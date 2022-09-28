USE `soft_uni_db`;
-- 01. Find Names of All Employees by First Name
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `first_name` LIKE 'Sa%'
ORDER BY `employee_id`;

-- 02. Find Names of All Employees by Last Name
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `last_name` LIKE '%ei%'
ORDER BY `employee_id`;

-- 03. Find First Names of All Employess
SELECT `first_name`
FROM `employees`
WHERE `department_id` IN (3, 10)
AND
YEAR(`hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;

-- 04. Find All Employees Except Engineers
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%'
ORDER BY `employee_id`; 

-- 05. Find Towns with Name Length
SELECT `name`
FROM `towns`
WHERE char_length(`name`) IN (5, 6)
ORDER BY `name`;

-- 06. Find Towns Starting With
SELECT `town_id`, `name`
FROM `towns`
WHERE `name` LIKE 'M%'
OR `name` LIKE 'K%'
OR `name` LIKE 'B%'
OR `name` LIKE 'E%'
ORDER BY `name`;

-- 07. Find Towns Not Starting With
SELECT `town_id`, `name`
FROM `towns`
WHERE `name` NOT LIKE 'R%'
AND `name` NOT LIKE 'B%'
AND `name` NOT LIKE 'D%'
ORDER BY `name`;

-- 08. Create View Employees Hired After
CREATE VIEW `v_employees_hired_after_2000`  AS
SELECT `first_name`, `last_name`
FROM `employees`
WHERE YEAR(`hire_date`) > 2000;

SELECT * FROM `v_employees_hired_after_2000`;

-- 09. Length of Last Name
SELECT `first_name`, `last_name`
FROM `employees`
WHERE char_length(`last_name`) = 5;

USE `geography`;

-- 10. Countries Holding 'A'
SELECT `country_name`, `iso_code`
FROM `countries`
WHERE `country_name` LIKE '%a%a%a%'
ORDER BY `iso_code`;

-- 11. Mix of Peak and River Names
SELECT `peak_name`, `river_name`,
CONCAT(LOWER(`peak_name`), SUBSTRING(LOWER(`river_name`), 2)) AS mix
FROM `peaks`, `rivers`
WHERE RIGHT(`peak_name`, 1) = LEFT(LOWER(`river_name`), 1)
ORDER BY mix;

-- 12. Games From 2011 and 2012 Year
USE `diablo`;

SELECT `name`, DATE_FORMAT(`start`, '%Y-%m-%d') AS start
FROM `games`
WHERE YEAR(`start`) BETWEEN 2011 AND 2012
ORDER BY `start`, `name`
LIMIT 50;

-- 13. User Email Providers
SELECT `user_name`, SUBSTRING(`email`, POSITION('@' IN `email`) + 1) AS `email_provider`
FROM `users`
ORDER BY `email_provider`, `user_name`;

-- 14. Get Users with IP Address Like Pattern
SELECT `user_name`, `ip_address`
FROM `users`
WHERE `ip_address` LIKE "___.1%.%.___"
ORDER BY `user_name`;

-- 15. Show All Games with Duration
SELECT `name` AS 'Game', 
IF(HOUR(`start`) >= 0 AND HOUR(`start`) < 12, 'Morning',
IF(HOUR(`start`) >= 12 AND HOUR(`start`) < 18, 'Afternoon',
'Evening'
'')) AS 'Part of the Day',
IF(`duration` <= 3, 'Extra Short',
IF(`duration` > 3 AND `duration` <= 6, 'Short',
IF(`duration` > 6 AND `duration` <= 10, 'Long ',
'Extra Long'))) AS 'Duration'
FROM `games`;

SELECT `name` as 'game',
CASE
WHEN hour(`start`) < 12 THEN 'Morning'
WHEN hour(`start`) < 18 THEN 'Afternoon'
ELSE 'Evening'
END 
AS 'Part of the Day',
CASE
WHEN `duration` <= 3 THEN 'Extra Short'
WHEN `duration` <= 6 THEN 'Short'
WHEN `duration` <= 10 THEN 'Long'
ELSE 'Extra Long'
END 
AS 'Duration'
FROM `games`;

-- 16. Orders Table
SELECT `product_name`, `order_date`,
adddate(`order_date`, interval 3 day) AS `pay_due`,
adddate(`order_date`, interval 1 month) AS `deliver_due`
FROM `orders`;

