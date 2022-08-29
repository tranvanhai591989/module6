package com.example.medical.dto;

import com.example.medical.model.Patient;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

public class MedicalFileDto implements Validator {
    private int id;
    @NotBlank
    @Pattern(regexp = "^(BA-)+d{3}$")
    private String medicalFileCode;
    @NotBlank
    @Pattern(regexp = "^(BN-)+d{3}$")
    private String patientCode;
    private Patient patient;
    @NotBlank
    private String startDay;
    @NotBlank
    private String endDay;
    @NotBlank
    @Pattern(regexp = "[A-Z]+[a-z]?$")
    private String reason;
    @NotBlank
    @Pattern(regexp = "[A-Z]+[a-z]?$")
    private String treatment;
    @NotEmpty
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "Wrong format Name")
    private String doctor;

    public MedicalFileDto() {
    }

    public void validate(MedicalFileDto medicalFileDto, BindingResult bindingResult) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MedicalFileDto medicalFileDto = (MedicalFileDto) target;

    }
}
