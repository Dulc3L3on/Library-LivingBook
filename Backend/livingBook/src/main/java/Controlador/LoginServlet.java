/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DB.DAOs.UsuarioDAO;
import Modelo.Herramientas.JSON.BodyExtractor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phily
 */

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet{
    private final BodyExtractor auxiliar = new BodyExtractor();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
       
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {                
            
        String body = auxiliar.getBody(request.getReader());    
            
    
    }    
}
