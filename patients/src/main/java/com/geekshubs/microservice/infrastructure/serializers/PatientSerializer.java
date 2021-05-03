package com.geekshubs.microservice.infrastructure.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekshubs.microservice.domain.entities.Patient;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class PatientSerializer implements Serializer<Patient> {

    private Logger logger = LoggerFactory.getLogger(PatientSerializer.class);


    @Override
    public byte[] serialize(String s, Patient p) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{

            retVal= objectMapper.writeValueAsString(p).getBytes();

        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return retVal;
    }

    @Override
    public void configure(Map configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }




    @Override
    public void close() {
        Serializer.super.close();
    }
}
