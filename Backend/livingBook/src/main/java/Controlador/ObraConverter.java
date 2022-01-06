/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Herramientas.JSON.Converter;

/**
 *
 * @author phily
 */
public class ObraConverter extends Converter<ObraConverter>{
    //quizá esta no sea útil, puesto que siempre se enviará una lista, a menos que en el nombre puedas indicar
    //que hay autores seguidos, libros adquiridos, si es que resulta necesario para hacer la conversión 
    //de forma correcta en Angular...

    public ObraConverter(Class<ObraConverter> typeConverter) {
        super(typeConverter);
    }  
    
}
