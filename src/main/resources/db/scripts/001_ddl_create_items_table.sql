--liquibase formatted sql

--changeset job4j:1-create-items
CREATE TABLE items (
    id SERIAL PRIMARY KEY,
    name TEXT,
    created TIMESTAMP
);

--rollback DROP TABLE items;
