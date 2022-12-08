DELETE
FROM tasks;


DELETE
FROM users;


INSERT INTO users (name, password)
VALUES ('Anatoly',
        '123');


INSERT INTO users (name, password)
VALUES ('Aram',
        '456');


INSERT INTO tasks (user_id, title, description, date_of_creation, date_of_completion)
VALUES (1,
        'Справка',
        'Взять справку в поликлинике',
        '2022-12-06',
        NULL);


INSERT INTO tasks (user_id, title, description, date_of_creation, date_of_completion)
VALUES (1,
        'Хакатон',
        'Победить',
        '2022-12-11',
        NULL);


INSERT INTO tasks (user_id, title, description, date_of_creation, date_of_completion)
VALUES (2,
        'Хакатон',
        'Победить',
        '2022-12-11',
        NULL);