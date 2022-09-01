package BL;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import news.dal.UserDAL;
import news.el.User;

public class UserBL {
    public static String encriptarMD5(String txt) throws Exception {
        try {
            StringBuffer sb = new StringBuffer();
            
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(txt.getBytes());

            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException ex) {
            throw ex;
        }
    }
    
    public static int createAccount(HttpServletRequest req){
        try{
            User user = new User();
//            user.setIdRole(parseInt(req.getParameter("IdRole")));
            user.setName(req.getParameter("Name"));
            user.setLastName(req.getParameter("LastName"));
            user.setEmail(req.getParameter("Email"));
            user.setPassword(encriptarMD5(req.getParameter("Password")));
            user.setProfilePhoto(req.getParameter("ProfilePhoto"));
            user.setIsAdmin((byte) 0);
            
            int result = UserDAL.create(user);
            return result;
        }catch(Exception e){
            return -1;
        }
    }
    public static ArrayList<User> getAllUsers() throws Exception{
        try{            
            return UserDAL.find();
        }catch(Exception e){
            throw e;
        }
    }
    public static User login(HttpServletRequest req) throws Exception{
        try{
            String email = req.getParameter("Email");
            String pass = req.getParameter("Password");
            return UserDAL.findWith(email, pass);
        }catch(Exception e){
            throw e;
        }
    }
    public static int updateAccount(HttpServletRequest req){
        return 1;
    }
}
