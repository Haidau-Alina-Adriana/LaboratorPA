package jpa.repository;

import jpa.entity.CitiesEntity;
import jpa.entity.ContinentsEntity;
import jpa.utils.EntityManagerResponsible;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CitiesRepository {
    public static EntityManager entityManager;
    public static EntityTransaction entityTransaction;

    public CitiesRepository() {
        entityManager = EntityManagerResponsible.getInstance().createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public void create(CitiesEntity entity) {
        beginTransaction();
        entityManager.persist(entity);
        commitTransaction();
        System.out.println("Created successfully.");
    }

    protected void beginTransaction() {
        try {
            entityTransaction.begin();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    protected void commitTransaction() {
        try {
            entityTransaction.commit();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    protected void rollbackTransaction() {
        try {
            entityTransaction.rollback();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public static CitiesEntity findById(long id) {
        CitiesEntity citiesEntity = entityManager.find(CitiesEntity.class, id);
        return citiesEntity;
    }

    public static List<CitiesEntity> findByName(String name) {
        return entityManager.createNamedQuery("CityDAO.findByName")
                .setParameter("cityName", name)
                .getResultList();
    }

}
