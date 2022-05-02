package jpa.repository;

import jpa.entity.CitiesEntity;
import jpa.entity.ContinentsEntity;
import jpa.entity.CountriesEntity;
import jpa.utils.EntityManagerResponsible;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ContinentRepository {
    public static EntityManager entityManager;
    public static EntityTransaction entityTransaction;

    public ContinentRepository() {
        entityManager = EntityManagerResponsible.getInstance().createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public void create(ContinentsEntity entity) {
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

    public static ContinentsEntity findById(long id) {
        ContinentsEntity continentsEntity = entityManager.find(ContinentsEntity.class, id);
        return continentsEntity;
    }

}
