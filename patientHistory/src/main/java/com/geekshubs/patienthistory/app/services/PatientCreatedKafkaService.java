package com.geekshubs.patienthistory.app.services;

public interface PatientCreatedKafkaService {

    public void consume(String message);
}
