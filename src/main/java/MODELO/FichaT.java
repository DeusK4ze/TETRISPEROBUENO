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
public class FichaT extends Ficha{

    
    public Cadrado c1 = new Cadrado(250, -50, Color.BLUE);
    public Cadrado c2 = new Cadrado(250, 0, Color.BLUE);
    public Cadrado c3 = new Cadrado(250, 50, Color.BLUE);
    public Cadrado c4 = new Cadrado(300, 0, Color.BLUE);
    private int posicion = 0;

    public FichaT(Xogo xogo) {
        super(xogo);
        cadrados.add(c1);
        cadrados.add(c2);
        cadrados.add(c3);
        cadrados.add(c4);
    }

    

    @Override
    public boolean rotar() {
        switch (posicion) {
            case 0 -> {
                c1.lblCadrado.setLocation(c1.x - xogo.LADOCADRADO, c1.y + xogo.LADOCADRADO);
                c1.x -= xogo.LADOCADRADO;
                c1.y += xogo.LADOCADRADO;
                c3.lblCadrado.setLocation(c3.x + xogo.LADOCADRADO, c3.y - xogo.LADOCADRADO);
                c3.x += xogo.LADOCADRADO;
                c3.y -= xogo.LADOCADRADO;
                c4.lblCadrado.setLocation(c4.x - xogo.LADOCADRADO, c4.y + xogo.LADOCADRADO);
                c4.x -= xogo.LADOCADRADO;
                c4.y += xogo.LADOCADRADO;
                posicion++;
            }
            case 1 -> {
                c1.lblCadrado.setLocation(c1.x + xogo.LADOCADRADO, c1.y - xogo.LADOCADRADO);
                c1.x += xogo.LADOCADRADO;
                c1.y -= xogo.LADOCADRADO;
                c3.lblCadrado.setLocation(c3.x - xogo.LADOCADRADO, c3.y + xogo.LADOCADRADO);
                c3.x -= xogo.LADOCADRADO;
                c3.y += xogo.LADOCADRADO;
                c4.lblCadrado.setLocation(c4.x - xogo.LADOCADRADO, c4.y - xogo.LADOCADRADO);
                c4.x -= xogo.LADOCADRADO;
                c4.y -= xogo.LADOCADRADO;
                posicion++;
            }
            case 2 -> {
                c1.lblCadrado.setLocation(c1.x - xogo.LADOCADRADO, c1.y + xogo.LADOCADRADO);
                c1.x -= xogo.LADOCADRADO;
                c1.y += xogo.LADOCADRADO;
                c3.lblCadrado.setLocation(c3.x + xogo.LADOCADRADO, c3.y - xogo.LADOCADRADO);
                c3.x += xogo.LADOCADRADO;
                c3.y -= xogo.LADOCADRADO;
                c4.lblCadrado.setLocation(c4.x + xogo.LADOCADRADO, c4.y - xogo.LADOCADRADO);
                c4.x += xogo.LADOCADRADO;
                c4.y -= xogo.LADOCADRADO;
                posicion++;
            }
            case 3 -> {
                c1.lblCadrado.setLocation(c1.x + xogo.LADOCADRADO, c1.y - xogo.LADOCADRADO);
                c1.x += xogo.LADOCADRADO;
                c1.y -= xogo.LADOCADRADO;
                c3.lblCadrado.setLocation(c3.x - xogo.LADOCADRADO, c3.y + xogo.LADOCADRADO);
                c3.x -= xogo.LADOCADRADO;
                c3.y += xogo.LADOCADRADO;
                c4.lblCadrado.setLocation(c4.x + xogo.LADOCADRADO, c4.y + xogo.LADOCADRADO);
                c4.x += xogo.LADOCADRADO;
                c4.y += xogo.LADOCADRADO;
                posicion++;
            }
            default -> {
            }
        }
        if (posicion == 4) {
            posicion = 0;
        }
        return true;
    }
}
