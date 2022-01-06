/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Herramientas.JSON;

import com.google.gson.Gson;

/**
 *
 * @author phily
 * @param <T>
 */
public class Converter<T> {//puesto que no voy a crear otras clases como para tener una "instancia" de esta, entonces no puedo dejarla como abstract...
    private final Gson gson;
    private final Class<T> typeConverter;//o erar tener una nueva instancia o usar un setter :v, para evitar posibles confusiones mejor sin setter xD

    public Converter(Class<T> typeConverter) {
        this.gson = new Gson();
        this.typeConverter = typeConverter;
    }
    
    public T fromJson(String json) {
        return gson.fromJson(json, typeConverter);
    }
    
    public String toJson(T object) {
        return gson.toJson(object, typeConverter);
    }
}
