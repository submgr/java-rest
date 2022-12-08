CREATE TABLE IF NOT EXISTS users (
    id IDENTITY NOT NULL,
    name VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,

    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS tasks (
    id IDENTITY NOT NULL,
    user_id BIGINT NOT NULL,
    title VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    date_of_creation TIMESTAMP NOT NULL,
    date_of_completion TIMESTAMP,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
