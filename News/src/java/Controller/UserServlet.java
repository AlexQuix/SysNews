/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BL.UserBL;
import Utils.Json.GsonCustom;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import news.dal.UserDAL;
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
    private void GetUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        req.getRequestDispatcher("views/user/update.jsp").forward(req, res);
    }
    private void PostUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        try{
            User user = UserBL.login(req);
            res.getWriter().println(user.getName());
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
            res.getWriter().println(user.getName());
        }catch(Exception e){
            res.getWriter().println(e);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String typeView = req.getParameter("view") + "";
        switch(typeView){
            case "create":
                GetCreate(req, res);
                break;
            case "login":
                GetLogin(req, res);
                break;
            case "delete":
//                GetDelete(req, res);
                break;
            case "details":
//                GetDetails(req, res);
                break;
            case "update":
                GetUpdate(req, res);
                break;
            default:
                GetAllUser(req, res);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String typeAction = req.getParameter("action") + "";
        switch(typeAction){
            case "login":
                PostLogin(req, res);
                break;
            case "create":
                PostCreate(req, res);
                break;
            case "delete":
//                PostDelete(req, res);
                break;
            case "update":
                PostUpdate(req, res);
            default:
                res.sendRedirect("views/role/index.jsp");
                break;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
