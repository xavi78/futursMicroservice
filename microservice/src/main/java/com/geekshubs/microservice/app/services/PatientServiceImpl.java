package com.geekshubs.microservice.app.services;

import com.geekshubs.microservice.app.factories.FactoryPatients;
import com.geekshubs.microservice.domain.entities.Patient;
import com.geekshubs.microservice.domain.exceptions.PatientException;
import com.geekshubs.microservice.domain.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) throws PatientException {

        try {
            return patientRepository.save(patient);
        }catch(Exception ex){
            throw new PatientException(ex.getMessage());
        }
    }

    @Override
    public Mono<Patient> findPatientByUUID(String uuid) {
        //return Mono.just(FactoryPatients.toStream().findFirst().get());
         Mono<Patient> monoPatient = Mono.fromCallable(() -> new Patient(
                "pepe",
                "pepe",
                LocalDate.now()
        ));
         return monoPatient;
    }


}