# Write your MySQL query statement below
select p.product_id,
  round(
    ifnull(
      sum(p.price * u.units)/sum(u.units)
    , 0)
  ,2)
  as average_price
from Prices as p
left join UnitsSold as u on u.product_id = p.product_id 
and u.purchase_date between p.start_date and p.end_date  
group by product_id
