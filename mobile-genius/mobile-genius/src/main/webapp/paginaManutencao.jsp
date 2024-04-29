<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mobile Genius</title>
    <link rel="stylesheet" href="./style/paginaManutencao.css">
    <link rel="stylesheet" href="style/styles.css">
    <title>Site em Manutenção</title>
</head>
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
    
  <!-- Hero -->
    <div class="hero">
      <div class="glide" id="glide_1">
        <div class="glide__track" data-glide-el="track">
          <ul class="glide__slides">
            <li class="glide__slide">
              <div class="hero__center">
                <div class="hero__left">
                  <span class="">New Inspiration 2020</span>
                  <h1 class="">PHONES MADE FOR YOU!</h1>
                  <p>Trending from mobile and headphone style collection</p>
                  <a href="#"><button class="hero__btn">SHOP NOW</button></a>
                </div>
                <div class="hero__right">
                  <div class="hero__img-container">
                    <img class="banner_01" src="/images/celular-vermelho.png" alt="banner2" />
                  </div>
                </div>
              </div>
            </li>
            <li class="glide__slide">
              <div class="hero__center">
                <div class="hero__left">
                  <span>New Inspiration 2020</span>
                  <h1>PHONES MADE FOR YOU!</h1>
                  <p>Trending from mobile and headphone style collection</p>
                  <a href="#"><button class="hero__btn">SHOP NOW</button></a>
                </div>
                <div class="hero__right">
                  <img class="banner_02" src="/images/banner_02.png" alt="banner2" />
                </div>
              </div>
            </li>
          </ul>
        </div>
        <div class="glide__bullets" data-glide-el="controls[nav]">
          <button class="glide__bullet" data-glide-dir="=0"></button>
          <button class="glide__bullet" data-glide-dir="=1"></button>
        </div>
  
        <div class="glide__arrows" data-glide-el="controls">
          <button class="glide__arrow glide__arrow--left" data-glide-dir="<">
            <img src="/images/arrow-left.png" alt="Previous">
          </button>
          <button class="glide__arrow glide__arrow--right" data-glide-dir=">">
            <img src="/images/arrow-right.png" alt="Next">
          </button>
        </div>
      </div>
    </div>
  </header>
  <!-- End Header -->
  

<body>
    <div class="container">
        <img src="./img/logo.png" alt="Logo da Empresa" class="logo">
        <h1>Estamos em Manutenção</h1>
        <p>Lamentamos o transtorno, mas estamos trabalhando para melhorar nossos serviços.</p>
        <p>Voltaremos em breve!</p>
        <a href="index.jsp" class="btn-home">Voltar para Home</a>
    </div>
</body>

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
</html>

