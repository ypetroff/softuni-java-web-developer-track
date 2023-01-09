delimiter $$
-- 1. Count Employees by Town
create FUNCTION ufn_count_employees_by_town(town_name VARCHAR(20))
returns int
DETERMINISTIC
begin
    declare e_count int;
    set e_count := (select count(employee_id) from employees as e
    join addresses as a
    on a.address_id = e.address_id
    join towns as t
    on t.town_id = a.town_id
    where t.name = town_name);
    return e_count;
end$$


select ufn_count_employees_by_town('Sofia') AS 'cout';
drop procedure usp_raise_salaries$$

-- 2. Employees Promotion
create procedure usp_raise_salaries(department_name varchar(50))
begin
update employees
set salary = salary * 1.05
where department_id = (select department_id from departments 
                        where  name = department_name);
end$$

call usp_raise_salaries ('Finance');

-- 3. Employees Promotion By ID
drop procedure usp_raise_salary_by_id$$

create procedure usp_raise_salary_by_id(id int)
begin
update employees
set salary = salary * 1.05
where employee_id = id;
end$$

call usp_raise_salary_by_id(300);

CREATE PROCEDURE usp_raise_salary_by_id(id int)
BEGIN
	START TRANSACTION;
	IF((SELECT count(employee_id) FROM employees WHERE employee_id like id)<>1) THEN
	ROLLBACK;
	ELSE
		UPDATE employees AS e SET salary = salary + salary*0.05 
		WHERE e.employee_id = id;
	END IF; 
END$$


-- 4. Triggered
create table deleted_employees(
employee_id int auto_increment,
first_name varchar(30),
last_name varchar(30),
middle_name varchar(30),
job_title varchar(30),
department_id int,
salary decimal,
primary key(employee_id))$$

create trigger tr_deleted_employees
after delete
on employees
for each row
begin
insert into deleted_employees (first_name, last_name, middle_name, job_title, department_id, salary)
values (old.first_name, old.last_name, old.middle_name, old.job_title, old.department_id, old.salary);
end$$

SET FOREIGN_KEY_CHECKS=0$$
delete from employees where employee_id in (1)$$
SET FOREIGN_KEY_CHECKS=1$$

delimiter ;
