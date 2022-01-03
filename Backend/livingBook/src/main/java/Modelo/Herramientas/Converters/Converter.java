/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Herramientas.Converters;

import com.google.gson.Gson;

/**
 *
 * @author phily
 * @param <T>
 */
public abstract class Converter<T> {
    private Gson gson;
    private Class<T> typeConverter;

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
