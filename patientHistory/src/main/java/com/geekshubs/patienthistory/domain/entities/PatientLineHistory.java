package com.geekshubs.patienthistory.domain.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name="HISTORYLINES")
public class PatientLineHistory {
    @Id
    @Column(name="uuid", length=16, unique= true, nullable=false, insertable = false, updatable = false)
    private String uuid= UUID.randomUUID().toString();

    @Column(name="acto")
    private String acto;

    @Column(name="prueba")
    private String prueba;

    @Column(name="doctor")
    private String doctor;

    @Column(name="date_created")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datecreated = new Date();


    @ManyToOne()
    @JoinColumn(name="cab_uuid")
    private PatientHistory patientHistory;

    public PatientLineHistory()
    {

    }

    public PatientLineHistory(String acto, String prueba, String doctor) {
        this.acto = acto;
        this.prueba = prueba;
        this.doctor = doctor;
    }
}