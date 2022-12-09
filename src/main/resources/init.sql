--Набор тестовых данных
DELETE
FROM recycling_points;


DELETE
FROM users;


INSERT INTO users (login,password)
VALUES ('Anatoly',
        '123');


INSERT INTO users (login,password)
VALUES ('Aram',
        '456');

/*
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Курск',
        51.720950,
        36.212637,
        'metal',
        'ЛСК Курск',
        '+7 (919) 176-31-33',
        'Пт-Сб до 18:00');
*/

--Курск
--5
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Курск',
        51.643452,
        36.122982,
        'metal,paper,plastic',
        'ЭкоЛогика',
        '+7 (4712) 37-74-24',
        'Пн-Пт 8:00 — 17:00, Сб 8:00 — 14:00');

--6
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Курск',
        51.757692,
        36.123899,
        'paper,plastic',
        'Эйва',
        '+7 (930) 765-57-77',
        'Пн-Вс 8:00 — 20:00');

--7
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Курск',
        51.758639, 
        36.153094,
        'metal',
        'Курские металлы плюс',
        '+7 (910) 313-11-48',
        'Пн-Пт 9:00 — 18:00, Сб 9:00 — 15:00');

--8
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Курск',
        51.740496, 
        36.234894,
        'metal',
        'Титан-курск',
        '+7 (4712) 34-24-30',
        'Пн-Вс 9:00 — 18:00');

--9
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Курск',
        51.735125, 
        36.240949,
        'metal',
        'Армета',
        '+7 (800) 505-02-76',
        'Пн-Пт 8:00 — 17:00');

--10
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Курск',
        51.717407, 
        36.198522,
        'metal',
        'Дилер',
        '+7 (4712) 20-01-00',
        'Пн-Пт 9:00 — 17:00');

--11
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Курск',
        51.710114, 
        36.141612,
        'glass,plastic,paper',
        'ЭкоДом',
        '+7 (951) 332-84-38',
        'Пн-Вс 8:00 — 20:00');

--12
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Курск',
        51.644799,
        36.113325,
        'glass,plastic,paper',
        'Торгвторсервис',
        '+7 (4712) 37-77-01',
        'Пн-Чт 8:00 — 17:00, Пт 8:00 — 16:00');

--13
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Курск',
        51.802550,
        36.139042,
        'glass,plastic,paper',
        'Воронежская Бумажная фабрика',
        '+7 (961) 196-64-13',
        'Пн-Пт 8:00 — 17:00');

--15
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Курск',
        51.660127, 
        36.142898,
        'glass,plastic,paper',
        'Курсктарапереработка',
        '+7 (4712) 39-91-35',
        'Пн-Пт 8:00 — 18:00');

--Самара

--17
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Самара',
        53.130634, 
        50.151218,
        'metal',
        'ТехПром',
        '+7 (930) 035-21-00',
        'Пн-Вс 8:00 — 20:00');


--19
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Самара',
        53.270135, 
        50.220900,
        'metal,plastic,paper',
        'Втор-Групп',
        '+7 (902) 237-63-88',
        'Пн-Вс круглосуточно');

--20
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Самара',
        53.189711, 
        50.111305,
        'metal,plastic,paper',
        'Приемный пункт Втормаркет',
        '+7 (902) 237-63-88',
        'Пн-Пт 8:00 — 18:00, Сб-Вс 8:00 — 14:00');

--22
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Самара',
        53.221339, 
        50.147705,
        'plastic,paper',
        'ТБО Архив',
        '+7 (846) 989-00-47',
        'Пн-Пт 8:00 — 19:00, Сб-Вс 8:00 — 16:00');


--24
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Самара',
        53.445204, 
        50.368233,
        'paper',
        'БелВторСамара',
        '+7 (927) 659-98-41',
        'Пн-Вс круглосуточно');

--25
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Самара',
        53.181877, 
        50.177754,
        'metal,plastic,paper',
        'Чистая Губерния',
        '+7 (937) 188-81-23',
        'Пн-Пт 9:00 — 18:00, Сб 9:00 — 16:00');

--26
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,phone,reception_days)
VALUES ('Самара',
        53.136020, 
        50.132014,
        'glass,plastic,paper',
        'Наш город',
        '+7 (927) 755-82-80',
        'Пн-Пт 8:00 — 17:00, Сб 9:00 — 15:00');

--34
INSERT INTO recycling_points (city,latitude,longitude,specialization,reception_days)
VALUES ('Самара',
        53.324904, 
        50.304012,
        'glass,plastic',
        'Пн-Вс круглосуточно');

--Курск
--35
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,reception_days)
VALUES ('Курск',
        51.657227, 
        36.067961,
        'paper,plastic',
        'ТД Успех',
        'Пн-Вс 9:00 — 17:00');
--35
--Курск

--36
INSERT INTO recycling_points (city,latitude,longitude,specialization,organization,reception_days)
VALUES ('Самара',
        53.193170, 
        50.274835,
        'glass,plastic,paper',
        'Корсо',
        'Пн-Вс 7:00 — 22:00');