/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import static java.awt.Color.yellow;

/**
 *
 * @author thicc
 */
public class FichaBarra extends Ficha {

    public Cadrado c1 = new Cadrado(150, 50, yellow);
    public Cadrado c2 = new Cadrado(150, 50, yellow);
    public Cadrado c3 = new Cadrado(150, 50, yellow);
    public Cadrado c4 = new Cadrado(150, 50, yellow);
    
    public FichaBarra() {
        cadrados.add(c1);
        cadrados.add(c2);
        cadrados.add(c3);
        cadrados.add(c4);
    }
    int x = super.cadrados.get(0).getX();
    int y = super.cadrados.get(0).getY();

@Override
public boolean rotarFicha() {

    }
}

