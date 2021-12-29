/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades.Libro;

/**
 *
 * @author phily
 */
public class PopularidadLibro {
     private final int IDLibro;
     private int cantidadMeGusta = 0;

    public PopularidadLibro(int IDLibro, int cantidadMeGusta) {
        this.IDLibro = IDLibro;
        this.cantidadMeGusta = cantidadMeGusta;
    }

    public int getIDLibro() {
        return IDLibro;
    }

    public int getCantidadMeGusta() {
        return cantidadMeGusta;
    }    
}
