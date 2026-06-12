SET search_path TO bank;

CREATE TABLE group (
     id BIGINT NOT NULL AUTO_INCREMENT,
     title VARCHAR(255),
     PRIMARY KEY (id)
);