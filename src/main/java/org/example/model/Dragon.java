package org.example.model;

import jakarta.persistence.*;

@Entity
public class Dragon {
    @Id
    private int id;
    private String nombre;
    private int intensidadFuego;
    private int hp;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bosque_id")
    private Bosque bosque;

    public Dragon(String nombre, int intensidadFuego, int hp) {
        this.nombre = nombre;
        this.intensidadFuego = intensidadFuego;
        this.hp = hp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIntensidadFuego() {
        return intensidadFuego;
    }

    public void setIntensidadFuego(int intensidadFuego) {
        this.intensidadFuego = intensidadFuego;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Bosque getBosque() {
        return this.bosque;
    }

    public void setBosque(Bosque bosque) {
        this.bosque = bosque;
    }

    public void exhalar(Monstruo monstruo) {
        monstruo.setVida(monstruo.getVida()-this.intensidadFuego);
    }
}
