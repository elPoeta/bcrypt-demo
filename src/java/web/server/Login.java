/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.server;

import bcrypt.domain.Datos;
import bcrypt.domain.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author elpoeta
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
       private static final Gson CONVERTIR = new Gson();
            
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
          System.out.println("login");
           	
            String texto = request.getReader().readLine();

            Usuario userParametro = CONVERTIR.fromJson(texto, Usuario.class);
            
             System.out.println(userParametro);
             
             Usuario u = Datos.consultar(userParametro);
              System.out.println(u);
             if(u !=null){
                 if(BCrypt.checkpw(userParametro.getPassword(), u.getPassword())){
                    out.println(CONVERTIR.toJson("LOGIN OK "+ u));
                 }else{
                     out.println(CONVERTIR.toJson("LOGIN FAIL"));
                 }
                     
             }else{
                 out.println(CONVERTIR.toJson("USUARIO NULL"));
             }
             
            
    }
}
