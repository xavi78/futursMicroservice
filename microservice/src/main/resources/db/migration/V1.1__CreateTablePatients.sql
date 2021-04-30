CREATE TABLE IF NOT EXISTS PATIENTS(
    uuid varchar(100) NOT NULL,
    name varchar(10) NOT NULL,
    lastName varchar(10) NOT NULL,
    dateCreated DATE,
    birthDate DATE,
    PRIMARY KEY (uuid )
    );