CREATE TABLE IF NOT EXISTS HISTORYLINES(
    uuid varchar(100) NOT NULL,
    acto varchar(255) NOT NULL,
    prueba varchar(255) NOT NULL,
    date_created DATE,
    doctor varchar(100),
    cab_uuid varchar(100) NOT NULL,
    PRIMARY KEY (uuid)
    );