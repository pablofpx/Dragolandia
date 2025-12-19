package org.example.model.persist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.model.Bosque;
import org.example.model.Dragon;
import org.example.model.Monstruo;

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

    public void update(int id, String nombre, int vida, int intensidad) {
        EntityManager em = JPAUtil.getInstance(UNIDAD).getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Dragon dragon= em.find(Dragon.class, id);
            if (dragon != null) {
                dragon.setNombre(nombre);
                dragon.setHp(vida);
                dragon.setIntensidadFuego(intensidad);
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
            Dragon dragon = em.find(Dragon.class, id);
            if (dragon != null) {
                em.remove(dragon);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }
}
