package org.example.model;

import java.util.List;
import java.util.Random;

public enum Hechizo {
    BOLA_FUEGO(3) {
        @Override
        public void efecto(Mago mago, Monstruo objetivo, Bosque bosque) {
            List<Monstruo> monstruos = bosque.getMonstruos();
            if (monstruos.isEmpty()) return;

            Random r = new Random();
            int cantidad = r.nextInt(monstruos.size()) + 1;

            for (int i = 0; i < cantidad; i++) {
                Monstruo m = monstruos.get(r.nextInt(monstruos.size()));
                int dano = mago.getNivelMagia() * poder;
                m.setVida(objetivo.getVida() - dano);
            }
        }
    },
    RAYO(5) {
        @Override
        public void efecto(Mago mago, Monstruo objetivo, Bosque bosque) {
            int dano = mago.getNivelMagia() * poder;
            objetivo.setVida(objetivo.getVida() - dano);
        }
    },
    BOLA_NIEVE(9999) {
        @Override
        public void efecto(Mago mago, Monstruo objetivo, Bosque bosque) {
            int dano = 1;
            objetivo.setVida(objetivo.getVida() - dano);
            //objetivo.setVida(0); // instakill
        }
    };

    protected final int poder;

    Hechizo(int poder) {
        this.poder = poder;
    }

    public abstract void efecto(Mago mago, Monstruo objetivo, Bosque bosque);
}
