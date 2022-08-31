/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BL.UserBL;
import Utils.Json.GsonCustom;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import news.dal.UserDAL;
import news.el.User;

/**
 *
 * @author alexq
 */
@WebServlet(name = "User", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
    private void GetAllUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        try{
            ArrayList<User> users = UserBL.getAll();
            String data = GsonCustom.get().toJson(users);
            res.setContentType("applicatino/json");
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
    private void GetLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("views/user/login.jsp").forward(req, res);
    }
    private void PostLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        try{
            
//            res.getWriter().println(result);
        }catch(Exception e){
            res.getWriter().println(e);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
//        GetCreate(req, res);
//        GetLogin(req, res);
        GetAllUser(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PostCreate(req, res);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
