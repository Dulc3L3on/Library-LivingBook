/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DB.DAOs;

import Modelo.DB.ManejadorDB;
import Modelo.Entidades.Configuracion;
import Modelo.Herramientas.Transformador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author phily
 */
public class ConfiguracionDAO {
    private final Connection conexion;
    private final Transformador transformador;
    
    private final String BUSCAR_CONFIGURACION_CUENTA = "SELECT * FROM Configuracion WHERE IDUsuario = ?";
    private final String AGREGAR_DATOS_CONFIGURACION_CUENTA = "";
    
    public ConfiguracionDAO(){
        conexion = ManejadorDB.darConexion();
        transformador = new Transformador();
    }
        
    public Configuracion buscarConfiguracionDeLaCuenta(int IDUsuario){
        Configuracion configuracionCuenta = null;
        
        try(PreparedStatement statement = conexion.prepareStatement(BUSCAR_CONFIGURACION_CUENTA)){
              statement.setInt(1, IDUsuario);  
            
              ResultSet resultado = statement.executeQuery();                           
              
              if(resultado.first()){//si se hace necesario tener un método para buscar autor con el ID como único parámetro, entonces eliminarás el que se usa aquí y usarás ese nuevo método...
                    configuracionCuenta = transformador.transformarAConfiguracionDeCuenta(resultado);                    
              }              
          }catch(SQLException sqlE){
              System.out.println("Error at tried FIND the configuracion de la cuenta"+ sqlE.getMessage());              
          }              
        
        return configuracionCuenta;
    }
    
    public boolean actualizarConfiguracionDeLaCuenta(int IDUsuario){//en los métodos de acutalización se haría la corroboaración de existencia del objeto, para así crearlo o acutalizarlo. Esto solo en aquellos métodos en los que se trabaje con entidades propias de la sesión...
        //Puesto que hasta cierto punto no sabes exactamente cuando es que está agregando datos por primera vez, 
        //podrías emplear el comando de MYSQL que revisa si hay existencias, para actualizar o crear de ser el
        //caso contrario... sale más fácil porque no tendrías que crera un método para saber cuando invocar a
        //crear o actualizar, en el caso especial de la configuración
        
        return false;
    }  
    
}
