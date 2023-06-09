INSERT INTO Client (name, surname, login, password, age)
SELECT
    CONCAT('Name', CAST(FLOOR(RAND() * 100)As INTEGER)),
    CONCAT('Surname', CAST(FLOOR(RAND() * 100)As INTEGER)),
    CONCAT('login', CAST(FLOOR(RAND() * 100)As INTEGER)),
    CONCAT('password', CAST(FLOOR(RAND() * 100)As INTEGER)),
    CAST(FLOOR(RAND() * 100)As INTEGER)
FROM
    (SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION
     SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION
     SELECT 11 UNION SELECT 12 UNION SELECT 13 UNION SELECT 14 UNION SELECT 15 UNION
     SELECT 16 UNION SELECT 17 UNION SELECT 18 UNION SELECT 19 UNION SELECT 20 UNION
     SELECT 21 UNION SELECT 22 UNION SELECT 23 UNION SELECT 24 UNION SELECT 25 UNION
     SELECT 26 UNION SELECT 27 UNION SELECT 28 UNION SELECT 29 UNION SELECT 30 UNION
     SELECT 31 UNION SELECT 32 UNION SELECT 33 UNION SELECT 34 UNION SELECT 35 UNION
     SELECT 36 UNION SELECT 37 UNION SELECT 38 UNION SELECT 39 UNION SELECT 40 UNION
     SELECT 41 UNION SELECT 42 UNION SELECT 43 UNION SELECT 44 UNION SELECT 45 UNION
     SELECT 46 UNION SELECT 47 UNION SELECT 48 UNION SELECT 49 UNION SELECT 50) AS dummy;

-- Generowanie danych dla tabeli Note
INSERT INTO Note (title, clientid, content, publicationdate, link, category)
SELECT
    CONCAT('Title', CAST(FLOOR(RAND() * 100)As INTEGER)),
    (FLOOR(RAND() * 50) + 1),
    CONCAT('Content', CAST(FLOOR(RAND() * 100)As INTEGER)),
    CONCAT(
            LPAD(DAY(NOW()), 2, '0'), '-',
            LPAD(MONTH(NOW()), 2, '0'), '-',
            YEAR(NOW()), ' ',
            LPAD(HOUR(NOW()), 2, '0'), ':',
            LPAD(MINUTE(NOW()), 2, '0'), ':',
            LPAD(SECOND(NOW()), 2, '0')
        ),
    CONCAT('Link', CAST(FLOOR(RAND() * 100)As INTEGER)),
    CONCAT('Category', CAST(FLOOR(RAND() * 100)As INTEGER))
FROM
    (SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION
     SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION
     SELECT 11 UNION SELECT 12 UNION SELECT 13 UNION SELECT 14 UNION SELECT 15 UNION
     SELECT 16 UNION SELECT 17 UNION SELECT 18 UNION SELECT 19 UNION SELECT 20 UNION
     SELECT 21 UNION SELECT 22 UNION SELECT 23 UNION SELECT 24 UNION SELECT 25 UNION
     SELECT 26 UNION SELECT 27 UNION SELECT 28 UNION SELECT 29 UNION SELECT 30 UNION
     SELECT 31 UNION SELECT 32 UNION SELECT 33 UNION SELECT 34 UNION SELECT 35 UNION
     SELECT 36 UNION SELECT 37 UNION SELECT 38 UNION SELECT 39 UNION SELECT 40 UNION
     SELECT 41 UNION SELECT 42 UNION SELECT 43 UNION SELECT 44 UNION SELECT 45 UNION
     SELECT 46 UNION SELECT 47 UNION SELECT 48 UNION SELECT 49 UNION SELECT 50) AS dummy;