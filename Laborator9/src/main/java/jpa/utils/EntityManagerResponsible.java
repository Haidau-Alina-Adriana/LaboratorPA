package jpa.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerResponsible {
    private static EntityManagerFactory entityManagerFactory;

    private EntityManagerResponsible() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }

    public static EntityManagerFactory getInstance() {
        if (entityManagerFactory == null)
            new EntityManagerResponsible();
        return entityManagerFactory;
    }
}
