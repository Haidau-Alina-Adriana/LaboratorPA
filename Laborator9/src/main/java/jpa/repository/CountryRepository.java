package jpa.repository;

import jpa.entity.CitiesEntity;
import jpa.entity.CountriesEntity;
import jpa.utils.EntityManagerResponsible;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CountryRepository {
    public static EntityManager entityManager;
    public static EntityTransaction entityTransaction;

    public CountryRepository() {
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
            //entityManager.close();
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

}
