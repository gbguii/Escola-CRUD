CREATE TABLE IF NOT EXISTS professors(
    professor_id INT NOT NULL AUTO_INCREMENT,
    professor_first_name VARCHAR(128),
    professor_last_name VARCHAR(128),
    course_id INT,
    professor_dt_begin DATETIME,
    professor_dt_update TIMESTAMP,
    professor_dt_end DATETIME,
    PRIMARY KEY(professor_id)
)