/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Herramientas.JSON;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author phily
 */
public class BodyExtractor {
    
    public String getBody(BufferedReader theReader){
           BufferedReader reader = theReader;
           String body = "";
           String line = "";
        try {
            while (line != null) {
                body = body + line;
                line = reader.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error at tried READ request's body"+ex.getMessage());
        }         
          
          System.out.println("body:");    
          System.out.println(body);          
          return body;
    }
    
}
