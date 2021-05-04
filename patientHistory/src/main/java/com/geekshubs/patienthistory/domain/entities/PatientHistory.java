package com.geekshubs.patienthistory.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name="PATIENTHISTORY")
public class PatientHistory {
    @Id
    @Column(name="uuid", length=16, unique= true, nullable=false, insertable = false,updatable = false)
    private String uuid= UUID.randomUUID().toString();

    @Column(name="patient_name")
    private String patientName;

    @Column(name="patient_last_name")
    private String patientLastName;

    @Column(name="patient_uuid")
    private String patientUuid;

    @Column
    private String doctor;

    @Column
    private String specialty;

    @OneToMany(cascade =CascadeType.ALL)
    @JoinColumn(name="cab_uuid")
    private List<PatientLineHistory> patientLineHistory;



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
