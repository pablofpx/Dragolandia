package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public class Mago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int vida; // no negativo
    private int nivelMagia; // no negativo
    @ElementCollection(targetClass = Hechizo.class)
    @Enumerated(EnumType.STRING)
    private List<Hechizo> hechizos = new ArrayList<>(); // lista de hechizos

    public Mago(){}

    public Mago(String nombre, int vida, int nivelMagia) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivelMagia = nivelMagia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

    public void setNivelMagia(int nivelMagia) {
        this.nivelMagia = nivelMagia;
    }

    public List<Hechizo> getHechizos() {
        return hechizos;
    }

    // recoge un hechizo aleatorio
    public Hechizo getHechizo() {
        if (hechizos.isEmpty()) {
            throw new IllegalStateException("El mago no tiene hechizos disponibles.");
        }
        Random r = new Random();
        return hechizos.get(r.nextInt(hechizos.size()));
    }

    public void lanzarHechizo(Monstruo monstruo) {
        monstruo.setVida(monstruo.getVida()-this.getNivelMagia());
    }

    // hay que restar vida en funcion del tipo de hechizo, todavía por implementar
    public void lanzarHechizo(Hechizo h, Monstruo obj, Bosque bosque) {
        h.efecto(this, obj, bosque);
        aplicarDanhoEsfuerzo();
    }

    private void aplicarDanhoEsfuerzo() {
        Random r = new Random();
        // 20% de probabilidad de recibir daño
        if (r.nextDouble() < 0.20) {
            int esfuerzo = Math.max(1, nivelMagia / 2);
            vida = vida - esfuerzo;
            System.out.println("El mago sufre " + esfuerzo + " de daño por esfuerzo mágico.");
        }
    }

    @Override
    public String toString() {
        return "Mago{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", vida=" + vida +
                ", nivelMagia=" + nivelMagia +
                '}';
    }
}
