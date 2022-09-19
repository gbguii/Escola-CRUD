CREATE TABLE IF NOT EXISTS class_rooms(
    class_room_id INT NOT NULL AUTO_INCREMENT,
    class_room_name VARCHAR(128),
    class_room_dt_begin DATETIME,
    class_room_dt_update TIMESTAMP,
    class_room_dt_end DATETIME,
    PRIMARY KEY(class_room_id)
)