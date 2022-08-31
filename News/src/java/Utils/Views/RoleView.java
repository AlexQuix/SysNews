/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils.Views;

import java.util.List;

/**
 *
 * @author alexq
 */
public class RoleView {
        public static String IndexContent(List<news.el.Role> roles){
        String content = "";
        for (news.el.Role role : roles){
            content += "<tr>"
                    + "<th>" + role.getIdRole() + "</th>"
                    + "<th>" + role.getRoleName()+ "</th>"
                    + "<th>" 
                        + "<a href=\""+ "/news/role?view=delete&id="+ role.getIdRole()+"\">Delete</a>"
                        + "<a href=\""+ "/news/role?view=details&id="+ role.getIdRole() +"\">Details</a>"
                        + "<a href=\""+ "/news/role?view=update&id="+ role.getIdRole() +"\">Update</a>"
                    + "</th>"
                    + "</tr>";
        }
        return content;
    }
}
