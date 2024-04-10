CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    username   VARCHAR(100) NOT NULL
               UNIQUE,
    password   VARCHAR(30) NOT NULL,
    created_at TIMESTAMP(6),
    updated_at TIMESTAMP(6)
);