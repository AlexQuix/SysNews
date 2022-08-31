<%-- 
    Document   : update
    Created on : Aug 31, 2022, 2:40:17 AM
    Author     : alexq
--%>

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
        <h1>Update Role!</h1>
        <form action="/news/role?action=update" method="POST">
            <input name="IdRole" type="text" value="<%=role.getIdRole()%>" hidden />
            <label>Nombre del Role</label>
            <input name="RoleName" type="text" value="<%=role.getRoleName()%>" />
            <button type="submit">Actualizar</button>
        </form>
        <% 
            if(request.getAttribute("alert") != null){
                out.print(request.getAttribute("alert"));
            }
        %>
    </body>
</html>
