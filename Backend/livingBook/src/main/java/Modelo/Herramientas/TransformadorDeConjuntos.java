/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Herramientas;

import Modelo.Entidades.Libro.Libro;
import Modelo.Entidades.Libro.LibroAdquirido;
import Modelo.Entidades.Usuario.Autor.Autor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class TransformadorDeConjuntos {
    private final Transformador transformador;
    
    public TransformadorDeConjuntos(){
        transformador = new Transformador();
    }
    
     /*
    Se empleará cuando se requiera crear un autor con los datos completos
    */
    public ArrayList<Autor> transformarAAutores(ResultSet resultado){
         ArrayList<Autor> autores = new ArrayList<>();
        
        try{
            while(resultado.next()){//creo que hay que hacer algo antes de usar el next, con el first... unque de ser solo nec este, podrías utilizar el método para ver si hay existencias y para no repetir el cuerpo aquí, hacer que esta clase herede de transofmrado ó crear una instancia de él aquí xD, quizá sea mejor lo segundo, porque creo que será nec sus sericios aquí (porque allá convierte entidades individuales y aquí entidades en conjunto (lo que no sé si solo de tipo especial o todos los que puedan devolver más de una fila, dependerá de la cnatidad de métodos para convertir los especiales...)
                autores.add(transformador.transformarAAutor(resultado));
            }
        }catch(SQLException sqlE){
            System.out.println("Error al TRANSFORMAR a autorES"+ sqlE.getMessage());
        }                 
        return autores;
    }    
    
    public ArrayList<Libro> transformarALibros(ResultSet resultado){
        ArrayList<Libro> libros = new ArrayList<>();
        
        try{
            while(resultado.next()){//creo que hay que hacer algo antes de usar el next, con el first... unque de ser solo nec este, podrías utilizar el método para ver si hay existencias y para no repetir el cuerpo aquí, hacer que esta clase herede de transofmrado ó crear una instancia de él aquí xD, quizá sea mejor lo segundo, porque creo que será nec sus sericios aquí (porque allá convierte entidades individuales y aquí entidades en conjunto (lo que no sé si solo de tipo especial o todos los que puedan devolver más de una fila, dependerá de la cnatidad de métodos para convertir los especiales...)
                libros.add(transformador.transformarALibro(resultado));
            }
        }catch(SQLException sqlE){
            System.out.println("Error al TRANSFORMAR a libroS"+ sqlE.getMessage());
        }                 
        return libros;
    }     
    
    public ArrayList<LibroAdquirido> transformarALibrosAdquiridos(ResultSet resultado){//hay que crear otro método que haga lo mismo que este, solo que lo que retorne sea un Array<Libro> para que así no haya probema, creo que tb habrá que hacer dos métodos para el listado de autores seguidos, si es que el método actual devulve solo autores y no autores seguidos :v xD
        ArrayList<LibroAdquirido> librosAdquiridos = new ArrayList<>();
        
        try{
            while(resultado.next()){//creo que hay que hacer algo antes de usar el next, con el first... unque de ser solo nec este, podrías utilizar el método para ver si hay existencias y para no repetir el cuerpo aquí, hacer que esta clase herede de transofmrado ó crear una instancia de él aquí xD, quizá sea mejor lo segundo, porque creo que será nec sus sericios aquí (porque allá convierte entidades individuales y aquí entidades en conjunto (lo que no sé si solo de tipo especial o todos los que puedan devolver más de una fila, dependerá de la cnatidad de métodos para convertir los especiales...)
                librosAdquiridos.add(transformador.transformarALibroAdquirido(resultado));
            }
        }catch(SQLException sqlE){
            System.out.println("Error al TRANSFORMAR a libroS"+ sqlE.getMessage());
        }                 
        return librosAdquiridos;
    }        
}
