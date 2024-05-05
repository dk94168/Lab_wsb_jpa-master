package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.ArrayList;
import java.util.List;

public final class PatientMapper {
    public static PatientTO mapToTO(final PatientEntity patientEntity)
    {
        if (patientEntity == null)
        {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setPremium(patientEntity.getPremium());

        List<VisitTO> visitTOS = new ArrayList<>();
        for(VisitEntity visitEntity : patientEntity.getVisit()){
            VisitTO visitTO = new VisitTO();
            visitTO.setId(visitEntity.getId());
            visitTO.setDescription(visitEntity.getDescription());
            visitTO.setTime(visitEntity.getTime());
            visitTOS.add(visitTO);
        }
        patientTO.setVisit(visitTOS);

        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO)
    {
        if(patientTO == null)
        {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setPremium(patientTO.getPremium());

        List<VisitEntity> visitEntities = new ArrayList<>();
        for(VisitTO visitTO : patientTO.getVisit()){
            VisitEntity visitEntity = new VisitEntity();
            visitEntity.setId(visitTO.getId());
            visitEntity.setDescription(visitTO.getDescription());
            visitEntity.setTime(visitTO.getTime());
            visitEntities.add(visitEntity);
        }
        patientEntity.setVisit(visitEntities);

        return patientEntity;
    }
}
