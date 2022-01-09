/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

import java.sql.Date;

/**
 *
 * @author phily
 */
public class Noticia {
    private final Date fechaPublciacion;
    private final int IDCreador;
    private String asunto;
    private String tipoDeNoticia;//no le puse final a estos últimos 2, por si acaso llegara a permitir la edición...
    
    private final String tipo = "Noticia";

    public Noticia(Date fechaPublciacion, int IDCreador, String asunto, String tipo) {
        this.fechaPublciacion = fechaPublciacion;
        this.IDCreador = IDCreador;
        this.asunto = asunto;
        this.tipoDeNoticia = tipo;
    }

    public Date getFechaPublciacion() {
        return fechaPublciacion;
    }

    public int getIDCreador() {
        return IDCreador;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getTipo() {
        return tipoDeNoticia;
    }
    
    
}
