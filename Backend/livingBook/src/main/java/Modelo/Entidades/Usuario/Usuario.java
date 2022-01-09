/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades.Usuario;

import Modelo.Entidades.Configuracion;

/**
 *
 * @author phily
 */
public class Usuario {//iba a poner getter para que desde aquí se pudiera enviar la foto de perfil, pero mejor creo un objeto configuración de perfil aquí xD
     int ID;
     String nombre;
     String apellido;
     String username;
     String genero;
     String birthday;
     String paisOrigen;
     String password;
     String correo;
     int numeroTelefono;
     int numeroTarjeta;
     String fechaUnion;//mejor que sean string xD
     int esAutor;//no lo cambiarás a boolean???
     Configuracion configuracionCuenta;
     
     String tipo = "Usuario";//puesto que no sé como averiguar qué tipo envié desde aquí al enviar el resultado de la petición [puesto que Angular lo recibe como Object [no func instanceof, creo que era obvi xD, ni la función comparativa con tipo de retorno => is Tipo...

    public Usuario(int ID, String nombre, String apellido, String username, String genero, String birthday,
            String paisOrigen, String password, String correo, int numeroTelefono, int numeroTarjeta, 
            String fechaUnion, int esAutor) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.genero = genero;
        this.birthday = birthday;
        this.paisOrigen = paisOrigen;
        this.password = password;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaUnion = fechaUnion;
        this.esAutor = esAutor;
    }    
        
    public void setID(long ID){
        this.ID = (int) ID;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void serApellido(String apellido){
        this.apellido = apellido;
    }
   
    public void setPassword(String password) {
        this.password = password;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setEsAutor(int esAutor) {
        this.esAutor = esAutor;
    }
    
    /*el parámetro será establecido directament por la query que se
    exe justo después de crear el usuario por haberse LOGEADO correctamente*/
    public void setConfiguracionCuenta(Configuracion configuracionCuenta){
        this.configuracionCuenta = configuracionCuenta;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public String getUsername(){
        return username;
    }    

    public String getGenero() {
        return genero;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public String getPassword() {
        return password;
    }

    public String getCorreo() {
        return correo;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getFechaUnion() {
        return fechaUnion;
    }

    public int getEsAutor() {
        return esAutor;
    } 
    
    public Configuracion getConfiguracionCuenta(){
        return configuracionCuenta;
    }    
}
