package com.geekshubs.patienthistory.domain.exceptions;

import javassist.NotFoundException;

public class PatientHistoryNotFoundException extends RuntimeException {

    public PatientHistoryNotFoundException(String msg){
        super(msg);
    }
}
