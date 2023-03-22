/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author a22anxoll
 */
public abstract class Ficha {

    public ArrayList<Cadrado> cadrados = new ArrayList();
    private Iterator<Cadrado> iterCadrados;
    public Xogo xogo;

    public Ficha(Xogo xogo) {
        this.xogo = xogo;
    }
 /**
 *
 * 
 */
    public boolean moverDereita() {
         boolean mover = true;
        Iterator<Cadrado> iter = xogo.fichaActual.cadrados.iterator();
        while (iter.hasNext()) {
            Cadrado cmover = iter.next();
            if (!xogo.ePosicionValida(cmover.x + xogo.LADOCADRADO, cmover.y)) {
                mover = false;
            }
        }
        return mover;
    }
 /**
 *
 * 
 */
    public boolean moverEsquerda() {  
        boolean mover = true;
        Iterator<Cadrado> iter = xogo.fichaActual.cadrados.iterator();
        while (iter.hasNext()) {
            Cadrado cmover = iter.next();
            if (!xogo.ePosicionValida(cmover.x - xogo.LADOCADRADO, cmover.y)) {
                mover = false;
            }
        }
        return mover;
    }
 /**
 *
 * 
 */
    public boolean moverAbaixo() {
        Iterator<Cadrado> iter = cadrados.iterator();
        while (iter.hasNext()) {
            Cadrado cmover = iter.next();
            cmover.lblCadrado.setLocation(cmover.x, cmover.y + xogo.LADOCADRADO);
            cmover.y += xogo.LADOCADRADO;
//            System.out.println(cmover.x + ", " + "" + cmover.y);
        }
        return true;
    }
 /**
 *
 * 
 */
    public abstract boolean rotar();
}
