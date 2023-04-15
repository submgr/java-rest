-- Пользователи
CREATE TABLE IF NOT EXISTS users (
    id IDENTITY NOT NULL PRIMARY KEY,
    email VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    username VARCHAR,
    age INTEGER
);

-- Публикации
CREATE TABLE IF NOT EXISTS posts (
    id IDENTITY NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    title VARCHAR(200) NOT NULL,
    content VARCHAR NOT NULL,
    publication_date TIMESTAMP NOT NULL,
    views INTEGER DEFAULT 0,

    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Комментарии
CREATE TABLE IF NOT EXISTS comments (
    id IDENTITY NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    post_id BIGINT NOT NULL,
    content VARCHAR NOT NULL,
    publication_date TIMESTAMP NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (post_id) REFERENCES posts(id) ON DELETE CASCADE
);

-- Пункты переработки отходов
CREATE TABLE IF NOT EXISTS recycling_points (
    id IDENTITY NOT NULL PRIMARY KEY,
    city VARCHAR(50) NOT NULL,
    latitude DOUBLE NOT NULL, --значения координат должны быть вещественного типа
    longitude DOUBLE NOT NULL,
    specialization VARCHAR, --специализация пункта (теги)
    organization VARCHAR DEFAULT 'Пункт переработки отходов',
    phone VARCHAR DEFAULT 'Не указан',
    reception_days VARCHAR --дни приёма
);
