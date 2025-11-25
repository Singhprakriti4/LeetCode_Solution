# Write your MySQL query statement below
select 
q.query_name, 
t3.quality,
case 
when  lessthanthree is null then 0
else 
round((lessthanthree/count(rating))*100,2) 
end as poor_query_percentage
from 
queries q
inner join
(select t1.query_name, t1.quality, t2.lessthanthree
from
(select *, 
round(avg(rating/position),2) as quality
from queries
group by query_name) as t1
left join
(select *, count(rating) as lessthanthree
from queries
where rating<3
group by query_name) as t2
on t1.query_name=t2.query_name) as t3
on q.query_name=t3.query_name
group by q.query_name;
