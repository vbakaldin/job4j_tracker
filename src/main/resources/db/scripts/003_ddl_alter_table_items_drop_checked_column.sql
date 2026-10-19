--liquibase formatted sql

--changeset job4j:3-drop-items-checked
ALTER TABLE items DROP COLUMN checked;

--rollback ALTER TABLE items ADD COLUMN checked BOOLEAN NOT NULL DEFAULT false;
