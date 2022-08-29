package com.example.medical.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @OneToMany(mappedBy = "patient")
    @JsonBackReference
    private Set<MedicalFile> medicalFileList;

    public Patient() {
    }

    public Patient(int id, String name, Set<MedicalFile> medicalFileList) {
        this.id = id;
        this.name = name;
        this.medicalFileList = medicalFileList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MedicalFile> getMedicalFileList() {
        return medicalFileList;
    }

    public void setMedicalFileList(Set<MedicalFile> medicalFileList) {
        this.medicalFileList = medicalFileList;
    }
}
