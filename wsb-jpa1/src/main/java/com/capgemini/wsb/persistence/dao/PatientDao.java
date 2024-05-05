package com.capgemini.wsb.persistence.dao;

import java.util.List;
import com.capgemini.wsb.persistence.entity.PatientEntity;

public interface PatientDao extends Dao<PatientEntity, Long>
{

    List<PatientEntity> findByPatientLastName(String pLastName);

    List<PatientEntity> findByVisitPatientID(Long pID);

    List<PatientEntity> findByMyTableColumnOfAllPatient(boolean pPremium);

    List<PatientEntity> findByMinNumberOfVisits(Long pVisits);
}

