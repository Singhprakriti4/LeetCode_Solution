# Write your MySQL query statement below
select round((sum(
    case when t1.order_date=t1.customer_pref_delivery_date
    then 1
    else 0 end
)/count(*))*100,2) as immediate_percentage
from
(select * from
delivery) as t1
inner join
(
select 
customer_id,
min(order_date) as minorder
from 
Delivery
group by 
customer_id
) as t2
on
t1.customer_id=t2.customer_id
and t1.order_date=t2.minorder;
