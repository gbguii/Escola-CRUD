CREATE TABLE IF NOT EXISTS students (
    student_id INT NOT NULL AUTO_INCREMENT,
    student_first_name VARCHAR(128),
    student_last_name VARCHAR(128),
    class_room_id INT,
    student_dt_begin DATETIME,
    student_dt_update TIMESTAMP,
    student_dt_end DATETIME,
    PRIMARY KEY(student_id),
    FOREIGN KEY(class_room_id) REFERENCES class_rooms(class_room_id)
)