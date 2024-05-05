package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.ArrayList;
import java.util.List;

public final class DoctorMapper {
    public static DoctorTO mapToTO(final DoctorEntity doctorEntity){
        if(doctorEntity == null){
            return null;
        }

        final DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctorEntity.getId());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTO.setEmail(doctorEntity.getEmail());
        doctorTO.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorTO.setSpecialization(doctorEntity.getSpecialization());

        List<VisitTO> visitTOS = new ArrayList<>();
        for(VisitEntity visitEntity : doctorEntity.getVisit()){
            VisitTO visitTO = new VisitTO();
            visitTO.setId(visitEntity.getId());
            visitTO.setDescription(visitEntity.getDescription());
            visitTO.setTime(visitEntity.getTime());
            visitTOS.add(visitTO);
        }
        doctorTO.setVisit(visitTOS);

        return doctorTO;
    }

    public static DoctorEntity mapToEntity(final DoctorTO doctorTO)
    {
        if(doctorTO == null)
        {
            return null;
        }
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorTO.getId());
        doctorEntity.setFirstName(doctorTO.getFirstName());
        doctorEntity.setLastName(doctorTO.getLastName());
        doctorEntity.setTelephoneNumber(doctorTO.getTelephoneNumber());
        doctorEntity.setEmail(doctorTO.getEmail());
        doctorEntity.setDoctorNumber(doctorTO.getDoctorNumber());
        doctorEntity.setSpecialization(doctorTO.getSpecialization());

        List<VisitEntity> visitEntities = new ArrayList<>();
        for(VisitTO visitTO : doctorTO.getVisit()){
            VisitEntity visitEntity = new VisitEntity();
            visitEntity.setId(visitTO.getId());
            visitEntity.setDescription(visitTO.getDescription());
            visitEntity.setTime(visitTO.getTime());
            visitEntities.add(visitEntity);
        }
        doctorEntity.setVisit(visitEntities);

        return doctorEntity;
    }
}
