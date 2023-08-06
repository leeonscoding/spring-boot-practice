-- liquibase formatted sql

-- changeset liquibase:1
create table employee(
    id int,
    name varchar(100),
    email varchar(100),
    primary key (id)
)