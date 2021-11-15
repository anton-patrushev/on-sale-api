DROP TABLE IF EXISTS Companies;
CREATE TABLE Companies (
    id UUID NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL UNIQUE,
    website_url VARCHAR(50),
    email VARCHAR(50),
    phone VARCHAR(50),
    work_schedule VARCHAR(150),

    PRIMARY KEY (id)
);