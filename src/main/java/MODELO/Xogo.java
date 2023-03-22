/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import IU.VentanaPrincipal;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author a22hugorp
 */
public class Xogo {

    public final int LADOCADRADO = 50;
    public int MAX_X = 450;
    public int MAX_Y = 750;
    private int MIN_Y = 0;
    public boolean pausa;
    public int numeroLineas = 0;
    public Ficha fichaActual;
    public ArrayList<Cadrado> cadradosChan = new ArrayList();
    public VentanaPrincipal ventanaPrincipal;
    private ArrayList<Cadrado> cadradosBorrar = new ArrayList<>();

    public ArrayList<Cadrado> getCadradosBorrar() {
        return cadradosBorrar;
    }

    public void setCadradosBorrar(ArrayList<Cadrado> cadradosBorrar) {
        this.cadradosBorrar = cadradosBorrar;
    }
    public Xogo(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    /**
     *
     *
     */
    public void moverFichaDereita() {
        if (fichaActual.moverDereita()) {
            Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
            while (iter.hasNext()) {
                Cadrado item = iter.next();
                item.lblCadrado.setLocation(item.x + LADOCADRADO, item.y);
                item.x += LADOCADRADO;
            }
        }
        actualizarGraf();
    }

    /**
     *
     *
     */
    public void moverFichaEsquerda() {
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

    /**
     *
     *
     */
    public void rotarFicha() {
        fichaActual.rotar();
        actualizarGraf();
    }

    /**
     *
     *
     */
    public boolean ePosicionValida(int x, int y) {
        boolean posicionValida = true;
        if (x > MAX_X || x < 0) {
            posicionValida = false;
        } else {
            Iterator<Cadrado> iter = cadradosChan.iterator();
            while (iter.hasNext()) {
                Cadrado chan = iter.next();
                if (chan.getX() == x && chan.getY() == y) {
                    posicionValida = false;
                }
            }
        }
        return posicionValida;

    }
    
    /**
     *
     *
     */
    public void xenerarNovaFicha() {
        fichaActual = fichaAleatoria();
        Iterator<Cadrado> its = fichaActual.cadrados.iterator();
        while (its.hasNext()) {

            Cadrado c = its.next();
            ventanaPrincipal.pintarCadrado(c.getLblCadrado());
        }
    }

    /**
     * Método que utiliza el metodo Math.floor(Math.random() * 4 + 1), para
     * generar un numero aleatorio entre los numeris 1,2,3 y 4.
     *
     */
    private Ficha fichaAleatoria() {
        int aleatorio = (int) Math.floor(Math.random() * 4 + 1);
        Ficha fichaleatoria = null;
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

    /**
     *
     *
     *
     */
    public void engadirFichaAoChan() {
        Iterator<Cadrado> iter = fichaActual.cadrados.iterator();
        while (iter.hasNext()) {
            Cadrado item = iter.next();
            cadradosChan.add(item);
            item.lblCadrado.setBackground(Color.gray);

        }
    }

    /**
     *
     *
     *
     */
    public void borrarLinasCompletas() {
        int lineaCompleta=10;
        Iterator<Cadrado> actual = fichaActual.cadrados.iterator();
        while (actual.hasNext()) {
            Cadrado cactual = actual.next();
            Iterator<Cadrado> chan = cadradosChan.iterator();
            while (chan.hasNext()) {
                Cadrado cchan = chan.next();
                if (cchan.getY() == cactual.getY()) {
                    cadradosBorrar.add(cchan);
                }
            }
            if (cadradosBorrar.size() == lineaCompleta) {
                borrarLinas();
            }
            cadradosBorrar.removeAll(cadradosBorrar);
        }
    }
    /**
     *
     *
     *
     */
//    public void borrarLina(int y) {
//        ArrayList<Cadrado> cadradosBorrar = new ArrayList<>();
//        Iterator<Cadrado> iter = cadradosChan.iterator();
//        while(iter.hasNext()){
//            Cadrado cadradoChan = iter.next();
//            if(cadradoChan.getY() == y){
//                cadradosBorrar.add(cadradoChan);
//                System.out.println("entra if cadrados chan");
//            }
//        }
//        Iterator<Cadrado> iterBorrar = cadradosBorrar.iterator();
//        while(iterBorrar.hasNext()){
//            Cadrado cadradoBorrar= iter.next();
//            if(cadradosBorrar.size() == 10){
//                cadradosBorrar.remove(cadradoBorrar);
//                ventanaPrincipal.borrarCadrado(cadradoBorrar.lblCadrado);
//                System.out.println("entra en if borrar");
//            }
//            
//        }
//    }
    
    public void borrarLinas() {

        Iterator<Cadrado> blinea = cadradosBorrar.iterator();
        while (blinea.hasNext()) {
            Cadrado este = blinea.next();

            ventanaPrincipal.borrarCadrado(este.getLblCadrado());
            cadradosChan.removeAll(cadradosBorrar);
        }
    }

    /**
     *
     *
     *
     */
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

    /**
     *
     *
     *
     */
    private boolean comprobarCadradosChan(int y, int x) {
        boolean chanComprobado = false;
        Iterator<Cadrado> iter = cadradosChan.iterator();
        
        while (iter.hasNext()) {
            Cadrado item = iter.next();
            if ((item.y == (y + LADOCADRADO)) && (item.x == x)) {
                chanComprobado = true;             
            } 
        }    
        return chanComprobado;
    }

    /**
     *
     *
     *
     */
    public void moverFichaAbaixo() {
        fichaActual.moverAbaixo();
        actualizarGraf();
    }

    /**
     *
     *
     *
     */
    private void actualizarGraf() {
        if (chocaFichaCoChan() && !detectarFinPartida(cadradosChan)) {
            engadirFichaAoChan();
            borrarLinasCompletas();
            xenerarNovaFicha();
        } else if (detectarFinPartida(cadradosChan)) {
            pausa = true;
        }
    }

    /**
     *
     *
     *
     */
    private boolean detectarFinPartida(ArrayList<Cadrado> cadradoschan) {
        //Recorre el arraylist de cadrados chan
        for (int i = 0; i < cadradosChan.size(); i++) {
            //Si algun cuadrado tiene cordenada y=0 la partida ha terminado
            if (cadradosChan.get(i).getY() <= MIN_Y) {
                ventanaPrincipal.mostrarFinDoXogo();
                
                return true;
            }
        }
        //Si no se encuentra algun cuadrado en la cordenada y=0 la partida sigue
        return false;
    }
}
