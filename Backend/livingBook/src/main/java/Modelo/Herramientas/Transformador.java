/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Herramientas;

import Modelo.Entidades.Configuracion;
import Modelo.Entidades.Libro.Libro;
import Modelo.Entidades.Libro.LibroAdquirido;
import Modelo.Entidades.Usuario.Autor.Autor;
import Modelo.Entidades.Usuario.Autor.AutorSeguido;
import Modelo.Entidades.Usuario.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phily
 */
public class Transformador {
    private final Herramienta herramienta;    
    
    public Transformador(){
        herramienta = new Herramienta();
    }
    
    private boolean verificarSiExistenResultados(ResultSet resultado){
        try {
            return resultado.first();
        } catch (SQLException ex) {
            Logger.getLogger(Transformador.class.getName()).log(Level.SEVERE, "Ningun resultado obtenido", ex);
            return false;
        }
    }
    
    public Usuario transformarAUsuario(ResultSet resultado){
        if(verificarSiExistenResultados(resultado)){
            try{
                return new Usuario(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4),
                                   resultado.getString(5), resultado.getString(6), resultado.getString(7),
                                   herramienta.desencriptarContraseña(resultado.getString(8)),  resultado.getString(9), 
                                   resultado.getInt(10), resultado.getInt(11), resultado.getDate(12).toString(), resultado.getInt(13));//ahí miras si te da problemas usar un sqlDate, para así usar el Date de java... más que todo por la transformación y por el envío a angular...
            
            }catch(SQLException sqlE){
                System.out.println("Error al TRANSFORMAR a usuario"+ sqlE.getMessage());
            }        
        }
       return null;
    }
    
    public Configuracion transformarAConfiguracionDeCuenta(ResultSet resultado){
        if(verificarSiExistenResultados(resultado)){//esti solo podría suceder si el usuario no seteo su foto de perfil/portada desde el inicio...
            try{
                return new Configuracion(resultado.getInt(1), resultado.getString(2), resultado.getBlob(3).toString(), 
                        resultado.getBlob(4).toString(), herramienta.transformarCadenaALista(resultado.getString(5), ","));//ahí miras si te da problemas usar un sqlDate, para así usar el Date de java... más que todo por la transformación y por el envío a angular...
            
            }catch(SQLException sqlE){
                System.out.println("Error al TRANSFORMAR a configuracion de cuenta"+ sqlE.getMessage());
            }        
        }        
        return null;
    }//ahí te recuerdas de eli el toString por cambiar el tipo de BLOB a TEXXT...
    
    public Autor transformarAAutor(Usuario usuario, ResultSet resultado){
        if(verificarSiExistenResultados(resultado)){        
            try{
                return new Autor(usuario, resultado.getDate(1).toString(),  resultado.getString(2), resultado.getInt(3));
            
            }catch(SQLException sqlE){
                System.out.println("Error al TRANSFORMAR a autor (login)"+ sqlE.getMessage());
            }         
        }
        return null;
    }
    
    public Autor transformarAAutor(ResultSet resultado){
        if(verificarSiExistenResultados(resultado)){
            try{
                return new Autor(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4),
                                    resultado.getString(5), resultado.getString(6), resultado.getString(7),
                                    herramienta.desencriptarContraseña(resultado.getString(8)),  resultado.getString(9), 
                                    resultado.getInt(10), resultado.getInt(11), resultado.getDate(12).toString(), resultado.getInt(13), 
                                    resultado.getDate(14).toString(), resultado.getString(15), resultado.getInt(16));//ahí miras si te da problemas usar un sqlDate, para así usar el Date de java... más que todo por la transformación y por el envío a angular...
                                
            }catch(SQLException sqlE){
                System.out.println("Error al TRANSFORMAR a autor (JOIN)"+ sqlE.getMessage());
            }        
        }
        return null;
    } 
    
    public AutorSeguido transformarAAutorSeguido(Autor autor, ResultSet resultado){
        if(verificarSiExistenResultados(resultado)){
            try{
                return new AutorSeguido(autor, resultado.getInt(1), resultado.getDate(2).toString());                                
            }catch(SQLException sqlE){
                System.out.println("Error al TRANSFORMAR a autor (JOIN)"+ sqlE.getMessage());
            }        
        }
        return null;
    }
        
    public Libro transformarALibro(ResultSet resultado){
        if(verificarSiExistenResultados(resultado)){
            try{
                return new Libro(resultado.getInt(1), resultado.getString(2), resultado.getDouble(3), resultado.getInt(4),
                                    resultado.getDate(5).toString(), resultado.getString(6), resultado.getString(7), resultado.getString(8),
                                    resultado.getString(9), resultado.getInt(10));
                                
            }catch(SQLException sqlE){
                System.out.println("Error al TRANSFORMAR a libro"+ sqlE.getMessage());
            }        
        }        
        return null;
    }
    
    public LibroAdquirido transformarALibroAdquirido(ResultSet resultado){
        if(verificarSiExistenResultados(resultado)){
            try{
                return new LibroAdquirido(resultado.getInt(1), resultado.getString(2), resultado.getDouble(3), resultado.getInt(4),
                                    resultado.getDate(5).toString(), resultado.getString(6), resultado.getString(7), resultado.getString(8),
                                    resultado.getString(9), resultado.getInt(13), //supongo que estará en la última, puesto que es lo último que aprece por SELECT en la query...
                                    resultado.getInt(10), resultado.getDate(11).toString(), resultado.getInt(12));                                
            }catch(SQLException sqlE){
                System.out.println("Error al TRANSFORMAR a libro Adquirido"+ sqlE.getMessage());
            }        
        }        
        return null;
    }
}
