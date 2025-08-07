CREATE TABLE Tickets
(
    id SERIAL NOT NULL,
    film VARCHAR(60) NOT NULL,
    amount INTEGER NOT NULL,
    name VARCHAR(60) NOT NULL,
    surname VARCHAR(60) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(60) NOT NULL,
    PRIMARY KEY (id)
);

