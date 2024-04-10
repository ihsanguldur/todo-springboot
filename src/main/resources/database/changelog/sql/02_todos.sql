CREATE TABLE todos (
                       id         SERIAL PRIMARY KEY,
                       user_id    INTEGER,
                       content    VARCHAR(255) NOT NULL,
                       status     BOOLEAN NOT NULL DEFAULT FALSE,
                       created_at TIMESTAMP(6),
                       updated_at TIMESTAMP(6),
                       FOREIGN KEY (user_id) REFERENCES users (id)
);