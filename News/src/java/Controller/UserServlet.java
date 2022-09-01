/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BL.UserBL;
import Utils.Json.GsonCustom;
import Utils.UserSession;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import news.el.User;


@WebServlet(name = "User", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
    private void GetAllUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        try{
            ArrayList<User> users = UserBL.getAllUsers();
            String data = GsonCustom.get().toJson(users);
            res.getWriter().print(data);
        }catch(Exception e){
            res.getWriter().print(e);
        }
    }
    private void GetCreate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("views/user/create.jsp").forward(req, res);
    }
    private void PostCreate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        try{
            int result = UserBL.createAccount(req);
            res.getWriter().println(result);
        }catch(Exception e){
            res.getWriter().println(e);
        }
    }
    private void GetDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try{
            User user = UserBL.findBySession(req);
            req.setAttribute("data", user);
            req.getRequestDispatcher("views/user/delete.jsp").forward(req, res);
        }catch(Exception e){
            res.getWriter().println(e);
        }
    }
    private void PostDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        try{
            UserBL.deleteAccount(req);
            UserSession.signOff(req);
            res.sendRedirect("/news/noticia");
        }catch(Exception e){
            res.getWriter().println(e);
        }
    }
    private void GetUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try{
            User user = UserBL.findBySession(req);
            req.setAttribute("data", user);
            req.getRequestDispatcher("views/user/update.jsp").forward(req, res);
        }catch(Exception e){
            res.getWriter().println(e);
        }
    }
    private void PostUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        try{
            UserBL.updateInfo(req);
            res.sendRedirect("/news/user");
        }catch(Exception e){
            res.getWriter().println(e);
        }
    }
    private void GetLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("views/user/login.jsp").forward(req, res);
    }
    private void PostLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        try{
            User user = UserBL.login(req);
            UserSession.authenticate(req, user);
            res.sendRedirect("/news/noticia");
        }catch(Exception e){
            res.getWriter().print(e);
//            req.getRequestDispatcher("/views/user/login.jsp").forward(req, res);
        }
    }
    private void GetSession(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().print(req.getSession().getAttribute("email"));
    }
    
    
    private void RequestGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String typeView = req.getParameter("view") + "";
        switch(typeView){
            case "delete":
                GetDelete(req, res);
                break;
            case "details":
//                GetDetails(req, res);
                break;
            case "update":
                GetUpdate(req, res);
                break;
            case "check":
                GetSession(req, res);
                break;
            default:
                GetAllUser(req, res);
                break;
        }
    }
    private void RequestPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String typeAction = req.getParameter("action") + "";
        switch(typeAction){
            case "delete":
                PostDelete(req, res);
                break;
            case "update":
                PostUpdate(req, res);
                break;
            default:
                res.sendRedirect("/news/noticia");
                break;
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String typeView = req.getParameter("view") + "";
        if(typeView.equals("create")){
            GetCreate(req, res);
            return;
        }
        if(typeView.equals("login")){
            GetLogin(req, res);
            return;
        }
        if(!UserSession.isAuth(req)){
            req.getRequestDispatcher(UserSession.urlLogin).forward(req, res);
        }else{
            RequestGet(req, res);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String typeView = req.getParameter("action") + "";
        if(typeView.equals("create")){
            PostCreate(req, res);
            return;
        }
        if(typeView.equals("login")){
            PostLogin(req, res);
            return;
        }
        if(UserSession.isAuth(req)){
            RequestPost(req, res);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
