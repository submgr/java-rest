--Набор тестовых данных
DELETE
FROM recycling_points;


DELETE
FROM users;


INSERT INTO users (login, password)
VALUES ('Anatoly',
        '123');


INSERT INTO users (login, password)
VALUES ('Aram',
        '456');


INSERT INTO recycling_points (city, latitude, longitude, specialization, organization, phone, reception_days)
VALUES ('Курск',
        51.720950,
        36.212637,
        'Сбор металлолома',
        'ЛСК Курск',
        '+7 (919) 176-31-33',
        'Пн-Сб до 18:00');


INSERT INTO recycling_points (city, latitude, longitude, specialization, organization, phone, reception_days)
VALUES ('Курск',
        51.733703,
        36.191296,
        NULL,
        NULL,
        NULL,
        NULL);