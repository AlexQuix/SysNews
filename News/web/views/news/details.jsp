

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% @import ""%>
<% News news = (News) request.getAttribute("data"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Details!</h1>
        
        <h2>ID</h2>
        <p><%= news.getIdNews() %></p>
        <h2>TÍTULO</h2>
        <p><%= news.getTittle() %></p>
        <h2>CATEGORIA</h2>
        <p><%= news.getCategory() %></p>
        <h2>DESCRIPCION</h2>
        <p><%= news.getDescription() %></p>
        <h2>FECHA</h2>
        <p><%= news.getDateNews() %></p>
        <h2>IMAGEN</h2>
        <p><%= news.getImageNews() %></p>
    </body>
</html>
