CREATE TYPE CUSTOMER_TYPE AS ENUM ('Corporation', 'Individual', 'Premier', 'Other');

CREATE TABLE Customer
(
    id           SERIAL PRIMARY KEY,
    number       TEXT,
    type         CUSTOMER_TYPE,
    name         TEXT,
    country_code VARCHAR(10),
    state        TEXT,
    postal_code  VARCHAR(10),
    city         TEXT,
    address      TEXT,
    phone        VARCHAR(15)
);

CREATE TYPE ACCOUNT_TYPE AS ENUM ('Checking', 'Savings', 'Loan', 'Other');

CREATE TABLE account
(
    id          SERIAL PRIMARY KEY,
    number      TEXT,
    type        ACCOUNT_TYPE,
    customer_id SERIAL REFERENCES Customer (id)
);

CREATE TABLE card
(
    id           SERIAL PRIMARY KEY,
    card_number  TEXT,
    credit_limit NUMERIC,
    customer_id SERIAL REFERENCES account (id)
);
