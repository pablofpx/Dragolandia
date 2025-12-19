package org.example.model.persist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static JPAUtil instance;
    private static volatile EntityManagerFactory emf;

    private JPAUtil(String unidadPersistencia){
        emf = Persistence.createEntityManagerFactory(unidadPersistencia);
    }

    public static JPAUtil getInstance(String unidadPersistencia) {
        if (instance == null) {
            synchronized (JPAUtil.class) {
                if (instance == null) {
                    instance = new JPAUtil(unidadPersistencia);
                }
            }
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
