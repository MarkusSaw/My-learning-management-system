SET search_path TO bank;

CREATE TABLE students (
      id BIGINT NOT NULL AUTO_INCREMENT,
      name VARCHAR(255),
      lastname VARCHAR(255),
      group_name VARCHAR(255),
      course_id BIGINT NOT NULL,
      group_id BIGINT NOT NULL,
      teacher_id BIGINT NOT NULL,
      timesheet_id BIGINT NOT NULL,
      PRIMARY KEY (id)

      FOREIGN KEY (course_id) REFERENCES course(id),
      FOREIGN KEY (group_id) REFERENCES groups(id),
      FOREIGN KEY (teacher_id) REFERENCES teacher(id),
      FOREIGN KEY (timesheet_id) REFERENCES timesheet(id)
);