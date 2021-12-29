/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades.Libro;

import java.sql.Date;

/**
 *
 * @author phily
 */
public class Libro {
     final int ID;
     String nombre;
     double precio;
     final int IDautor;
     final Date fechaPublicacion;
     String reseña;
     final String tipo;
     final String portada;//imagen en base64
     final String archivoPDF;//en base64

    public Libro(int ID, String nombre, double precio, int IDautor, Date fechaPublicacion, String reseña, 
            String tipo, String portada, String archivoPDF) {
        this.ID = ID;
        this.nombre = nombre;
        this.precio = precio;
        this.IDautor = IDautor;
        this.fechaPublicacion = fechaPublicacion;
        this.reseña = reseña;
        this.tipo = tipo;
        this.portada = portada;
        this.archivoPDF = archivoPDF;
    }    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setReseña(String reseña) {
        this.reseña = reseña;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getIDautor() {
        return IDautor;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getReseña() {
        return reseña;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPortada(){
        return portada;
    }
    
    public String getArchivoPDF() {
        return archivoPDF;
    }
    
    /*creo que los setter no serán necesarios, porque si no estoy mal, siemre debería estarse solicitando
    la info a la DB... y además no hay axn que se generen aquí en el Backend que pueda setear otro 
    dato... además aquí no hay algo como un observable como para que pueda reflejarse el cambio hecho 
    aquí en el contenido recibido por Angular...*/
}
