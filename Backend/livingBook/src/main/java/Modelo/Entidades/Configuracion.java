/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

import java.util.List;

/**
 *
 * @author phily
 */
public class Configuracion {
    private final int IDUsuario;
    private String tema;
    private String fotoPerfil;//en Base64
    private String portada;//en Base64, sin importar que decida que sea un gradiente o una imagen, si es gradiente pienso enviar el color así normal xD
    private List<String> preferencias;//si no se logra enviar el Array desde angular hacia aquí, tendrá que pasarse a un String[]
    
    private String tipo = "Configuracion_Cuenta";

    public Configuracion(int IDUsuario, String tema, String fotoPerfil, String fotoPortada, List<String> preferencias) {
        this.IDUsuario = IDUsuario;
        this.tema = tema;
        this.fotoPerfil = fotoPerfil;
        this.preferencias = preferencias;
    }

    //recuerda que los setter los tengo para actulizar el objeto que se encuentra almacenado en el repositorio para así no generar otro... pero debes indicar esto antes de transformar el result a un objeto, es decir, si y existe uno, entonces utilizarás los respectivos setter, por medio de otro constructor y si no, pues el constructor para crear xD
    
    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public void setFotoPortada(String fotoPortada) {
        this.portada = fotoPortada;
    }    

    public void setPreferencias(List<String> preferencias) {
        //aquí la lógica para separar por ","
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public String getTema() {
        return tema;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }
    
    public String getFotoPortada(){
        return portada;
    }

    public List<String> getPreferencias() {
        return preferencias;
    }
    
    //debes ver cómo hizo Marcos para establecer un BLOB en una varibale String al recuperar los datos de la DB. Menciono que la var es string, porque ví que ese tipo tenía la var corresp en ANgular, entonces imgaino que en java también es String xD
}
