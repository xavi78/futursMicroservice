package com.geekshubs.microservice.app.services;

import com.geekshubs.microservice.domain.entities.Patient;
import reactor.core.publisher.Mono;

public interface PatientService {

    Patient savePatient(Patient patient) throws Exception;

    Mono<Patient> findPatientByUUID(String uuid);
}
