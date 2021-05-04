package com.geekshubs.patienthistory.app.services;

import com.geekshubs.patienthistory.domain.entities.PatientLineHistory;

public interface PatientLineHistoryService {

    public PatientLineHistory save(String patientUUID, PatientLineHistory patientLineHistory) throws Exception;
}
