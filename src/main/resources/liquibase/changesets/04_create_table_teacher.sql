SET search_path TO bank;

CREATE TABLE teacher (
     id BIGINT NOT NULL AUTO_INCREMENT,
     name VARCHAR(255),
     lastname VARCHAR(255)
     PRIMARY KEY (id)
);