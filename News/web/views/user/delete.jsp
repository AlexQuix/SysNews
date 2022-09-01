<%-- 
    Document   : delete
    Created on : Aug 31, 2022, 11:06:47 PM
    Author     : alexq
--%>
<%@page import="news.el.User"%>
<%User user = (User) request.getAttribute("data");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Delete!</h1>
        <form action="/news/user?action=delete" method="POST">
            <input type="hidden" name="action" value="<%=request.getAttribute("action")%>">                
            <input type="hidden" name="IdUser" value="<%=user.getIdUser()%>"> 
            <div class="row">
                <div class="input-field col l5 s12">   
                    <label for="txtEmail">Correo Electrónico</label>
                    <input  id="Email" value="<%=user.getEmail()%>" type="text" name="Email" disabled class="validate" maxlength="25">  
                </div>                                       
            </div>
            <div class="row">
                <div class="col l12 s12">
                    <button type="sutmit" class="waves-effect waves-light btn blue">Eliminar Cuenta</button>                                               
                </div>
            </div>
        </form>  
    </body>
</html>
