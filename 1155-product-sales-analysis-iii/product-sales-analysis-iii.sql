# Write your MySQL query statement below
select 
s.product_id,
t1.first_year,
s.quantity as quantity,
s.price as price
from
sales s
inner join
(select product_id as pid,
min(year) as first_year
from 
sales
group by product_id) as t1
on
s.product_id=t1.pid
and 
s.year=t1.first_year;