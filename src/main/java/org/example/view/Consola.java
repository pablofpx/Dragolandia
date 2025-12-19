package org.example.view;

import java.util.Scanner;

public class Consola {
    private Scanner sc = new Scanner(System.in);

    public String pedirNombre(String tipo) {
        System.out.println("Nombre del "+tipo+": ");
        return sc.nextLine();
    }

    public int pedirInt(String msg) {
        System.out.println(msg + ": ");
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    public String pedirTipo() {
        System.out.println("Tipo de monstruo (OGRO, TROLL, ESPECTRO): ");
        return sc.nextLine();
    }

    public void mostrarResultado(String ganador) {
        System.out.println("El ganador es: "+ganador);
    }
}
