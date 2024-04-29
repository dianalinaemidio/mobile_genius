<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    
    <link rel="stylesheet" href="./style/areaCliente.css">
    <link rel="stylesheet" href="style/styles.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
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
    
    <section class="banner">
        <div class="container">
            <div class="banner-content">
                <img src="./img/logo.png" alt="Mobile Genius">
                <a href="#" class="home-link">Home</a>
            </div>
        </div>
    </section>

    <section class="cliente-info">
        <div class="container">
            <div class="info">
                <h3>Informações</h3>
                <p>Nome: Diana Lina Emidio</p>
                <p>E-mail: dianalinafacul@gmail.com</p>
                <p>Telefone: (11)99999-9999</p>
                <button type="button" class="excluir-btn">Deseja excluir sua conta?</button>
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
        </div>
        <div class="footer-top__box">
          <h3>INFORMATION</h3>
          <a href="#">About Us</a>
          <a href="#">Privacy Policy</a>
          <a href="#">Terms & Conditions</a>
        </div>
        <div class="footer-top__box">
          <h3>MY ACCOUNT</h3>
          <a href="#">My Account</a>
          <a href="#">Order History</a>
          <a href="#">Wish List</a>
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
        </div>
      </div>
    </div>
  </footer>
  <!-- End Footer -->
</body>
</html>
