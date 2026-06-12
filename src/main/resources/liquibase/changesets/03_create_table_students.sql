SET search_path TO bank;

CREATE TABLE students (
      id BIGINT NOT NULL AUTO_INCREMENT,
      name VARCHAR(255),
      lastname VARCHAR(255),
      group_name VARCHAR(255)
      PRIMARY KEY (id)
);