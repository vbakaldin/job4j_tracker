--liquibase formatted sql

--changeset job4j:2-add-items-checked
ALTER TABLE items ADD COLUMN checked BOOLEAN NOT NULL DEFAULT false;

--rollback ALTER TABLE items DROP COLUMN checked;
