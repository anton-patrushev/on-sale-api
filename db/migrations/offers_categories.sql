DROP TABLE IF EXISTS Offers_Categories;
CREATE TABLE Offers_Categories (
    offer_id UUID NOT NULL,
    category_id UUID NOT NULL,

    FOREIGN KEY (offer_id) REFERENCES Offers(id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES Categories(id) ON DELETE CASCADE
);