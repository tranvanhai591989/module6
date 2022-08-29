package com.example.medical.service;

import com.example.medical.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> getALL();

    Optional<Patient> findById(int id);
}
