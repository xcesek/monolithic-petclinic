DROP TABLE revenue IF EXISTS;

CREATE TABLE revenue (
    id          INTEGER IDENTITY PRIMARY KEY,
    payment_date        DATE,
    cost        INTEGER NOT NULL
);
