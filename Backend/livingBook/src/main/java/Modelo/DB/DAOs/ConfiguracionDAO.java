/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DB.DAOs;

import Modelo.DB.ManejadorDB;
import Modelo.Entidades.Configuracion;
import Modelo.Herramientas.Herramienta;
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
    private final Herramienta herramienta;
   //Luego de registrarse exitosamente, se exe la guarda de login, que empleará los métodos del backend para obtener los datos de conf,
    //[puesto que ya posee los del usuario al contrario del caso en el que se esté logeando directametne], esto con el fin de no tener
    //una lógica repetida, por el tipo de foto de perfil y tb resulta mejor, puesto que es posible que los valores por defecto cb
    //y por lo tanto de esta manera se evitaría tener que cb los datos en más de un lugar...
    
    private final String BUSCAR_CONFIGURACION_CUENTA = "SELECT * FROM Configuracion WHERE IDUsuario = ?";
    private final String CREAR_CONFIGURACION_INICIAL = "INSERT INTO Configuracionn (IDUsuario, fotoPerfil) "
                                                                                               + "VALUES (?,?)";
    private final String ACTUALIZAR_CONFIGURACION_CTA = "UPDATE Configuracion SET tema = ?, fotoPerfil = ?, "
                                                                                                     + "fotoPortada = ?, preferencias = ? WHERE IDUsuario = ?";
    
    public ConfiguracionDAO(){
        conexion = ManejadorDB.darConexion();
        transformador = new Transformador();
        herramienta = new Herramienta();
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
    
    //se llama al crear el usuario y al actualizarl datos [es decir cuando presione "guardar" en la pág de configuraación...] xD
    public boolean crearConfiguracionInicialCuenta(int IDUsuario, String genero){
         try(PreparedStatement statement = conexion.prepareStatement(CREAR_CONFIGURACION_INICIAL)){
              statement.setInt(1, IDUsuario);
              statement.setString(2, herramienta.establecerFotoPerfilPorDefecto(genero));                       
              
              statement.executeUpdate();            
          }catch(SQLException sqlE){
              System.out.println("Error at tried INSERT the config"+ sqlE.getMessage());
              return false;
          }
        return true;
    }  
    
    public boolean actualizarDatosDeConfiguracion(int IDUsuario, Configuracion configuracion){
        try(PreparedStatement statement = conexion.prepareStatement(CREAR_CONFIGURACION_INICIAL)){
              statement.setString(1, configuracion.getTema());
              statement.setString(2, configuracion.getFotoPerfil());
              statement.setString(3, configuracion.getFotoPortada());
              statement.setString(4, herramienta.transformarArregloACadena(
                      (String[])configuracion.getPreferencias().toArray()));
              statement.setInt(5, IDUsuario);
              
              statement.executeUpdate();            
          }catch(SQLException sqlE){
              System.out.println("Error at tried UPDATE the config"+ sqlE.getMessage());
              return false;
          }
        return true;
    }  
    
}
