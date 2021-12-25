package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConfiguration {
    private final String persistenceUnitName;
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public JPAConfiguration(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
        this.factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        this.entityManager = factory.createEntityManager();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return factory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void shutdown() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (factory != null) {
            factory.close();
        }
    }
}