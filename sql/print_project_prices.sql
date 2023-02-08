SELECT p.*,
       IFNULL(SUM(w.salary) * TIMESTAMPDIFF(MONTH, start_date, finish_date), 0) price
FROM project p
         LEFT JOIN project_worker pw on p.id = pw.project_id
         LEFT JOIN worker w on pw.worker_id = w.id
GROUP BY p.id
ORDER BY price DESC;