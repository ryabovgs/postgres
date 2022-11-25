CREATE TABLE IF NOT EXISTS role (
    id bigserial primary key,
    customer_id bigint NOT NULL,
    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer(id)
);