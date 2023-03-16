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

    public void setMAX_X(int MAX_X) {
        this.MAX_X = MAX_X;
    }

    public void setMAX_Y(int MAX_Y) {
        this.MAX_Y = MAX_Y;
    }

    public Xogo(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public void moverFichaDereita() {
        if (fichaActual.moverDereita()) {
            Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
            while (iter.hasNext() && ePosicionValida(MAX_X, MAX_Y)) {
                if (ePosicionValida(MAX_X, MAX_Y)) {
                    Cadrado item = iter.next();
                    item.lblCadrado.setLocation(item.x + LADOCADRADO, item.y);
                    item.x += LADOCADRADO;
                }
                System.out.println("Mover cadrado dereita");
            }
            actualizarGraf();
        }
    }

    public void moverFichaEsquerda() {

        if (fichaActual.moverEsquerda()) {
            Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
            while (iter.hasNext()) {
                if (ePosicionValida(MAX_X, MAX_Y)) {
                    Cadrado item = iter.next();
                    item.lblCadrado.setLocation(item.x - LADOCADRADO, item.y);
                    item.x -= LADOCADRADO;
                }
            }
            System.out.println("mover cadrado esquerda");
        }
        actualizarGraf();
    }

    public void rotarFicha() {
        if (ePosicionValida(MAX_X, MAX_Y)) {
            fichaActual.rotar();
            actualizarGraf();
        } 
    }

    public boolean ePosicionValida(int x, int y) {
        boolean posicionValida = false;
        Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
        while (iter.hasNext()) {
            Cadrado c = iter.next();
            if ((c.getX() >= 50) && (c.getX() <= MAX_X) && (c.getY() >= 0) && (c.getY() <= MAX_Y)) {
                posicionValida = true;
            }
        }
        return posicionValida;
    }

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
        aleatorio = 1;
        switch (aleatorio) {
            case 1 -> {
                fichaleatoria = new FichaBarra(this);

            }
            case 2 -> {
                fichaleatoria = new FichaCadrada(this);

            }
            case 3 -> {
                fichaleatoria = new FichaL(this);

            }
            case 4 -> {
                fichaleatoria = new FichaT(this);

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
        System.out.println("Ficha engadida");
    }

    public void borrarLinasCompletas() {
        Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
        if (cadradosChan.size() == 10) {
            borrarLina();
            actualizarGraf();
        }
    }

    public void borrarLina() {

        Iterator<Cadrado> iter = cadradosChan.iterator();
        if (chocaFichaCoChan() && cadradosChan.size() == 10) {
            while (iter.hasNext()) {
                Cadrado cChan = iter.next();
                    ventanaPrincipal.borrarCadrado(cChan.lblCadrado);
                    actualizarGraf();
            }
        }
    }

    public boolean chocaFichaCoChan() {
        boolean tocaChan = false;
        Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
        while (iter.hasNext()) {
            Cadrado item = iter.next();
            if (item.getY() == MAX_Y || comprobarCadradosChan(item.getY(), item.getX())) {
                tocaChan = true;
                System.out.println("Ficha chocou co chan");
            }
        }

        return tocaChan;
    }

    private boolean comprobarCadradosChan(int y, int x) {
        boolean chocaCoChan = false;
        Iterator<Cadrado> iter = cadradosChan.iterator();
        while (iter.hasNext()) {
            Cadrado item = iter.next();
            if ((item.getY() == (y + LADOCADRADO)) && (item.getX() == x)) {
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
