/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades.Usuario.Autor;

import java.sql.Date;

/**
 *
 * @author phily
 */
public class AutorSeguido extends Autor{//en realidad solo va a ser útil para angular, porque no exe axn alguna...    
    private int meGusta;//no había boolean por eso es int xD
    private final Date seguidoDesde;
    
    public AutorSeguido(Autor autor, int meGusta, Date seguidoDesde){
        this(autor.getID(), autor.getNombre(), autor.getApellido(), autor.getUsername(), autor.getGenero(), autor.getBirthday(),
                autor.getPaisOrigen(), autor.getPassword(), autor.getCorreo(), autor.getNumeroTelefono(), autor.getNumeroTarjeta(),
                autor.getFechaUnion(), 1, autor.getFechaDecision(), autor.getDescripcion(), autor.getCantidadMeGusta(), meGusta,
                seguidoDesde);
    }

    public AutorSeguido(int ID, String nombre, String apellido, String username, String genero, String birthday, 
            String paisOrigen, String password, String correo, int numeroTelefono, int numeroTarjeta, Date fechaUnion,
            int esAutor, Date fechaDecision, String descripcion, int cantidadMeGusta, int meGusta, Date seguidoDesde) {
            
            super(ID, nombre, apellido, username, genero, birthday, paisOrigen, password, correo, numeroTelefono, 
                numeroTarjeta, fechaUnion, esAutor, fechaDecision, descripcion, cantidadMeGusta);
            
            this.meGusta = meGusta;
            this.seguidoDesde = seguidoDesde;
    }
  
    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
    }

    public int getMeGusta() {
        return meGusta;
    }

    public Date getSeguidoDesde() {
        return seguidoDesde;
    }      
    
}
