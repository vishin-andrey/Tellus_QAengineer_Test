SELECT model, AVG(price) as average_price
FROM Products
WHERE product_type='laptop'
GROUP BY model
HAVING AVG(price)<2000