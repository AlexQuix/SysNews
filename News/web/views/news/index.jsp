

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>index</title>
    <link href="/news/wwwroot/styles/menu.css" rel="stylesheet" type="text/css"/>
    <link href="/news/wwwroot/styles/buscador.css" rel="stylesheet" type="text/css"/>
    <link href="/news/wwwroot/styles/ventanas.css" rel="stylesheet" type="text/css"/>
</head>

<body>
    <section>
        <form autocomplete="off">
            <div>
                <imput type="text" name="q" aria-placeholder="Buscar"></imput>
            </div>
        </form>
    </section>
    <section class="px-5 d-flex justify-content-between align-items-center">
        <img class="avatar" src="img/logo.png">
    </section>
    <header class="header">
        <div class="container">
            <div class="btn-menu">
                <label for="btn-menu">☰</label>
                <h2>
                    <article autocomplete="off">
                        <div>
                            <input tapy="text" name="q" placeholder="Buscar">
                        </div>
                    </article>
                </h2>
            </div>
            <div class="logo">
            </div>
            <nav class="menu">

                <a href="Noticia.html">Noticias</a>
                <a href="User.html"> User </a>
            </nav>
        </div>
    </header>
    <!---<div class="capa"></div>-->
    <!--	--------------->
    <input type="checkbox" id="btn-menu">
    <div class="container-menu">
        <div class="cont-menu">
            <nav>
                <a href="Noticia.html">New News</a>
                <a href="latest news.html">News of the moment </a>

                <a href="#">Add News</a>
                <a href="#">Configuration</a>
            </nav>
            <label for="btn-menu">X </label>
        </div>
    </div>
    <!---Home---->
    <div class="container-card">

        <div class="card">
            <figure>
                <img src="https://img-s-msn-com.akamaized.net/tenant/amp/entityid/AA11iyUx.img?w=768&h=525&m=6&x=0&y=0&s=3072&d=2048">
            </figure>
            <div class="contenido-card">
                <h3>News Ucrania / Rusia</h3>
                <p>Sigue la última hora de la guerra entre Rusia y Ucrania hoy en directo. Reacciones internacionales al conflicto y avance de las tropas de Vladímir Putin por el territorio ucraniano ante la resistencia de Volodímir Zelenski. Últimas noticias
                    de la guerra ruso-ucraniana.</p>
                <br>

                <a href="news intenacional.html">Leer Màs</a>
            </div>
        </div>
        <div class="card">
            <figure>
                <img src="https://www.bing.com/th?id=OVFT.pS3B7XzBrmC48ORekCzX1y&pid=News&w=234&h=132&c=14&rs=2&qlt=90">
            </figure>
            <div class="contenido-card">
                <h3>El auténtico Neymar empieza a asomar cerca del Mundial</h3>
                <p>Hubo un momento en que la actitud de Neymar fue muy criticada por su propensidad a provocar a sus rivales con sus filigranas o por reclamarle a sus compañeros que el pasaran el balón, para luego quedar en deuda cuando el PSG más necesitaba
                    de él en la Liga de Campeones.</p>
                <a href="news sport.html">Leer Màs</a>
            </div>
        </div>
        <div class="card">
            <figure>
                <img src="https://tse1.mm.bing.net/th?&id=OVP.Yge3siWT3zc7cRmvYOt2xgEsCo&w=272&h=180&c=7&pid=2.1&rs=1">
            </figure>
            <div class="contenido-card">
                <h3> breaking news</h3>
                <p>La noticia en ultimo moento Últimas noticias del mundo, breaking news, videos y fotos sobre el mundo. Noticias internacionales y el mundo: Europa, Asia, Africa, Medio Oriente, Oceanía y América, en CNN.</p>
                <br>
                <br>
                <br>
                <br>
                <a href="Noticia.html">Leer Màs</a>
            </div>
        </div>
    </div>

</body>

</html>
