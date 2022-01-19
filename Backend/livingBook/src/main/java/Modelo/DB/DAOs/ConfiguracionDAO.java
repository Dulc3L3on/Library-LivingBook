/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DB.DAOs;

import Modelo.DB.ManejadorDB;
import Modelo.Entidades.ConfiguracionCuenta;
import Modelo.Entidades.Usuario.Usuario;
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
    private final String CREAR_CONFIGURACION_INICIAL = "INSERT INTO Configuracion (IDUsuario, fotoPerfil, portada) "
                                                                                               + "VALUES (?,?,?)";
    private final String ACTUALIZAR_CONFIGURACION_CTA = "UPDATE Configuracion SET tema = ?, fotoPerfil = ?, "
                                                                                                     + "fotoPortada = ?, preferencias = ? WHERE IDUsuario = ?";
    
    public ConfiguracionDAO(){
        conexion = ManejadorDB.darConexion();
        transformador = new Transformador();
        herramienta = new Herramienta();
    }
    
     //se llama al crear el usuario y al actualizarl datos [es decir cuando presione "guardar" en la pág de configuraación...] xD
    public void crearConfiguracionInicialCuenta(int IDUsuario, String genero) throws SQLException{
         try(PreparedStatement statement = conexion.prepareStatement(CREAR_CONFIGURACION_INICIAL)){
              statement.setInt(1, IDUsuario);
              statement.setString(2, herramienta.establecerImagenPorDefecto("Perfil", genero));                       
              statement.setString(3, herramienta.establecerImagenPorDefecto("Portada", ""));
              
              statement.executeUpdate();            
          }
    }  
    
   /*
    Empleado al buscar usuario
    [lo cual no sería util para llenar el campo
    corresp de la entidad creada en Angular...]
    */
    public ConfiguracionCuenta buscarConfiguracionDeLaCuenta(int IDUsuario){
        ConfiguracionCuenta configuracionCuenta = null;
        
        System.out.println("Id usuario: "+ IDUsuario);
        try(PreparedStatement statement = conexion.prepareStatement(BUSCAR_CONFIGURACION_CUENTA,                 
                     ResultSet.TYPE_SCROLL_SENSITIVE, 
                     ResultSet.CONCUR_UPDATABLE)){
              statement.setInt(1, IDUsuario);  
            
              ResultSet resultado = statement.executeQuery();                           
              
              if(resultado.first()){//si se hace necesario tener un método para buscar autor con el ID como único parámetro, entonces eliminarás el que se usa aquí y usarás ese nuevo método...
                    System.out.println("Configuracion hallada");
                    configuracionCuenta = transformador.transformarAConfiguracionDeCuenta(resultado);                    
              }              
          }catch(SQLException sqlE){
              System.out.println("Error at tried FIND the configuracion de la cuenta"+ sqlE.getMessage());              
          }              
        
        System.out.println("Configuracion buscada y hallada");
        return configuracionCuenta;
    }
        
    public boolean actualizarDatosDeConfiguracion(Usuario usuario){
         ConfiguracionCuenta configuracion = usuario.getConfiguracionCuenta();
        
        try(PreparedStatement statement = conexion.prepareStatement(ACTUALIZAR_CONFIGURACION_CTA)){
              statement.setString(1, configuracion.getTema());//este campo nunca podrá estar vacío, puesto que los elige de un cbBox xD
              statement.setString(2, (configuracion.getFotoPerfil() == null)
                      ?herramienta.establecerImagenPorDefecto("Perfil", usuario.getGenero())
                      :configuracion.getFotoPerfil());//si funciona al crear la base64 en Angular entonces está bien que solo se use el get, sino (es decir si se requiere que se haga en el backend para que Angular pueda mostrar la foto) entonces enviarás el file, el nombre y el contexto a otro método que sirva para setear las imágenes (ya sea otro del de la imagen por defecto u otro xD, si es el de la img por defecto entonces ahí deberás revisar si es null o no para dejar la img por defecto o no, pue
              statement.setString(3, (configuracion.getFotoPortada() == null)
                      ?herramienta.establecerImagenPorDefecto("Portada", "")
                      :configuracion.getFotoPortada());
              statement.setString(4, (configuracion.getPreferencias()!=null)//entonces en el frontend se debe enviar null cuando no selecciones etiqueta alguna...
                      ?herramienta.transformarArregloACadena((String[])configuracion.getPreferencias().toArray())
                      :null);
              statement.setInt(5, usuario.getID());
              
              statement.executeUpdate();            
          }catch(SQLException sqlE){
              System.out.println("Error at tried UPDATE the config"+ sqlE.getMessage());
              return false;
          }
        return true;
    }  
    
    
    //tienes que ver por qué es que el resultado es null, si se supone que el first() dio true;    
}
