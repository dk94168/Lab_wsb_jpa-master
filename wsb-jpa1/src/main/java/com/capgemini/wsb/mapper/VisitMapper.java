package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

public final class VisitMapper {
    public static VisitTO mapToTO(final VisitEntity visitEntity)
    {
        if (visitEntity == null)
        {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());

        final PatientTO patientTO = new PatientTO();
        patientTO.setId(visitEntity.getPatient().getId());
        patientTO.setFirstName(visitEntity.getPatient().getFirstName());
        patientTO.setLastName(visitEntity.getPatient().getLastName());
        patientTO.setTelephoneNumber(visitEntity.getPatient().getTelephoneNumber());
        patientTO.setEmail(visitEntity.getPatient().getEmail());
        patientTO.setPatientNumber(visitEntity.getPatient().getPatientNumber());
        patientTO.setDateOfBirth(visitEntity.getPatient().getDateOfBirth());
        patientTO.setPremium(visitEntity.getPatient().getPremium());
        visitTO.setPatient(patientTO);

        final DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(visitEntity.getDoctor().getId());
        doctorTO.setFirstName(visitEntity.getDoctor().getFirstName());
        doctorTO.setLastName(visitEntity.getDoctor().getLastName());
        doctorTO.setTelephoneNumber(visitEntity.getDoctor().getTelephoneNumber());
        doctorTO.setEmail(visitEntity.getDoctor().getEmail());
        doctorTO.setDoctorNumber(visitEntity.getDoctor().getDoctorNumber());
        doctorTO.setSpecialization(visitEntity.getDoctor().getSpecialization());
        visitTO.setDoctor(doctorTO);

        return visitTO;
    }

    public static VisitEntity mapToEntity(final VisitTO visitTO)
    {
        if(visitTO == null)
        {
            return null;
        }
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());

        final PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(visitTO.getPatient().getId());
        patientEntity.setFirstName(visitTO.getPatient().getFirstName());
        patientEntity.setLastName(visitTO.getPatient().getLastName());
        patientEntity.setTelephoneNumber(visitTO.getPatient().getTelephoneNumber());
        patientEntity.setEmail(visitTO.getPatient().getEmail());
        patientEntity.setPatientNumber(visitTO.getPatient().getPatientNumber());
        patientEntity.setDateOfBirth(visitTO.getPatient().getDateOfBirth());
        patientEntity.setPremium(visitTO.getPatient().getPremium());
        visitEntity.setPatient(patientEntity);

        final DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(visitTO.getDoctor().getId());
        doctorEntity.setFirstName(visitTO.getDoctor().getFirstName());
        doctorEntity.setLastName(visitTO.getDoctor().getLastName());
        doctorEntity.setTelephoneNumber(visitTO.getDoctor().getTelephoneNumber());
        doctorEntity.setEmail(visitTO.getDoctor().getEmail());
        doctorEntity.setDoctorNumber(visitTO.getDoctor().getDoctorNumber());
        doctorEntity.setSpecialization(visitTO.getDoctor().getSpecialization());
        visitEntity.setDoctor(doctorEntity);

        return visitEntity;
    }
}
