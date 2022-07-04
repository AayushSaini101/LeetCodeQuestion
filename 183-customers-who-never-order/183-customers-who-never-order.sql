# Write your MySQL query statement below

## Find all the records who

select customers.name as customers from customers where Customers.id not In (select orders.customerID from customers, orders where customers.id = orders.customerID);