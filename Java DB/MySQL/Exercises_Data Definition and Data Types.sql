-- Exercises: Data Definition and Data Types

CREATE SCHEMA `minions` DEFAULT CHARACTER SET utf8;

USE `minions`;

CREATE TABLE `minions` (
`id` INT AUTO_INCREMENT,
`name` VARCHAR(50),
`age` INT,

PRIMARY KEY (`id`)
);

USE `minions`;

CREATE TABLE `towns` (
`town_id` INT AUTO_INCREMENT,
`name` VARCHAR(50),

PRIMARY KEY (`town_id`)
);

USE `minions`;

ALTER TABLE `towns`
RENAME COLUMN `town_id` TO `id`;

ALTER TABLE `minions`
ADD COLUMN `town_id` INT NOT NULL,
ADD CONSTRAINT `fk_minions_towns`
FOREIGN KEY (`town_id`)
REFERENCES `towns` (`id`);

USE `minions`;

INSERT INTO `towns` (`id`, `name`)
VALUES
('1', 'Sofia'),
('2', 'Plovdiv'),
('3', 'Varna');

INSERT INTO `minions` (`id`, `name`, `age`, `town_id`)
VALUES
('1', 'Kevin', '22', '1'),
('2', 'Bob', '15', '3'),
('3', 'Steward', NULL, '2');

USE `minions`;

TRUNCATE TABLE `minions`;

USE `minions`;

DROP TABLES `minions`, `towns`;

-- 6 Create table people

CREATE TABLE `people` (
`id` INT UNIQUE AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DOUBLE(10, 2),
`weight` DOUBLE(10, 2),
`gender` ENUM('m', 'f') NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT,

PRIMARY KEY (`id`)
);

USE `minions`;

INSERT INTO `people` (`name`, `gender`, `birthdate`)
VALUES
('test', 'm', DATE(now())),
('test1', 'f', DATE(now())),
('test2', 'm', DATE(now())),
('test3', 'f', DATE(now())),
('test4', 'm', DATE(now()));

-- 7 Create Table users
USE `minions`;

CREATE TABLE `users` (
`id` INT UNIQUE AUTO_INCREMENT,
`username` VARCHAR(30) UNIQUE NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` DATE,
`is_deleted` BOOLEAN,

PRIMARY KEY (`id`)
);

INSERT INTO `users` (`username`, `password`)
VALUES
('test1', '124334'),
('test2', '123434'),
('test3', '123454'),
('test4', '127634'),
('test5', '176334');

-- 8 Change Primary Key

USE `minions`;

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT
PRIMARY KEY `pk_users` (`id`, `username`);

-- 9 Set Default Values of a Field

USE `minions`;

ALTER TABLE `users`
MODIFY COLUMN `last_login_time` DATETIME DEFAULT NOW();

-- 10 Set Unique Field

USE `minions`;

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users`
PRIMARY KEY `users` (`id`),
MODIFY COLUMN `username` VARCHAR(30) UNIQUE;

-- 11 Movies Database

CREATE SCHEMA `movies` DEFAULT CHARACTER SET utf8;

CREATE TABLE `directors` (
`id` INT AUTO_INCREMENT,
`director_name` VARCHAR(30) NOT NULL,
`notes` TEXT,

PRIMARY KEY (`id`)
);

INSERT INTO `directors` (`director_name`)
VALUES
('test_test1'),
('test_test2'),
('test_test3'),
('test_test4'),
('test_test5');

CREATE TABLE `genres` (
`id` INT AUTO_INCREMENT,
`genre_name` VARCHAR(30) NOT NULL,
`notes` TEXT,

PRIMARY KEY (`id`)
);

INSERT INTO `genres` (`genre_name`)
VALUES
('genre_test1'),
('genre_test2'),
('genre_test3'),
('genre_test4'),
('genre_test5');

CREATE TABLE `categories` (
`id` INT AUTO_INCREMENT,
`category_name` VARCHAR(30) NOT NULL,
`notes` TEXT,

PRIMARY KEY (`id`)
);

INSERT INTO `categories` (`category_name`)
VALUES
('category_test1'),
('category_test2'),
('category_test3'),
('category_test4'),
('category_test5');


CREATE TABLE `movies` (
`id` INT AUTO_INCREMENT,
`title` VARCHAR(30) NOT NULL,
`director_id` INT,
`copyright_year` YEAR,
`length` DECIMAL(10, 2),
`genre_id` INT,
`category_id` INT,
`rating` DOUBLE,
`notes` TEXT,

PRIMARY KEY (`id`)
);

INSERT INTO `movies` (`title`, `director_id`, `genre_id`, `category_id`)
VALUES
('title_1', '1', '5', '1'),
('title_2', '2', '4', '2'),
('title_2', '3', '3', '3'),
('title_2', '4', '2', '4'),
('title_2', '5', '1', '5');

-- 12 Car Rental Database

    CREATE SCHEMA `car_rental`;
    
    USE `car_rental`;
    
    CREATE TABLE `categories` (
    `id` INT AUTO_INCREMENT NOT NULL,
    `category` VARCHAR(50) NOT NULL,
    `daily_rate` DECIMAL(10, 2),
    `weekly_rate` DECIMAL(10, 2),
    `monthly_rate` DECIMAL(10, 2),
    `weekend_rate` DECIMAL(10, 2),
    
    PRIMARY KEY (`id`)
    );
    
    INSERT INTO `categories` (`category`, `daily_rate`, `weekly_rate`, `monthly_rate`, `weekend_rate`)
    VALUES
    ('test_category_1', '0.1', '1.1', '2.20', '3.03'),
    ('test_category_1', '0.1', '1.1', '2.20', NULL),
    ('test_category_1', '0.1', '1.1', NULL , '3.03');
    
    CREATE TABLE `cars` (
    `id`INT AUTO_INCREMENT UNIQUE, 
    `plate_number` VARCHAR(30) NOT NULL, 
    `make` VARCHAR(30), 
    `model` VARCHAR(30), 
    `car_year`YEAR, 
    `category_id` INT NOT NULL, 
    `doors` INT, 
    `picture` BLOB, 
    `car_condition` VARCHAR(30), 
    `available` BOOLEAN,
    
    PRIMARY KEY (`id`),
    
    FOREIGN KEY (`category_id`)
    REFERENCES `categories` (`id`)
    );
    
INSERT INTO `cars` (`plate_number`, `category_id`, `available`)
VALUES
('P1111KH', '1', TRUE),
('P1121KH', '3', FALSE),
('P1331KH', '2', TRUE);

CREATE TABLE `employees` (
`id` INT UNIQUE AUTO_INCREMENT,
`first_name` VARCHAR(30), 
`last_name`VARCHAR(30),
`title` VARCHAR(30),
 `notes` TEXT,
 
 PRIMARY KEY (`id`)
);

INSERT INTO `employees` (`last_name`)
VALUES
('Petrov'),
('Ivanov'),
('Petkov');

CREATE TABLE `customers` (
`id` INT AUTO_INCREMENT UNIQUE, 
`driver_licence_number` INT NOT NULL UNIQUE, 
`full_name` VARCHAR(30), 
`address` VARCHAR(30), 
`city` VARCHAR(30), 
`zip_code` VARCHAR(10), 
`notes` TEXT,

PRIMARY KEY (`id`)
);

INSERT INTO `customers` (`driver_licence_number`)
VALUES
('123456'),
('789012'),
('456789');

CREATE TABLE `rental_orders` (
`id` INT AUTO_INCREMENT, 
`employee_id` INT NOT NULL, 
`customer_id` INT NOT NULL, 
`car_id` INT NOT NULL, 
`car_condition` VARCHAR(30), 
`tank_level` VARCHAR(30),  
`kilometrage_start` INT, 
`kilometrage_end` INT, 
`total_kilometrage` INT, 
`start_date` DATE, 
`end_date` DATE, 
`total_days` INT, 
`rate_applied` DECIMAL(10, 2), 
`tax_rate`DECIMAL(10, 2), 
`order_status` VARCHAR(30), 
`notes` TEXT,

PRIMARY KEY (`id`),

FOREIGN KEY (`employee_id`)
REFERENCES `employees` (`id`),

FOREIGN KEY (`customer_id`)
REFERENCES `customers` (`id`),

FOREIGN KEY (`car_id`)
REFERENCES `cars` (`id`)
);

INSERT INTO `rental_orders` (`employee_id`, `customer_id`, `car_id`)
VALUES
('1', '2', '3'),
('2', '3', '1'),
('3', '1', '2');

-- 13 Basic Insert
CREATE SCHEMA `soft_uni`;

USE `soft_uni`;

CREATE TABLE `towns` (
`id` INT AUTO_INCREMENT,
`name` VARCHAR(30),

CONSTRAINT
PRIMARY KEY (`id`)
);

CREATE TABLE `addresses` (
`id` INT AUTO_INCREMENT,
`address` VARCHAR(30),
`text` TEXT,
`town_id` INT NOT NULL,

CONSTRAINT
PRIMARY KEY (`id`),
FOREIGN KEY (`town_id`)
REFERENCES `towns` (`id`)
);

CREATE TABLE `departments` (
`id` INT AUTO_INCREMENT,
`name` VARCHAR(30),

CONSTRAINT
PRIMARY KEY (`id`)
);

CREATE TABLE `employees` (
`id` INT AUTO_INCREMENT, 
`first_name` VARCHAR(30), 
`middle_name` VARCHAR(30), 
`last_name` VARCHAR(30), 
`job_title` VARCHAR(30), 
`department_id` INT NOT NULL, 
`hire_date` DATE, 
`salary` DECIMAL(10, 2), 
`address_id`INT NOT NULL,

CONSTRAINT
PRIMARY KEY (`id`),
FOREIGN KEY (`department_id`)
REFERENCES `departments` (`id`),
FOREIGN KEY (`address_id`)
REFERENCES `addresses`(`id`)
);

-- modifications and adjustments
ALTER TABLE `employees`
MODIFY COLUMN `address_id` INT;

ALTER TABLE `employees`
MODIFY COLUMN `hire_date` DATE;

ALTER TABLE `employees`
MODIFY COLUMN `salary` DECIMAL(10, 2);

TRUNCATE TABLE `employees`;

INSERT INTO `towns` (`name`)
VALUES
('Sofia'), ('Plovdiv'), ('Varna'), ('Burgas');

INSERT INTO `departments` (`name`)
VALUES
('Engineering'), ('Sales'), ('Marketing'), ('Software Development'), ('Quality Assurance');

INSERT INTO `employees` (`first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`, `salary`)
VALUES
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', '4', '2013-02-01', '3500.00'), 
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', '1', '2004-03-02', '4000.00'),
('Maria', 'Petrova', 'Ivanova', 'Intern', '5', '2016-08-28', '525.25'),
('Georgi', 'Terziev', 'Ivanov', 'CEO', '2', '2007-12-09', '3000.00'),
('Peter', 'Pan', 'Pan', 'Intern', '3', '2016-08-28', '599.88');

-- 14 Basic Select All Fields
SELECT * FROM `towns`;
SELECT * FROM `departments`;
SELECT * FROM `employees`;

-- 15 Basic Select All Fields and Order Them

SELECT * FROM `towns`
ORDER BY `name` ASC;
SELECT * FROM `departments`
ORDER BY `name` ASC;
SELECT * FROM `employees`
ORDER BY `salary` DESC;

-- 16 Basic Select Some Fields
SELECT `name` FROM `towns`
ORDER BY `name` ASC;
SELECT `name` FROM `departments`
ORDER BY `name` ASC;
SELECT `first_name`, `last_name`, `job_title`, `salary` FROM `employees`
ORDER BY `salary` DESC;

-- 17 Increase Employees Salary
SET SQL_SAFE_UPDATES = 1;
UPDATE `employees`
SET `salary` = `salary` * 1.1;
SELECT `salary` FROM `employees`;

        
        

