INSERT INTO worker (id, name, birthday, level, salary)
VALUES (1, 'Cade Mays', '1998-09-23', 'Trainee', 300),
       (2, 'Ruth Little', '1995-01-07', 'Trainee', 500),
       (3, 'Euan Sykes', '1989-07-14', 'Junior', 900),
       (4, 'Marnie Wilkinson', '1983-02-04', 'Junior', 1200),
       (5, 'Montgomery Welch', '1986-05-19', 'Middle', 2100),
       (6, 'Zackary Clarke', '1993-07-01', 'Middle', 3240),
       (7, 'Faris Combs', '1998-11-21', 'Middle', 4300),
       (8, 'Wiktor Stone', '1998-06-17', 'Middle', 1800),
       (9, 'Mariam Snow', '2001-02-05', 'Senior', 5600),
       (10, 'Alessia Mora', '1987-04-27', 'Senior', 12000);

INSERT INTO client (id, name)
VALUES (1, 'Mohamad Jordan'),
       (2, 'Jamil Coffey'),
       (3, 'Ellena Stein'),
       (4, 'Michael Bennett'),
       (5, 'Abbas Russell');

INSERT INTO project (id, client_id, name, start_date, finish_date)
VALUES (1, 1, 'Magnetic Program', '2021-01-10', '2023-11-30'),
       (2, 1, 'Project Synergy' ,'2022-11-23', '2023-01-10'),
       (3, 3, 'Dynamic Program' ,'2022-12-17', '2023-06-24'),
       (4, 4, 'Project Illuminate' ,'2018-03-12', '2023-04-01'),
       (5, 1, 'Native Program' ,'2010-04-11', '2015-09-22'),
       (6, 4, 'Tarius' ,'2022-10-17', '2023-12-11'),
       (7, 3, 'MicroRaptor' ,'2017-07-14', '2020-01-10'),
       (8, 3, 'Osiris' ,'2021-10-25', '2022-11-09'),
       (9, 3, 'INCANDESCENT GHOST' ,'2016-01-06', '2018-07-01'),
       (10, 5, 'Tearful bite', '2022-04-18', '2025-12-31');

INSERT INTO project_worker (project_id, worker_id)
VALUES (1, 10),
       (2, 8),
       (2, 7),
       (2, 2),
       (3, 1),
       (3, 9),
       (3, 5),
       (4, 3),
       (4, 4),
       (5, 9),
       (5, 8),
       (5, 5),
       (5, 1),
       (5, 4),
       (6, 10),
       (6, 1),
       (7, 10),
       (8, 8),
       (8, 7),
       (8, 3),
       (9, 1),
       (9, 2),
       (9, 3),
       (10, 10),
       (10, 9),
       (10, 7),
       (10, 6);