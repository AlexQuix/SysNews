<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <main class="container">   
            <h5>Editar Usuario</h5>
            <form action="user" method="POST" onsubmit="return  ValidateForm()">  
                <input type="hidden" name="action" value="<%=request.getAttribute("action")%>"> 
                <input type="hidden" name="id" value="<%=user.getIdUser()%>">  
                <div class="row">
                    <div class="input-field col l4 s12">
                        <input  id="txtName" type="text" value="<%=user.getName()%>" disabled>
                        <label for="txtName">Nombre</label>
                    </div>                       
                    <div class="input-field col l4 s12">
                        <input  id="txtLastName" type="text" value="<%=user.getLastName()%>" disabled>
                        <label for="txtLastName">Apellido</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input  id="txtEmail" type="text" value="<%=user.getEmail()%>" disabled>
                        <label for="txtEmail">Correo Electrónico</label>
                    </div>                     
                    <div class="input-field col l4 s12">
                        <input id="txtRole" type="text" value="<%=user.getRole().getRoleName()%>" disabled>
                        <label for="txtRole">Rol</label>
                    </div> 
                </div>
                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">delete</i>Eliminar</button>
                        <a href="User" class="waves-effect waves-light btn blue"><i class="material-icons right">list</i>Cancelar</a>                          
                    </div>
                </div>
            </form>           
        </main>
    </body>
</html>
