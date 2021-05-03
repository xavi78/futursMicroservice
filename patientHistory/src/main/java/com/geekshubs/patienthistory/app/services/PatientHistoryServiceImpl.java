package com.geekshubs.patienthistory.app.services;

import com.geekshubs.patienthistory.domain.entities.PatientHistory;
import com.geekshubs.patienthistory.domain.exceptions.PatientHistoryException;
import com.geekshubs.patienthistory.domain.repositories.PatientHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService{

    private PatientHistoryRepository patientHistoryRepository;

    public PatientHistoryServiceImpl(PatientHistoryRepository patientHistoryRepository){
        this.patientHistoryRepository  = patientHistoryRepository;
    }

    @Override
    public void save(PatientHistory patientHistory) throws PatientHistoryException {
        PatientHistory patientReturn= null;
        try {
                patientHistoryRepository.save(patientHistory);
        }catch(Exception ex){
            throw new PatientHistoryException(ex.getMessage());
        }

    }
}
