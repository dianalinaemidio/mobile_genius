<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <%@ page contentType="text/html; charset=UTF-8" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <link rel="stylesheet" href="style/index.css" />
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
                  <a href="cart.jsp"><button class="hero__btn">COMPRE AGORA</button></a>
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

<br> <br>

  <main>

       <!-- Seção de Produtos em Destaque -->
       <section class="featured-products">
           <div class="container">
               <h2>Produtos em Destaque</h2>
               <div class="product-list">

                   <c:forEach var="celular" items="${celulares}">
                       <div class="product">
                           <img src="${celular.image}" alt="${celular.marca} ${celular.modelo}">
                           <h3>${celular.marca} ${celular.modelo}</h3>
                           <p>${celular.descricao}</p>
                           <p>Preço: R$ ${celular.preco}</p>

                           <c:choose>
                               <c:when test="${sessionScope.LoggedUser != null}">
                                   <form action="index" method="post">
                                       <input type="hidden" name="action" value="addCarrinho">
                                       <input type="hidden" name="celularId" value="${celular.id}">
                                       <input type="submit" class="button" value="Adicionar ao Carrinho">
                                   </form>
                               </c:when>
                               <c:otherwise>
                                   <p>Por favor, faça login para adicionar produtos ao carrinho.</p>
                                   <a href="login.jsp" class="button">Ir para a página de login</a>
                               </c:otherwise>
                           </c:choose>

                           <form action="descricao" method="get">
                               <input type="hidden" name="id" value="${celular.id}">
                               <input type="submit" class="button" value="Ver Descrição">
                           </form>
                       </div>
                   </c:forEach>


               </div>
           </div>
       </section>


     <!-- Seção de Sobre Nós -->
     <section class="about-us">
       <div class="container">
         <h2>Sobre Nós</h2>
         <div class="about-content">
           <div class="about-text">
             <p>Somos o Mobile Genius, um e-commerce fundado em 2024, dedicado a fornecer os melhores produtos e serviços para nossos clientes. Nossa missão é oferecer uma experiência de compra excepcional, proporcionando produtos de alta qualidade e um atendimento ao cliente de excelência.</p>
             <p>Desde nossa fundação, nos comprometemos em ser uma referência no mercado, oferecendo uma ampla variedade de smartphones, acessórios e serviços relacionados. Nosso objetivo é satisfazer as necessidades dos nossos clientes, proporcionando produtos inovadores e soluções tecnológicas que melhorem suas vidas.</p>
             <p>Nossa equipe é composta por profissionais apaixonados e experientes que trabalham duro para garantir a satisfação do cliente. Estamos sempre atualizados com as últimas tendências e tecnologias do mercado, para oferecer aos nossos clientes as melhores opções disponíveis.</p>
             <p>Seja qual for sua necessidade em relação a dispositivos móveis, acessórios ou serviços, estamos aqui para ajudar. Entre em contato conosco hoje mesmo para saber mais sobre como podemos atendê-lo.</p>
           </div>
         </div>
       </div>
     </section>


   <!-- Carrossel de Depoimentos de Clientes -->
   <div class="glide" id="glide_2">
     <div class="glide__track" data-glide-el="track">
       <ul class="glide__slides">
         <li class="glide__slide">
           <div class="testimonial">
             <p>"O produto superou minhas expectativas! O suporte ao cliente também foi excelente."</p>
             <span class="author">- Maria Silva</span>
           </div>
         </li>
         <li class="glide__slide">
           <div class="testimonial">
             <p>"Estou muito satisfeito com a rapidez da entrega e a qualidade do produto. Recomendo!"</p>
             <span class="author">- João Santos</span>
           </div>
         </li>
         <li class="glide__slide">
           <div class="testimonial">
             <p>"Ótimo atendimento! Comprei várias vezes e nunca me decepcionei."</p>
             <span class="author">- Ana Oliveira</span>
           </div>
         </li>
         <!-- Adicione mais depoimentos conforme necessário -->
       </ul>
     </div>

      <!-- Indicadores de navegação -->
       <div class="glide__bullets" data-glide-el="controls[nav]">
         <button class="glide__bullet" data-glide-dir="=0"></button>
         <button class="glide__bullet" data-glide-dir="=1"></button>
         <button class="glide__bullet" data-glide-dir="=2"></button>
       </div>
     </div>
   <!-- End Carrossel de Depoimentos de Clientes -->

   <!-- Seção de FAQ -->
   <section class="faq">
     <div class="container">
       <h2>Perguntas Frequentes</h2>
       <div class="faq-items">
         <div class="faq-item">
           <h3 class="faq-question">Como faço para fazer um pedido?</h3>
           <p class="faq-answer">Para fazer um pedido, basta navegar pelo nosso catálogo de produtos, selecionar o item desejado e adicionar ao carrinho de compras. Depois, siga as instruções para finalizar o pedido e escolher o método de pagamento.</p>
         </div>
         <div class="faq-item">
           <h3 class="faq-question">Quais são as opções de pagamento disponíveis?</h3>
           <p class="faq-answer">Aceitamos várias formas de pagamento, incluindo cartão de crédito, débito, PayPal e transferência bancária. Você pode escolher a opção que melhor se adapta às suas necessidades durante o processo de checkout.</p>
         </div>
         <div class="faq-item">
           <h3 class="faq-question">Qual é a política de devolução da Mobile Genius?</h3>
           <p class="faq-answer">Nossa política de devolução permite que você devolva produtos dentro de 30 dias a partir da data da compra, desde que estejam em condições de novo e na embalagem original. Para mais detalhes, consulte nossa página de políticas de devolução.</p>
         </div>
       </div>
     </div>
   </section>


  </main>

<br> <br> <br> <br> <br>
 <!-- Footer -->
   <footer class="footer">
     <div class="container">
       <p>&copy; 2024 Mobile Genius.</p>
     </div>
   </footer>
   <!-- End Footer -->


   <!-- Scripts -->
     <script src="https://cdnjs.cloudflare.com/ajax/libs/Glide.js/3.4.1/glide.min.js"></script>
     <script>
       new Glide('#glide_1', {
         type: 'carousel',
         startAt: 0,
         perView: 1
       }).mount();

       new Glide('#glide_2', {
         type: 'carousel',
         startAt: 0,
         perView: 3,
         breakpoints: {
           800: {
             perView: 2
           },
           480: {
             perView: 1
           }
         }
       }).mount();

     </script>

     <script>
       document.addEventListener("DOMContentLoaded", function() {
         const faqItems = document.querySelectorAll(".faq-item");

         faqItems.forEach(function(item) {
           item.addEventListener("click", function() {
             faqItems.forEach(function(item) {
               item.classList.remove("active");
             });
             this.classList.add("active");
           });
         });
       });


     </script>


</body>

</html>