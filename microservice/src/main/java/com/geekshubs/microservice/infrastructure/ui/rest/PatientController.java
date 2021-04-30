package com.geekshubs.microservice.infrastructure.ui.rest;

import com.geekshubs.microservice.domain.entities.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patients")
public class PatientController {

    @RequestMapping(value="", method= RequestMethod.GET, produces="application/json" )
    public ResponseEntity<Void> home()
    {
        return new ResponseEntity("Es una prueba", HttpStatus.OK);
    }


    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient)
    {
        return null;
    }


}
