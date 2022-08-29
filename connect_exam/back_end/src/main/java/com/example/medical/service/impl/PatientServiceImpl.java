package com.example.medical.service.impl;

import com.example.medical.model.Patient;
import com.example.medical.repository.PatientRepository;
import com.example.medical.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getALL() {
        return patientRepository.getAll();
    }

    @Override
    public Optional<Patient> findById(int id) {
        return patientRepository.findById(id);
    }
}
