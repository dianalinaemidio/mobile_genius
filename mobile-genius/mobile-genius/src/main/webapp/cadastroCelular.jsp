<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mobile Genius</title>
    <link rel="stylesheet" href="./style/cadastroCelular.css">
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
  </header>
  <!-- End Header -->


    <form action="/create-celular" method="post">
        <div class="container-form">
            <h2>Cadastro de Celular</h2>
            <div class="form-group">
                <label for="marca">Marca</label>
                <input type="text" id="marca" name="marca" value="${param.marca}">
            </div>
            <div class="form-group">
                <label for="modelo">Modelo</label>
                <input type="text" id="modelo" name="modelo" value="${param.modelo}">
            </div>
            <div class="form-group">
                <label for="preco">Preço</label>
                <input type="text" id="preco" name="preco" value="${param.preco}">
            </div>
            <div class="form-group">
                <label for="quantidade">Quantidade</label>
                <input type="text" id="quantidade" name="quantidade" value="${param.quantidade}">
            </div>
            <div class="form-group">
                <label for="descricao">Descrição</label>
                <input type="text" id="descricao" name="descricao" value="${param.descricao}">
            </div>
            <div class="form-group">
                <input type="hidden" id="id" name="id" value="${param.id}">
            </div>
            <div class="buttons">
                <button type="submit">Confirmar</button>
                <a href="/encontre-todos-celulares" class="btn">Celulares Cadastrados</a>
            </div>
        </div>
    </form>

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
