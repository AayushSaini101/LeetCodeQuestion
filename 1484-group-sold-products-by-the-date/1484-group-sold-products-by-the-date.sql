# Write your MySQL query statement belowy

select sell_date, count(Distinct Product) as num_sold,  GROUP_CONCAT(DISTINCT product) as products from activities group by sell_date order by sell_date;