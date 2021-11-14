DROP TABLE IF EXISTS Offers;
CREATE TABLE Offers (
    id UUID NOT NULL UNIQUE,
    name VARCHAR(20) NOT NULL UNIQUE,
    description VARCHAR(300),
    sale VARCHAR(50),
    city_id UUID NOT NULL,
    created_at DATE NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (city_id) REFERENCES Cities(id)
);