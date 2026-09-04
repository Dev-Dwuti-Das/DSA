# Write your MySQL query statement below
select p.product_id, COALESCE(round(sum(p.price * u.units)/sum(u.units) ,2), 0) as average_price 
from Prices as p
left join UnitsSold as u on u.product_id = p.product_id
AND u.purchase_date >= p.start_date
AND u.purchase_date <= p.end_date
group by p.product_id

