package com.geekshubs.patienthistory.app.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PatientCreatedKafkaServiceImpl implements PatientCreatedKafkaService {
    Logger log = LoggerFactory.getLogger(PatientCreatedKafkaServiceImpl.class);


    @Override
    @KafkaListener(topics="patients")
    public void consume(String message) {
        log.info("Mensaje recibido ->" + message.toString());
    }
}
