package com.geekshubs.microservice.app.service;

import com.geekshubs.microservice.app.services.PatientService;
import com.geekshubs.microservice.domain.entities.Patient;
import com.geekshubs.microservice.domain.exceptions.PatientException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void addPatient() throws Exception
    {

        Patient patient= new Patient(
                "Pepe",
                "Manuel",
                LocalDate.now()
        );
        Patient result = patientService.savePatient(patient);
        assertThat(patient.getName()).isEqualTo(result.getName());


    }



}
