<%@page import="news.el.Role"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Role role = (Role) request.getAttribute("data"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Details!</h1>
        
        <h2>Role Name</h2>
        <p><%= role.getRoleName() %></p>
    </body>
</html>
