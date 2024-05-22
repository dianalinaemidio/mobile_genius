<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="UTF-8" />
    <title>Descrição do Produto - Mobile Genius</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha384-REPLACE_WITH_YOUR_SHA384" crossorigin="anonymous">
    <link rel="stylesheet" href="style/checkout.css" />
    <link rel="stylesheet" href="style/styles.css" />
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
                        <a href="/index" class="scroll-link"> Mobile Genius </a>
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
                        <a href="/carrinho" class="icon__item" id="cart-btn">
                            <img src="/img/cart-icon.png" alt="Cart">
                        </a>
                    </div>
                </nav>
            </div>
        </div>
    </header>

    <main>
        <section>
            <div class="container-checkout">
                <div class="left-side">
                    <div class="items">
                        <div class="select-image">
                            <img src="${celular.image}" alt="${celular.marca} ${celular.modelo}">
                        </div>
                    </div>
                </div>
                <div class="right-side">
                    <div class="content">
                        <h6>${celular.marca}</h6>
                        <h1>${celular.modelo}</h1>
                        <p>${celular.descricao}</p>
                        <div class="prices">
                            <span class="price">R$ ${celular.preco}</span>
                        </div>
                        <div class="options">
                            <div class="amount">
                                <div class="minus">
                                    <button><i class="fa-solid fa-minus"></i></button>
                                </div>
                                <span>1</span>
                                <div class="plus">
                                    <button><i class="fa-solid fa-plus"></i></button>
                                </div>
                            </div>
                            <a href="/carrinho?add=${celular.id}" class="button"><i class="fa-solid fa-cart-shopping"></i> Adicionar ao Carrinho</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <!-- Footer -->
    <footer class="footer">
        <div class="container">
            <p>&copy; 2024 Mobile Genius.</p>
        </div>
    </footer>
    <!-- End Footer -->
</body>

</html>
