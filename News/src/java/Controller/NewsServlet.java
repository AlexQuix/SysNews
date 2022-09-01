package Controller;

import BL.NewsBL;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.Integer.parseInt;
import news.el.News;

@WebServlet(name = "NewsServlet", urlPatterns = {"/news"})
public class NewsServlet extends HttpServlet {

    private void GetIndex(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            String content = NewsBL.getAll();
            req.setAttribute("news", content);
            req.getRequestDispatcher("views/news/index.jsp").forward(req, res);
        } catch (Exception e) {
            res.sendRedirect("views/error/internal.html");
        }
    }

    private void GetCreate(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            req.getRequestDispatcher("views/news/create.jsp").forward(req, res);
        } catch (Exception e) {
            res.sendRedirect("views/error/internal.html");
        }
    }

    private void PostCreate(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            String tittle = req.getParameter("Tittle");
            String category = req.getParameter("Category");
            String description = req.getParameter("Description");
            //String image = req.getParameter("Image");

            
            req.setAttribute("alert", "Debes rellenar el campo");
            
            if (tittle != "" && category != "" && description != "") {
                int result = NewsBL.create(req);
                
                if (result == 0) {
                    req.setAttribute("alert", "No se pudo agregar el usuario");
                } else {
                    req.setAttribute("alert", "Usuario agregado exitosamente");
                }
            }
            
            GetIndex(req, res);
        } catch (Exception e) {
            req.setAttribute("alert", "Ocurrio un error al tratar de agregar el usuario");
            res.getWriter().print(e);
        }
    }

    private void GetDetails(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            int id = parseInt(req.getParameter("id"));
            News news = NewsBL.findById(id);
            req.setAttribute("data", news);
            req.getRequestDispatcher("views/news/details.jsp").forward(req, res);
        } catch (Exception e) {
            res.sendRedirect("views/error/nofound.html");
        }
    }

    private void GetDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            int id = parseInt(req.getParameter("id"));
            News news = NewsBL.findById(id);
            req.setAttribute("data", news);
            req.getRequestDispatcher("views/news/delete.jsp").forward(req, res);
        } catch (Exception e) {
            res.sendRedirect("views/error/nofound.html");
        }
    }

    private void PostDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            int id = parseInt(req.getParameter("IdNews"));
            int result = NewsBL.delete(id);
            if (result == 0) {
                req.setAttribute("alert", "No se pudo eliminar el usuario");
                GetDelete(req, res);
                return;
            }

            req.setAttribute("alert", "Usuario eliminado exitosamente");
            GetIndex(req, res);
        } catch (Exception e) {
            req.setAttribute("alert", "Ocurrio un error al tratar de eliminar el usuario");
            GetDelete(req, res);
        }
    }

    private void GetUpdate(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            int id = parseInt(req.getParameter("id"));
            News news = NewsBL.findById(id);
            req.setAttribute("data", news);
            req.getRequestDispatcher("views/news/update.jsp").forward(req, res);
        } catch (Exception e) {
            res.sendRedirect("views/error/nofound.html");
        }
    }

    private void PostUpdate(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            int id = parseInt(req.getParameter("IdNews"));
            String title = req.getParameter("Tittle");
            String category = req.getParameter("Category");
            String description = req.getParameter("Description");
            //String image = req.getParameter("Image");
            
            int result = NewsBL.update(req);
            if (result == 0) {
                req.setAttribute("alert", "No se pudo actualizar el usuario");
                GetUpdate(req, res);
                return;
            }

            req.setAttribute("alert", "Usuario actualizado exitosamente");
            GetIndex(req, res);
        } catch (Exception e) {
            req.setAttribute("alert", "Ocurrio un error al tratar de actualizar el usuario");
            GetUpdate(req, res);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String typeView = req.getParameter("view") + "";
        switch (typeView) {
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
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String typeAction = req.getParameter("action") + "";
        switch (typeAction) {
            case "create":
                PostCreate(req, res);
                break;
            case "delete":
                PostDelete(req, res);
                break;
            case "update":
                PostUpdate(req, res);
            default:
                res.sendRedirect("views/news/index.jsp");
                break;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
