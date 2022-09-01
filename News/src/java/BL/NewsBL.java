
package BL;

import static BL.UserBL.encriptarMD5;
import Utils.Views.NewsView;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import news.dal.NewsDAL;
import news.dal.UserDAL;
import news.el.News;
import news.el.User;

public class NewsBL {
    public static String getAll(){
        try{
            List<News> newss = NewsDAL.getAll();
            String content = NewsView.IndexContent(newss);
            return content;
        } catch(Exception e){
            return "No hay datos :(";
        }
    }
    public static int create(HttpServletRequest req){
        try{
            News news = new News();
            
            //news.setIdUser(Integer.parseInt(req.getParameter("")));
            news.setTittle(req.getParameter("Tittle"));
            news.setCategory(req.getParameter("Category"));
            news.setDescription(req.getParameter("Description"));
            //news.setImageNews(req.getParameter("Image"));
            
            int result = NewsDAL.create(news);
            
            return result;
        }catch(Exception e){
            return -1;
        }
    }
    public static News findById(int id){
        News news = new News();
        news.setIdNews(id);
        try{
            return NewsDAL.findById(news);
        }catch(Exception e){
            return new News();
        }
    }
    public static int delete(int id){
        try{
            News news = new News();
            news.setIdNews(id);
            return NewsDAL.delete(news);
        }catch(Exception e){
            return 0;
        }
    }
    public static int update(HttpServletRequest req){
        try{
            News news = new News();
            
            news.setTittle(req.getParameter("txtTittle"));
            news.setCategory(req.getParameter("txtCategory"));
            news.setDescription(req.getParameter("txtDescription"));
            //news.setImageNews(req.getParameter("txtImage"));
            
            return NewsDAL.update(news);
        }catch(Exception e){
            return 0;
        }
    }
}
