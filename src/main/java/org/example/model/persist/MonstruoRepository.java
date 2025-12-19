package org.example.model.persist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.model.Monstruo;

public class MonstruoRepository {
    private static final String UNIDAD = "dragolandia";

    public void save(Monstruo monstruo) {
        EntityManager em = JPAUtil.getInstance(UNIDAD).getEntityManager();

        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(monstruo);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Monstruo get(int id) {
        try (EntityManager em = JPAUtil.getInstance(UNIDAD).getEntityManager()) {
            return em.find(Monstruo.class, id);
        }
    }
}
