create schema softuni_imdb;
use softuni_imdb;
drop SCHEMA softuni_imdb;

-- 01. Table Design
CREATE TABLE countries (
    id INT AUTO_INCREMENT,
    name VARCHAR(30) UNIQUE NOT NULL,
    continent VARCHAR(30) NOT NULL,
    currency VARCHAR(5) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE genres (
    id INT AUTO_INCREMENT,
    name VARCHAR(50) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE actors (
    id INT AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL,
    height INT,
    awards INT,
    country_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_actors_countries FOREIGN KEY (country_id)
        REFERENCES countries (id)
);

CREATE TABLE movies_additional_info (
    id INT AUTO_INCREMENT,
    rating DECIMAL(10 , 2 ) NOT NULL,
    runtime INT NOT NULL,
    picture_url VARCHAR(80) NOT NULL,
    budget DECIMAL(10 , 2 ),
    release_date DATE NOT NULL,
    has_subtitles TINYINT(1),
    description TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE movies (
    id INT AUTO_INCREMENT,
    title VARCHAR(70) UNIQUE NOT NULL,
    country_id INT NOT NULL,
    movie_info_id INT UNIQUE NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_movies_countries FOREIGN KEY (country_id)
        REFERENCES countries (id),
    CONSTRAINT fk_movies_movies_additional_info FOREIGN KEY (movie_info_id)
        REFERENCES movies_additional_info (id)
);

CREATE TABLE movies_actors (
    movie_id INT,
    actor_id INT,
    CONSTRAINT fk_movies_actors_movies FOREIGN KEY (movie_id)
        REFERENCES movies (id),
    CONSTRAINT fk__movies_actors_actors FOREIGN KEY (actor_id)
        REFERENCES actors (id)
);

CREATE TABLE genres_movies (
    genre_id INT,
    movie_id INT,
    CONSTRAINT fk_genres_movies_genres FOREIGN KEY (genre_id)
        REFERENCES genres (id),
    CONSTRAINT fk_genres_movies_movies FOREIGN KEY (movie_id)
        REFERENCES movies (id)
);

-- 02. Insert
INSERT into actors (first_name, last_name, birthdate, height, awards, country_id)
select
reverse(first_name),
reverse(last_name),
date_sub(birthdate, interval 2 day),
height + 10,
country_id,
3
from actors
where id <= 10;

-- 03. Update
UPDATE `movies_additional_info` 
SET 
    runtime = runtime - 10
WHERE
    id >= 15 AND id <= 25;


-- 04. Delete
SET SQL_SAFE_UPDATES = 0;
DELETE FROM countries 
WHERE
    id NOT IN (SELECT 
        country_id
    FROM
        movies); 
SET SQL_SAFE_UPDATES = 1;

-- 05. Countries
SELECT * FROM `countries`
ORDER BY currency DESC, id;

-- 06. Old movies
SELECT 
    mai.id, m.title, mai.runtime, mai.budget, release_date
FROM
    movies_additional_info AS mai
        JOIN
    movies AS m ON mai.id = m.movie_info_id
WHERE
    YEAR(release_date) BETWEEN 1996 AND 1999
ORDER BY runtime , id
LIMIT 20;

-- 07. Movie casting
select 
concat_ws(' ', first_name, last_name) as 'full_name',
concat(reverse(last_name), char_length(last_name), '@cast.com') as 'email',
2022 - year(birthdate) as 'age',
height
from actors
where id not in (select actor_id from movies_actors GROUP BY actor_id)
ORDER BY height;

-- 08. International festival
select
c.name,
count(m.country_id) as 'movies_count'
from countries as c
join movies as m
where c.id = m.country_id
group by c.id
having `movies_count` >= 7
ORDER BY name desc;

-- 09. Rating system
select
m.title,
case
when mai.rating <= 4 then 'poor'
when mai.rating <= 7 then 'good'
else 'excellent'
end
as 'rating',
if(mai.has_subtitles = 1, 'english', '-') as 'subtitles',
mai.budget
from movies as m
join movies_additional_info as mai
on m.movie_info_id = mai.id
order by mai.budget desc;

-- 10. History movies
delimiter $$
create function udf_actor_history_movies_count(full_name VARCHAR(50))
returns INT
deterministic
begin
declare fm varchar(50);
return (select 
count(gm.movie_id) as 'history_movies'
from actors as a
join movies_actors as ma
on a.id = ma.actor_id
join genres_movies as gm
on ma.movie_id = gm.movie_id
join genres as g
on gm.genre_id = g.id
where g.name = 'History' and concat_ws(' ', a.first_name, a.last_name) = full_name);
end $$
delimiter ;

-- 11. Movie awards
delimiter $$
create procedure udp_award_movie (movie_title VARCHAR(50))
begin
update actors 
set awards = awards + 1
where id = (select 
ma.actor_id
from movies_actors as ma
join movies as m
on ma.movie_id = m.id
where m.title = movie_title and ma.actor_id = actors.id);
end $$
delimiter ;

drop procedure udp_award_movie
