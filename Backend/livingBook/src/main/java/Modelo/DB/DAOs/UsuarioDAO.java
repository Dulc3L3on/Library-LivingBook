/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DB.DAOs;

import Modelo.DB.ManejadorDB;
import Modelo.Entidades.Usuario.Autor.Autor;
import Modelo.Entidades.Usuario.Usuario;
import Modelo.Herramientas.Herramienta;
import Modelo.Herramientas.Transformador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author phily
 */
public class UsuarioDAO {//en este caso usuario = lector...
     private final Connection conexion;
     private final Herramienta herramienta;     
     private final Transformador transformador;
     private final AutorDAO autorDAO;
     private final ConfiguracionDAO configuracionDAO;
     
     private final String CREAR = "INSERT INTO Usuario (nombre, apellido, username, genero, birthday, paisOrigen, "
                                                    + " password, correo, numeroTelefono, numeroTarjeta, esAutor)"
                                                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
     private final String BUSCAR_USUARIO = "SELECT * FROM Usuario"
                                                                      + " WHERE userName = ? OR correo = ? AND password = ?";//puesto que no hay administrador, solo se requirá una busqueda para el login, a difernecia del autor, que tiene una opción propia para filtrarlos y encontrarlos...
     
     private final String ACTUALIZAR_USUARIO= "UPDATE Usuario SET nombre = ?, apellido = ?, username = ?,"
                                                                            + " password = ?, correo = ?, numeroTelefono = ?,  numeroTarjeta = ?"
                                                                            + "WHERE id = ?";//estos son todos los campos que se podrían editar, hasta el momento pienso que para no tener que revisar el valor de cada botón y así saber que dato actualizó, o hacer una función por dato, o hacer que se reciba una lista con los nombres de las columnas y los valores modificados, mejor que se envíen todos los datos que pueden ser actualizados, ya sea que haya recibido cambio o no...
          
      public UsuarioDAO(){
        conexion = ManejadorDB.darConexion();
        herramienta = new Herramienta();
        autorDAO = new AutorDAO();        
        transformador = new Transformador();
        configuracionDAO = new ConfiguracionDAO();
     }
     
     public void crearUsuario(Usuario usuario) throws SQLException{
         try ( //para exe, despues de exe login y signup correctamente
             PreparedStatement statement = conexion.prepareStatement(CREAR, 
                     Statement.RETURN_GENERATED_KEYS) ) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setString(3, usuario.getUsername());
            statement.setString(4, usuario.getGenero());
            statement.setString(5, usuario.getBirthday());
            statement.setString(6, usuario.getPaisOrigen());
            statement.setString(7, herramienta.encriptarContraseña(usuario.getPassword()) );
            statement.setString(8, usuario.getCorreo());
            statement.setInt(9, usuario.getNumeroTelefono());
            statement.setInt(10, usuario.getNumeroTarjeta());
            statement.setInt(11, usuario.getEsAutor());
             
            statement.executeUpdate();
            
           ResultSet resultado = statement.getGeneratedKeys();//a menos que no sea de tipo sqlException, no se catcheará el error al retornar la clave en el catch del servlet, sino pues se informará de esto con su respectivo msje xD           
           resultado.first();
               
           usuario.setID(resultado.getLong(1));
             System.out.println("Id usuario creado: "+ usuario.getID());
         
            if(usuario instanceof Autor){
                 autorDAO.crearAutor(usuario);
             }
             configuracionDAO.crearConfiguracionInicialCuenta(usuario.getID(), usuario.getGenero());
             //se llama al transformador, de ser necesario mantener un objeto de aquello que se requiera mantener en la sesión iniciada, es decir de ser nece crear un reporistorio xD          
         }
     }
     
      public Usuario buscarUsuario(String nameORemail, String password){//no se exe al registrarse el usuario, puesto que ya se poseerá el objeto en angular antes de nvocar al servlet para crear al usuario o editor, según corresp al tipo de obj/que esté o no chequeado el checkbox...
          Usuario usuario = null;          
          
          try(PreparedStatement statement = conexion.prepareStatement(BUSCAR_USUARIO, ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE)){
              statement.setString(1, nameORemail);
              statement.setString(2, nameORemail);
              statement.setString(3, password);
              
              ResultSet resultado = statement.executeQuery();                           
              
              if((usuario = transformador.transformarAUsuario(resultado))!= null){
                   usuario =  (resultado.getInt(11)==1)?autorDAO.buscarAutor(usuario, usuario.getID()):usuario;                                                                        
                   usuario.setConfiguracionCuenta(configuracionDAO.buscarConfiguracionDeLaCuenta(usuario.getID()));//habrá que hacer algo para "contraatacar" cuando el resultado sea null, para evitar errores con las axn del usuario, imagino que se deberá tratar allá en angular, cuando ya sea nec utilizar los datos que debería tener la configuración de la cuenta...              
                   System.out.println(usuario.getConfiguracionCuenta());
              }                            
          }catch(SQLException sqlE){
              System.out.println("Error at tried FIND the user"+ sqlE.getMessage());              
          }              
          return usuario;
     }     
            
       public boolean actualizarUsuario(Usuario usuario){
          Autor usuarioAutor = (usuario instanceof Autor)? (Autor) usuario:null;//si llego a necesitar más instanceo para el mismo u otros, crea una clase, para esto..
           
          try(PreparedStatement statement = conexion.prepareStatement(ACTUALIZAR_USUARIO)){
              statement.setString(1, usuario.getNombre());
              statement.setString(2, usuario.getApellido());
              statement.setString(3, usuario.getUsername());
              statement.setString(4, usuario.getPassword());
              statement.setString(5, usuario.getCorreo());
              statement.setInt(6, usuario.getNumeroTelefono());
              statement.setInt(7, usuario.getNumeroTarjeta());
              statement.setInt(8, usuario.getID());
              
              statement.executeUpdate();
          }catch(SQLException sqlE){
              System.out.println("Error at tried UPDATE the user"+ sqlE.getMessage());
              return false;
          }
          
          if(usuario.getEsAutor() == 1){
              autorDAO.actualizarAutor(usuarioAutor);
          }                    
          return configuracionDAO.actualizarDatosDeConfiguracion(usuario);
     }
       
}//TERMINADA uwu, porque no vamos a eliminar usuario (tpco autores xD)
