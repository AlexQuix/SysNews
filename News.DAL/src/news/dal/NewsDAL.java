package news.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import news.el.News;

public class NewsDAL {

    public static int create(News news) throws Exception {
        int result;
        String sql;

        try ( Connection con = CommonDb.getConnection();) {
            sql = "INSERT INTO News(IdUser, Tittle, Category, [Description], DateNews, ImageNews) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 11);
            ps.setString(2, news.getTittle());
            ps.setString(3, news.getCategory());
            ps.setString(4, news.getDescription());
            ps.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
            ps.setString(6, "img/news/photo.jpg");

            result = ps.executeUpdate();

            ps.close();
            con.close();
        } catch (SQLException ex) {
            throw ex;
        }

        return result;
    }

    public static ArrayList<News> getAll() throws Exception {
        ArrayList<News> newss = new ArrayList<News>();

        try ( Connection conn = CommonDb.getConnection();) {
            String sql = "SELECT n.IdNews, n.IdUser, n.Tittle, n.Category, n.[Description], n.DateNews, n.ImageNews FROM News AS n";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet data = ps.executeQuery();

            while (data.next()) {
                News news = new News();

                news.setIdNews(data.getInt(1));
                news.setIdUser(data.getInt(2));
                news.setTittle(data.getString(3));
                news.setCategory(data.getString(4));
                news.setDescription(data.getString(5));
                news.setDateNews(data.getDate(6).toLocalDate());
                news.setImageNews(data.getString(7));

                newss.add(news);
            }

            data.close();
            conn.close();
        } catch (SQLException ex) {
            throw ex;
        }

        return newss;
    }

    public static int delete(News news) throws Exception {
        int result = -616;
        String sql = "DELETE FROM News WHERE IdNews=?";

        try ( Connection conn = CommonDb.getConnection();) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, news.getIdNews());

            result = ps.executeUpdate();

            ps.close();
            conn.close();
        } catch (SQLException ex) {
            throw ex;
        }

        return result;
    }

    public static News findById(News _news) throws Exception {
        News news = new News();
        String sql = "SELECT n.IdNews, n.IdUser, n.Tittle, n.Category, n.[Description], n.DateNews, n.ImageNews FROM News AS n WHERE n.IdNews=?";

        try ( Connection conn = CommonDb.getConnection();) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, _news.getIdNews());
            ResultSet data = ps.executeQuery();

            if (data.next()) {

                news.setIdNews(data.getInt(1));
                news.setIdUser(data.getInt(2));
                news.setTittle(data.getString(3));
                news.setCategory(data.getString(4));
                news.setDescription(data.getString(5));
                news.setDateNews(data.getDate(6).toLocalDate());
                news.setImageNews(data.getString(7));
            }

            ps.close();
            conn.close();
        } catch (SQLException ex) {
            throw ex;
        }
        
        return news;
    }

    public static int update(News news) throws Exception {
        int result;
        String sql;

        try ( Connection conn = CommonDb.getConnection();) {
            sql = "UPDATE News SET Tittle=?, Category=?, [Description]=?, DateNews=?, ImageNews=? WHERE IdNews=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, news.getTittle());
            ps.setString(2, news.getCategory());
            ps.setString(3, news.getDescription());
            ps.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
            ps.setString(5, "img/news/photo.jpg");
            ps.setInt(6, news.getIdUser());
            
            
            result = ps.executeUpdate();

            conn.close();
        } catch (SQLException ex) {
            throw ex;
        }

        return result;
    }
}
