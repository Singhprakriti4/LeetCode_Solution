# Write your MySQL query statement below
select s1.student_id, s1.student_name,
       s2.subject_name, 
    --    s3.subject_name,
       count(s3.subject_name) as attended_exams 
from
students s1
cross join
subjects s2
left join
examinations s3
on
s1.student_id=s3.student_id
and
s2.subject_name=s3.subject_name
group by s1.student_id,s2.subject_name
order by s1.student_id, s2.subject_name;
