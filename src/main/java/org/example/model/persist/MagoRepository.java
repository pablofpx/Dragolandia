package org.example.model.persist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.model.Mago;

public class MagoRepository {
    private static final String UNIDAD = "dragolandia";

    public void save(Mago mago) {
        EntityManager em = JPAUtil.getInstance(UNIDAD).getEntityManager();

        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(mago);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Mago get(int id) {
        try (EntityManager em = JPAUtil.getInstance(UNIDAD).getEntityManager()) {
            return em.find(Mago.class, id);
        }
    }
}
