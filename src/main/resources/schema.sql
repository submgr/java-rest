CREATE TABLE IF NOT EXISTS users (
    id IDENTITY NOT NULL,
    login VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    score INT DEFAULT 0,
);


CREATE TABLE IF NOT EXISTS recycling_points (
    id IDENTITY NOT NULL,
    city VARCHAR NOT NULL,
    latitude DECIMAL NOT NULL, --значения координат должны быть вещественного типа
    longitude DECIMAL NOT NULL,
    specialization VARCHAR, --специализация организации/точки сбора
    organization VARCHAR,
    phone VARCHAR,
    reception_days VARCHAR --дни приёма
);
