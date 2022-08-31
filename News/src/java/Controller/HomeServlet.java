/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexq
 */
@WebServlet(name = "Home", urlPatterns = {"/"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
//      req.getRequestDispatcher("user").forward(req, res);
//      res.sendRedirect("Index.jsp");
        res.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
//        String name = req.getParameter("username");
//        String pass = req.getParameter("password");
//     
//        PrintWriter out = res.getWriter();
//        out.println(name + " - " + pass);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
