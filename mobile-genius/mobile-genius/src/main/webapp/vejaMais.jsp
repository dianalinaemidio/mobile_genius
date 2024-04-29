<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <title>Celulares</title>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="./style/listaCelular.css">
    <link rel="stylesheet" href="style/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>

<body class="main-bg">
  <!-- Header -->
  <header id="header" class="header">
    <div class="navigation">
      <div class="container">
        <nav class="nav">
          <div class="nav__hamburger">
            <img src="/images/menu-icon.png" alt="Menu">
          </div>
  
          <div class="nav__logo">
            <a href="/" class="scroll-link">
              MOBILE GENIUS
            </a>
          </div>
  
          <div class="nav__menu">
            <div class="menu__top">
              <span class="nav__category">PHONE</span>
              <a href="#" class="close__toggle">
                <img src="/images/user-solid.svg" alt="Close">
              </a>
            </div>
            <ul class="nav__list">
              <li class="nav__item">
                <a href="#header" class="nav__link scroll-link">Home</a>
              </li>
              <li class="nav__item">
                <a href="#category" class="nav__link scroll-link">Category</a>
              </li>
              <li class="nav__item">
                <a href="#news" class="nav__link scroll-link">Blog</a>
              </li>
              <li class="nav__item">
                <a href="#contact" class="nav__link scroll-link">Contact</a>
              </li>
            </ul>
          </div>
  
          <div class="nav__icons">
            <a href="#" class="icon__item" id="login-btn">
              <img src="/images/icone-user.png" alt="User">
            </a>
  
            <a href="#" class="icon__item" id="search-btn">
              <img src="/images/search-icon.png" alt="Search">
            </a>
  
            <a href="#" class="icon__item" id="cart-btn">
              <img src="/images/cart-icon.png" alt="Cart">
              <span id="cart__total">3</span>
            </a>
          </div>
        </nav>
      </div>
    </div>
  </header>
  <!-- End Header -->
  


    <div class="menu-spacing"></div>

    <section id="Samsung" class="intro main-bg section">
        <div class="main-content intro-content">
            <div class="intro-text-content">
                <h2>Samsung</h2>
                <p>
                    A Samsung é uma das principais fabricantes de smartphones do mundo. Seus dispositivos são conhecidos
                    pela inovação, desempenho e qualidade de construção. Com uma ampla gama de modelos, a Samsung oferece
                    opções para todos os tipos de usuários, desde os mais básicos até os mais avançados.
                </p>
            </div>
            <div class="intro-img">
                <img src="img/image%201.png" alt="Imagem representativa da Samsung">
            </div>
        </div>
    </section>

    <section id="Xiaomi" class="white-bg section">
        <div class="main-content intro-content">
            <div class="intro-text-content">
                <h2>Xiaomi</h2>
                <p>
                    A Xiaomi é uma marca inovadora que se destaca por oferecer produtos de alta qualidade a preços acessíveis.
                    Conhecida como "Apple chinesa", a Xiaomi é famosa por seus smartphones, que combinam um design elegante
                    com recursos avançados. Além de smartphones, a Xiaomi fabrica uma ampla gama de dispositivos inteligentes
                    para casa, gadgets e acessórios que visam simplificar a vida dos usuários.
                </p>
            </div>
            <div class="intro-img">
                <img src="img/image%202.png" alt="Imagem representativa da Xiaomi">
            </div>
        </div>
    </section>


  <!-- Footer -->
  <footer id="footer" class="section footer">
    <div class="container">
      <div class="footer__top">
        <div class="footer-top__box">
          <h3>EXTRAS</h3>
          <a href="#">Brands</a>
          <a href="#">Gift Certificates</a>
          <a href="#">Affiliate</a>
          <a href="#">Specials</a>
          <a href="#">Site Map</a>
        </div>
        <div class="footer-top__box">
          <h3>INFORMATION</h3>
          <a href="#">About Us</a>
          <a href="#">Privacy Policy</a>
          <a href="#">Terms & Conditions</a>
          <a href="#">Contact Us</a>
          <a href="#">Site Map</a>
        </div>
        <div class="footer-top__box">
          <h3>MY ACCOUNT</h3>
          <a href="#">My Account</a>
          <a href="#">Order History</a>
          <a href="#">Wish List</a>
          <a href="#">Newsletter</a>
          <a href="#">Returns</a>
        </div>
        <div class="footer-top__box">
          <h3>CONTACT US</h3>
          <div>
            Senac, Nações Unidas, 2000 São Paulo
          </div>
          <div>
            teste@teste.com
          </div>
          <div>
            11 99999-9999
          </div>
          <div>
            São Paulo, BR
          </div>
        </div>
      </div>
    </div>
  </footer>
  <!-- End Footer -->
</body>

</html>
