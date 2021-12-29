/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DB.DAOs;

import Modelo.DB.ManejadorDB;
import Modelo.Entidades.Usuario.Autor.AutorSeguido;
import Modelo.Herramientas.Transformador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author phily
 */
public class AutoresSeguidosDAO {
    private final Connection conexion;
    private final Transformador transformador;
    private final AutorDAO autorDAO;
    
    private final String ADD_SEGUIMIENTO_DE_AUTOR = "INSERT INTO AutorSeguido (IDSeguidor, IDAutor) "
                                                                                            + "VALUES (?,?)";
    private final String BUSCAR_AUTOR_SEGUIDO = "SELECT meGusta, seguidoDesde FROM AutorSeguido "
                                                                                    + "WHERE IDSeguidor = ? AND IDAutor = ?";
    private final String ACTUALIZAR_ME_GUSTA = "UPDATE AutorSeguido SET meGusta = ? "
                                                                                  + "WHERE IDSeguidor = ? AND IDAutor = ?";
    private final String DEJAR_DE_SEGUIR = "DELETE FROM AutorSeguido WHERE IDSeguidor = ? AND IDAutor = ?";
    
    public AutoresSeguidosDAO(){
        conexion = ManejadorDB.darConexion();
        transformador = new Transformador();
        autorDAO = new AutorDAO();
    }
    
    public boolean crearRelacionSeguimientoDeAutor(int IDSeguidor, int IDAutor){
         try(PreparedStatement statement = conexion.prepareStatement(ADD_SEGUIMIENTO_DE_AUTOR)){
              statement.setInt(1, IDSeguidor);
              statement.setInt(2, IDAutor);              
                            
              statement.executeUpdate();             
          }catch(SQLException sqlE){
              System.out.println("Error at tried INSERT the autor (Seguido)"+ sqlE.getMessage());
              return false;
          }        
        return true;
    }
    
    public AutorSeguido buscarAutor(int idSeguidor, int idAutor){//se utilizará cuando se requiera buscar un autor seguido en específico. También es útil para saber si el autor en cuestión o es seguido o no por el usuario actual...
       AutorSeguido autorSeguido = null;
        
          try(PreparedStatement statement = conexion.prepareStatement(BUSCAR_AUTOR_SEGUIDO, ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE)){
              statement.setInt(1, idSeguidor);
              statement.setInt(2, idAutor);

              ResultSet resultado = statement.executeQuery();             
                            
              autorSeguido = (resultado.first())?transformador.transformarAAutorSeguido(autorDAO.buscarAutor(idAutor), resultado):null;              
          }catch(SQLException sqlE){
              System.out.println("Error at tried FIND an author (seguido)"+ sqlE.getMessage());              
          }              
          return autorSeguido;
    }
    
    public boolean actualizarAutor(int estadoDe_MeGusta, int idSeguidor, int idAutor){//los parám son así puesto que, el obj autorSeguido no almacena el ID del seguidor puesto que el seguidor [Desde la perspectiva de la app funcionando para cada user] únicamente puede ser el usuario en sesión...        
          try(PreparedStatement statement = conexion.prepareStatement(ACTUALIZAR_ME_GUSTA)){
              statement.setInt(1, estadoDe_MeGusta);
              statement.setInt(2, idSeguidor);
              statement.setInt(3, idAutor);
                           
              statement.executeUpdate();
          }catch(SQLException sqlE){
              System.out.println("Error at tried UPDATE the author (Seguido)"+ sqlE.getMessage());
              return false;
          }
        return true;
    }
    
    public boolean eliminarAutor(int idSeguidor, int idAutor){
        try(PreparedStatement statement = conexion.prepareStatement(DEJAR_DE_SEGUIR)){
              statement.setInt(1, idSeguidor);
              statement.setInt(2, idAutor);
                                          
              statement.executeUpdate();              
        }catch(SQLException sqlE){
            System.out.println("Error at tried DELETE the autor (Seguido)"+ sqlE.getMessage());
            return false;
        }
        return true;
    }
}//Terminada xD uwu

//LÉELO: Si quiera tener algo como un historial para saber cuántas veces y cuando empezó o dejó de seguir a un autor, lo que debería hacer es
//crear una columna para AutorSeguido "dejeDeSeguirloEn" de tipo TIMSTAMP que obtendría su valor el día en el que el usuario presionara el btn 
//dejar de seguir y además de eso cada vez que presione el botón de seguimiento y este diga "seguir", se cree un nuevo registro, para lo cual no 
//habría problema, puesto que no hay corroboración de repetidos [al asignar un id a cada registro de esta tabla, para evitar tener relaciones repetidas]
//y de esa forma, para buscar, puesto que habría ID de seguidores y de autores iguales en más de un registro, que lo recuperado se ordenara a partir
//de la fecha de seguimiento desde la más reciente hasta la maś antigua y solo se actualice la #1 ó, puesto que se agregaría la columna de la
//fecha en la cual dejó de seguir al autor, poner como restricción que se actualice Ssi ese campo está vacío; es un hecho que dicha función de acutalización se invocaría
//solmanete cuando el usuario esté siguindo al autor, puesto que el btn de "meGusta" estará deshabilitado en el caso contrario xD

//pero como no voy a add esa columna, puesto que el tipo de negocio no requiere dicho historial, entonces cuando deje de seguirlo, simplemente eliminaré el registro xD
