create schema sgd;
use sgd;
drop schema sgd;

-- 01. Table Design
CREATE TABLE addresses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(10) NOT NULL
);

CREATE TABLE offices (
    id INT AUTO_INCREMENT PRIMARY KEY,
    workspace_capacity INT NOT NULL,
    website VARCHAR(50),
    address_id INT NOT NULL,
    CONSTRAINT fk_offices_addresses FOREIGN KEY (address_id)
        REFERENCES addresses (id)
);

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    age INT NOT NULL,
    salary DECIMAL(10 , 2 ) NOT NULL,
    job_title VARCHAR(20) NOT NULL,
    happiness_level CHAR(1) NOT NULL
);

CREATE TABLE teams (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    office_id INT NOT NULL,
    leader_id INT UNIQUE NOT NULL,
    CONSTRAINT fk_teams_offices FOREIGN KEY (office_id)
        REFERENCES offices (id),
    CONSTRAINT fk_teams_employees FOREIGN KEY (leader_id)
        REFERENCES employees (id)
);

CREATE TABLE games (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    description TEXT,
    rating FLOAT DEFAULT 5.5 NOT NULL,
    budget DECIMAL(10 , 2 ) NOT NULL,
    release_date DATE,
    team_id INT NOT NULL,
    CONSTRAINT fk_games_teams FOREIGN KEY (team_id)
        REFERENCES teams (id)
);

CREATE TABLE games_categories (
    game_id INT NOT NULL,
    category_id INT NOT NULL,
    CONSTRAINT pk_gc PRIMARY KEY (game_id , category_id),
    CONSTRAINT fk_gc_games FOREIGN KEY (game_id)
        REFERENCES games (id),
    CONSTRAINT fk_gc_categories FOREIGN KEY (category_id)
        REFERENCES categories (id)
);

-- 02. Insert

insert into games (name, rating, budget, team_id)
select
reverse(substring(lower(name), 2)), 
id,
leader_id * 1000,
id
from teams
where id between 1 and 9;

-- 03. Update
UPDATE employees AS e
        JOIN
    teams AS t ON e.id = t.leader_id 
SET 
    e.salary = e.salary + 1000
WHERE
    e.age < 40 AND e.salary < 5000;
    
    -- 04. Delete
DELETE FROM games 
WHERE
    id NOT IN (SELECT 
        game_id
    FROM
        games_categories)
    AND release_date IS NULL;
    
-- 05. Employees
SELECT 
    first_name, last_name, age, salary, happiness_level
FROM
    employees
ORDER BY salary , id;

-- 06. Addresses of the teams
SELECT 
    t.name AS 'team_name',
    a.name AS 'address_name',
    CHAR_LENGTH(a.name) AS 'count_of_characters'
FROM
    teams AS t
        JOIN
    offices AS o ON t.office_id = o.id
        JOIN
    addresses AS a ON o.address_id = a.id
WHERE
    o.website IS NOT NULL
ORDER BY t.name , a.name;

-- 07. Categories Info
SELECT 
    c.name AS 'name',
    COUNT(g.id) AS 'games_count',
    ROUND(AVG(g.budget), 2) AS 'avg_budget',
    MAX(g.rating) AS 'max_rating'
FROM
    categories AS c
        JOIN
    games_categories AS gc ON c.id = gc.category_id
        JOIN
    games AS g ON gc.game_id = g.id
GROUP BY c.id
HAVING `max_rating` >= 9.5
ORDER BY `games_count` DESC , c.name;

-- 08. Games of 2022
SELECT 
    g.name AS 'name',
    g.release_date AS 'release_date',
    CONCAT(SUBSTRING(g.description, 1, 10), '...') AS 'summary',
    CASE
        WHEN
            MONTH(release_date) = 1
                OR MONTH(release_date) = 2
                OR MONTH(release_date) = 3
        THEN
            'Q1'
        WHEN
            MONTH(release_date) = 4
                OR MONTH(release_date) = 5
                OR MONTH(release_date) = 6
        THEN
            'Q2'
        WHEN
            MONTH(release_date) = 7
                OR MONTH(release_date) = 8
                OR MONTH(release_date) = 9
        THEN
            'Q3'
        WHEN
            MONTH(release_date) = 10
                OR MONTH(release_date) = 11
                OR MONTH(release_date) = 12
        THEN
            'Q4'
    END AS 'quarter',
    t.name AS 'team_name'
FROM
    games AS g
        JOIN
    teams AS t ON g.team_id = t.id
WHERE
    g.name LIKE '%2' and year(g.release_date) = 2022
HAVING MONTH(`release_date`) % 2 = 0
ORDER BY `quarter`;

-- 09. Full info for games
SELECT 
    g.name,
    IF(g.budget < 50000,
        'Normal budget',
        'Insufficient budget') AS 'budget_level',
    t.name AS 'team_name',
    a.name AS 'address_name'
FROM
    games AS g
        JOIN
    teams AS t ON g.team_id = t.id
        JOIN
    offices AS o ON t.office_id = o.id
        JOIN
    addresses AS a ON o.address_id = a.id
WHERE
    g.release_date IS NULL
        AND g.id NOT IN (SELECT game_id FROM games_categories)
ORDER BY g.name;

-- 10. Find all basic information for a game
delimiter $$
create function udf_game_info_by_name (game_name VARCHAR (20))
returns varchar(300)
deterministic
begin
declare id_of_team int;
declare team_name VARCHAR(40);
declare address_text VARCHAR(50);

set id_of_team := (select team_id from games where name = game_name);
set team_name := (select name from teams where id = id_of_team);
set address_text := (select a.name from addresses as a join offices as o on a.id = o.address_id join teams as t on o.id = t.office_id where t.name = team_name);
return concat_ws(' ', 'The', game_name, 'is', 'developed', 'by', 'a', team_name, 'in', 'an', 'office', 'with', 'an', 'address', address_text);
end $$
delimiter ;

-- 11. Update Budget of the Games
delimiter $$
create procedure udp_update_budget (min_game_rating float)
begin
update games
set budget = budget + 100000,
release_date = date_add(release_date, interval 1 year)
where  id not in (select game_id from games_categories) and 
        rating > min_game_rating and
        release_date is not null;

end $$
delimiter ;

set sql_safe_updates = 0;
