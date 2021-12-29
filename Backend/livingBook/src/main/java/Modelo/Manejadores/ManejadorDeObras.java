/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Manejadores;

import Modelo.DB.DAOs.AutorDAO;
import Modelo.DB.DAOs.AutoresSeguidosDAO;
import Modelo.DB.DAOs.LibroAdquiridoDAO;
import Modelo.DB.DAOs.LibroDAO;
import Modelo.Entidades.Libro.Libro;
import Modelo.Entidades.Libro.LibroAdquirido;
import Modelo.Entidades.Obra;
import Modelo.Entidades.Usuario.Autor.Autor;
import Modelo.Entidades.Usuario.Autor.AutorSeguido;
import Modelo.Herramientas.Casteador;
import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class ManejadorDeObras {//Creo que estos métodos deben colocarse directamente en el cuerpo del servlet correspondiente [1 será para la tienda y otro será para miBiblioteca] con e fin de evitar el tener un parámetro para saber que tipo de listados pedir...
    private final LibroAdquiridoDAO libroAdquiridoDAO;
    private final LibroDAO libroDAO;
    private final AutorDAO autorDAO;   
    private final AutoresSeguidosDAO autorSeguidoDAO;
    private final Casteador casteador;

    public ManejadorDeObras(){
        libroAdquiridoDAO = new LibroAdquiridoDAO();
        libroDAO = new LibroDAO();
        autorDAO = new AutorDAO();
        autorSeguidoDAO = new AutoresSeguidosDAO();
        casteador = new Casteador();
    }
    
    public ArrayList<Obra> buscarListadoObras_SesionNoIniciada(){
        ArrayList<Obra> obras = new ArrayList<>();
        ArrayList<Libro> losLibros = libroDAO.buscarLibros();
        
        //if(!losLibros.isEmpty()){
            for (Libro libros : losLibros) {
                //por la forma en que hago esto, creo que los métodos de los DAO [para objetos individuales] en lugar de devolver null, debería devolver una nueva instancia, para que así la clase de cada objeto devuelva un valor default cuando no tenga datos, para así no tener que hacer tanta corroboración en el FRONTEND...               
                obras.add(new Obra(libros, autorDAO.buscarAutor(libros.getIDautor())));
                //o era pedir el autor a la DB, o crear un métood para buscar los obj por ID,puesto que todos poseen ese campo, podría haberse hecho en una clase Paraméttrica...
            //}
        }
        return obras;
    }
    
    public ArrayList<Obra> buscarListadoObras_SesionIniciada(String luegarDestinoDeLaObra, int IDUsuario){        
        ArrayList<Obra> obras = new ArrayList<>();
        ArrayList<Libro> losLibros;        
        
        if(luegarDestinoDeLaObra.equals("Tienda")){
            losLibros = libroDAO.buscarLibros();
            
            reemplazarSiLibroYaEstaAdquirido(losLibros, IDUsuario);
        }else {//MiBiblioteca
            losLibros = casteador.castearContenidoALibro(libroAdquiridoDAO.buscarLibrosAdquiridos(IDUsuario));
        }
               
        for (Libro libro : losLibros) {     
           AutorSeguido autorSeguido= autorSeguidoDAO.buscarAutor(IDUsuario, libro.getIDautor());               
           obras.add(new Obra(libro, (autorSeguido!= null)?autorSeguido:autorDAO.buscarAutor(libro.getIDautor())));                
        }        
        return obras;       
    }
    
    public ArrayList<Obra> buscarListadoObras_PaginaAutor(String luegarDestinoDeLaObra, Autor elAutor, int IDVisitante){//lugar de destino = creaciones o página del autor, perspectiva de visitante        
        ArrayList<Obra> obras = new ArrayList<>();
        ArrayList<Libro> losLibros = libroDAO.buscarLibrosCreados(elAutor.getID());        
        
        if(luegarDestinoDeLaObra.equals("Visitante")){
            reemplazarSiLibroYaEstaAdquirido(losLibros, IDVisitante);
        }        
        
        //el autor recibido como parám será solo autor o seguido, puesto que este objeto se obtendrá de la lista de obras que se buscó para el componente dese el cual hizo click sobre el autor (tienda o miBiblioteca) para la cual se hizo la búsqueda para saber si lo sigue o no xD
         for (Libro libro : losLibros) {            
           obras.add(new Obra(libro, elAutor));                
        }                
        return obras;       
    }     
    
    private void reemplazarSiLibroYaEstaAdquirido(ArrayList<Libro> losLibros, int IDPosibleDueño){
        LibroAdquirido libroAdquirido;
        
        for (Libro libro : losLibros) {     
                libroAdquirido= libroAdquiridoDAO.buscarLibroAdquirido(IDPosibleDueño, libro.getIDautor());            
                
                if(libroAdquirido!= null){
                    losLibros.add(losLibros.indexOf(libro), libroAdquirido);
                    losLibros.remove(libro);//puesto que mueve los elementos que se encontraban en la posi add o posterior a ella, 1 lugar a la derecha
                }//esto es el equivalente a un reemplazo :v xD. Iba a crear una clase para no tener que repetir esto, pero de ser así tendría que crear el equivalente de este objeto en Angular y reemplazar todos los arrayList por una instancia de la clase que yo cree. si se repite mucho este bloque deplano que sí tendré que hacerlo...            
        }
    }
    
}//terminada uwu