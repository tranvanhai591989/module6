package com.example.medical.service.impl;

import com.example.medical.model.MedicalFile;
import com.example.medical.repository.MedicalRepository;
import com.example.medical.service.MedicalFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalServiceImpl implements MedicalFileService {

    @Autowired
    private MedicalRepository medicalRepository;

    @Override
    public List<MedicalFile> getAll() {
        return medicalRepository.getAll();
    }

    @Override
    public List<MedicalFile> findByName(String name) {
        return medicalRepository.findByName(name);
    }

    @Override
    public MedicalFile findById(int id) {
        return medicalRepository.findById(id);
    }

    @Override
    public void save(MedicalFile medical) {
        medicalRepository.save(medical);
    }

    @Override
    public void update(int id,MedicalFile medical) {
        medicalRepository.update(
                medical.getMedicalFileCode(),
                medical.getPatientCode(),
                medical.getPatient().getName(),
                medical.getStartDay(),
                medical.getEndDay(),
                medical.getReason(),
                medical.getTreatment(),
                medical.getDoctor(),
                medical.getId());
    }

    @Override
    public void delete(int id) {
        medicalRepository.delete(id);
    }
}
