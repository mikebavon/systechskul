package com.school.organization.bean;

import com.school.organization.model.motor.Audi;
import com.school.organization.model.motor.Car;
import com.school.organization.model.motor.Toyota;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote
public class InheritanceTest {

    @PersistenceContext
    private EntityManager em;

    public void addSomeCars(){

        Car toyota = new Toyota();
        toyota.setName("Landcruiser");
        toyota.setBodyType("SUV");
        em.merge(toyota);

        Car audi = new Audi();
        audi.setName("Q8");
        audi.setBodyType("SUV");
        em.merge(audi);

    }

    @SuppressWarnings("unchecked")
    public void listToyata(String searchBy, int start, int limit){

  /*      List<Toyota> toyotas = em.createNamedQuery(Toyota.NQ_TOYOTA_ALL)
                //.setFirstResult(start)
               // .setMaxResults(limit)
                .getResultList();*/

        List<Toyota> toyotas = em.createNamedQuery(Toyota.NQ_TOYOTA_SEARCH_BY_NAME)
                .setParameter("searchKey", searchBy)
                //.setFirstResult(start)
               // .setMaxResults(limit)
                .getResultList();

        for(Toyota toyota : toyotas){
            System.out.println(toyota.toyotaDetails());
        }
    }

    public void listAudi(){
        List<Audi> audis = em.createQuery("FROM Audi a").getResultList();

        for(Audi audi : audis){
            System.out.println(audi.audiDetails());
        }
    }

    public void listCars(){
        List<Car> cars = em.createQuery("FROM Car c").getResultList();

        for(Car car : cars){
            System.out.println(car.carDetails());
        }
    }
}
