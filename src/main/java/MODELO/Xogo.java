/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import IU.VentanaPrincipal;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author a22hugorp
 */
public class Xogo {

    public final int LADOCADRADO = 50;
    public int MAX_X = 450;
    public int MAX_Y = 650;
    public boolean pausa;
    public int numeroLineas = 0;
    public Ficha fichaActual;
    public ArrayList<Cadrado> cadradosChan = new ArrayList();
    public VentanaPrincipal ventanaPrincipal;

    public Xogo(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public void moverFichaDereita() {
        if (fichaActual.moverDereita()) {
            Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
            while (iter.hasNext()) {
                Cadrado item = iter.next();
                if (ePosicionValida(item.x, item.y)) {
                    item.lblCadrado.setLocation(item.x + LADOCADRADO, item.y);
                    item.x += LADOCADRADO;
                }
            }
        }
        actualizarGraf();
    }

    public void moverFichaEsquerda() {
        System.out.println("mover cadrado esquerda");
        if (fichaActual.moverEsquerda()) {
            Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
            while (iter.hasNext()) {
                Cadrado item = iter.next();
                item.lblCadrado.setLocation(item.x - LADOCADRADO, item.y);
                item.x -= LADOCADRADO;

            }
        }
        actualizarGraf();
    }

    public void rotarFicha() {
        fichaActual.rotar();
        actualizarGraf();
    }

    public boolean ePosicionValida(int x, int y) {
        boolean posicionValida = true;
        if (x > MAX_X || x < 0 || y > MAX_Y || y < -LADOCADRADO) {
            posicionValida = false;
            System.out.println("non se rotou");
        }
        Iterator<Cadrado> iter = cadradosChan.iterator();
        while (iter.hasNext()) {
            Cadrado chan = iter.next();
            if ((chan.getX() == x && chan.getY() == y)) {
                posicionValida = false;
            }
        }
        return posicionValida;
    }

//    public boolean ePosicionValida(int x, int y) {
//        
//    Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
//    while (iter.hasNext()) {
//        Cadrado cadrado = iter.next();
//        int newX = cadrado.getX() + x;
//        int newY = cadrado.getY() + y;
//
//         Comprobar si el cadrado está dentro del panel de juego
//        if (newX < 0 || newX >= MAX_X || newY < 0 || newY >= MAX_Y) {
//            return false;
//        }
//         Comprobar si el cadrado choca con otra ficha fija
//        for (Cadrado cadrado1 : cadradosFijos) {
//            if (cadradoFijo.getX() == newX && cadradoFijo.getY() == newY) {
//                return false;
//            }
//        }
//    }
//    return true;
//}
//     public boolean ePosicionValida(int x, int y) {
//        boolean posicionValida = false;
//        Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
//        while (iter.hasNext()) {
//            Cadrado c = iter.next();
//            if ((c.x >= 0) && (c.x <= MAX_X)) {
//                posicionValida = true;
//            }
//        }
//        return posicionValida;
//    }
    public void xenerarNovaFicha() {
        fichaActual = fichaAleatoria();
        Iterator<Cadrado> its = fichaActual.cadrados.iterator();
        while (its.hasNext()) {

            Cadrado c = its.next();
            ventanaPrincipal.pintarCadrado(c.getLblCadrado());
        }
    }

    private Ficha fichaAleatoria() {
        int aleatorio = (int) Math.floor(Math.random() * 4 + 1);
        Ficha fichaleatoria = null;
        aleatorio = 3;
        switch (aleatorio) {
            case 1 -> {
                fichaleatoria = new FichaBarra(this);
                System.out.println("Se ha creado ficha Barra");
            }
            case 2 -> {
                fichaleatoria = new FichaCadrada(this);
                System.out.println("Se ha creado ficha Cadrada");
            }
            case 3 -> {
                fichaleatoria = new FichaL(this);
                System.out.println("Se ha creado ficha L");
            }
            case 4 -> {
                fichaleatoria = new FichaT(this);
                System.out.println("Se ha creado ficha T");
            }
        }
        return fichaleatoria;
    }

    public void engadirFichaAoChan() {
        Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
        while (iter.hasNext()) {
            Cadrado item = iter.next();
            cadradosChan.add(item);
        }
    }

    public void borrarLinasCompletas() {

    }

    public void borrarLina() {

    }

    public boolean chocaFichaCoChan() {
        boolean chocaCoChan = false;
        Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
        while (iter.hasNext()) {
            Cadrado item = iter.next();
            if (item.y == MAX_Y || comprobarCadradosChan(item.y, item.x)) {
                chocaCoChan = true;
            }
        }
        return chocaCoChan;
    }

    private boolean comprobarCadradosChan(int y, int x) {
        boolean chocaCoChan = false;
        Iterator<Cadrado> iter = cadradosChan.iterator();
        while (iter.hasNext()) {
            Cadrado item = iter.next();
            if ((item.y == (y + LADOCADRADO)) && (item.x == x)) {
                chocaCoChan = true;
            }
        }
        return chocaCoChan;
    }

    public void moverFichaAbaixo() {
        fichaActual.moverAbaixo();
        actualizarGraf();
    }

    private void actualizarGraf() {
        if (chocaFichaCoChan()) {
            engadirFichaAoChan();
            xenerarNovaFicha();
        }
    }

}
