<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mobile Genius</title>
    <link rel="stylesheet" href="./style/minhaConta.css">
</head>
<body>
    <header>
        <div class="container">
            <nav>
                <div class="logo">
                    <img src="./img/logo.png" alt="Mobile Genius">
                </div>
                <div class="menu">

                </div>
                <div class="icones">
                    <a href="#"><img src="img/user.png" alt="user"></a>
                    <a href="#"><img src="img/carrinho.png" alt="carrinho"></a>
                </div>
            </nav>
        </div>
    </header>

    <section class="banner">
        <div class="container">
            <div class="banner-content">
                <img src="img/logo.png" alt="Mobile Genius">
                <a href="#" class="home-link">Home</a>
            </div>
        </div>
    </section>
    

    <section class="form">
        <div class="container-form">
            <h2>Minha conta</h2>
            <div class="form-container">
                <form class="login-form">
                    <h3>Log In</h3>
                    <input type="email" placeholder="E-mail" required>
                    <input type="password" placeholder="Senha" required>
                    <button type="submit">Log In</button>
                </form>
                <form class="register-form">
                    <h3>Registrar</h3>
                    <input type="text" placeholder="Nome" required>
                    <input type="email" placeholder="E-mail" required>
                    <input type="password" placeholder="Senha" required>
                    <input type="tel" placeholder="Telefone">
                    <button type="submit">Registrar</button>
                </form>
            </div>
        </div>
    </section>

    <footer>
        <div class="container">
            <div class="footer-logo">
                <img src="./img/logo.png" alt="Mobile Genius">
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
