/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.awt.Color;
import java.util.Iterator;

/**
 *
 * @author thicc
 */
public class FichaBarra extends Ficha {

    Iterator<Cadrado> it = cadrados.iterator();
    Cadrado c1 = new Cadrado(250, -50, Color.RED);
    Cadrado c2 = new Cadrado(250, 0, Color.RED);
    Cadrado c3 = new Cadrado(250, 50, Color.RED);
    Cadrado c4 = new Cadrado(250, 100, Color.RED);
    private int posicion = 0;

    public FichaBarra(Xogo xogo) {
        super(xogo);
        cadrados.add(c1);
        cadrados.add(c2);
        cadrados.add(c3);
        cadrados.add(c4);
    }

    @Override
    public boolean rotar() {
        boolean rotar = true;
        switch (posicion) {
            case 0 -> {
                if (xogo.ePosicionValida(c1.x - xogo.LADOCADRADO, c1.y + xogo.LADOCADRADO) && (xogo.ePosicionValida(c3.x + xogo.LADOCADRADO, c3.y - xogo.LADOCADRADO)) && (xogo.ePosicionValida(c4.x + (xogo.LADOCADRADO * 2), c4.y - (xogo.LADOCADRADO * 2)))) {
                    c1.lblCadrado.setLocation(c1.x - xogo.LADOCADRADO, c1.y + xogo.LADOCADRADO);
                    c1.x -= xogo.LADOCADRADO;
                    c1.y += xogo.LADOCADRADO;
                    c3.lblCadrado.setLocation(c3.x + xogo.LADOCADRADO, c3.y - xogo.LADOCADRADO);
                    c3.x += xogo.LADOCADRADO;
                    c3.y -= xogo.LADOCADRADO;
                    c4.lblCadrado.setLocation(c4.x + (xogo.LADOCADRADO * 2), c4.y - (xogo.LADOCADRADO * 2));
                    c4.x += (xogo.LADOCADRADO * 2);
                    c4.y -= (xogo.LADOCADRADO * 2);
                    posicion++;
                }
            }
            case 1 -> {
                c1.lblCadrado.setLocation(c1.x + xogo.LADOCADRADO, c1.y - xogo.LADOCADRADO);
                c1.x += xogo.LADOCADRADO;
                c1.y -= xogo.LADOCADRADO;
                c3.lblCadrado.setLocation(c3.x - xogo.LADOCADRADO, c3.y + xogo.LADOCADRADO);
                c3.x -= xogo.LADOCADRADO;
                c3.y += xogo.LADOCADRADO;
                c4.lblCadrado.setLocation(c4.x - (xogo.LADOCADRADO * 2), c3.y + (xogo.LADOCADRADO * 2));
                c4.x -= (xogo.LADOCADRADO * 2);
                c4.y += (xogo.LADOCADRADO * 2);
                posicion++;
            }
            default -> {
            }
        }
        if (posicion == 2) {
            posicion = 0;
        }
        return rotar;

    }
}
