<%@page import="news.el.Role"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Role role = (Role) request.getAttribute("data"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Delete!</h1>
        <form action="/news/role?action=delete" method="POST">
            <input name="IdRole" value="<%= role.getIdRole() %>" hidden="true"/>
            <label>Nombre del Role</label>
            <input name="RoleName" type="text" value="<%= role.getRoleName() %>"/>
            <button type="submit">Delete</button>
        </form>
        <% 
            if(request.getAttribute("alert") != null){
                out.print(request.getAttribute("alert"));
            }
        %>
    </body>
</html>
