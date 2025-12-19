package org.example.model.persist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.model.Bosque;

public class BosqueRepository {
    private static final String UNIDAD = "dragolandia";

    public void save(Bosque bosque) {
        EntityManager em = JPAUtil.getInstance(UNIDAD).getEntityManager();

        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(bosque);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Bosque get(int id) {
        try (EntityManager em = JPAUtil.getInstance(UNIDAD).getEntityManager()) {
            return em.find(Bosque.class, id);
        }
    }
}
