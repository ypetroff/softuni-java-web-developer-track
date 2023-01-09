CREATE SCHEMA table_relations;
USE table_relations;

CREATE TABLE passports (
    passport_id INT AUTO_INCREMENT,
    passport_number VARCHAR(30) UNIQUE,
    CONSTRAINT pk_passports PRIMARY KEY (passport_id)
);

CREATE TABLE people (
    person_id INT AUTO_INCREMENT,
    first_name VARCHAR(30),
    salary DECIMAL(15, 2 ),
    passport_id INT UNIQUE,
    CONSTRAINT pk_people PRIMARY KEY (person_id),
    FOREIGN KEY (passport_id)
        REFERENCES passports (passport_id)
);

INSERT INTO passports (passport_id, passport_number)
VALUES 
(101,	'N34FG21B'),
(102,	'K65LO4R7'),
(103,	'ZE657QP2');

INSERT INTO people (person_id, first_name, salary, passport_id)
VALUES
(1, 'Roberto', 43300.00, 102),
(2,	'Tom', 56100.00, 103),
(3,	'Yana', 60200.00, 101);

-- 02. One-To-Many Relationship
CREATE TABLE manufacturers (
    manufacturer_id INT AUTO_INCREMENT,
    `name` VARCHAR(30),
    established_on DATE,
    CONSTRAINT pk_manuf PRIMARY KEY (manufacturer_id)
);

INSERT INTO manufacturers (manufacturer_id, `name`, established_on)
VALUES
(1,	'BMW', '1916-03-01'),
(2,	'Tesla', '2003-01-01'),
(3,	'Lada', '1966-05-01');


CREATE TABLE models (
    model_id INT AUTO_INCREMENT,
    `name` VARCHAR(30),
    manufacturer_id INT,
    CONSTRAINT pk_model PRIMARY KEY (model_id),
    CONSTRAINT fk_models_manufacturer_id FOREIGN KEY (manufacturer_id)
        REFERENCES manufacturers (manufacturer_id)
);

INSERT INTO models (model_id, `name`, manufacturer_id)
values
(101, 'X1', 1),
(102, 'i6', 1),
(103, 'Model S', 2),
(104, 'Model X', 2),
(105, 'Model 3', 2),
(106, 'Nova', 3);

-- 03. Many-To-Many Relationship

