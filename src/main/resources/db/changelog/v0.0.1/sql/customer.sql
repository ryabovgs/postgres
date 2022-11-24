CREATE TABLE IF NOT EXISTS customer (
    id bigserial primary key,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL
);