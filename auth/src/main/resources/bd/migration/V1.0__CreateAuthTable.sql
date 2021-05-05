CREATE TABLE IF NOT EXISTS USERS(
    uuid varchar(100) NOT NULL,
    name varchar(10),
    last_name varchar(10),
    date_created DATE NOT NULL,
    username varchar(16) NOT NULL,
    password varchar(50) NOT NULL,
    PRIMARY KEY (uuid )
    );