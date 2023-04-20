-- Набор тестовых данных

-- Пользователи
-- Пароли шифруются bcrypt (для удобства у всех тестовых пользователей зашифрован пароль password)
INSERT INTO users (email, password, username, age, scores)
VALUES  ('admin@itcube46.ru', '$2a$10$ectAI3ADP4uCJx7l5SdGfugVD7mgrRxt9gIxCbprQ5VGFwCqNAVW2', 'Administrator', 5, 0),
        ('anatoly@itcube46.ru', '$2a$10$ectAI3ADP4uCJx7l5SdGfugVD7mgrRxt9gIxCbprQ5VGFwCqNAVW2', 'Murunov Anatoly', 17,0),
        ('roman@itcube46.ru', '$2a$10$ectAI3ADP4uCJx7l5SdGfugVD7mgrRxt9gIxCbprQ5VGFwCqNAVW2', 'Korovin Roman', 14,0),
        ('aram@itcube46.ru', '$2a$10$ectAI3ADP4uCJx7l5SdGfugVD7mgrRxt9gIxCbprQ5VGFwCqNAVW2', 'Virabyan Aram', 17,0);
--Викторины
INSERT INTO quizzes(title, theme, difficulty)
VALUES ('Страны', 'Путешествия','middle'),
        ('Философы', 'Известные личности','easy'),
        ('Исторические факты', 'История', 'hard');

--Вопросы
INSERT INTO questions (quiz_id, question, variant1, variant2, variant3, answer, question_scores)
VALUES  (1,'Какой город является столицей Италии?','Рим','Милан','Венеция', 'Рим', 5),
        (1,'В какой стране находится город Мачу-Пикчу?','Португалия','Испания','Перу','Перу', 10),
        (1,'Как называется самый высокий водопад в мире?','Виктория','Ниогарский','Игуасу','Ниогарский', 5),

        (2,'Кто ввёл первые определения, аксиомы и методы доказательств теорем?', 'Пифагор', 'Конфуций', 'Сократ', 'Пифагор', 5),
        (2,'Кто ученик Сократа?','Платон', 'Аристотель', 'Ксенофан', 'Платон', 10),
        (2,'Кто римский император из династии Антонинов и последний из пяти хороших императоров?', 'Марк Аврелий', 'Траян', 'Тит', 'Марк Аврелий', 5),

        (3, 'Какой человек правил Египтом в период своего правления в 1473-1458 годах до нашей эры?', 'Хеопс', 'Тутанхамон','Клеопатра' 'Клеопатра', 15),
        (3, 'Какой главный город Америки был основан белыми колонистами в 1607 году?', 'Отман', 'Джеймстаун', 'Дедвуд', 'Джеймстаун', 15),
        (3, 'Как назывался главный герой великой французской революции?', 'Робеспьер Максимилиан', 'Камиль Демулен', 'Жан-Поль Марат', 'Робеспьер Максимилиан', 15);

--
--Ежедневные ивенты (придумать нормальные вопросы)
INSERT INTO daily_events (quiz_id, event_date, difficulty, event_name, daily_scores)--сделать случайную выборку викторин
VALUES(1,'2023-04-20','middle','Страны', 10),
      (2,'2023-04-21','easy','Философы', 15),
      (3, '2023-04-22', 'hard', 'Исторические факты', 20);

--VALUES ('easy','Вопрос дня','Кто открыл атом?','Эрнест Резерфорд','Исаак Ньютон','Джеймс Джоуль','Эрнест Резерфорд',3);
--видео
INSERT INTO learning_videos(video_title, video_url, theme)
VALUES('История США на карте', 'https://www.youtube.com/watch?v=w1bWTB3S_4U', 'История'),
      ('Философия на пальцах', 'https://www.youtube.com/watch?v=ICMtwRpfcb0', 'Философия'),
      ('Венеция. Орёл и Решка. Перезагрузка', 'https://www.youtube.com/watch?v=Xiuce2-837Y', 'Путешествия');