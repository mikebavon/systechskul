package com.systech.interns;

import com.school.organization.model.hospital.ConsultationRoom;
import com.school.organization.model.hospital.Doctor;
import com.school.organization.model.hospital.Patient;
import com.school.organization.model.hospital.Visit;
import com.school.organization.model.others.Citizen;
import com.school.organization.model.others.IdCard;
import com.school.organization.model.skul.BioData;
import com.school.organization.model.skul.Gender;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Stateless
@Remote
public class HospitalBean {

    @PersistenceContext
    private EntityManager em;

    public void populateSampleData(){

        Doctor doctor1 = new Doctor();
        doctor1.setBioData(new BioData());
        doctor1.getBioData().setSurname("John");
        doctor1.getBioData().setOtherNames("Doe");
        doctor1.getBioData().setGender(Gender.MALE);
        doctor1.getBioData().setIdNo("1213232323");
        doctor1.setPracticeId("12345");
        doctor1 = em.merge(doctor1);

        Doctor doctor2 = new Doctor();
        doctor2.setBioData(new BioData());
        doctor2.getBioData().setSurname("Jane");
        doctor2.getBioData().setOtherNames("Doe");
        doctor2.getBioData().setGender(Gender.FEMALE);
        doctor2.getBioData().setIdNo("323232323");
        doctor2.setPracticeId("12346");
        doctor2 =  em.merge(doctor2);

        Doctor doctor3 = new Doctor();
        doctor3.setBioData(new BioData());
        doctor3.getBioData().setSurname("John");
        doctor3.getBioData().setOtherNames("Smith");
        doctor3.getBioData().setGender(Gender.MALE);
        doctor3.getBioData().setIdNo("323232323233");
        doctor3.setPracticeId("12347");
        doctor3 = em.merge(doctor3);

        Patient patient1 = new Patient();
        patient1.setBioData(new BioData());
        patient1.getBioData().setSurname("Jack");
        patient1.getBioData().setOtherNames("Slocum");
        patient1.getBioData().setGender(Gender.MALE);
        patient1.getBioData().setIdNo("1213232323");
        patient1 = em.merge(patient1);

        Patient patient2 = new Patient();
        patient2.setBioData(new BioData());
        patient2.getBioData().setSurname("Tony");
        patient2.getBioData().setOtherNames("Stark");
        patient2.getBioData().setGender(Gender.MALE);
        patient2.getBioData().setIdNo("323232323");
        patient2 =  em.merge(patient2);

        ConsultationRoom consultationRoom = new ConsultationRoom();
        consultationRoom.setRoomNo("001");
        consultationRoom =  em.merge(consultationRoom);

        Visit visit1 = new Visit();
        visit1.setDoctor(doctor1);
        visit1.setPatient(patient2);
        visit1.setRoom(consultationRoom);
        visit1.setFromDate(new Date());
        visit1.setToDate(new Date());
        em.merge(visit1);

        Visit visit2 = new Visit();
        visit2.setDoctor(doctor2);
        visit2.setPatient(patient2);
        visit2.setRoom(consultationRoom);
        visit2.setFromDate(new Date());
        visit2.setToDate(new Date());
        em.merge(visit2);

        Visit visit3 = new Visit();
        visit3.setDoctor(doctor2);
        visit3.setPatient(patient1);
        visit3.setRoom(consultationRoom);
        visit3.setFromDate(new Date());
        visit3.setToDate(new Date());
        em.merge(visit3);


    }

    public void populateCitizens(){
        Citizen citizen = new Citizen();
        citizen.setName("John Doe");

        citizen.setIdCard(new IdCard());
        citizen.getIdCard().setIdNo("12344444");
        citizen.getIdCard().setSerialNo("4rtrtewtrewtwret");

        em.merge(citizen);

        citizen = new Citizen();
        citizen.setName("Jane Doe");

        citizen.setIdCard(new IdCard());
        citizen.getIdCard().setIdNo("4567777");
        citizen.getIdCard().setSerialNo("hhhh56666");

        em.merge(citizen);

        citizen = new Citizen();
        citizen.setName("John Smith");

        citizen.setIdCard(new IdCard());
        citizen.getIdCard().setIdNo("55667777");
        citizen.getIdCard().setSerialNo("yyuuuu");

        em.merge(citizen);
    }

}
