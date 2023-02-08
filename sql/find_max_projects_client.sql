SELECT c.name, COUNT(c.id) project_count
FROM client c
         INNER JOIN project p on c.id = p.client_id
GROUP BY c.id
HAVING COUNT(c.id) =
       (SELECT COUNT(c.id) c
        FROM client c
                 INNER JOIN project p on c.id = p.client_id
        GROUP BY c.id
        ORDER BY c DESC
        LIMIT 1);