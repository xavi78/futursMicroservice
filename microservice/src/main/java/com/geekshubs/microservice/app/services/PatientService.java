package com.geekshubs.microservice.app.services;

import com.geekshubs.microservice.domain.entities.Patient;

public interface PatientService {

    Patient savePatient(Patient patient) throws Exception;

}
