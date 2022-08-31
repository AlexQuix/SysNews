<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear Role!</h1>
        <form action="/news/role?action=create" method="POST">
            <label>Nombre del Role</label>
            <input name="RoleName" type="text" />
            <button type="submit">Guardar</button>
        </form>
        <% 
            if(request.getAttribute("alert") != null){
                out.print(request.getAttribute("alert"));
            }
        %>
    </body>
</html>
