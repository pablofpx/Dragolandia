package org.example.model.persist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.model.Mago;
import org.example.model.Monstruo;

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

    public void update(int id, String nombre, int vida, int magia) {
        EntityManager em = JPAUtil.getInstance(UNIDAD).getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Mago mago = em.find(Mago.class, id);
            if (mago != null) {
                mago.setId(id);
                mago.setNombre(nombre);
                mago.setVida(vida);
                mago.setNivelMagia(magia);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }

    public Mago get(int id) {
        try (EntityManager em = JPAUtil.getInstance(UNIDAD).getEntityManager()) {
            return em.find(Mago.class, id);
        }
    }

    public void delete(int id) {
        EntityManager em = JPAUtil.getInstance(UNIDAD).getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Mago mago = em.find(Mago.class, id);
            if (mago != null) {
                em.remove(mago);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }
}
