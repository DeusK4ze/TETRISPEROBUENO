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

    public final int LADOCADRADO = 50;
    public int x;
    public int y;
    public Color corRecheo;
    public JLabel lblCadrado = new JLabel();

    public Cadrado(int x, int y, Color corRecheo) {
        this.x = x;
        this.y = y;
        this.corRecheo = corRecheo;
        lblCadrado = new JLabel();
        lblCadrado.setLocation(x, y);
        lblCadrado.setBackground(corRecheo);
        lblCadrado.setBounds(x, y, LADOCADRADO, LADOCADRADO);
        lblCadrado.setOpaque(true);
        lblCadrado.setVisible(true);
     
    }

    public void setCorRecheo(Color corRecheo) {
        this.corRecheo = corRecheo;
    }

    public void setLblCadrado(JLabel lblCadrado) {
        this.lblCadrado = lblCadrado;
    }

    public Color getCorRecheo() {
        return corRecheo;
    }

    public JLabel getLblCadrado() {
        return lblCadrado;
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

    public String getCoordenadas() {
        return x + " ; " + y;
    }
}
