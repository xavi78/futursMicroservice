package com.geekshubs.patienthistory.app.services;

import com.geekshubs.patienthistory.domain.entities.PatientHistory;
import com.geekshubs.patienthistory.domain.entities.PatientLineHistory;
import com.geekshubs.patienthistory.domain.exceptions.PatientHistoryNotFoundException;
import com.geekshubs.patienthistory.domain.repositories.PatientHistoryRepository;
import com.geekshubs.patienthistory.domain.repositories.PatientLineHistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientLineHistoryServiceImpl implements PatientLineHistoryService{

    private PatientLineHistoryRepository patientLineHistoryRepository;
    private PatientHistoryRepository patientHistoryRepository;
    private Logger log = LoggerFactory.getLogger(PatientLineHistoryServiceImpl.class);

    public PatientLineHistoryServiceImpl(PatientLineHistoryRepository patientLineHistoryRepository, PatientHistoryRepository patientHistoryRepository){
            this.patientLineHistoryRepository = patientLineHistoryRepository;
            this.patientHistoryRepository= patientHistoryRepository;
    }

    @Override
    public PatientLineHistory save(String patientUUID, PatientLineHistory patientLineHistory) {

        try {
            Optional<PatientHistory> patientHistory = patientHistoryRepository.findByPatientUuid(patientUUID);
           // if (!patientHistory.isPresent()) PatientHistoryNotFoundException(e.getMessage());
            patientLineHistory.setCabUuid(patientHistory.get().getUuid());

            //patientLineHistory.setPatientHistory(patientHistory.get());
            return patientLineHistoryRepository.save(patientLineHistory);
        }catch(Exception e){
            throw new PatientHistoryNotFoundException(e.getMessage());
        }
    }
}
