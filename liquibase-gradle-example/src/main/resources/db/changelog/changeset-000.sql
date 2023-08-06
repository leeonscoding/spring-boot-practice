-- liquibase formatted sql

-- changeset create-employee:1
create table employee(
    id serial,
    name varchar(100),
    email varchar(100),
    primary key (id)
)