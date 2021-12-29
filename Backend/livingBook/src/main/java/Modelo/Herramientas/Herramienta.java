/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Herramientas;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author phily
 */
public class Herramienta {
    private final String contraseniaMaestra = "MasterLivingBookPass";
    
     public String generarContraseñaAleatoria(){
          Random caracterAleatorio = new Random();
          Random tamanioAleatorio = new Random();
          String contrasenia = "";
        
          int tamanio = 8 + tamanioAleatorio.nextInt(13);//recuerda que comieza desde 0...
        
          for (int caracterActual = 0; caracterActual < tamanio; caracterActual++) {            
               contrasenia+= Character.toString(33+caracterAleatorio.nextInt(94));            
          }
        
          return contrasenia;
     }
     
     public String encriptarContraseña(String contraseniaReal){
      String encriptada=null;        
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(contraseniaMaestra.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = contraseniaReal.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.getEncoder().encode(buf);
            encriptada = new String(base64Bytes);            
        } catch (Exception ex) {
            System.out.println("surgió un error al cifrar\nla contrasenia\n"+ex.getMessage());
            encriptada = null;
        }
        return encriptada;
     }
     
     public String desencriptarContraseña(String encriptada){
        String desencriptada=null;        
        
        try {
            byte[] message = Base64.getDecoder().decode(encriptada.getBytes("utf-8"));            
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(contraseniaMaestra.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            desencriptada = new String(plainText, "UTF-8");

        } catch (Exception ex) {
            System.out.println("surgió un error al descifrar\nla contrasenia ->"+ex.getMessage());
            desencriptada = null;
        }
        return desencriptada;        
     }
     
     public ArrayList<String> transformarCadenaALista(String cadena, String indicadorSeparacion){
         String[] listaDeLaCadena = cadena.split(indicadorSeparacion);        
         
         return transformarArregloALista(listaDeLaCadena);
     }
     
     public ArrayList<String> transformarArregloALista(String[] arreglo){
         ArrayList<String> lista = new ArrayList<>();
         
         lista.addAll(Arrays.asList(arreglo));
         
         return lista;
     }
}
