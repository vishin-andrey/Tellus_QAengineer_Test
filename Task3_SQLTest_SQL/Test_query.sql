SELECT product_id, price 
FROM (
  SELECT 
  p.product_id, p.price,
  AVG(p.price) OVER 
    (ORDER BY p.price ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)
                                                           AS average_price
  FROM (
    SELECT product_id, price
    FROM Products
    WHERE product_type='laptop'
  ) p
) t
WHERE
  average_price < 2000;