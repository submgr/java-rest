-- Пользователи
CREATE TABLE IF NOT EXISTS users (
    id IDENTITY NOT NULL PRIMARY KEY,
    email VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    username VARCHAR,
    age INTEGER,
    scores INTEGER DEFAULT 0
);

--Виктрины
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

    FOREIGN KEY (quiz_id) REFERENCES quizzes(id) ON DELETE CASCADE

);

-- Ежедневные события
CREATE TABLE IF NOT EXISTS daily_events(
    id IDENTITY NOT NULL PRIMARY KEY,
    quiz_id BIGINT NOT NULL,
    event_date DATE NOT NULL,
    difficulty VARCHAR,
    event_name VARCHAR,
    daily_scores INTEGER NOT NULL,

    FOREIGN KEY (quiz_id) REFERENCES quizzes(id) ON DELETE CASCADE
);
--
CREATE TABLE IF NOT EXISTS learning_videos (
    id IDENTITY NOT NULL PRIMARY KEY,
    video_title VARCHAR,
    video_url VARCHAR,
    theme VARCHAR
);

