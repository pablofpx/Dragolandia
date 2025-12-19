package org.example.model.persist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.model.Dragon;

public class DragonRepository {
    private static final String UNIDAD = "dragolandia";

    public void save(Dragon dragon) {
        EntityManager em = JPAUtil.getInstance(UNIDAD).getEntityManager();

        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(dragon);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Dragon get(int id) {
        try (EntityManager em = JPAUtil.getInstance(UNIDAD).getEntityManager()) {
            return em.find(Dragon.class, id);
        }
    }
}
