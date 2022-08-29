package com.example.medical.controller;

import com.example.medical.dto.PatientDto;
import com.example.medical.model.Patient;
import com.example.medical.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping()
    public ResponseEntity<List<Patient>> getAll() {
        List<Patient> patientList = patientService.getALL();
        if (patientList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Integer id) {
        Optional<Patient> patienter = patientService.findById(id);
        if (!patienter.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patienter.get(), HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity save(@RequestBody Patient patient) {
//        patientService.save(patient);
//        return new ResponseEntity(HttpStatus.OK);
//    }
//
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Patient> update(@PathVariable Integer id, @Validated @RequestBody PatientDto patienterDto, BindingResult bindingResult) {
//        Optional<Patient> currentPatient = patientService.findById(id);
//
//        if (bindingResult.hasFieldErrors()) {
//            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//        }
//
//        if (!currentPatienter.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        currentPatient.get().setName(patienterDto.getName());
//
//        patienterService.update(currentPatient.get());
//
//        return new ResponseEntity(currentPatient.get(), HttpStatus.OK);
//    }
}
