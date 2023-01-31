/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author a22hugorp
 */
public class Cadrado {
    public int x;
    public int y;
    public Color corRecheo;
    public JLabel lblCadrado = new JLabel();

    public Cadrado(int x, int y, Color corRecheo) {
        this.x = x;
        this.y = y;
        this.corRecheo = corRecheo;
        
        lblCadrado.setBackground(corRecheo);
        lblCadrado.setLocation(x, y);
    }
    
    
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public String getCoordenadas(){
        String coordenadas = "" + this.x + this.y;
        return coordenadas;
    } 
}
