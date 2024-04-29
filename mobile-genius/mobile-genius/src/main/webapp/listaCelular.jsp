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
  <link rel="stylesheet" href="style/listaCelular.css" />
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
            <a href="#" class="icon__item" id="login-btn">
              <img src="/img/icone-user.png" alt="User">
            </a>

            <a href="#" class="icon__item" id="cart-btn">
              <img src="/img/cart-icon.png" alt="Cart">
              <span id="cart__total">3</span>
            </a>
          </div>
        </nav>
      </div>
    </div>
    </header>
  <!-- End Header -->
  
    <div class="modal-content">
        <h3>LISTA DE CELULARES CADASTRADOS</h3>

        <table>
                        <tr>
                            <th>ID</th>
                            <th>Marca</th>
                            <th>Modelo</th>
                            <th>Preco</th>
                            <th>Quantidade</th>
                            <th>Descricao</th>
                            <th>Ações</th>
                        </tr>

                        <c:forEach var="celular" items="${celulares}">
                            <tr>
                                <td>${celular.id}</td>
                                <td>${celular.marca}</td>
                                <td>${celular.modelo}</td>
                                <td>${celular.preco}</td>
                                <td>${celular.quantidade}</td>
                                <td>${celular.descricao}</td>
                                <td>
                                    <form action="/delete-celular" method="post">
                                        <input type="hidden" id="id" name="id" value="${celular.id}">
                                        <button type="submit">Deletar</button>
                                    </form>
                                        <span> | </span>
                                    <form action="cadastroCelular.jsp" method="post">
                                            <input type="hidden" name="id" value="${celular.id}">
                                            <input type="hidden" name="marca" value="${celular.marca}">
                                            <input type="hidden" name="modelo" value="${celular.modelo}">
                                            <input type="hidden" name="preco" value="${celular.preco}">
                                            <input type="hidden" name="quantidade" value="${celular.quantidade}">
                                            <input type="hidden" name="descricao" value="${celular.descricao}">
                                            <button type="submit">Update</button>
                                        </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

    </div>


    
<!-- Footer -->
  <footer id="footer" class="section footer">
    <div class="container">
      <div class="footer__top">
        <ul>
          <li><a href="index.jsp">Home</a></li>
          <li><a href="#">Loja</a></li>
          <li><a href="#">Opções de Pagamento</a></li>
        </ul>
      </div>
    </div>
  </footer>
  <!-- End Footer -->
    </body>
    </html>
