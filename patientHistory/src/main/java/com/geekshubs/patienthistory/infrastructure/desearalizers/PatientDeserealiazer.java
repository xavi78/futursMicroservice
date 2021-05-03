package com.geekshubs.patienthistory.infrastructure.desearalizers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekshubs.patienthistory.domain.models.Patient;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class PatientDeserealiazer  implements Deserializer{

    private Logger logger = LoggerFactory.getLogger(PatientDeserealiazer.class);
    @Override
    public Patient deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        Patient patient = null;
        try{
            patient = mapper.readValue(bytes, Patient.class);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return patient;
    }
}
