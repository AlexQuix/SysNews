

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% News news = (News) request.getAttribute("news"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Delete!</h1>
        <form action="/news/noticia?action=delete" method="POST">
            <input name="IdNews" value="<%= news.getIdNews() %>" hidden="true"/>
            <label>TITULO</label>
            <input name="Tittle" type="text" value="<%= news.getTittle() %>"/>
            <label>CATEGORIA</label>
            <input name="Category" type="text" value="<%= news.getCategory() %>"/>
            <label>DESCRIPCION</label>
            <input name="Description" type="text" value="<%= news.getDescription() %>"/>
            <label>FECHA</label>
            <input name="" type="text" value="<%= news.getDateNews() %>"/>
            <label>IMAGEN</label>
            <input name="" type="text" value="<%= news.getImageNews() %>"/>
            
            <button type="submit">Delete</button>
        </form>
        <% 
            if(request.getAttribute("alert") != null){
                out.print(request.getAttribute("alert"));
            }
        %>    </body>
</html>
