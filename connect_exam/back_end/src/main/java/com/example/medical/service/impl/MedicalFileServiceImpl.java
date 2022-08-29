package com.example.medical.service.impl;

import com.example.medical.model.MedicalFile;
import com.example.medical.repository.MedicalFileRepository;
import com.example.medical.service.MedicalFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalFileServiceImpl implements MedicalFileService {

    @Autowired
    private MedicalFileRepository medicalRepository;

    @Override
    public List<MedicalFile> getAll() {
        return medicalRepository.getAll();
    }

    @Override
    public List<MedicalFile> findByName(String patientCode, String medicalFileCode, String patientName) {
        return medicalRepository.findByName("%" + patientCode + "%", "%" + medicalFileCode + "%","%" + patientName + "%");
    }

    @Override
    public MedicalFile findById(int id) {
        return medicalRepository.findById(id);
    }

    @Override
    public void save(MedicalFile medicalFile) {
        medicalRepository.save(medicalFile);
//        medicalRepository.saveMedicalFile(
//                medicalFile.getMedicalFileCode(), medicalFile.getPatientCode(), medicalFile.getPatient().getId(),
//                medicalFile.getStartDay(), medicalFile.getEndDay(), medicalFile.getReason(), medicalFile.getTreatment(), medicalFile.getDoctor());
    }

    @Override
    public void update(int id, MedicalFile medical) {
        medicalRepository.update(
                medical.getPatient().getId(),
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
