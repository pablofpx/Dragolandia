package org.example.model.persist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.model.Bosque;
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

    public void update(int id, String nombre, int vida) {
        EntityManager em = JPAUtil.getInstance(UNIDAD).getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Monstruo monstruo= em.find(Monstruo.class, id);
            if (monstruo != null) {
                monstruo.setId(id);
                monstruo.setNombre(nombre);
                monstruo.setVida(vida);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        EntityManager em = JPAUtil.getInstance(UNIDAD).getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Monstruo monstruo = em.find(Monstruo.class, id);
            if (monstruo != null) {
                em.remove(monstruo);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }
}
