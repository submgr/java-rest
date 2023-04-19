-- Пользователи
CREATE TABLE IF NOT EXISTS users (
    id IDENTITY NOT NULL PRIMARY KEY,
    email VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    username VARCHAR,
    age INTEGER,
    scores INTEGER
);
--Виктарины
CREATE TABLE IF NOT EXISTS quizzes(
    id  IDENTITY NOT NULL PRIMARY KEY,
    title VARCHAR NOT NULL,
    theme VARCHAR,
    difficulty VARCHAR
);
--Вопросы
CREATE TABLE IF NOT EXISTS questions(
    id IDENTITY NOT NULL PRIMARY KEY,
    quiz_id  BIGINT NOT NULL,
    question VARCHAR,
    variant1 VARCHAR,
    variant2 VARCHAR,
    variant3 VARCHAR,
    answer VARCHAR,
    question_scores INTEGER,
    
    FOREIGN KEY (quiz_id) REFERENCES quizzes(id)

);

-- Ежедневные события
CREATE TABLE IF NOT EXISTS daily_events(
    id IDENTITY NOT NULL PRIMARY KEY,
    difficulty VARCHAR,
    event_name VARCHAR,
    question VARCHAR,
    variant1 VARCHAR,
    variant2 VARCHAR,
    variant3 VARCHAR,
    answer VARCHAR,
    question_scores INTEGER
    
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
