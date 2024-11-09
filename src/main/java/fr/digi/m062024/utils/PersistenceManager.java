package fr.digi.m062024.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class PersistenceManager {

    private static EntityManagerFactory emf;

    private PersistenceManager() {
    }


    /**
     * Allows to create an entity manager factory
     *
     * @return an EntityManagerFactory
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("petstore");
        }
        return emf;
    }

    /**
     * Allows to close an EntityManagerFactory
     */
    public static void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
        }
    }

}
