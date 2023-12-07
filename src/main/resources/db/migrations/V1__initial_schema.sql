CREATE TABLE IF NOT EXISTS author (
    id SERIAL PRIMARY KEY,
    username VARCHAR(20) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    CONSTRAINT unique_username UNIQUE (username)
);

CREATE TABLE IF NOT EXISTS task (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(20),
    priority VARCHAR(20),
    author_id BIGINT,
    FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_author_username ON author (username);