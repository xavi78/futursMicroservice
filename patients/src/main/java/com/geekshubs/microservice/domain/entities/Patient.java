package com.geekshubs.microservice.domain.entities;



import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="PATIENTS")
public class Patient implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @Column(name="uuid", length=16, unique= true, nullable=false)
    private String uuid= UUID.randomUUID().toString();

    @Column
    private String name;

    @Column
    private String lastname;



    @Column
    private LocalDate birthdate;

    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datecreated = new Date();

    public Patient(){

    }

    public Patient(String name, String lastname, LocalDate birthdate) {
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public String getName()
    {
        return this.name;
    }
    
    public String getLastname()
    {
        return this.lastname;

    }


}
