package com.geekshubs.microservice.domain.repositories;

import com.geekshubs.microservice.domain.entities.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, String> {
}
