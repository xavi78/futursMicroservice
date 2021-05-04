package com.geekshubs.patienthistory.infrastructure.ui.rest;


import com.geekshubs.patienthistory.app.services.PatientLineHistoryService;
import com.geekshubs.patienthistory.domain.entities.PatientHistory;
import com.geekshubs.patienthistory.domain.entities.PatientLineHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;

@RestController
@RequestMapping("/patients")
public class PatientHistoryController {

    private PatientLineHistoryService patientLineHistoryService;
    public PatientHistoryController(PatientLineHistoryService patientLineHistoryService){
        this.patientLineHistoryService= patientLineHistoryService;

    }


    @PostMapping("/{uuid}")
    public ResponseEntity<PatientLineHistory>saveLine(@RequestBody PatientLineHistory patientLineHistory,
                                                  @PathVariable("uuid") String uuid) throws Exception {

        try {

            PatientLineHistory result = patientLineHistoryService.save(uuid, patientLineHistory);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch(Exception e){

            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);

        }


    }



}
