<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css2?family=Archivo:wght@400;700&display=swap" rel="stylesheet" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha384-REPLACE_WITH_YOUR_SHA384" crossorigin="anonymous">
  <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon" />

  <!-- Carousel -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Glide.js/3.4.1/css/glide.core.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Glide.js/3.4.1/css/glide.theme.min.css">
  <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />

  <!-- Folha de Estilos Personalizada -->
  <link rel="stylesheet" href="style/styles.css" />

  <title>Mobile Genius</title>
</head>

<body>

  <!-- Cabeçalho -->
  <header class="header">
    <div class="navigation">
      <nav class="nav">
        <div class="nav__hamburger">
          <img src="/images/menu-icon.png" alt="Menu">
        </div>

        <div class="nav__logo">
          <a href="/" class="scroll-link">  Mobile Genius </a>
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

    <!-- Hero -->
    <div class="hero">
      <div class="glide" id="glide_1">
        <div class="glide__track" data-glide-el="track">
          <ul class="glide__slides">
            <li class="glide__slide">
              <div class="hero__center">
                <span class="">Nova Inspiração 2020</span>
                <h1 class="">SMARTPHONES FEITOS PARA VOCÊ!</h1>
                <p>Em alta na coleção de estilos para celular e fone de ouvido</p>
                <a href="#"><button class="hero__btn">COMPRE AGORA</button></a>
                <div class="hero__img-container">
                  <img class="banner_01" src="/images/celular-vermelho.png" alt="banner2" />
                </div>
              </div>
            </li>
            <li class="glide__slide">
              <div class="hero__center">
                <span>Nova Inspiração 2020</span>
                <h1>SMARTPHONES FEITOS PARA VOCÊ!</h1>
                <p>Em alta na coleção de estilos para celular e fone de ouvido</p>
                <a href="#"><button class="hero__btn">COMPRE AGORA</button></a>
                <img class="banner_02" src="/images/banner_02.png" alt="banner2" />
              </div>
            </li>
          </ul>
        </div>
        <div class="glide__bullets" data-glide-el="controls[nav]">
          <button class="glide__bullet" data-glide-dir="=0"></button>
          <button class="glide__bullet" data-glide-dir="=1"></button>
        </div>
      </div>
    </div>
  </header>
  <!-- Fim do Cabeçalho -->

  <main>
    <section class="section latest__products" id="latest">
      <div class="title__container">
        <div class="section__title active" data-id="Últimos Produtos">
          <span class="dot"></span>
          <h1 class="primary__title">Novidades</h1>
        </div>
      </div>
      <div class="container aos-init aos-animate" data-aos="fade-up" data-aos-duration="1200">
        <div class="glide glide--ltr glide--carousel glide--swipeable" id="glide_2">
          <div class="glide__track" data-glide-el="track">
            <ul class="glide__slides latest-center">
            </ul>
          </div>
          <div class="glide__arrows" data-glide-el="controls">
            <button class="glide__arrow glide__arrow--left" data-glide-dir="<">
              <i class="uil uil-angle-left-b"></i>
            </button>
            <button class="glide__arrow glide__arrow--right" data-glide-dir=">">
              <i class="uil uil-angle-right-b"></i>
            </button>
          </div>
          <div class="glide__bullets" data-glide-el="controls[nav]">
            <button class="glide__bullet" data-glide-dir="=0"></button>
            <button class="glide__bullet" data-glide-dir="=1"></button>
          </div>
        </div>
      </div>
    </section>

  </main>

  <!-- Rodapé -->
  <footer class="section footer">
    <div class="container">
      <div class="footer__top">
        <div class="footer-top__box">
          <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="#">Loja</a></li>
            <li><a href="#">Opções de Pagamento</a></li>
          </ul>
        </div>
      </div>
    </div>
  </footer>


</body>

</html>
