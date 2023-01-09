-- 1.	Employees with Salary Above 35000
DELIMITER $$

create procedure usp_get_employees_salary_above_35000() 
begin
select first_name, last_name from employees
where salary > 35000
order by first_name, last_name, employee_id;
end $$ 

DELIMITER ;
call usp_get_employees_salary_above_35000;

-- 02. Employees with Salary Above Number
DELIMITER $$
create procedure usp_get_employees_salary_above(num decimal(20, 4))
begin
select first_name, last_name from employees
where salary >= num
order by first_name, last_name, employee_id;
end $$
DELIMITER ;

call usp_get_employees_salary_above(45000);

-- 03. Town Names Starting With
delimiter $$
create procedure usp_get_towns_starting_with (str varchar(30))
begin
select name as 'town_name' from towns
where name LIKE concat(str, '%')
order by name;
end $$
delimiter ;

call usp_get_towns_starting_with ('b');
drop procedure usp_get_towns_starting_with;

-- 04. Employees from Town
delimiter $$
create procedure usp_get_employees_from_town (town_name varchar(30))
begin
select first_name, last_name
from employees as e
join addresses as a
on e.address_id = a.address_id
join towns as t
on a.town_id = t.town_id
where t.name = town_name
order by first_name, last_name, employee_id;
end $$

delimiter ;

call usp_get_employees_from_town('Sofia');

-- 05. Salary Level Function
delimiter $$
create function ufn_get_salary_level (sal decimal(20, 5))
returns varchar(30)
deterministic
begin
declare salary_level varchar(30);
set salary_level := 
                case 
                when sal < 30000 THEN 'Low'
                when sal between 30000 and 50000 THEN 'Average'
                else 'High'
                end;
                return salary_level;
end $$
delimiter ;

DELIMITER && 
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19, 4))
RETURNS VARCHAR(8)
DETERMINISTIC
BEGIN
    DECLARE salary_level VARCHAR(8);
    IF salary < 30000 THEN SET salary_level := 'Low';
    ELSEIF salary <= 50000 THEN SET salary_level := 'Average';
    ELSE SET salary_level := 'High';
    END IF;
    RETURN salary_level;
END &&  
DELIMITER ;

select ufn_get_salary_level(43300);

drop function ufn_get_salary_level;

-- 06. Employees by Salary Level
delimiter $$
create procedure usp_get_employees_by_salary_level (salary_level varchar(10))
begin
select first_name, last_name
from employees
where ufn_get_salary_level(salary) like salary_level
order by first_name desc, last_name desc;
end $$
delimiter ;

call usp_get_employees_by_salary_leve ('high');

-- 07. Define Function
delimiter $$
create function ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
returns int
deterministic
begin
return word regexp (concat('^[', set_of_letters, ']+$'));
end $$
delimiter ;

select ufn_is_word_comprised('oistmiahf', 'Sofia');
drop function ufn_is_word_comprised;

-- 08. Find Full Name
delimiter $$
create procedure usp_get_holders_full_name()
begin
select concat_ws(' ', first_name, last_name) as 'full_name'
from account_holders
ORDER BY `full_name`, id;
end $$
delimiter ;

call usp_get_holders_full_name();
drop procedure usp_get_holders_full_name;

-- 9. People with Balance Higher Than
delimiter $$
create procedure usp_get_holders_with_balance_higher_than (amount decimal(19, 4))
begin
select ah.first_name, ah.last_name
from account_holders as ah
left join accounts as a
on ah.id = a.account_holder_id
group by ah.first_name, ah.last_name
having sum(a.balance) > amount
order by a.account_holder_id;
end $$
delimiter ;

call usp_get_holders_with_balance_higher_than(7000);
drop procedure usp_get_holders_with_balance_higher_than;

-- 10. Future Value Function
delimiter $$
create function ufn_calculate_future_value (i decimal(20, 4), r double, t int)
returns decimal(20, 4)
deterministic
begin
return i * (power((1 + r), t));
end $$
delimiter ;

select ufn_calculate_future_value(1000, 0.5, 5);

-- 11. Calculating Interest
delimiter $$
create PROCEDURE usp_calculate_future_value_for_account (account_id int, interest_rate decimal(20, 4))
begin
select 
a.id as 'account_id',
ah.first_name,
ah.last_name,
a.balance as 'current_balance',
ufn_calculate_future_value(balance, interest_rate, 5) as 'balance_in_5_years'
from accounts as a
join account_holders as ah
on ah.id = a.account_holder_id
where a.id = account_id;
end $$
delimiter ;


call usp_calculate_future_value_for_account(1, 0.1);

drop procedure usp_calculate_future_value_for_account;

-- 12. Deposit Money
delimiter $$
create procedure usp_deposit_money(account_id int, money_amount decimal(20, 4))
begin
start transaction;
if(money_amount < 0) then
rollback;
else
update accounts
set balance = balance + money_amount
where id = account_id;
end if;
end $$
delimiter ;

call usp_deposit_money(1, 10);
drop procedure usp_deposit_money;

-- 13. Withdraw Money
delimiter $$
create procedure usp_withdraw_money(account_id int, money_amount decimal(20, 4))
    begin
    declare account_balance decimal(20, 4);
    set account_balance := (select balance from accounts where id = account_id);
        start transaction;
   if(account_balance < money_amount) then 
   ROLLBACK;
   elseif (money_amount < 0) then
   ROLLBACK;
   ELSE
   update accounts
   set balance = balance - money_amount
   where id = account_id;
end if;
    end $$
delimiter ;

call usp_withdraw_money(1, 10);

-- 14. Money Transfer
delimiter $$
create procedure usp_transfer_money(from_account_id int, to_account_id int , amount decimal(20, 4))
begin
declare from_id boolean;
declare to_id boolean;
declare from_balance decimal(20, 4);

set from_id := if((select id from accounts where id = from_account_id), true, false);
set to_id := if((select id from accounts where id = to_account_id), true, false);
set from_balance := (select balance from accounts where id = from_account_id);

start TRANSACTION;
if(from_id = false or to_id = false) then rollback;
elseif(from_balance < amount or amount <= 0) then ROLLBACK;
else 
update accounts
set balance = balance - amount
WHERE id = from_account_id;

update accounts
set balance = balance + amount
WHERE id = to_account_id;

end if;
end $$
delimiter ;

call usp_transfer_money(1, 2, 10);
drop procedure usp_transfer_money;

-- 15. Log Accounts Trigger 
CREATE TABLE `logs`(
    `log_id` INT PRIMARY KEY AUTO_INCREMENT, 
    `account_id` INT NOT NULL,
    `old_sum` DECIMAL(19, 4) NOT NULL,
    `new_sum` DECIMAL(19, 4) NOT NULL
);
DELIMITER $$
CREATE TRIGGER tr_change_balance
AFTER UPDATE ON `accounts`
FOR EACH ROW
BEGIN
    INSERT INTO `logs`(`account_id`, `old_sum`, `new_sum`) 
    VALUES (OLD.id, OLD.balance, NEW.balance);
END$$

-- 16. Emails Trigger
CREATE TABLE `notification_emails`(
    `id` INT PRIMARY KEY AUTO_INCREMENT, 
    `recipient` INT NOT NULL,
    `subject` TEXT,
    `body` TEXT
);
DELIMITER $$
CREATE TRIGGER tr_email_on_change_balance
AFTER INSERT
ON `logs`
FOR EACH ROW
BEGIN
    INSERT INTO `notification_emails`(`recipient`, `subject`, `body`)
    VALUES (NEW.`account_id`, concat_ws(' ', 'Balance change for account:', NEW.`account_id`), concat_ws(' ', 'On', NOW(), 'your balance was changed from', NEW.`old_sum`, 'to', NEW.`new_sum`, '.'));
END$$