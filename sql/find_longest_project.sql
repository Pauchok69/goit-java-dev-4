SELECT id, name, TIMESTAMPDIFF(MONTH, start_date, finish_date) months_count
FROM project
WHERE TIMESTAMPDIFF(MONTH, start_date, finish_date) =
      (SELECT TIMESTAMPDIFF(MONTH, start_date, finish_date) months_count
       FROM project
       ORDER BY months_count DESC
       LIMIT 1);