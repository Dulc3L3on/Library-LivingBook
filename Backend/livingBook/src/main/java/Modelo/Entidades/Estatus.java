/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

/**
 *
 * @author phily
 */
public class Estatus {
    private final String tipoDeEstatus;//successs, error (cuando el msje sea específico, es decir, cuando sea un 404, no se enviará un obj de estos, sino que de una vez se invocará a la página que dice esto [lo hago así puesto que quiero abarcar toda la página para informar de este error, y con los demás mostrar un div...), warning..
    private final String cuerpo;
    
    private String tipo = "Estatus";
    
    public Estatus(String tipo, String cuerpo){
        this.tipoDeEstatus = tipo;
        this.cuerpo = cuerpo;
    }
    
    public String getTipo(){
        return this.tipoDeEstatus;
    }
    
    public String getCuerpo(){
        return this.cuerpo;
    }
    
}
