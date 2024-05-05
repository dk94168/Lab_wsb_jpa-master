package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class VisitTO implements Serializable {
    private Long id;

    private String description;

    private LocalDateTime time;

    private PatientTO patient;

    private DoctorTO doctor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public DoctorTO getDoctor() { return doctor; }

    public void setDoctor(DoctorTO doctor) { this.doctor = doctor; }

    public PatientTO getPatient() { return patient; }

    public void setPatient(PatientTO patient) { this.patient = patient; }

}
