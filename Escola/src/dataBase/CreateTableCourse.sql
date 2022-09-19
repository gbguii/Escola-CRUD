CREATE TABLE IF NOT EXISTS courses(
    course_id INT NOT NULL AUTO_INCREMENT,
    course_name VARCHAR(128),
    professor_id INT,
    course_dt_begin DATETIME,
    course_dt_update TIMESTAMP,
    course_dt_end DATETIME,
    PRIMARY KEY(course_id)
)

ALTER TABLE courses
ADD FOREIGN KEY(professor_id) REFERENCES professors(professor_id)