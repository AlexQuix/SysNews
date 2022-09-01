<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <main class="container">   
            <h1>Login</h1>
            <form action="/news/user?action=login" method="POST">
                <input type="hidden" name="action" value="<%=request.getAttribute("action")%>">                
                <div class="row">
                    <div class="input-field col l5 s12">   
                        <label for="txtEmail">Correo Electrónico</label>
                        <input  id="txtEmail" type="text" name="Email" required class="validate" maxlength="25">  
                    </div>                                       
                </div>
                <div class="row">
                    <div class="input-field col l5 s12">                                             
                        <label for="txtPassword">Password</label> 
                        <input  id="txtPassword" type="password" name="Password" required class="validate" minlength="5" maxlength="32">                         
                    </div>                                       
                </div>
                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right"></i>Login</button>                                               
                    </div>
                </div>
            </form>          
        </main>
    </body>
</html>
