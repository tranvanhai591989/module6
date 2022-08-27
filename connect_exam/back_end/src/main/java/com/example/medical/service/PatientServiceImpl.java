package com.example.medical.service;

import com.example.medical.model.Patient;
import com.example.medical.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getALL() {
        return patientRepository.getAll();
    }
}
