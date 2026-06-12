SET search_path TO bank;

CREATE TABLE timesheet (
      id BIGINT NOT NULL AUTO_INCREMENT,
      group_name VARCHAR(255),
      teacher VARCHAR(255),
      course VARCHAR(255),
      date_of_the_lesson VARCHAR(255)
      PRIMARY KEY (id)
);