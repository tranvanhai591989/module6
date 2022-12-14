package com.example.medical.model;

import javax.persistence.*;

@Entity
public class MedicalFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String medicalFileCode;
    private String patientCode;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;
    private String startDay;
    private String endDay;

    private String reason;
    private String treatment;
    private String doctor;

    public MedicalFile() {
    }

    public MedicalFile(int id, String medicalFileCode, String patientCode,
                       Patient patient, String startDay, String endDay,
                       String reason, String treatment,
                       String doctor) {
        this.id = id;
        this.medicalFileCode = medicalFileCode;
        this.patientCode = patientCode;
        this.patient = patient;
        this.startDay = startDay;
        this.endDay = endDay;
        this.reason = reason;
        this.treatment = treatment;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicalFileCode() {
        return medicalFileCode;
    }

    public void setMedicalFileCode(String medicalFileCode) {
        this.medicalFileCode = medicalFileCode;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
