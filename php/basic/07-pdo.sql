CREATE DATABSE phpbasic;

USE phpbasic;

CREATE TABLE member (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

INSERT INTO member (name, email) VALUES ('Donald Trump', 'donald@example.com');