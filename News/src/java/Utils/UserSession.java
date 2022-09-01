/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import news.el.User;

/**
 *
 * @author alexq
 */
public class UserSession {
    public static String urlLogin = "/views/user/login.jsp";
    private static boolean disabledAuth = false;
    public static void authenticate(HttpServletRequest req, User user){
        HttpSession session = req.getSession();
        session.setAttribute("email", user.getEmail());
        session.setAttribute("auth", true);
//        session.setAttribute("role", user.getRole().getRoleName());
    }
    public static boolean isAuth(HttpServletRequest req) {
        if(disabledAuth) return true;
        HttpSession session = req.getSession();
        Object auth = session.getAttribute("auth");
        return (auth != null)? (boolean) auth : false;
    }
    public static User getUser(HttpServletRequest req){
        User user = new User();
        HttpSession session = req.getSession();
        user.setEmail((String) session.getAttribute("email"));
        return user;
    }
    public static void signOff(HttpServletRequest req){
        HttpSession session = (HttpSession) req.getSession();
        session.invalidate(); 
    }
}
