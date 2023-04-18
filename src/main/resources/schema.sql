-- Пользователи
CREATE TABLE IF NOT EXISTS users (
    id IDENTITY NOT NULL PRIMARY KEY,
    email VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    username VARCHAR,
    age INTEGER ,
    scores INTEGER
);

--Вопросы
CREATE TABLE IF NOT EXISTS questions(
    id IDENTITY NOT NULL PRIMARY KEY,
    question_id  BIGINT NOT NULL,
    difficulty VARCHAR,
    question VARCHAR NOT NULL,
    answer  VARCHAR ,
    question_scores INTEGER ,
    FOREIGN KEY (question_id) REFERENCES users(id)

);
-- Ежедневные события и задания
CREATE TABLE IF NOT EXISTS daily_events(
    id IDENTITY NOT NULL PRIMARY KEY,
    event_id BIGINT NOT NULL,
    difficulty VARCHAR,
    event_name VARCHAR,
    event_value VARCHAR NOT NULL,
    answer VARCHAR,
    escores INTEGER,
    FOREIGN KEY (event_id) REFERENCES users(id) 

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
