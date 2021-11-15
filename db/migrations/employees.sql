DROP TABLE IF EXISTS Employees;
CREATE TABLE Employees (
    id UUID NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);