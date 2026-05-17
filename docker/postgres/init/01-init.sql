CREATE TABLE notes (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(100) NOT NULL,
                       content TEXT,
                       archived BOOLEAN NOT NULL DEFAULT FALSE,
                       created_at TIMESTAMP WITH TIME ZONE NOT NULL,
                       updated_at TIMESTAMP WITH TIME ZONE NOT NULL
);