package news.dal;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import news.el.User;
import news.dal.CommonDb;

public class UserDAL {
    public static int create(User user) throws Exception {
        int result = -616;
        String sql;
        
            try (Connection con = CommonDb.getConnection();) {
                sql = "INSERT INTO [User](IdRole, Name, LastName, Email, Password, RegistreDate, ProfilePhoto, IsAdmin) VALUES(?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setInt(1, 1); 
                ps.setString(2, user.getName()); 
                ps.setString(3, user.getLastName()); 
                ps.setString(4, user.getEmail()); 
                ps.setString(5, user.getPassword()); 
                ps.setDate(6, java.sql.Date.valueOf(LocalDate.now())); 
                ps.setString(7, user.getProfilePhoto());
                ps.setByte(8, user.getIsAdmin());
                
                result = ps.executeUpdate();
                ps.close(); 
                con.close();
            } 
            catch (SQLException ex) {
                throw ex; 
            }
      
        return result; 
    }
    
//    Metodos de busqueda
    public static ArrayList<User> find() throws SQLException{
        ArrayList<User> users = new ArrayList<User>();
        try (Connection conn = CommonDb.getConnection();) { 
            String sql = "SELECT u.IdUser, u.IdRole, u.Name, u.LastName, u.Email, u.RegistreDate, u.ProfilePhoto, u.Password FROM [User] AS u";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet data = ps.executeQuery();
            while (data.next()) {
                User user = new User();
                
                user.setIdUser(data.getInt(1));
                user.setIdRole(data.getInt(2)); 
                user.setName(data.getString(3)); 
                user.setLastName(data.getString(4));
                user.setEmail(data.getString(5));
                user.setRegistreDate(data.getDate(6).toLocalDate());
                user.setProfilePhoto(data.getString(7));
                user.setPassword(data.getString(8));
                
                users.add(user);
            }
            
            ps.close();
            conn.close(); 
        }
        catch (SQLException ex) {
            throw ex;
        }
        
        return users;
    }
    public static User findWith(String email, String pass) throws Exception {
        User user = new User();
        try (Connection conn = CommonDb.getConnection();) { 
            String sql = "SELECT u.Name, u.LastName FROM [User] AS u WHERE u.Email=? AND u.[Password]=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            
            ResultSet data = ps.executeQuery();
            if(data.next()){
                user.setName(data.getString(1));
                user.setLastName(data.getString(2));
                user.setEmail(email);
            }

            ps.close(); 
            conn.close();
            return user;
        } 
        catch (SQLException ex) {
            throw ex; 
        }
    }
    public static User findWith(String email) throws SQLException{
        User user = new User();
        try (Connection conn = CommonDb.getConnection();) { 
            String sql = "SELECT u.IdUser, u.IdRole, u.Name, u.LastName, u.Email, u.RegistreDate, u.ProfilePhoto FROM [User] AS u WHERE u.Email=? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            
            ResultSet data = ps.executeQuery();
            if(data.next()){
                user.setIdUser(data.getInt(1));
                user.setIdRole(data.getInt(2)); 
                user.setName(data.getString(3)); 
                user.setLastName(data.getString(4));
                user.setEmail(data.getString(5));
                user.setRegistreDate(data.getDate(6).toLocalDate());
                user.setProfilePhoto(data.getString(7));
            }

            ps.close(); 
            conn.close();
            return user;
        } catch (SQLException ex) {
            throw ex; 
        }
    }
    
    public static int update(User user) throws Exception {
        int result = -616;
        String sql;        
            try (Connection conn = CommonDb.getConnection();) {
                sql = "UPDATE [User] SET Name=?, LastName=?, Email=?, ProfilePhoto=? WHERE IdUser=?";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, user.getName()); 
                ps.setString(2, user.getLastName()); 
                ps.setString(3, user.getEmail()); 
                ps.setString(4, user.getProfilePhoto());
                ps.setInt(5, user.getIdUser());
                
                result = ps.executeUpdate(); 
                ps.close();
                conn.close(); 
                return result; 
            } 
            catch (SQLException ex) {
                throw ex; 
            }
    }
    
    public static int delete(User user) throws SQLException{
        int result;
        try (Connection conn = CommonDb.getConnection();) { 
            String sql = "DELETE FROM [User] WHERE IdUser=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getIdUser());
            result = ps.executeUpdate(); 

            ps.close();
            conn.close();
            return result;
        }
        catch (SQLException ex) {
            throw ex;
        }
    }
}
