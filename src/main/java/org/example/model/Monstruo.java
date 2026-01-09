package org.example.model;

import jakarta.persistence.*;

@Entity
public class Monstruo {
    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int vida;
    @Enumerated(EnumType.STRING)
    private TipoMonstruo tipo;
    private int fuerza; // impacto

    @ManyToOne
    @JoinColumn(name = "bosque_id")
    private Bosque bosque;

    public Monstruo(){}

    public Monstruo(String nombre, int vida, TipoMonstruo tipo, int fuerza) {
        this.nombre = nombre;
        this.vida = vida;
        this.tipo = tipo;
        this.fuerza = fuerza;
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

    public TipoMonstruo getTipo() {
        return tipo;
    }

    public void setTipo(TipoMonstruo tipo) {
        this.tipo = tipo;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public Bosque getBosque() {
        return bosque;
    }

    public void setBosque(Bosque bosque) {
        this.bosque = bosque;
    }

    public void atacar(Mago mago) {
        mago.setVida(mago.getVida()-this.fuerza);
    }

    // el dragón es inmortal
    public void atacarDragon(Dragon dragon) {
        dragon.getHp();
    }

    @Override
    public String toString() {
        return "Monstruo " +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", vida=" + vida +
                ", tipo=" + tipo +
                ", fuerza=" + fuerza;
    }
}
