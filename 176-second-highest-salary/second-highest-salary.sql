# Write your MySQL query statement below
with cte as(
    select distinct salary from employee order by salary desc limit 2
)
select case when count(cte.salary)=2 then min(salary) else null end as SecondHighestSalary  from cte