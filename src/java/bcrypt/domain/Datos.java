
package bcrypt.domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author elpoeta
 */
public class Datos {
    private static List<TreeMap<String,Usuario>> datosUser = new ArrayList();
    private static final String SALT = "salt";
     
    public static void insertar(Usuario usuario){
         TreeMap<String,Usuario> tm = new TreeMap<>();
         //String hashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
         String hashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt(12, new SecureRandom(SALT.getBytes())));
         System.out.println("cryt > "+hashed+" longitud "+hashed.length());
         usuario.setPassword(hashed);
         tm.put(usuario.getEmail(), usuario);
         datosUser.add(tm);
    
     }
     
     public static Usuario consultar(Usuario usuario){
         for(int i=0; i<datosUser.size(); i++){
             System.out.println("map "+ datosUser.get(i).get(usuario.getEmail()));
             if(datosUser.get(i).containsKey(usuario.getEmail())){
                 return datosUser.get(i).get(usuario.getEmail());
             }
         }
         return null;
     }
    
}
