/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DB.DAOs;

import Modelo.DB.ManejadorDB;
import Modelo.Entidades.Libro.LibroAdquirido;
import Modelo.Herramientas.Transformador;
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
public class LibroAdquiridoDAO {//si no requiere de más métodos, entonces ya está terminada xD
     private final Connection conexion;
     private final Transformador transformador;
     private final TransformadorDeConjuntos transformadorConjunto;    
     
     private final String ADD_LIBRO_ADQUIRIDO = "INSERT INTO LibroAdquirido (IDUsuario, IDLibro) VAUES(?,?)";     
     private final String BUSCAR_LIBRO_ADQUIRIDO = "SELECT Libro.* LibroAdquirido.tiempoLectura,"
                                                                                            + " LibroAdquirido.fechaAdquisicion,  LibroAdquirido.meGusta"
                                                                                            + " FROM LibroAdquirido INNER JOIN Libro"
                                                                                            + " ON LibroAdquirido.IDLibro = Libro.ID "
                                                                                            + "WHERE LibroAdquirido.IDUsuario = ? AND"
                                                                                            + " LibroAdquirido.IDLibro = ?";
     private final String BUSCAR_LIBROS_ADQUIRIDOS = "SELECT Libro.* LibroAdquirido.tiempoLectura,"
                                                                                            + " LibroAdquirido.fechaAdquisicion,  LibroAdquirido.meGusta"
                                                                                            + " FROM LibroAdquirido INNER JOIN Libro"
                                                                                            + " ON LibroAdquirido.IDLibro = Libro.ID "
                                                                                            + "WHERE LibroAdquirido.IDUsuario = ?";   
     private final String DESECHAR_LIBRO_ADQUIRIDO = "DELETE FROM LibroAdquirido "
                                                                                            + "WHERE IDUsuario = ? AND IDLibro = ?";
     
     public LibroAdquiridoDAO(){
        conexion = ManejadorDB.darConexion();
        transformadorConjunto = new TransformadorDeConjuntos();
        transformador = new Transformador();
     }
     
     public boolean agregarAdquisicionDeLibro(int IDUsuario, int IDLibro){
         try(PreparedStatement statement = conexion.prepareStatement(ADD_LIBRO_ADQUIRIDO)){
              statement.setInt(1, IDUsuario);
              statement.setInt(2, IDLibro);
                           
              statement.executeUpdate();             
          }catch(SQLException sqlE){
              System.out.println("Error at tried INSERT the libro (Adquirido)"+ sqlE.getMessage());
              return false;
          }        
         return true;
     }
     
     public LibroAdquirido buscarLibroAdquirido(int IDUsuario, int IDLibro){
         LibroAdquirido libroAdquirido = null;
         
         try(PreparedStatement statement = conexion.prepareStatement(BUSCAR_LIBRO_ADQUIRIDO, 
                 ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){         

              statement.setInt(1, IDUsuario);
              statement.setInt(2, IDLibro);
              ResultSet resultado = statement.executeQuery();               
              
              libroAdquirido = transformador.transformarALibroAdquirido(resultado);              
          }catch(SQLException sqlE){
              System.out.println("Error at tried FIND libroS Adquiridos"+ sqlE.getMessage());              
          }             
         return libroAdquirido;
     }
     
     public ArrayList<LibroAdquirido> buscarLibrosAdquiridos(int IDUsuario){
         ArrayList<LibroAdquirido> librosAdquiridos = new ArrayList<>();
         
         try(PreparedStatement statement = conexion.prepareStatement(BUSCAR_LIBROS_ADQUIRIDOS, 
                 ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){         

              statement.setInt(1, IDUsuario);
              ResultSet resultado = statement.executeQuery();               
              
              librosAdquiridos = transformadorConjunto.transformarALibrosAdquiridos(resultado);              
          }catch(SQLException sqlE){
              System.out.println("Error at tried FIND libroS Adquirido"+ sqlE.getMessage());              
          }             
         return librosAdquiridos;
     }
     
     public boolean actualizarDatosLibroAdquirido(int IDUsuario, int IDLibro, String tipoDatoActualizar, int dato){//tipo de dato = nombreColumna, que puede ser [meGusta y tiempoLectura], el método solo updateará un dato por vez...     
         final String ACTUALIZAR_DATOS_LIBRO_ADQUIRIDO = "UPDATE LibroAdquirido SET "+tipoDatoActualizar+" = ? "
                                                                                                    + "WHERE IDUsuario = ? AND idLibro = ?";
         try(PreparedStatement statement = conexion.prepareStatement(ACTUALIZAR_DATOS_LIBRO_ADQUIRIDO)){           
              statement.setInt(1, dato);
              statement.setInt(2, IDUsuario);
              statement.setInt(3, IDLibro);
              
              statement.executeUpdate();
          }catch(SQLException sqlE){
              System.out.println("Error at tried UPDATE the libroAdquirido"+ sqlE.getMessage());
              return false;
          }         
          return true;
     }//Se quedará como un solo método por ahora, de dar problemas lo partirás en dos...
     
     public boolean eliminarLibroAdquirido(int IDUsuario, int IDLibro){
         try(PreparedStatement statement = conexion.prepareStatement(DESECHAR_LIBRO_ADQUIRIDO)){
              statement.setInt(1, IDUsuario);
              statement.setInt(2, IDLibro);
                                          
              statement.executeUpdate();              
          }catch(SQLException sqlE){
              System.out.println("Error at tried DELETE the libro (Adquirido)"+ sqlE.getMessage());
              return false;
          }        
         return true;
     }
}//TERMINADA uwu xD
