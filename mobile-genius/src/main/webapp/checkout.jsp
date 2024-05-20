<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8" />

    <title>Mobile Genius</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="style/styles.css" />
    <link rel="stylesheet" href="style/checkout.css" />

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

<main>
    <section>
        <div class="container-checkout">
            <div class="left-side">
                <div class="items">
                    <div class="select-image">
                        <img src="/img/iphone2.jpeg">
                    </div>

                    <div class="thumbnails">
                        <div class="thumbnail">
                            <img src="/img/iphone2.jpeg">
                        </div>

                        <div class="thumbnail">
                            <img src="/img/iphone6.jpeg">
                        </div>

                        <div class="thumbnail">
                            <img src="/img/iphone2.jpeg">
                        </div>

                        <div class="thumbnail">
                            <img src="/img/iphone6.jpeg">
                        </div>
                    </div>
                </div>
            </div>
            <div class="right-side">
                <div class="content">
                    <h6> IPHONE 13 PRO </h6>
                    <h1> asdjaksjdasd</h1>
                    <p> Esse é o Iphone 13, um ótimo smartphone da Apple, com câmera e tela maravilhosos!</p>
                    <div class="prices">
                        <span class="price">$150.00</span>
                        <span class="off">$230.00</span>
                    </div>
                    <div class="options">
                        <div class="amount">
                            <div class="minus">
                                <button><i class="fa-solid fa-minus"></i></button>
                            </div>
                            <span>0</span>
                            <div class="plus">
                                <button><i class="fa-solid fa-plus"></i></button>
                            </div>
                        </div>

                        <a href="" class="button"><i class="fa-solid fa-cart-shopping"></i> Add to cart</a>

                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

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
  <!-- Footer -->
      <footer class="footer">
        <div class="container">
          <p>&copy; 2024 Mobile Genius.</p>
        </div>
      </footer>
  <!-- End Footer -->
</body>
</html>
