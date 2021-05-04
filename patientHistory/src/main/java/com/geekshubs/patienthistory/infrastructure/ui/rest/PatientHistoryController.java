package com.geekshubs.patienthistory.infrastructure.ui.rest;


import com.geekshubs.patienthistory.app.services.PatientHistoryService;
import com.geekshubs.patienthistory.app.services.PatientLineHistoryService;
import com.geekshubs.patienthistory.domain.entities.PatientHistory;
import com.geekshubs.patienthistory.domain.entities.PatientLineHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.ws.rs.PathParam;

@RestController
@RequestMapping("/patients")
public class PatientHistoryController {

    private Logger log = LoggerFactory.getLogger(PatientHistoryController.class);

    private PatientLineHistoryService patientLineHistoryService;
    private PatientHistoryService patientHistoryService;
    public PatientHistoryController(PatientLineHistoryService patientLineHistoryService, PatientHistoryService patientHistoryService){
        this.patientLineHistoryService= patientLineHistoryService;
        this.patientHistoryService = patientHistoryService;

    }


    @PostMapping("/{uuid}")
    public ResponseEntity<PatientLineHistory>saveLine(@RequestBody PatientLineHistory patientLineHistory,
                                                  @PathVariable("uuid") String uuid) {

        try {

            PatientLineHistory result = patientLineHistoryService.save(uuid, patientLineHistory);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch(Exception e){

            log.error(e.getMessage());
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);

        }


    }

    @GetMapping("/getallhistory/{uuid}")
    public Flux<PatientHistory> getAllHistory(@PathVariable("uuid") String uuid) {


        Flux<PatientHistory> result = Flux.just(patientHistoryService.getAllHistoryByUuid(uuid).get());
        return result;
    }
}
