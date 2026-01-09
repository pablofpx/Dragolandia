package org.example.model;

import java.util.Random;

public class MotorCombate {
    // simula el combate hasta que uno de los dos quede con hp a 0
    public void combatir(Mago mago, Bosque bosque, Dragon dragon) {
        while (mago.getVida() > 0 && !bosque.getMonstruos().isEmpty()) {

            // escojo un monstruo de la lista para que se le pueda atacar
            Monstruo objetivo = bosque.getMonstruos()
                    .get(new Random().nextInt(bosque.getMonstruos().size()));

            Hechizo hechizo = mago.getHechizo();
            mago.lanzarHechizo(hechizo, objetivo, bosque);
            System.out.println(mago.getNombre()+" ataca a "+objetivo.getNombre()+" con hechizo "+hechizo);

            if (objetivo.getVida() <= 0) {
                bosque.getMonstruos().remove(objetivo);
                System.out.println(objetivo+" ha muerto en este asalto.");
            }

            // dragon ataca sólo al jefe actual
            Monstruo jefe = bosque.getMonstruoJefe();
            dragon.exhalar(jefe);
            System.out.println(dragon.getNombre()+ " hace arder al monstruo jefe "+jefe.getNombre());

            jefe.atacarDragon(dragon);
            System.out.println("El jefe intenta dañar al dragón "+dragon.getNombre() +"... pero no lo consigue.");

            if (jefe.getVida() <= 0 && !bosque.getMonstruos().isEmpty()) {
                bosque.cambiarJefe(bosque.getMonstruos().getFirst());
                System.out.println("Nuevo jefe: "+bosque.getMonstruoJefe().getNombre());
            }

            for (Monstruo m : bosque.getMonstruos()) {
                if (m.getVida() > 0 && !m.equals(jefe)) {
                    m.atacar(mago);
                    System.out.println(m.getNombre()+" se defiende!");
                }
            }

        }
    }

    // devuelve el objeto ganador
    public String getGanador(Mago mago, Bosque bosque) {
        if (mago.getVida() > 0) {
            return "Mago";
        }
        return "Monstruos";
    }
}
