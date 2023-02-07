CREATE TABLE IF NOT EXISTS worker
(
    `id`       BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name`     VARCHAR(1000)                                  NOT NULL,
    `birthday` DATE,
    `level`    ENUM ('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL,
    `salary`   INT,
    CONSTRAINT worker_check_name CHECK ( LENGTH(`name`) >= 2 ),
    CONSTRAINT worker_check_birthday CHECK (`birthday` >= '1901-01-01'),
    CONSTRAINT worker_check_salary CHECK ( `salary` BETWEEN 100 AND 100000 )
);

CREATE TABLE IF NOT EXISTS client
(
    `id`   BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(1000) NOT NULL,
    CONSTRAINT client_check_name CHECK ( LENGTH(`name`) >= 2 )
);

CREATE TABLE IF NOT EXISTS project
(
    `id`          BIGINT AUTO_INCREMENT PRIMARY KEY,
    `client_id`   BIGINT,
    `name`        VARCHAR(1000) NOT NULL,
    `start_date`  DATETIME,
    `finish_date` DATETIME,
    FOREIGN KEY (`client_id`)
        REFERENCES client (`id`),
    CONSTRAINT project_name_check CHECK ( LENGTH(`name`) >= 2 )
);

CREATE TABLE IF NOT EXISTS project_worker
(
    `project_id` BIGINT NOT NULL,
    `worker_id`  BIGINT NOT NULL,
    PRIMARY KEY (`project_id`, `worker_id`),
    FOREIGN KEY (`project_id`) REFERENCES project (`id`),
    FOREIGN KEY (`worker_id`) REFERENCES worker (`id`)
);

-- ALTER TABLE project_worker ADD PRIMARY KEY (project_id, worker_id);
