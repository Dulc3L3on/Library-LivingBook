/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author phily
 */
public class Seguridad {
        private final Connection conexion;                        
        
        public Seguridad(){
            conexion = ManejadorDB.darConexion();
        }
    
        public boolean asegurarInexistencia(String tabla, String campoAVerificar){//útil para username, correo, #tel, #tarjeta, contraseña, al cambiarla...
            boolean hayExistencias = true;//por el error
            
             String BUSCAR_EXISTENCIA = "SELECT * FROM  "+tabla+" WHERE "+ campoAVerificar +" = ?";
            
              try(PreparedStatement instrucciones = conexion.prepareStatement(BUSCAR_EXISTENCIA,
                      ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
            
                     ResultSet resultado = instrucciones.executeQuery();           
                     hayExistencias = resultado.last();//o creo que era first... pureba y lo descubrirás xD                   
            }catch (SQLException e) {
                    System.out.println("Error: al buscar existencia de "+ campoAVerificar +" en "+tabla+"\n"+e.getMessage());
            }        
            return hayExistencias;
        }       
}
