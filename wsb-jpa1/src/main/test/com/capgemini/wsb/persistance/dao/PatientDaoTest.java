package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.dao.AddressDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.dao.MedicalTreatmentDao;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest
{

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private MedicalTreatmentDao medicalTreatmentDao;

    @Transactional
    @Test
    public void testLab2FindPatientById() {
        // given

        // when
        PatientEntity patientEntity = patientDao.findOne(1L);

        // then
        assertThat(patientEntity).isNotNull();
        assertThat(patientEntity.getFirstName()).isEqualTo("Piotr");
        assertThat(patientEntity.getPremium()).isEqualTo(false);
    }

    @Transactional
    @Test
    public void testLab2Patient() {
        long patientID = 3;

        //given
            // Dane pacjenta, wizyt, adresów zostały dodane za pomocą poleceń INSERT w pliku data.sql

        long patientEntitiesNumBefore = patientDao.count();
        long doctorEntitiesNumBefore = doctorDao.count();
        long addressEntitiesNumBefore = addressDao.count();
        long visitEntitiesNumBefore = visitDao.count();
        long medicalTreatmentEntitiesNumBefore = medicalTreatmentDao.count();

        //when
            final PatientEntity saved = patientDao.getOne(patientID);
            // Dane zostały już wcześniej zapisane w bazie danych
            patientDao.delete(saved.getId());

        //then
            // Czy pacjent został usunięty
            final PatientEntity removed = patientDao.findOne( patientID);
            assertThat(removed).isNull();
            // Czy zgadza się nadal liczba doktorów
            assertThat(doctorDao.count()).isEqualTo(doctorEntitiesNumBefore);
            // Czy wizyta została usunięta
            assertThat(visitDao.count()).isEqualTo(visitEntitiesNumBefore - 1);
            // Czy adres pacjenta został usunięty
            assertThat(addressDao.count()).isEqualTo(addressEntitiesNumBefore - 1);
    }

    @Transactional
    @Test
    public void testFindByPatientLastName(){
        // given
        final String pLastName = "Kozioł";
        long expectedNumOfPatient = 1;

        // when
        final List<PatientEntity> pats = patientDao.findByPatientLastName(pLastName);

        // then
        assertThat(pats).isNotNull();
        assertThat(pats.size()).isEqualTo(expectedNumOfPatient);

        System.out.println("\n\nTest result FindByPatientLastName: " + pats.size() + "\n\n");
    }

    @Transactional
    @Test
    public void testFindByVisitPatientID(){
        // given
        final long pID = 2;
        long expectedNumOfVisits = 2;

        // when
        final List<PatientEntity> pats = patientDao.findByVisitPatientID(pID);

        // then
        assertThat(pats).isNotNull();
        assertThat(pats.size()).isEqualTo(expectedNumOfVisits);

        System.out.println("\n\nTest result FindByVisitPatientID: " + pats.size() + "\n\n");
    }

    @Transactional
    @Test
    public void testFindByMinNumberOfVisits(){
        // given
        final long pVisits = 1; // większe niż podana wartość
        long expectedNumOfVisits = 1;

        // when
        final List<PatientEntity> pats = patientDao.findByVisitPatientID(pVisits);

        // then
        assertThat(pats).isNotNull();
        assertThat(pats.size()).isEqualTo(expectedNumOfVisits);

        System.out.println("\n\nTest result FindByMinNumberOfVisits: " + pats.size() + "\n\n");
    }

    @Transactional
    @Test
    public void testFindByMyTableColumnOfAllPatient(){
        // given
        final boolean pPremium = false;
        long expectedNumOfVisits = 2;

        // when
        final List<PatientEntity> pats = patientDao.findByMyTableColumnOfAllPatient(pPremium);

        // then
        assertThat(pats).isNotNull();
        assertThat(pats.size()).isEqualTo(expectedNumOfVisits);

        System.out.println("\n\nTest result FindByMyTableColumnOfAllPatient: " + pats.size() + "\n\n");
    }
}