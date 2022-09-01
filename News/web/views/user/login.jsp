<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>Home</title>
        
    <link href="/news/wwwroot/styles/menu.css" rel="stylesheet" type="text/css"/>
    <link href="/news/wwwroot/styles/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <div class="hola">
        <form action="/news/user?action=login" method="POST">
            <input type="hidden" name="action" value="<%=request.getAttribute("action")%>">  
            <div class="form">
                <div class="grupo">
                    <div class="login-box">
                        <img class="avatar" src="Img/depositphotos_355964924-stock-illustration-default-avatar-profile-icon-vector.jpg" alt="" lang="30%">
                    </div>
                </div>
                <div class="grupo">
                    <label type="submit">Login</label>
                </div>
                <br>
                <br>
                <div class="grupo">
                    <input id="txtEmail" type="text" name="Email" required class="validate"><span class="barra"></span>
                    <label for="txtPassword">Email</label>
                </div>
                <div class="grupo">
                    <input id="txtPassword" type="password" name="Password" required class="validate"><span class="barra"></span>
                    <label for="txtPassword">Password</label>
                    <br>
                    <section class="px-5 d-flex justify-content-between align-items-center">
                        <a href="formulario.html" aria-haspopup=""> create new count</a>
                    </section>
                </div>
<<<<<<< Updated upstream
                <br>
                <br>
                <button type="submit">Confirmar</button>
            </div>
        </form>
    </div>
=======
            </form>  
            <a href="/news/user?view=create">No tengo una cuenta</a>
        </main>
>>>>>>> Stashed changes
    </body>
</html>
