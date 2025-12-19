package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Bosque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int nivelPeligro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monstruo_jefe_id")
    private Monstruo monstruoJefe; // jefe

    @OneToMany(mappedBy = "bosque", cascade = CascadeType.ALL)
    private List<Monstruo> monstruos = new ArrayList<>();

    @OneToOne(mappedBy = "bosque", cascade = CascadeType.ALL, orphanRemoval = true)
    private Dragon dragon;

    public Bosque() {}

    public Bosque(String nombre, int nivelPeligro, Monstruo monstruoJefe) {
        this.nombre = nombre;
        this.nivelPeligro = nivelPeligro;
        this.monstruoJefe = monstruoJefe;
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

    public int getNivelPeligro() {
        return nivelPeligro;
    }

    public void setNivelPeligro(int nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }

    public Monstruo getMonstruoJefe() {
        return monstruoJefe;
    }

    public void setMonstruoJefe(Monstruo monstruoJefe) {
        this.monstruoJefe = monstruoJefe;
    }

    public Monstruo mostrarJefe() {
        return getMonstruoJefe();
    }

    public void cambiarJefe(Monstruo monstruo) {
        setMonstruoJefe(monstruo);
    }

    public List<Monstruo> getMonstruos() {
        return monstruos;
    }

    public void setMonstruos(List<Monstruo> monstruos) {
        this.monstruos = monstruos;
    }

    public void addMonstruos(Monstruo monstruo) {
        monstruos.add(monstruo);
        monstruo.setBosque(this);
    }

    public void asignarDragon(Dragon dragon) {
        this.dragon = dragon;
        dragon.setBosque(this);
    }

    @Override
    public String toString() {
        return "Bosque{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nivelPeligro=" + nivelPeligro +
                ", monstruoJefe=" + monstruoJefe +
                '}';
    }
}
