/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.util.ArrayList;

/**
 *
 * @author a22anxoll
 */
public abstract class Ficha {
    
    ArrayList<Cadrado> cadrados = new ArrayList<>();
    int posicion;
    public Ficha() {

        Cadrado c1 = new Cadrado();
        cadrados.add(c1);

        Cadrado c2 = new Cadrado();
        cadrados.add(c2);

        Cadrado c3 = new Cadrado();
        cadrados.add(c3);

        Cadrado c4 = new Cadrado();
        cadrados.add(c4);
    }

    public boolean moverFichaDereita() {
        boolean mover = false;
        return mover;
    }

    public boolean moverFichaEsquerda() {
        boolean mover = false;
        return mover;
    }

    public boolean moverFichaAbaixo() {
        boolean mover = false;
        return mover;
    }

    public abstract boolean rotarFicha();
}
