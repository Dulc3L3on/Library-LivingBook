/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DB.DAOs;

import Modelo.DB.ManejadorDB;
import Modelo.Entidades.Libro.Libro;
import Modelo.Herramientas.TransformadorDeConjuntos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class LibroDAO {
     private final Connection conexion;
     private final TransformadorDeConjuntos transformadorConjunto;    
     private final PopularidadDAO popularidadDAO;
     
     private final String CREAR_LIBRO = "INSERT INTO Libro (nombre, precio, IDautor, resenia, tipo, portada, archivoPDF) "
                                                              + "VALUES (?,?,?,?,?,?,?)";
     private final String BUSCAR_LIBROS = "SELECT * FROM Libro";
     //este listado al igual que el de los de la tienda y los de miBiblioteca, será pasado al repositorio por medio de comunicación padre/ (data binding) bueno si es que invoco el repositorio por medio del selector...
     private final String BUSCAR_LIBROS_CREADOS = "SELECT * FROM Libro WHERE IDautor = ?";//se utilizará cuando un usuario visite la página de un autor en particular, luego de haber clickeado en su alias (el nombre lo verá hasta llegar a su perfil...)
     private final String ACTUALIZAR_LIBRO = "UPDATE Libro SET nombre = ?, precio = ?, resenia = ?, tipo = ?,"
                                                                         + " portada = ?, archivoPDF = ?";
     private final String BORRAR_LIBRO = "DELETE FROM Libro WHERE ID = ?";//tb se debería eliminar de libro adquirido y popularidad libro, por eso ON DELETE CASCADE en ellos xD
     //si el autor elimina su cuenta, en realidad no se borrará nada, solo se le hará una marca, pues no tendrían porqué desapareer sus obras, estas solo se eliminarán si el autor lo hace directamente...
     
     public LibroDAO(){
        conexion = ManejadorDB.darConexion();
        transformadorConjunto = new TransformadorDeConjuntos();
        popularidadDAO = new PopularidadDAO();
     }
     
     public boolean crearLiibro(Libro libro){
         try(PreparedStatement statement = conexion.prepareStatement(CREAR_LIBRO)){
              statement.setString(1, libro.getNombre());
              statement.setDouble(2, libro.getPrecio());
              statement.setInt(3, libro.getIDautor());
              statement.setString(4, libro.getReseña());
              statement.setString(5, libro.getTipo());
              statement.setString(6, libro.getPortada());
              statement.setString(7, libro.getArchivoPDF());
                            
              statement.executeUpdate();              
              
              return popularidadDAO.crearRegistroDePopularidadLibroReciente(libro.getID());
          }catch(SQLException sqlE){
              System.out.println("Error at tried INSERT the libro"+ sqlE.getMessage());
              return false;
          }          
     }
     
     public ArrayList<Libro> buscarLibros(){
         ArrayList<Libro> libros = new ArrayList<>();
         
         try(PreparedStatement statement = conexion.prepareStatement(BUSCAR_LIBROS, 
                 ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){         

              ResultSet resultado = statement.executeQuery();               
              
              libros = transformadorConjunto.transformarALibros(resultado);              
          }catch(SQLException sqlE){
              System.out.println("Error at tried FIND libroS"+ sqlE.getMessage());              
          }             
         return libros;
     }
     
     public ArrayList<Libro> buscarLibrosCreados(int idAutor){
         ArrayList<Libro> libros = new ArrayList<>();
         
         try(PreparedStatement statement = conexion.prepareStatement(BUSCAR_LIBROS_CREADOS, 
                 ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){         

              ResultSet resultado = statement.executeQuery();               
              
              libros = transformadorConjunto.transformarALibros(resultado);              
          }catch(SQLException sqlE){
              System.out.println("Error at tried FIND libroS (Creados)"+ sqlE.getMessage());              
          }             
         return libros;
     }
     
     public boolean actualizarLibro(Libro elLibro){           
          try(PreparedStatement statement = conexion.prepareStatement(ACTUALIZAR_LIBRO)){
              statement.setString(1, elLibro.getNombre());
              statement.setDouble(2, elLibro.getPrecio());
              statement.setString(3, elLibro.getReseña());
              statement.setString(4, elLibro.getTipo());
              statement.setString(5, elLibro.getPortada());
              statement.setString(6, elLibro.getArchivoPDF());//yo diría que este campo no lo pueda editar, así como en youtube, si se confundió entonces que elimine la publicación...
              
              statement.executeUpdate();
          }catch(SQLException sqlE){
              System.out.println("Error at tried UPDATE the user"+ sqlE.getMessage());
              return false;
          }         
         return true;
     }
     
     public boolean eliminarLibro(int IDLibro){
         try(PreparedStatement statement = conexion.prepareStatement(BORRAR_LIBRO)){
              statement.setInt(1, IDLibro);
                                          
              statement.executeUpdate();              
          }catch(SQLException sqlE){
              System.out.println("Error at tried DELETE the libro"+ sqlE.getMessage());
              return false;
          }
          return true;
     }
}//TERMINADA uwu xD

//OJO todos los UPDATE, deberán devolver el objeto actualizado, si es que el objeto no radica en una lista (puesto que se acordó que al ser listas,
// de objetos, esta se solicitaría de nuevo, cada vez que se exe una axn que cb la info,o cuando se "releyera" el componente para ser renderizado
//[releer por -> redirección, navegación routedLinkeado, llamado directo con selector...], de tal forma que ANGULAR pueda tener la info actualizada
//NOOOO, se aplicará la nota del cuaderno... es decir, ni los create, update y delete tienen por qué devolver un obj, solo las búsquedas de listados o de un objeto que estes segura no poseas aún en el frontend
