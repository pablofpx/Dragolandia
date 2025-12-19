package org.example.model;

public class MotorCombate {
    // simula el combate hasta que uno de los dos quede con hp a 0
    public void combatir(Mago mago, Monstruo monstruo, Bosque bosque, Dragon dragon) {
        while (mago.getVida() > 0 && monstruo.getVida() > 0) {

            Hechizo hechizo = mago.getHechizo();
            mago.lanzarHechizo(hechizo, monstruo, bosque);
            System.out.println(mago.getNombre()+" ataca con "+hechizo);

            dragon.exhalar(monstruo);
            System.out.println(dragon.getNombre()+ " hace arder al monstruo "+monstruo.getNombre());

            if (monstruo.getVida() <= 0) break;

            System.out.println(monstruo.getNombre()+" se defiende!!");
            monstruo.atacar(mago);
        }
    }

    // devuelve el objeto ganador
    public String getGanador(Mago mago, Monstruo monstruo) {
        return mago.getVida() > 0 ? mago.getNombre() : monstruo.getNombre();
    }
}
