<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mobile Genius</title>
    <link rel="stylesheet" href="./style/home.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>

<body>
<header>
    <div class="container">
        <nav>
            <div class="logo">
                <a href="index.jsp">
                    <img src="./img/logo.png" alt="Mobile Genius">
                </a>
            </div>
            <div class="menu">

            </div>
            <div class="icones">
                <a href="paginaManutencao.jsp"><i class="fa-solid fa-user"></i></a>
                <a href="paginaManutencao.jsp"><i class="fa-solid fa-cart-shopping"></i></a>
            </div>
        </nav>
    </div>
</header>

<section class="banner">
    <div class="container-banner">
        <div class="banner-content">
            <h1>Bem vindo!</h1>
            <p>Cadastre um novo celular no nosso site!</p>
            <a href="cadastroCelular.jsp" class="btn">Cadastre!</a>
        </div>
    </div>
</section>


<section class="produtos">
    <div class="container-produtos">
        <div class="produto">
            <img src="./img/image 1.png" alt="Samsung">
            <h2>Samsung</h2>
            <a href="vejaMais.jsp" class="btn">Veja Mais</a>
        </div>
        <div class="produto">
            <img src="./img/image 2.png" alt="Xiaomi">
            <h2>Xiaomi</h2>
            <a href="vejaMais.jsp" class="btn">Veja Mais</a>
        </div>
    </div>
</section>

<footer>
    <div class="container">
        <div class="footer-logo">
            <a href="index.jsp">
                <img src="./img/logo.png" alt="Mobile Genius">
            </a>
        </div>
        <div class="footer-links">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">Loja</a></li>
                <li><a href="#">Opções de Pagamentos</a></li>
            </ul>
        </div>
    </div>
</footer>
</body>
</html>