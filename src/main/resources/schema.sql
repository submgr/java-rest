CREATE TABLE IF NOT EXISTS users (
    id IDENTITY NOT NULL,
    login VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    score INT DEFAULT 0,
);


CREATE TABLE IF NOT EXISTS recycle_points (
    id IDENTITY NOT NULL,
    coords_latitude VARCHAR NOT NULL,
    coords_longitude VARCHAR NOT NULL,
    organisation VARCHAR NOT NULL,
    number INT NOT NULL
);
--REAL CHECK