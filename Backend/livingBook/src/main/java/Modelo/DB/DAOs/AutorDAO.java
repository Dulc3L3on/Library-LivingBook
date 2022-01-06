/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DB.DAOs;

import Modelo.Entidades.Usuario.Autor.Autor;
import Modelo.DB.ManejadorDB;
import Modelo.Entidades.Usuario.Usuario;
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
public class AutorDAO {//acordemos que los string de las query sean descriptivas y os métodos tengan un nombre general, a menos que se requiera más de un tipo de axn y los paráms sean iguales o se requiera especificar la variación en el nombre del método para evitar posibles confusiones xD [este acuerdo será no solo para este proyecto xD]
    private final Connection conexion;
    private final Transformador transformador;
    private final TransformadorDeConjuntos transformadorConjunto;
    
    private final String CREAR_AUTOR ="INSERT INTO Autor (IDUsuario, descripcion) VALUES (?,?)";
    private final String BUSCAR_AUTOR = "SELECT Usuario.*, Autor.fechaDeUnion, Autor.descripcion, Autor.cantidadMeGusta "
                                                                  + "FROM Autor INNER JOIN Usuario ON Autor.IDUsuario = Usuario.IDUsuario "
                                                                 + "WHERE IDUsuario = ?";
    private final String BUSCAR_AUTOR_LOGIN = "SELECT fechaDeUnion, descripcion, cantidadMeGusta FROM Autor "
                                                                               + "WHERE IDUsuario = ? ";
    private final String BUSCAR_AUTORES = "SELECT * FROM Autor";
    private final String ACTUALIZAR_DESCRIPCION_DEL_AUTOR = "UPDATE Autor SET descripcion = ? WHERE IDUsuario = ?";//se empleará si el campo es descripción... o el #MeGustas cambió    
    
    public AutorDAO(){
     conexion = ManejadorDB.darConexion();
     transformador = new Transformador();
     transformadorConjunto = new TransformadorDeConjuntos();
   }   
        
    public void crearAutor(Usuario usuario) throws SQLException{//será invocado de ser necesario, luego de haber creado al usuario, puseto que el autor se debe registrar también en su tabla respectiva...
        Autor autor = (Autor) usuario;//solo podría dar error si es que no aviso al enviar el obj desde angular, que este es un autor... aunque por lo que ví con Marcos, si se puede notificar un nombre (aquí en este caso iría el tipo) y el objeto, entonces todo nice xD
        try (PreparedStatement statement = conexion.prepareStatement(CREAR_AUTOR)) {
            statement.setInt(1, autor.getID());
            statement.setString(2, autor.getDescripcion());
            
            statement.executeUpdate();
        }          
    }
    
    public Autor buscarAutor(Usuario usuario, int id){//se utilizaá para el login, en el cual no se sabe si el usuario es un lector o un autor...
       Autor autor = null;//recuerda que harbá que hay que imple la axn cuando esto sea null, es decir de error, en backend, por si acaso lo debes manejar y en frontend, el backend hará que en lugar de error tanto en él como en el forntend suceda algo lógico, en el caso del frontend un msje de advertencia del error xD
        
          try(PreparedStatement statement = conexion.prepareStatement(BUSCAR_AUTOR_LOGIN, ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE)){
              statement.setInt(1, id);

              ResultSet resultado = statement.executeQuery();               
              autor = transformador.transformarAAutor(usuario, resultado);              
          }catch(SQLException sqlE){
              System.out.println("Error at tried FIND an author (id)"+ sqlE.getMessage());              
          }              
          return autor;
    }
    
      public Autor buscarAutor(int id){//se utilizaá para formar las obras y el autorSeguido, es decir cuando quieras recuperar un autor específico
       Autor autor = null;
        
          try(PreparedStatement statement = conexion.prepareStatement(BUSCAR_AUTOR, ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE)){
              statement.setInt(1, id);

              ResultSet resultado = statement.executeQuery();               
              autor = transformador.transformarAAutor(resultado);              
          }catch(SQLException sqlE){
              System.out.println("Error at tried FIND an author (login)"+ sqlE.getMessage());              
          }              
          return autor;
    }
    
    public ArrayList<Autor> buscarAutores(){
        ArrayList<Autor> listaDeAutores = new ArrayList<>();//recuerda que harbá que hay que imple la axn cuando esto sea null, es decir de error, en backend, por si acaso lo debes manejar y en frontend, el backend hará que en lugar de error tanto en él como en el forntend suceda algo lógico, en el caso del frontend un msje de advertencia del error xD
        
          try(PreparedStatement statement = conexion.prepareStatement(BUSCAR_AUTORES, ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE)){         

              ResultSet resultado = statement.executeQuery();               
              
              listaDeAutores = transformadorConjunto.transformarAAutores(resultado);              
          }catch(SQLException sqlE){
              System.out.println("Error at tried find an USER"+ sqlE.getMessage());              
          }              
          return listaDeAutores;
    }
    
    public boolean actualizarAutor(Autor autor){//Será invocado por el método para actualizar usuario, puesto que no se buscará cual de los campos si cambio, para enviar solo esos a la DB, sino que serán enviados todos independientemente de que hayan sido actualizados o no...
        try(PreparedStatement statement = conexion.prepareStatement(ACTUALIZAR_DESCRIPCION_DEL_AUTOR)){
              statement.setString(1, autor.getDescripcion());
              statement.setInt(2, autor.getID());
              
              statement.executeUpdate();
          }catch(SQLException sqlE){
              System.out.println("Error at tried UPDATE the Author's description"+ sqlE.getMessage());          
              return false;
          }            
        return true;
    }
    
    public boolean actualizarCantidadMeGusta(String tipoOperacion, Autor autor){//enviarán un + o un - dependiendo en lugar del nombre y en el valor el autor, para evitar tener qué invocar más veces el método que permite intercambiar datos entre ANgular y Java...
        String ACTUALIZAR_ME_GUSTA = "UPDATE Autor SET cantidadMeGusta = cantidadMeGusta "+ tipoOperacion+" 1 WHERE IDUsuario = ?";
        
           try(PreparedStatement statement = conexion.prepareStatement(ACTUALIZAR_ME_GUSTA)){
              statement.setInt(1, autor.getID());
              
              statement.executeUpdate();
          }catch(SQLException sqlE){
              System.out.println("Error at tried UPDATE Author's like's number"+ sqlE.getMessage());          
              return false;
          }            
        return true;
    }
}

//Ver de nuevo si será nec o no tener un repo aquí; aunque ya creaste el transformador xD
