package org.example.model.persist;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.model.Bosque;
import org.example.model.Mago;

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

    public void update(int id, String nombre, int nivelPeligro) {
        EntityManager em = JPAUtil.getInstance(UNIDAD).getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Bosque bosque= em.find(Bosque.class, id);
            if (bosque != null) {
                bosque.setId(id);
                bosque.setNombre(nombre);
                bosque.setNivelPeligro(nivelPeligro);
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
            Bosque bosque = em.find(Bosque.class, id);
            if (bosque != null) {
                em.remove(bosque);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }
}
