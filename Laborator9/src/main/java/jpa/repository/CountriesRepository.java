package jpa.repository;

import jpa.entity.CitiesEntity;
import jpa.entity.ContinentsEntity;
import jpa.entity.CountriesEntity;
import jpa.utils.EntityManagerResponsible;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CountriesRepository {
    public static EntityManager entityManager;
    public static EntityTransaction entityTransaction;

    public CountriesRepository() {
        entityManager = EntityManagerResponsible.getInstance().createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public void create(CountriesEntity entity) {
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

    public static CountriesEntity findById(long id) {
        CountriesEntity countriesEntity = entityManager.find(CountriesEntity.class, id);
        return countriesEntity;
    }

    public static List<CountriesEntity> findByName(String name) {
        return entityManager.createNamedQuery("CountryDAO.findByName")
                .setParameter("countryName", name)
                .getResultList();
    }

}
