-- Набор тестовых данных

-- Пользователи
-- Пароли шифруются bcrypt (для удобства у всех тестовых пользователей зашифрован пароль password)
INSERT INTO users (email, password, username, age, scores)
VALUES  ('admin@itcube46.ru', '$2a$10$ectAI3ADP4uCJx7l5SdGfugVD7mgrRxt9gIxCbprQ5VGFwCqNAVW2', 'Administrator', 5, 0),
        ('anatoly@itcube46.ru', '$2a$10$ectAI3ADP4uCJx7l5SdGfugVD7mgrRxt9gIxCbprQ5VGFwCqNAVW2', 'Murunov Anatoly', 17,0),
        ('roman@itcube46.ru', '$2a$10$ectAI3ADP4uCJx7l5SdGfugVD7mgrRxt9gIxCbprQ5VGFwCqNAVW2', 'Korovin Roman', 14,0),
        ('aram@itcube46.ru', '$2a$10$ectAI3ADP4uCJx7l5SdGfugVD7mgrRxt9gIxCbprQ5VGFwCqNAVW2', 'Virabyan Aram', 17,0);
--Викторины
INSERT INTO quizzes(title,theme,difficulty)
VALUES ('Виды треугольников','Геометрия','easy'),
        ('Виды ','Геометрия','easy'),
        ('треугольников ','Геометрия','easy');

--Вопросы
INSERT INTO questions (quiz_id, question,variant1,variant2,variant3, answer, question_scores)
VALUES  (1,'Какая градусная сумма у углов треугольника?','180','360','120','180',3),
        (1,'Как называется треугольник, у которого все стороны равны?','Остроугольный','Равносторонний','Прямоугольный','Равносторонний',1),
        (1,'Сумма квадратов катетов равна квадрату гипотенузы в прямоугольном треугольнике - какя это теорема?','Теорема Эйлера','Нет правильного ответа','Теорема Пифагора','Теорема Пифагора',2);
--
--Ежедневные ивенты (придумать нормальные вопросы)
INSERT INTO daily_events (quiz_id,event_date,difficulty, event_name, daily_scores)--сделать случайную выборку викторин
VALUES(1,'2023-04-19','easy','Викторина Дня', 10),
      (1,'2023-04-20','easy','Викторина Дня1', 10);

--VALUES ('easy','Вопрос дня','Кто открыл атом?','Эрнест Резерфорд','Исаак Ньютон','Джеймс Джоуль','Эрнест Резерфорд',3);
--видео
INSERT INTO learning_videos(video_title,video_url,theme)
VALUES('Assembler','https://www.youtube.com/watch?v=015dEE3NnZg','Геометрия');