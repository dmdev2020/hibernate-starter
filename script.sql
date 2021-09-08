CREATE TABLE users
(
    firstname VARCHAR(128) NOT NULL ,
    lastname VARCHAR(128) NOT NULL ,
    birth_date DATE NOT NULL ,
    username VARCHAR(128) UNIQUE ,
    role VARCHAR(32),
    info JSONB,
    PRIMARY KEY (firstname, lastname, birth_date)
);

create sequence users_id_seq
    owned by users.id;

drop sequence users_id_seq;

DROP TABLE users;

create table all_sequence
(
    table_name VARCHAR(32) PRIMARY KEY ,
    pk_value BIGINT NOT NULL
);