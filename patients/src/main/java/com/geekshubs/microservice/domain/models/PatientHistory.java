package com.geekshubs.microservice.domain.models;


import lombok.Data;

import java.io.Serializable;

@Data
public class PatientHistory  implements Serializable {



    private String uuid;
    private String patientName;
    private String patientLastName;
    private String patientUuid;
    private String doctor;
    private String specialty;
    //private List<PatientLineHistory> patientLineHistory;

    public PatientHistory()
    {

    }

    public PatientHistory(String patientName, String patientLastName, String patientUuid, String doctor, String specialty) {
        this.patientName = patientName;
        this.patientLastName = patientLastName;
        this.patientUuid = patientUuid;
        this.doctor = doctor;
        this.specialty = specialty;
    }
}
