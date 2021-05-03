package com.geekshubs.patienthistory.domain.repositories;

import com.geekshubs.patienthistory.domain.entities.PatientHistory;
import org.springframework.data.repository.CrudRepository;

public interface PatientHistoryRepository extends CrudRepository<PatientHistory, String> {
}
