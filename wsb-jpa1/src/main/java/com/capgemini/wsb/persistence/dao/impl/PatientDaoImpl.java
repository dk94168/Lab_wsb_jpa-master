package com.capgemini.wsb.persistence.dao.impl;

import java.util.List;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{

    @Override
    public List<PatientEntity> findByPatientLastName(String pLastName){
        return entityManager.createQuery("SELECT pat FROM PatientEntity pat WHERE pat.lastName = :param1", PatientEntity.class).setParameter("param1", pLastName).getResultList();

    }

    @Override
    public List<PatientEntity> findByVisitPatientID(Long pID){
        return entityManager.createQuery("SELECT pat FROM PatientEntity pat JOIN pat.visit vis WHERE pat.id = :param1", PatientEntity.class).setParameter("param1", pID).getResultList();

    }

    @Override
    public List<PatientEntity> findByMyTableColumnOfAllPatient(boolean pPremium){
        // Ze względu, że dodana kolumna jest typu boolean można tylko użyć wartości true or false

        return entityManager.createQuery("SELECT DISTINCT pat FROM PatientEntity pat WHERE pat.premium = :param1", PatientEntity.class).setParameter("param1", pPremium).getResultList();

    }

    @Override
    public List<PatientEntity> findByMinNumberOfVisits(Long pVisits){
        return entityManager.createQuery("SELECT pat FROM PatientEntity pat JOIN pat.visit vis GROUP BY pat HAVING count(pat.visit) > :param1", PatientEntity.class).setParameter("param1", pVisits).getResultList();

    }
}