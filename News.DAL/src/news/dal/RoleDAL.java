package news.dal;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.ArrayList;
import news.el.Role;

public class RoleDAL {
    public static int create(Role role) throws Exception {
        int result = -616;
        String sql;
        
        try (Connection con = CommonDb.getConnection();) {
            sql = "INSERT INTO Role(RoleName) VALUES(?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, role.getRoleName());
            result = ps.executeUpdate();
            
            ps.close(); 
            con.close();
        } 
        catch (SQLException ex) {
            throw ex; 
        }
      
        return result; 
    }
    public static ArrayList<Role> getAll() throws Exception {
        ArrayList<Role> roles = new ArrayList<Role>();
        
        try (Connection conn = CommonDb.getConnection();) {
            String sql = "SELECT r.IdRole, r.RoleName FROM Role AS r";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet data = ps.executeQuery();
            
            while (data.next()) { 
                Role role = new Role();
                role.setIdRole(data.getInt(1));
                role.setRoleName(data.getString(2));
                roles.add(role); 
            }
            
            data.close(); 
            conn.close(); 
        } 
        catch (SQLException ex) {
            throw ex; 
        }
        return roles; 
    }
    public static int delete(Role role) throws Exception {
        int result = -616;
        String sql = "DELETE FROM Role WHERE IdRole=?";
        try(Connection conn = CommonDb.getConnection();){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, role.getIdRole());
            result = ps.executeUpdate();

            ps.close(); 
            conn.close(); 
        } catch (SQLException ex) {
            throw ex; 
        }
        return result;
    } 
    public static Role findById(Role prole) throws Exception {
        Role role = new Role();
        String sql = "SELECT r.IdRole, r.RoleName FROM Role AS r WHERE r.IdRole=?";
        try(Connection conn = CommonDb.getConnection();){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, prole.getIdRole());
            ResultSet data = ps.executeQuery();
            
            if(data.next()){
                role.setIdRole(data.getInt(1));
                role.setRoleName(data.getString(2));
            }

            ps.close(); 
            conn.close(); 
        } catch (SQLException ex) {
            throw ex; 
        }
        return role;
    } 
    public static int update(Role role) throws Exception {
        int result;
        String sql;
        
        try (Connection conn = CommonDb.getConnection();) { 
            sql = "UPDATE Role SET RoleName=? WHERE IdRole=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, role.getRoleName());
            ps.setInt(2, role.getIdRole());
            result = ps.executeUpdate();
            
            conn.close(); 
        } catch (SQLException ex) {
            throw ex;  
        }
        
        return result; 
    }
}
