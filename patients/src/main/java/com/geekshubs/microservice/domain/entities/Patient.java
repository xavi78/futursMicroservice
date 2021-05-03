package com.geekshubs.microservice.domain.entities;



import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
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
    @JsonSerialize(using = LocalDateSerializer.class)
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



}
