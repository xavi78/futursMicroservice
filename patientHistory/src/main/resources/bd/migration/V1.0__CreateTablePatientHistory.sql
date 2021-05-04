CREATE TABLE IF NOT EXISTS PATIENTHISTORY(
    uuid varchar(100) NOT NULL,
    patient_name varchar(10) NOT NULL,
    patient_last_name varchar(10) NOT NULL,
    patient_uuid varchar(100) NOT NULL,
    doctor varchar(100),
    specialty varchar(100),
    PRIMARY KEY (uuid )
    );