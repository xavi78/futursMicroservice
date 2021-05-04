package com.geekshubs.patienthistory.domain.repositories;

import com.geekshubs.patienthistory.domain.entities.PatientHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PatientHistoryRepository extends CrudRepository<PatientHistory, String> {

    public Optional<PatientHistory> findByPatientUuid(String patientUuid);
}
