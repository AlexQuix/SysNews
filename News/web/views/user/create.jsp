<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    <title>Formulario</title>
    <link href="/news/wwwroot/styles/menu.css" rel="stylesheet" type="text/css"/>
    <link href="/news/wwwroot/styles/login.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
    <div class="hola">
        <form action="/news/user?action=create" method="POST" onsubmit="return  ValidateForm()">
             <input type="hidden" name="action" value="<%=request.getAttribute("action")%>">  
            <div class="form">
                <div></div>
                <div class="grupo">
                    <div class="login-box">
                        <img class="avatar" src="img/depositphotos_355964924-stock-illustration-default-avatar-profile-icon-vector.jpg" alt="" lang="30%">
                    </div>
                </div>
                <div class="grupo">
                    <input id="txtName" type="text" name="Name" required class="validate"><span class="barra"></span>
                    <label for="txtName">Name</label>
                </div>
                <div class="grupo">
                    <input id="txtLastName" type="text" name="LastName" required class="validate"><span class="barra"></span>
                    <label for="txtLastName">Last Name</label>
                </div>
                <div class="grupo">
                    <input id="txtEmail" type="text" name="Email" required class="validate"><span class="barra"></span>
                    <label for="txtEmail">Email</label>
                </div>
                <div class="grupo">
                    <input id="txtPassword" type="password" name="Password" required class="validate"><span class="barra"></span>
                    <label for="txtPassword">Password</label>
                </div>
                <div class="grupo">
                    <input id="txtConfirmPassword" type="password" required class="validate"><span class="barra"></span>
                    <label for="txtConfirmPassword">Password Confirm</label>
                </div>
                <div class="grupo">
                    <input id="txtEmail" type="text" name="ProfilePhoto" required class="validate"><span class="barra"></span>
                    <label for="txtEmail">Profile Photo</label>
                </div>
                <button type="submit">Confirmar</button>
            </div>
        </form>
    </div>
</body>
</html>
