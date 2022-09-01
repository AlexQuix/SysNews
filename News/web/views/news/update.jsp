
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="news.el.User"%>
<% News news = (News) request.getAttribute("news");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <<main class="container">   
            <h5>Crear Noticia</h5>
            <form action="/news/news?action=update" method="POST" onsubmit="return  ValidateForm()">
                <input type="hidden" name="action" value="<%=request.getAttribute("action")%>"> 
                <input type="hidden" name="id" value="<%=news.getIdNews()%>">                
                <div class="row">
                    <div class="input-field col l4 s12">
                        <input id="txtTittle" type="text" name="Tittle" value="<%=news.getTittle()%>" required class="validate" >
                        <label for="txtTittle">Título</label>
                    </div>                       
                    <div class="input-field col l4 s12">
                        <input id="txtCategory" type="text" name="Category" value="<%=news.getCategory()%>" required class="validate">
                        <label for="txtCategory">Categoría</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input id="txtDescription" type="text" name="Description" value="<%=news.getDescription()%>" required class="validate">
                        <label for="txtDescription">Descripción</label>
                    </div> 
                    <!-- <div class="input-field col l4 s12">
                        <input id="txtImage" type="file" name="Image" value="<%=news.getImageNews()%>" class="validate">
                        <label for="txtImage">Imagen</label>
                    </div>  -->
                    
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
