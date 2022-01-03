/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades.Usuario.Autor;

import Modelo.Entidades.Usuario.Usuario;

/**
 *
 * @author phily
 */
public class Autor extends Usuario{    
     final String fechaDecision;    
     String descripcion;
     int cantidadMeGusta = 0;   
     
     public Autor(Usuario usuario, String fechaDecision, String descripcion, int cantidadMeGusta){
         this(usuario.getID(), usuario.getNombre(), usuario.getApellido(), usuario.getUsername(), usuario.getGenero(),
                 usuario.getBirthday(), usuario.getPaisOrigen(), usuario.getPassword(), usuario.getCorreo(), 
                 usuario.getNumeroTelefono(), usuario.getNumeroTarjeta(), usuario.getFechaUnion(), 1,
                 fechaDecision, descripcion, cantidadMeGusta);         
     }
        
    public Autor(int ID, String nombre, String apellido, String username, String genero, String birthday, String paisOrigen, String password, String correo, 
            int numeroTelefono, int numeroTarjeta, String fechaUnion, int esAutor, String fechaDecision, String descripcion, 
            int cantidadMeGusta) {
        
        super(ID, nombre, apellido, username, genero, birthday, paisOrigen, password, correo, numeroTelefono, numeroTarjeta, fechaUnion, esAutor);       
        
        this.fechaDecision = fechaDecision;        
        this.descripcion = descripcion;
        this.cantidadMeGusta = cantidadMeGusta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidadMeGusta(int cantidadMeGusta) {
        this.cantidadMeGusta = cantidadMeGusta;
    }

    public String getFechaDecision() {
        return fechaDecision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidadMeGusta() {
        return cantidadMeGusta;
    }    
}
