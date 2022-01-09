/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades.Libro;

/**
 *
 * @author phily
 */
public class LibroAdquirido extends Libro{    
    private int tiempoLectura;
    private final String fechaAdquisicion;
    private int meGusta;//eqq qboolean
    
    String tipo = "Libro_Adquirido";

    public LibroAdquirido(int ID, String nombre, double precio, int IDautor, String fechaPublicacion, String reseña, 
            String tipo, String portada, String archivoPDF, int cantidadMeGusta, int tiempoLectura, 
            String fechaAdquisicion, int meGusta) {
        super(ID, nombre, precio, IDautor, fechaPublicacion, reseña, tipo, portada, archivoPDF, cantidadMeGusta);
        
        this.tiempoLectura = tiempoLectura;
        this.fechaAdquisicion = fechaAdquisicion;
        this.meGusta = meGusta;
    } 

    public void setTiempoLectura(int tiempoLectura) {
        this.tiempoLectura = tiempoLectura;
    }//me imagino que se hará por medio de una función (o un hilo) que se exe a partir de que de click a leer y se terminará cuando se destruya el componente de preisualización... y/o cuando la sesión se cierre... esto por el hecho de que se abre en una ventana nueva...

    public void setMeGusta(int meGusta) {//Esto se establecerá luego de que el componente sea DESTRUIDO, para evitar estar llamando cada vez al servicio de la DB, a menos que esto pueda provocar algún desacuerdo...
        this.meGusta = meGusta;
    }   

    public int getTiempoLectura() {
        return tiempoLectura;
    }

    public String getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public int getMeGusta() {
        return meGusta;
    }
    
    
}
