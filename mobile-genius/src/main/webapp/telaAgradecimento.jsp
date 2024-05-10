<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="style/styles.css" />
    <link rel="stylesheet" href="style/telaAgradecimento.css" />
</head>
<body>
<header id="header" class="header">
    <div class="navigation">
        <div class="container">
            <nav class="nav">
                <div class="nav__hamburger">
                    <img src="/img/menu-icon.png" alt="Menu">
                </div>

                <div class="nav__logo">
                    <a href="/" class="scroll-link"> Mobile Genius </a>
                </div>

                <div class="nav__menu">
                    <div class="menu__top">
                        <span class="nav__category">PHONE</span>
                        <a href="#" class="close__toggle">
                            <img src="/img/user-solid.svg" alt="Close">
                        </a>
                    </div>
                </div>

                <div class="nav__icons">
                    <a href="/login.jsp" class="icon__item" id="login-btn">
                        <img src="/img/icone-user.png" alt="User">
                    </a>

                    <a href="#" class="icon__item" id="cart-btn">
                        <img src="/img/cart-icon.png" alt="Cart">
                    </a>
                </div>
            </nav>
        </div>
    </div>
</header>

<div class="agradecimento">
    <h1>Obrigado pela compra!</h1>
    <h3>Em breve voce recebera um e-mail com as informacoes do pedido!</h3>
    <p>Nos da Mobile Genius, agradecemos sua compra e lhe desejamos um otimo uso do seu novo smartphone!</p>
    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
</div>

<footer id="footer" class="section footer">
    <div class="container">
        <div class="footer__top">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">Loja</a></li>
                <li><a href="login.jsp">Login</a></li>
            </ul>
        </div>
    </div>
</footer>
</body>
</html>