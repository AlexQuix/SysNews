<%@page import="news.el.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%User user = (User) request.getAttribute("data");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <main class="container">   
            <h5>Editar Usuario</h5>
            <form action="/news/user?action=update" method="POST">
                <input type="hidden" name="IdUser" value="<%=user.getIdUser()%>">  
                <div class="row">
                    <div class="input-field col l4 s12">
                        <input  name="Name" type="text" value="<%=user.getName()%>">
                        <label for="txtName">Nombre</label>
                    </div>                       
                    <div class="input-field col l4 s12">
                        <input  name="LastName" type="text" value="<%=user.getLastName()%>">
                        <label for="txtLastName">Apellido</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input  name="Email" type="text" value="<%=user.getEmail()%>">
                        <label for="txtEmail">Correo Electrónico</label>
                    </div>     
                    <div class="input-field col l4 s12">
                        <input  name="ProfilePhoto" type="text" value="<%=user.getProfilePhoto()%>">
                        <label for="txtEmail">Foto</label>
                    </div> 
                </div>
                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue">Actualizar</button>                       
                    </div>
                </div>
            </form>           
        </main>
    </body>
</html>
