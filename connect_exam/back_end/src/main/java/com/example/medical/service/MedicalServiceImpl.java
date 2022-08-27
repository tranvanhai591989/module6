package com.example.medical.service;

import com.example.medical.model.Medical;
import com.example.medical.repository.MedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalServiceImpl implements IMedicalService {

    @Autowired
    private MedicalRepository medicalRepository;

    @Override
    public List<Medical> getAll() {
        return medicalRepository.getAll();
    }

    @Override
    public List<Medical> findByName(String name) {
        return medicalRepository.findByName(name);
    }

    @Override
    public Medical findById(int id) {
        return medicalRepository.findById(id);
    }

    @Override
    public void save(Medical medical) {
        medicalRepository.save(medical);
    }

    @Override
    public void update(Medical medical) {
        medicalRepository.update(medical.getCodePatient(),
                medical.getNamePeoplePatient(),
                medical.getNamePeoplePatient(),
                medical.getDayStart(),
                medical.getDayEnd(),
                medical.getReason(),
                medical.getMethod(),
                medical.getDoctor(),
                medical.getId());
    }

    @Override
    public void delete(int id) {
        medicalRepository.delete(id);
    }
}
