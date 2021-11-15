DROP TABLE IF EXISTS Likes;
CREATE TABLE Likes (
    id UUID NOT NULL UNIQUE,
    offer_id UUID NOT NULL,
    employee_id UUID NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (offer_id) REFERENCES Offers(id),
    FOREIGN KEY (employee_id) REFERENCES Employees(id)
);