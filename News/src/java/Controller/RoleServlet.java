/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import news.dal.RoleDAL;
import news.el.Role;
import BL.RoleBL;
import com.google.gson.Gson;
import Utils.Json.GsonCustom;
import java.util.List;
import BL.RoleBL;
import static java.lang.Integer.parseInt;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "RoleServlet", urlPatterns = {"/role"})
public class RoleServlet extends HttpServlet {
    private void GetIndex(HttpServletRequest req, HttpServletResponse res) throws IOException{
        try{
            String content = RoleBL.getAll();
            req.setAttribute("data", content);
            req.getRequestDispatcher("views/role/index.jsp").forward(req, res);
        }catch(Exception e){
            res.sendRedirect("views/error/internal.html");
        }
    }
    private void GetCreate(HttpServletRequest req, HttpServletResponse res) throws IOException{
        try{
            req.getRequestDispatcher("views/role/create.jsp").forward(req, res);
        }catch(Exception e){
            res.sendRedirect("views/error/internal.html");
        }
    }
    private void PostCreate(HttpServletRequest req, HttpServletResponse res) throws IOException{
        try{
            String roleName = req.getParameter("RoleName");
            req.setAttribute("alert", "Debes rellenar el campo");
            if(roleName != null && roleName != ""){
                int result = RoleBL.create(roleName);
                if(result == 0){
                    req.setAttribute("alert", "No se pudo agregar el usuario");
                }else {
                    req.setAttribute("alert", "Usuario agregado exitosamente");
                }
            }
            GetCreate(req, res);
        }catch(Exception e){
            req.setAttribute("alert", "Ocurrio un error al tratar de agregar el usuario");
            GetCreate(req, res);
        }
    }
    private void GetDetails(HttpServletRequest req, HttpServletResponse res) throws IOException{
        try{
            int id = parseInt(req.getParameter("id"));
            Role role = RoleBL.findById(id);
            req.setAttribute("data", role);
            req.getRequestDispatcher("views/role/details.jsp").forward(req, res);
        }catch(Exception e){
            res.sendRedirect("views/error/nofound.html");
        }
    }
    private void GetDelete(HttpServletRequest req, HttpServletResponse res) throws IOException{
        try{
            int id = parseInt(req.getParameter("id"));
            Role role = RoleBL.findById(id);
            req.setAttribute("data", role);
            req.getRequestDispatcher("views/role/delete.jsp").forward(req, res);
        }catch(Exception e){
            res.sendRedirect("views/error/nofound.html");
        }
    }
    private void PostDelete(HttpServletRequest req, HttpServletResponse res) throws IOException{
        try{
            int id = parseInt(req.getParameter("IdRole"));
            int result = RoleBL.delete(id);
            if(result == 0){
                req.setAttribute("alert", "No se pudo eliminar el usuario");
                GetDelete(req, res);
                return;
            }
            
            req.setAttribute("alert", "Usuario eliminado exitosamente");
            GetIndex(req, res);
        }catch(Exception e){
            req.setAttribute("alert", "Ocurrio un error al tratar de eliminar el usuario");
            GetDelete(req, res);
        }
    }
    private void GetUpdate(HttpServletRequest req, HttpServletResponse res) throws IOException{
        try{
            int id = parseInt(req.getParameter("id"));
            Role role = RoleBL.findById(id);
            req.setAttribute("data", role);
            req.getRequestDispatcher("views/role/update.jsp").forward(req, res);
        }catch(Exception e){
            res.sendRedirect("views/error/nofound.html");
        }
    }
    private void PostUpdate(HttpServletRequest req, HttpServletResponse res) throws IOException{
        try{
            int id = parseInt(req.getParameter("IdRole"));
            String name = req.getParameter("RoleName");
            int result = RoleBL.update(id, name);
            if(result == 0){
                req.setAttribute("alert", "No se pudo actualizar el usuario");
                GetUpdate(req, res);
                return;
            }
            
            req.setAttribute("alert", "Usuario actualizado exitosamente");
            GetIndex(req, res);
        }catch(Exception e){
            req.setAttribute("alert", "Ocurrio un error al tratar de actualizar el usuario");
            GetUpdate(req, res);
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
            case "delete":
                GetDelete(req, res);
                break;
            case "details":
                GetDetails(req, res);
                break;
            case "update":
                GetUpdate(req, res);
                break;
            default:
                GetIndex(req, res);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String typeAction = req.getParameter("action") + "";
        switch(typeAction){
            case "create":
                PostCreate(req, res);
                break;
            case "delete":
                PostDelete(req, res);
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
