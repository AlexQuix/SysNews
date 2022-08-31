<%-- 
    Document   : create
    Created on : Aug 31, 2022, 3:01:49 AM
    Author     : alexq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <main class="container">   
            <h5>Crear Usuario</h5>
            <form action="/news/user?action=create" method="POST" onsubmit="return  ValidateForm()">
                <input type="hidden" name="action" value="<%=request.getAttribute("action")%>">                
                <div class="row">
                    <div class="input-field col l4 s12">
                        <input id="txtName" type="text" name="Name" required class="validate" maxlength="30">
                        <label for="txtName">Nombre</label>
                    </div>                       
                    <div class="input-field col l4 s12">
                        <input id="txtLastName" type="text" name="LastName" required class="validate" maxlength="30">
                        <label for="txtLastName">Apellido</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input id="txtEmail" type="text" name="Email" required class="validate" maxlength="25">
                        <label for="txtEmail">Correo Electrónico</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input id="txtPassword" type="password" name="Password" required class="validate" minlength="5" maxlength="32">
                        <label for="txtPassword">Password</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input id="txtConfirmPassword" type="password" required class="validate" minlength="5" maxlength="32">
                        <label for="txtConfirmPassword">Confirmar Password</label>
                        <span id="txtConfirmPassword_Error" style="color:red" class="helper-text"></span>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input id="txtEmail" type="text" name="ProfilePhoto" required class="validate" maxlength="25">
                        <label for="txtEmail">Photo</label>
                    </div> 
                </div>

                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right"></i>Guardar</button>
                        <!--<a href="User" class="waves-effect waves-light btn blue"><i class="material-icons right">list</i>Cancelar</a>-->                          
                    </div>
                </div>
            </form>          
        </main>
    </body>
</html>
