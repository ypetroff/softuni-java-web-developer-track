-- 1
SELECT 
    e.employee_id, e.job_title, e.address_id, a.address_text
FROM
    employees AS e
        JOIN
    addresses AS a ON e.address_id = a.address_id
ORDER BY address_id
LIMIT 5;

-- 02. Addresses with Towns
SELECT 
    e.first_name, e.last_name, t.name, a.address_text
FROM
    employees AS e
        JOIN
    towns AS t
        JOIN
    addresses AS a ON (e.address_id = a.address_id
        AND a.town_id = t.town_id)
ORDER BY first_name , last_name
LIMIT 5;

-- 03. Sales Employee
SELECT 
    e.employee_id,
    e.first_name,
    e.last_name,
    d.name AS 'department_name'
FROM
    employees AS e
        JOIN
    departments AS d ON (e.department_id = d.department_id
        AND d.name = 'Sales')
ORDER BY employee_id DESC;

-- 04. Employee Departments
SELECT 
    e.employee_id, e.first_name, e.salary, d.name
FROM
    employees AS e
        JOIN
    departments AS d ON (e.department_id = d.department_id
        AND e.salary > 15000)
ORDER BY d.department_id DESC
LIMIT 5;

-- 05. Employees Without Project
SELECT 
    e.employee_id, e.first_name
FROM
    employees AS e
        LEFT JOIN
    employees_projects AS ep ON e.employee_id = ep.employee_id
    WHERE ep.project_id IS NULL
ORDER BY e.employee_id DESC
LIMIT 3;

-- 06. Employees Hired After
SELECT 
    e.first_name, e.last_name, e.hire_date, d.name AS 'dept_name'
FROM
    employees AS e
        JOIN
    departments AS d ON e.department_id = d.department_id
WHERE
    d.name IN ('Sales' , 'Finance')
ORDER BY e.hire_date;

-- 07. Employees with Project
SELECT 
    e.employee_id, e.first_name, p.name AS 'project_name'
FROM
    employees AS e
        JOIN
    employees_projects AS ep ON e.employee_id = ep.employee_id
        JOIN
    projects AS p ON ep.project_id = p.project_id
WHERE
    DATE(p.start_date) > '2002-08-13'
        AND p.end_date IS NULL
ORDER BY e.first_name , p.name
LIMIT 5;

-- 08. Employee 24
SELECT 
    e.employee_id,
    e.first_name,
    IF(YEAR(p.start_date) < 2005,
        p.name,
        NULL) AS 'project_name'
FROM
    employees AS e
        JOIN
    employees_projects AS ep ON e.employee_id = ep.employee_id
        JOIN
    projects AS p ON ep.project_id = p.project_id
WHERE
    e.employee_id = 24
ORDER BY p.name;

-- 09. Employee Manager
SELECT 
    e.employee_id,
    e.first_name,
    e.manager_id,
    (SELECT 
            e1.first_name
        FROM
            employees AS e1
        WHERE
            e.manager_id = e1.employee_id) AS 'manager_name'
FROM
    employees AS e
WHERE
    e.manager_id IN (3 , 7)
ORDER BY e.first_name;

-- or
SELECT e.`employee_id`, e.`first_name`, e.`manager_id`, m.`first_name`
FROM `employees` AS e
JOIN `employees` AS m ON e.`manager_id` = m.`employee_id`
WHERE e.`manager_id` IN (3 , 7)
ORDER BY e.`first_name`;

-- 10. Employee Summary
SELECT 
    e.employee_id,
    CONCAT_WS(' ', e.first_name, e.last_name) AS 'employee_name',
    CONCAT_WS(' ', m.first_name, m.last_name) AS 'manager_name',
    d.name AS 'department_name'
FROM
    employees AS e
        JOIN
    employees AS m ON m.employee_id = e.manager_id
        JOIN
    departments AS d ON d.department_id = e.department_id
WHERE
    e.manager_id IS NOT NULL
ORDER BY e.employee_id
LIMIT 5;

-- 11. Min Average Salary
SELECT 
    AVG(salary) AS 'min_average_salary'
FROM
    employees
GROUP BY department_id
ORDER BY `min_average_salary`
LIMIT 1;

-- 12. Highest Peaks in Bulgaria
SELECT 
    c.country_code, m.mountain_range, p.peak_name, p.elevation
FROM
    countries AS c
        JOIN
    mountains_countries AS mc ON c.country_code = mc.country_code
        JOIN
    mountains AS m ON mc.mountain_id = m.id
        JOIN
    peaks AS p ON m.id = p.mountain_id
WHERE
    mc.country_code = 'BG'
        AND p.elevation > 2835
ORDER BY p.elevation DESC;

-- 13. Count Mountain Ranges
SELECT 
    country_code, COUNT(mountain_id) AS 'mountain_range'
FROM
    mountains_countries
WHERE
    country_code IN ('US' , 'RU', 'BG')
GROUP BY country_code
ORDER BY `mountain_range` DESC;

-- or
SELECT c.`country_code`, COUNT(m.`mountain_range`) AS `mountain_range` FROM `mountains` AS m 
INNER JOIN `mountains_countries` AS c ON m.`id` = c.`mountain_id`
WHERE c.`country_code` IN ('BG', 'RU', 'US')
GROUP BY c.`country_code`
ORDER BY `mountain_range` DESC;

-- 14. Countries with Rivers
SELECT 
    c.country_name, r.river_name
FROM
    countries AS c
        LEFT JOIN
    countries_rivers AS cr ON c.country_code = cr.country_code
        LEFT JOIN
    rivers AS r ON cr.river_id = r.id
        JOIN
    continents AS cc ON cc.continent_code = c.continent_code
WHERE
    cc.continent_name = 'Africa'
ORDER BY c.country_name
LIMIT 5;

-- 15. *Continents and Currencies
SELECT 
    c1.continent_code,
    c1.currency_code,
    COUNT(*) AS 'currency_usage'
FROM
    countries AS c1
GROUP BY c1.continent_code , c1.currency_code
HAVING `currency_usage` > 1
    AND `currency_usage` = (SELECT 
        COUNT(*) AS cn
    FROM
        countries AS c2
    WHERE
        c2.continent_code = c1.continent_code
    GROUP BY c2.currency_code
    ORDER BY cn DESC
    LIMIT 1)
ORDER BY c1.continent_code;

-- 16. Countries without any Mountains
SELECT 
    COUNT(*) AS country_count
FROM
    countries AS c
        LEFT JOIN
    mountains_countries AS mc ON c.country_code = mc.country_code
WHERE
    mc.mountain_id IS NULL;
    
    -- 17. Highest Peak and Longest River by Country
    SELECT 
    c.country_name,
    MAX(p.elevation) AS 'highest_peak_elevation',
    MAX(r.length) AS 'longest_river_length'
FROM
    countries AS c
        LEFT JOIN
    mountains_countries AS mc ON c.country_code = mc.country_code
        LEFT JOIN
    peaks AS p ON mc.mountain_id = p.mountain_id
        LEFT JOIN
    countries_rivers AS cr ON c.country_code = cr.country_code
        LEFT JOIN
    rivers AS r ON cr.river_id = r.id
GROUP BY c.country_name
ORDER BY `highest_peak_elevation` DESC , `longest_river_length` DESC , c.country_name
LIMIT 5;




