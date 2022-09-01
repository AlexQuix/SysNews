

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>News</h1>
        <a href="/news/views/news/create.jsp">Crear</a>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>TITULO</th>
                    <th>CATEGORIA</th>
                    <th>DESCRIPCION</th>
                    <th>FECHA</th>
                    <th>IMAGEN</th>
                </tr>
            </thead>
            <tbody>
                <% out.print(request.getAttribute("news")); %>
            </tbody>
        </table>
    </body>
</html>
