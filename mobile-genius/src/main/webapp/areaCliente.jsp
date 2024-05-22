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
  <link rel="stylesheet" href="style/areaCliente.css" />
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
            <a href="/index" class="scroll-link">Mobile Genius</a>
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

  <!-- Cliente Info Section -->
  <section class="cliente-info">
    <div class="container">
      <div class="info">

        <h3>Informações do Cliente</h3>

        <p>Nome de Usuário: ${user.username}</p>
        <p>Nome: ${user.nome}</p>
        <p>Sobrenome: ${user.sobrenome}</p>
        <p>CPF: ${user.cpf}</p>
        <p>Data de Nascimento: ${dataNascimentoFormatada}</p>
        <p>Endereço: ${user.endereco}</p>
        <p>E-mail: ${user.email}</p>
        <p>Telefone: ${user.numeroCelular}</p>
        <p>Password: ${user.password}</p>

        <!-- Ações -->
        <c:if test="${sessionScope.LoggedUser != null}">
          <c:if test="${sessionScope.admin}">
            <form action="/cadastrarUser.jsp" method="post">
              <input type="hidden" name="id" value="${user.id}">
              <input type="hidden" name="username" value="${user.username}">
              <input type="hidden" name="nome" value="${user.nome}">
              <input type="hidden" name="sobrenome" value="${user.sobrenome}">
              <input type="hidden" name="cpf" value="${user.cpf}">
              <input type="hidden" name="datanascimento" value="${dataNascimento}">
              <input type="hidden" name="endereco" value="${user.endereco}">
              <input type="hidden" name="email" value="${user.email}">
              <input type="hidden" name="numerocelular" value="${user.numeroCelular}">
              <input type="hidden" name="senha" value="${user.password}">
              <input type="hidden" name="admin" value="${user.admin}">
              <input type="hidden" name="loggedUser" value="${user.loggedUser}">
              <button type="submit" class="button excluir-btn">Editar</button>
            </form>

            <form action="/delete-user" method="post">
              <input type="hidden" name="id" value="${user.id}">
              <input type="hidden" name="cliente" value="true">
              <button type="submit" class="button excluir-btn">Deletar</button>
            </form>
          </c:if>
        </c:if>
      </div>
    </div>
  </section>

  <!-- Footer -->
  <footer class="footer">
    <div class="container">
      <p>&copy; 2024 Mobile Genius.</p>
    </div>
  </footer>
  <!-- End Footer -->
</body>

</html>
