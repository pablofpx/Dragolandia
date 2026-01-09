package org.example.controller;

import org.example.model.*;
import org.example.model.persist.BosqueRepository;
import org.example.model.persist.DragonRepository;
import org.example.model.persist.MagoRepository;
import org.example.model.persist.MonstruoRepository;
import org.example.view.Consola;

public class CombateController {
    private MagoRepository magoRepo = new MagoRepository();
    private BosqueRepository bosqueRepo = new BosqueRepository();
    private Consola view = new Consola();
    private MotorCombate motor = new MotorCombate();

    private TipoMonstruo parseMonstruo(String input) {
        if (input == null) return null;

        switch (input.trim().toUpperCase()) {
            case "OGRO":
                return TipoMonstruo.OGRO;
            case "TROLL":
                return TipoMonstruo.TROLL;
            case "ESPECTRO":
                return TipoMonstruo.ESPECTRO;
            default:
                throw new IllegalArgumentException("Tipo de monstruo desconocido: " + input);
        }
    }

    public void iniciar() {
        String nombreMago = view.pedirNombre("mago");
        int vidaMago = view.pedirInt("Vida del mago");
        int nivelMagia = view.pedirInt("Daño del mago");

        Mago mago = new Mago(nombreMago, vidaMago, nivelMagia);
        mago.getHechizos().add(Hechizo.BOLA_FUEGO);
        mago.getHechizos().add(Hechizo.RAYO);
        mago.getHechizos().add(Hechizo.BOLA_NIEVE);
        magoRepo.save(mago);

        String nombreMonstruo = view.pedirNombre("monstruo");
        int vidaMonstruo = view.pedirInt("Vida del monstruo");
        String tipoMonstruo = view.pedirTipo();
        int danoMonstruo = view.pedirInt("Daño del monstruo");

        TipoMonstruo tipo = parseMonstruo(tipoMonstruo);
        Monstruo monstruo = new Monstruo(nombreMonstruo, vidaMonstruo, tipo, danoMonstruo);
        Monstruo monstruo2 = new Monstruo("Carlinhos brown", vidaMonstruo, tipo, danoMonstruo);
        Monstruo monstruo3 = new Monstruo("Malenia", vidaMonstruo, tipo, danoMonstruo);
        // no puedo persistir el monstruo porque lo hago en bosque
        // monstruoRepo.save(monstruo);

        String nombreBosque = view.pedirNombre("bosque");
        int nivelPeligro = view.pedirInt("Nivel de peligro");

        Bosque bosque = new Bosque(nombreBosque, nivelPeligro, monstruo);

        //hardcodeado el dragon para probar
        Dragon dragon = new Dragon("Julian", 6, 1000);
        //hardcodeado
        bosque.addMonstruos(monstruo);
        bosque.addMonstruos(monstruo2);
        bosque.addMonstruos(monstruo3);
        bosque.asignarDragon(dragon);
        bosqueRepo.save(bosque);

        // cambio monstruo por bosque.getMonstruos
        motor.combatir(mago, bosque, dragon);

        String ganador = motor.getGanador(mago, bosque);
        view.mostrarResultado(ganador);
    }
}