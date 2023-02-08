/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.util.Iterator;

/**
 *
 * @author thicc
 */
public class FichaCadrada extends Ficha{
    Iterator<Cadrado> it = cadrados.iterator();
    int x = super.cadrados.get(0).getX();
    int y = super.cadrados.get(0).getY();

    public Cadrado c1 = new Cadrado();
    public Cadrado c2 = new Cadrado();
    public Cadrado c3 = new Cadrado();
    public Cadrado c4 = new Cadrado();

    public FichaCadrada() {
        cadrados.add(c1);
        cadrados.add(c1);
        cadrados.add(c1);
        cadrados.add(c1);
    }
    
    @Override
    public boolean rotarFicha(){
        
    }
}
