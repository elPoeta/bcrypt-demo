
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

/**
 *
 * @author elpoeta
 */
@WebServlet(name = "Registrar", urlPatterns = {"/Registrar"})
public class Registrar extends HttpServlet {
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
          System.out.println("registrserver");
           	
            String texto = request.getReader().readLine();

            Usuario userParametro = CONVERTIR.fromJson(texto, Usuario.class);
            
             System.out.println(userParametro);
             Datos.insertar(userParametro);
             out.println(CONVERTIR.toJson("REGISTRO OK"));
    }
}