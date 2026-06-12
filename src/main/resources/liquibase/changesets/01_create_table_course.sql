SET search_path TO bank;

CREATE TABLE course (
     id BIGINT NOT NULL AUTO_INCREMENT,
     name VARCHAR(255),
     description VARCHAR(255),
     PRIMARY KEY (id)
);