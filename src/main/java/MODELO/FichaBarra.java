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
public class FichaBarra extends Ficha {

    public FichaBarra() {
        for (int i = 0; i < super.cadrados.size(); i++) {
            super.cadrados.get(i).corRecheo=Color.YELLOW;
            super.cadrados.get(i).getX();
            super.cadrados.get(i).getY();
                    
        }

    }

    @Override
    public boolean rotarFicha() {

    }
}
