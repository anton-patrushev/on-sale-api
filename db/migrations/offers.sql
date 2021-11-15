DROP TABLE IF EXISTS Offers;
CREATE TABLE Offers (
    id UUID NOT NULL UNIQUE,
    company_id UUID NOT NULL,
    description VARCHAR(300),
    sale VARCHAR(50),
    city_id UUID NOT NULL,
    created_at DATE NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (company_id) REFERENCES Companies(id),
    FOREIGN KEY (city_id) REFERENCES Cities(id)
);