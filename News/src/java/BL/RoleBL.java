/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL;

import java.util.List;
import news.dal.RoleDAL;
import news.el.Role;
import Utils.Views.RoleView;

/**
 *
 * @author alexq
 */
public class RoleBL {
    public static String getAll(){
        try{
            List<Role> roles = RoleDAL.getAll();
            String content = RoleView.IndexContent(roles);
            return content;
        } catch(Exception e){
            return "No hay datos :(";
        }
    }
    public static int create(String name){
        try{
            Role role = new Role();
            role.setRoleName(name);
            return RoleDAL.create(role);
        }catch(Exception e){
            return 0;
        }
    }
    public static Role findById(int id){
        Role role = new Role();
        role.setIdRole(id);
        try{
            return RoleDAL.findById(role);
        }catch(Exception e){
            return new Role();
        }
    }
    public static int delete(int id){
        try{
            Role role = new Role();
            role.setIdRole(id);
            return RoleDAL.delete(role);
        }catch(Exception e){
            return 0;
        }
    }
    public static int update(int id, String name){
        try{
            Role role = new Role();
            role.setIdRole(id);
            role.setRoleName(name);
            return RoleDAL.update(role);
        }catch(Exception e){
            return 0;
        }
    }
}
