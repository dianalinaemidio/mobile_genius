<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <%@ page contentType="text/html; charset=UTF-8" %>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css2?family=Archivo:wght@400;700&display=swap" rel="stylesheet" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha384-REPLACE_WITH_YOUR_SHA384" crossorigin="anonymous">
  <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon" />

  <!-- Carrossel -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Glide.js/3.4.1/css/glide.core.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Glide.js/3.4.1/css/glide.theme.min.css">
  <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />

  <!-- Custom StyleSheet -->
  <link rel="stylesheet" href="style/styles.css" />

  <title>Mobile Genius</title>
</head>

<body>

  <!-- Header -->
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
              <a href="/cart.jsp" class="icon__item" id="cart-btn">
                  <img src="/img/cart-icon.png" alt="Cart">
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
                  <span class="">Nova Inspiração 2024</span>
                  <h1 class="">SMARTPHONES FEITOS PARA VOCÊ!</h1>
                  <p>Em alta na coleção de estilos para celular e fone de ouvido</p>
                  <a href="#"><button class="hero__btn">COMPRE AGORA</button></a>
                </div>
                <div class="hero__right">
                  <div class="hero__img-container">
                    <img class="banner_01" src="/img/celular-vermelho.png" alt="banner2" />
                  </div>
                </div>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </header>
  <!-- End Header -->

  <main>
    <section class="section latest__products" id="latest">
      <div class="title__container">
        <div class="section__title active" data-id="Latest Products">
          <span class="dot"></span>
          <h1 class="primary__title">Novidades</h1>
        </div>
      </div>
      <div class="container aos-init aos-animate" data-aos="fade-up" data-aos-duration="1200">
        <div class="glide glide--ltr glide--carousel glide--swipeable" id="glide_2">
          <div class="glide__track" data-glide-el="track">
            <ul class="glide__slides latest-center" style="transition: transform 0ms cubic-bezier(0.165, 0.84, 0.44, 1) 0s; width: 4733px; transform: translate3d(-1116px, 0px, 0px);">
              <li class="glide__slide glide__slide--clone" style="width: 269px; margin-right: 5px;">
                <div class="product">
              </li>
              <li class="glide__slide glide__slide--clone" style="width: 269px; margin-left: 5px; margin-right: 5px;">
                <div class="product">
                  <div class="product__header">
                    <img src="/images/samsung2.jpeg" alt="product">
                  </div>
                  <div class="product__footer">
                    <h3>Samsung Galaxy</h3>
                    <div class="rating">
                    </div>
                    <div class="product__price">
                      <h4>$300</h4>
                    </div>
                    <a href="#"><button type="submit" class="product__btn">Add To Cart</button></a>
                  </div>
                  <ul>
                    <li>
                      <a data-tip="Quick View" data-place="left" href="#"></a>
                    </li>
                    <li>
                      <a data-tip="Add To Wishlist" data-place="left" href="#"></a>
                    </li>
                    <li>
                      <a data-tip="Add To Compare" data-place="left" href="#"></a>
                    </li>
                  </ul>
                </div>
              </li>
              <li class="glide__slide glide__slide--clone" style="width: 269px; margin-left: 5px; margin-right: 5px;">
                <div class="product">
                  <div class="product__header">
                    <img src="/img/iphone1.jpeg" alt="product">
                  </div>
                  <div class="product__footer">
                    <h3>Sony WH-CH510</h3>
                    <div class="rating">
                    </div>
                    <div class="product__price">
                      <h4>$250</h4>
                    </div>
                    <a href="#"><button type="submit" class="product__btn">Add To Cart</button></a>
                  </div>
                  <ul>
                    <li>
                      <a data-tip="Quick View" data-place="left" href="#"></a>
                    </li>
                    <li>
                      <a data-tip="Add To Wishlist" data-place="left" href="#"></a>
                    </li>
                    <li>
                      <a data-tip="Add To Compare" data-place="left" href="#"></a>
                    </li>
                  </ul>
                </div>
              </li>
              <li class="glide__slide glide__slide--clone" style="width: 269px; margin-left: 5px; margin-right: 5px;">
                <div class="product">
                  <div class="product__header">
                    <img src="/img/products/headphone/headphone1.jpeg" alt="product">
                  </div>
                  <div class="product__footer">
                    <h3>Sony WH-CH510</h3>
                    <div class="rating">
                    </div>
                    <div class="product__price">
                      <h4>$250</h4>
                    </div>
                    <a href="#"><button type="submit" class="product__btn">Adicionar ao carrinho</button></a>
                  </div>
                  <ul>
                    <li>
                      <a data-tip="Quick View" data-place="left" href="#"></a>
                    </li>
                    <li>
                      <a data-tip="Add To Wishlist" data-place="left" href="#"></a>
                    </li>
                    <li>
                      <a data-tip="Add To Compare" data-place="left" href="#"></a>
                    </li>
                  </ul>
                </div>
              </li>
              <li class="glide__slide glide__slide--clone" style="width: 269px; margin-left: 5px; margin-right: 5px;">
                <div class="product">
                  <div class="product__header">
                    <img src="/img/iphone2.jpeg" alt="product">
                  </div>
                  <div class="product__footer">
                    <h3>Apple iPhone XR</h3>
                    <div class="rating">
                    </div>
                    <div class="product__price">
                      <h4>$550</h4>
                    </div>
                    <a href="#"><button type="submit" class="product__btn">Adicionar ao carrinho</button></a>
                  </div>
                  <ul>
                    <li>
                      <a data-tip="Quick View" data-place="left" href="#"></a>
                    </li>
                    <li>
                      <a data-tip="Add To Wishlist" data-place="left" href="#"></a>
                    </li>
                    <li>
                      <a data-tip="Add To Compare" data-place="left" href="#"></a>
                    </li>
                  </ul>
                </div>
              </li>
              <li class="glide__slide glide__slide--active" style="width: 269px; margin-left: 5px; margin-right: 5px;">
                <div class="product">
                  <div class="product__header">
                    <img src="/img/iphone5.jpeg" alt="product">
                  </div>
                  <div class="product__footer">
                    <h3>Apple iPhone 11</h3>
                    <div class="rating">
                    </div>
                    <div class="product__price">
                      <h4>$750</h4>
                    </div>
                    <a href="#"><button type="submit" class="product__btn">Adicionar ao carrinho</button></a>
                  </div>
                  <ul>
                    <li>
                      <a data-tip="Quick View" data-place="left" href="#"></a>
                    </li>
                    <li>
                      <a data-tip="Add To Wishlist" data-place="left" href="#"></a>
                    </li>
                    <li>
                      <a data-tip="Add To Compare" data-place="left" href="#"></a>
                    </li>
                  </ul>
                </div>
              </li>
              <li class="glide__slide" style="width: 269px; margin-left: 5px; margin-right: 5px;">
                <div class="product">
                  <div class="product__header">
                    <img src="/img/samsung5.jpeg" alt="product">
                  </div>
                  <div class="product__footer">
                    <h3>Samsung Galaxy</h3>
                    <div class="rating">
                    </div>
                    <div class="product__price">
                      <h4>$900</h4>
                    </div>
                    <a href="#"><button type="submit" class="product__btn">Adicionar ao carrinho</button></a>
                  </div>
                  <ul>
                    <li>
                      <a data-tip="Quick View" data-place="left" href="#"></a>
                    </li>
                    <li>
                      <a data-tip="Add To Wishlist" data-place="left" href="#"></a>
                    </li>
                    <li>
                      <a data-tip="Add To Compare" data-place="left" href="#"></a>
                    </li>
                  </ul>
                </div>
              </li>
              <li class="glide__slide" style="width: 269px; margin-left: 5px; margin-right: 5px;">
                <div class="product">
                  <div class="product__header">
                    <img src="/img/iphone6.jpeg" alt="product">
                  </div>
                  <div class="product__footer">
                    <h3>Apple iPhone 12</h3>
                    <div class="rating">
                    </div>
                    <div class="product__price">
                      <h4>$950</h4>
                    </div>
                    <a href="#"><button type="submit" class="product__btn">Adicionar ao carrinho</button></a>
                  </div>
                  <ul>
                    <li>
                      <a data-tip="Quick View" data-place="left" href="#"></a>
                    </li>
                    <li>
                      <a data-tip="Add To Wishlist" data-place="left" href="#"></a>
                    </li>
                    <li>
                      <a data-tip="Add To Compare" data-place="left" href="#"></a>
                    </li>
                  </ul>
                </div>
              </li>
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
        </div>
      </div>
    </section>

     <!-- Text Section -->
      <section class="section-text">
        <div class="container">
        </div>
      </section>
     <!-- End Text Section -->
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
