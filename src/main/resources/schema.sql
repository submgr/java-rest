CREATE TABLE IF NOT EXISTS users (
    id IDENTITY NOT NULL,
    login VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    score INT DEFAULT 0
);


CREATE TABLE IF NOT EXISTS recycling_points (
    id IDENTITY NOT NULL,
    city VARCHAR NOT NULL,
    latitude DOUBLE NOT NULL, --значения координат должны быть вещественного типа
    longitude DOUBLE NOT NULL,
    specialization VARCHAR, --специализация организации/точки сбора
    organization VARCHAR,
    phone VARCHAR,
    reception_days VARCHAR --дни приёма
);
