package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import com.capgemini.wsb.persistence.enums.Specialization;

import java.io.Serializable;
import java.util.List;
import java.lang.String;

public class DoctorTO implements Serializable{
    private long id;

    private String firstName;

    private String lastName;

    private String telephoneNumber;

    private String email;

    private String doctorNumber;

    private Specialization specialization;

    private AddressTO address;
    private List<VisitTO> visit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDoctorNumber() {
        return doctorNumber;
    }

    public void setDoctorNumber(String doctorNumber) {
        this.doctorNumber = doctorNumber;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public AddressTO getAddress() { return address; }

    public void setAddress(AddressTO address){ this.address = address; }

    public List<VisitTO> getVisit() { return visit; }

    public void setVisit(List<VisitTO> visit) { this.visit = visit; }

}
