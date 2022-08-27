package com.example.medical.service;

import com.example.medical.model.Medical;

import java.util.List;

public interface IMedicalService {
    List<Medical> getAll();

    List<Medical> findByName(String name);

    Medical findById(int id);

    void save(Medical medical);

    void update(Medical medical);

    void delete(int id);
}
