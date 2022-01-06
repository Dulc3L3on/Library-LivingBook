/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DB.DAOs.UsuarioDAO;
import Modelo.Entidades.Estatus;
import Modelo.Entidades.Usuario.Autor.Autor;
import Modelo.Entidades.Usuario.Usuario;
import Modelo.Herramientas.JSON.Converter;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phily
 */
@MultipartConfig()
public class Signin_servlet extends HttpServlet {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final Converter converterUsuario = new Converter(Usuario.class);
    private final Converter converterAutor = new Converter(Autor.class);    
    private final Converter converterResultado = new Converter(Estatus.class);    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String tipoDeUsuario = ((request.getParameter("Autor")!=null)?"Autor":"Usuario");
        String datosDeRegistro = request.getParameter(tipoDeUsuario);//se supone que no debería devolver un null nunca :v, a menos que hubiera surgido un error al transportar los datos desde angular...
        
        try{
            Usuario elUsuario = (tipoDeUsuario.equals("Usuario"))?
                    (Usuario)converterUsuario.fromJson(datosDeRegistro)
                    :(Autor)converterAutor.fromJson(datosDeRegistro);
            
            usuarioDAO.crearUsuario(elUsuario);//por el hecho de que en el servlet se estará enviando estos msjes, sería mejor en los DAO, se use un throws, para así atrapar y tratar aquí los errores... sino aquí jamás llegaría la notificación de error...
            
            response.getWriter().append((tipoDeUsuario.equals("Usuario"))?
                    converterUsuario.toJson(usuarioDAO.buscarUsuario(elUsuario.getUsername(), elUsuario.getPassword())):
                    converterAutor.toJson(usuarioDAO.buscarUsuario(elUsuario.getUsername(), elUsuario.getPassword())));
        }catch(SQLException sqlE){
            System.out.println("Error: at tried INSERT an  "+tipoDeUsuario.toUpperCase()+"\n"+sqlE.getMessage());
             response.getWriter().append(converterResultado.toJson
                        (new Estatus("error", "Error del servidor\n imposible realizar el registro\n intente de nuevo")));
        }
    }
}
