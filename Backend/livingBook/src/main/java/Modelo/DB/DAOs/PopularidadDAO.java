/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DB.DAOs;

import Modelo.DB.ManejadorDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author phily
 */
public class PopularidadDAO {
    private final Connection conexion;    
    
    private final String CREAR_REGISTRO_POPULARIDAD_LIBRO = "INSERT INTO PopularidadLibro IDLibro "
                                                                                                            + "VALUES ?";
    
    private final String BUSCAR_MAYOR_ME_GUSTA_AUTOR = "SELECT cantidadMeGusta FROM Autor "
                                                                                                      + "ORDER BY cantidadMeGusta DESC LIMIT 1";
    private final String BUSCAR_MAYOR_ME_GUSTA_LIBRO = "SELECT cantidadMeGusta FROM PopularidadLibro "
                                                                                                    + "ORDER BY DESC LIMIT 1";
    
    //solo tienes que ver si lo que devulve cad método concuerda con lo que especificaste en el cuaderno, tb si fallé al add algo en el cuad o si no add una categoría o un elemento en una de ellas, luego terminar el de configuración [yo recuerdo que tiene algo especialito xD, creo que era para no tener que crear 2 métodos sino solo 1 para crear y actualizar [ahora ya sabes cómo se hace xD], lo de noticia no es nec porque no lo imple... sino tendrías que ampliar tu tiempo a más días... luego ver el tuto, hacer servlets, fusionar, ver desacuerdos entre cómo lo que puede haer ANgular para comunicar y cómo habías pensado que se así y por eso lo plasmaste en los paráms de los métodos de aquí y en los return, y si puedes hacer lo de los temas, portadas [colores y/o foto] (perfil sí lo harás xD) y apariencias [más que todo colro predeterminado xD] y LISTO jajaj [conigruación proy] si de verdad miras que ya usaste mucho tiempo para esto y quieres y/o debes hacer otra cosa en las mañanas porque ya es enero xD, solo haz lo necesario entonces, o en el más fuerte de los casos sólo infórmate cómo hacerlo y luego piensa en cómo se app a este caso, pero sería mejor aaplo, por los errores, incongruencias o escazes [es decir nohaber hecho funcionds o métodos o add algo]  que pusidte haber cometido por no saber cómo se comunicaban
    
    
    public PopularidadDAO(){
        conexion = ManejadorDB.darConexion();        
    }    
    
    public boolean crearRegistroDePopularidadLibroReciente(int IDLibro){
        try(PreparedStatement statement = conexion.prepareStatement(CREAR_REGISTRO_POPULARIDAD_LIBRO)){
              statement.setInt(1, IDLibro);
              
              statement.executeUpdate();                            
          }catch(SQLException sqlE){
              System.out.println("Error at tried INSERT the libro"+ sqlE.getMessage());
              return false;
          }
        return true;
    }
            
    //la popularidad se basará en el número mayor de MeGUstas de la tabla de popularidad correspondiente
    //croe que las demás búsquedas de los filtros si se hará en el DAO de la entidad correspondiente...

    private int buscarMayorCantidadMeGusta_Autor(){//o creo que podría hacerlo en una sola query (es decir la que corresp a las de abajito), pero bien pensada xD xD         
          try(PreparedStatement statement = conexion.prepareStatement(BUSCAR_MAYOR_ME_GUSTA_AUTOR, 
                  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){                        
              ResultSet resultado = statement.executeQuery();                           
              
              if(resultado.first()){
                    return resultado.getInt(1);
              }              
          }catch(SQLException sqlE){
              System.out.println("Error at tried FIND author's most popular"+ sqlE.getMessage());              
          }                      
        return -1;//allá en angular cuando reciba un menos 1, mostrará todas las estrellitas en blanco, y en el caso de la búsqueda por filtros, dirá que ningún autor por el momento ha recibido un "me gusta"
    }
    
    private int buscarMayorCantidadMeGusta_Libro(){
        try(PreparedStatement statement = conexion.prepareStatement(BUSCAR_MAYOR_ME_GUSTA_LIBRO, 
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){                        
              ResultSet resultado = statement.executeQuery();                           
              
              if(resultado.first()){
                    return resultado.getInt(1);
              }              
          }catch(SQLException sqlE){
              System.out.println("Error at tried FIND libro's most popular"+ sqlE.getMessage());              
          }                      
        return -1;
    }
    
    public double getPorcentajePopularidad(String tipoObjeto, int canitdaMeGustaDelObjeto){
        if(tipoObjeto.equals("Autor")){
            return canitdaMeGustaDelObjeto/buscarMayorCantidadMeGusta_Autor();//no se almacena el valor, puesto que este dato es cambiante a una velocidad desconocida...
        }
        return canitdaMeGustaDelObjeto/buscarMayorCantidadMeGusta_Libro();
    }
    
    
    //se me estaba ocurriendo un método resetear xD, por lo que hizo youtube con los "me gusta", pero quizá sería mejor no resetear xD
}//TERMINADA uwu xD, a menos que se requieran más métodos relacionados con la popularidad

