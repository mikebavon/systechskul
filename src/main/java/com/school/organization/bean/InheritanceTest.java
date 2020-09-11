package com.school.organization.bean;

import com.school.organization.model.*;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    public void listToyata(){
        List<Toyota> toyotas = em.createQuery("FROM Toyota t").getResultList();

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
