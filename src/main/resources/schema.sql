CREATE TABLE Client (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    surname VARCHAR(255),
    login VARCHAR(255),
    password VARCHAR(255),
    age VARCHAR(255)
);

CREATE TABLE Notes (
    id LONG PRIMARY KEY AUTO_INCREMENT,
    user_Id LONG REFERENCES Client(id),
    title VARCHAR(255),
    content VARCHAR(255),
    publication_date TIMESTAMP,
    link VARCHAR(255),
    category VARCHAR(255)
);