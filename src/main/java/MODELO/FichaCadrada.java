/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.awt.Color;

/**
 *
 * @author thicc
 */
public class FichaCadrada extends Ficha {

    Cadrado c1 = new Cadrado(200, -50, Color.GREEN);
    Cadrado c2 = new Cadrado(250, -50, Color.GREEN);
    Cadrado c3 = new Cadrado(250, 0, Color.GREEN);
    Cadrado c4 = new Cadrado(200, 0, Color.GREEN);

    public FichaCadrada(Xogo xogo) {
        super(xogo);
        cadrados.add(c1);
        cadrados.add(c2);
        cadrados.add(c3);
        cadrados.add(c4);
    }
 /**
 *
 * 
 */
    @Override
    public boolean rotar() {
       
        return false;
    }
}
