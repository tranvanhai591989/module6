package com.example.medical.service;

import com.example.medical.model.MedicalFile;

import java.util.List;

public interface MedicalFileService {
    List<MedicalFile> getAll();

    List<MedicalFile> findByName(String patientCode, String medicalFileCode, String patientName);

    MedicalFile findById(int id);

    void save(MedicalFile medical);

    void update(int id,MedicalFile medical);

    void delete(int id);
}
