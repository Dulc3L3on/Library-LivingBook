/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

import Modelo.Entidades.Libro.Libro;
import Modelo.Entidades.Usuario.Autor.Autor;

/**
 *
 * @author phily
 */
public class Obra {
    private final Libro libro;//serpa lbro o libro adquirido si es que la búsqueda es para tienda o miBiblioteca, respectivamente
    private final Autor autor;//será autor o autorSeguido, según lo de arriba 

    public Obra(Libro libro, Autor autor) {
        this.libro = libro;
        this.autor = autor;
    }

    public Libro getLibro() {
        return libro;
    }

    public Autor getAutor() {
        return autor;
    }
}
