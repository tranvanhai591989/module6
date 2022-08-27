package com.example.medical.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codePeoplePatient;
    @JsonBackReference
    @OneToMany(mappedBy = "codePeoplePatient")
    List<Patient> patientList;

    public Patient() {
    }

    public Patient(int id, String codePeoplePatient, List<Patient> patientList) {
        this.id = id;
        this.codePeoplePatient = codePeoplePatient;
        this.patientList = patientList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodePeoplePatient() {
        return codePeoplePatient;
    }

    public void setCodePeoplePatient(String codePeoplePatient) {
        this.codePeoplePatient = codePeoplePatient;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
}
