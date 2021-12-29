/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Herramientas;

import Modelo.Entidades.Libro.Libro;
import Modelo.Entidades.Libro.LibroAdquirido;
import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class Casteador {
    
    public ArrayList<Libro> castearContenidoALibro(ArrayList<LibroAdquirido> librosAdquiridos){
        ArrayList<Libro> libros = new ArrayList<>();
        for (LibroAdquirido libroAdquirido: librosAdquiridos){
            libros.add(libroAdquirido);
        }
        return libros;        
    }
    
    public Libro castearALibro(LibroAdquirido libroAdquirido){
        return (Libro) libroAdquirido;
    }
    
}
