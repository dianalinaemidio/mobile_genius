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
  <link rel="stylesheet" href="style/cadastroCelular.css" />
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
    </header>
  <!-- End Header -->


    <form action="/create-celular" method="post" enctype="multipart/form-data">
        <div class="container-form">
            <h2>Cadastro de Celular</h2>
            <div class="form-group">
                <label for="marca">Marca</label>
                <input type="text" id="marca" name="marca" value="${param.marca}" required>
            </div>

            <div class="form-group">
                <label for="modelo">Modelo</label>
                <input type="text" id="modelo" name="modelo" value="${param.modelo}" required>
            </div>

            <div class="form-group">
                <label for="preco">Preço</label>
                <input type="text" id="preco" name="preco" value="${param.preco}" required>
            </div>

            <div class="form-group">
                <label for="quantidade">Quantidade</label>
                <input type="text" id="quantidade" name="quantidade" value="${param.quantidade}" required>
            </div>

            <div class="form-group">
                <label for="descricao">Descrição</label>
                <input type="text" id="descricao" name="descricao" value="${param.descricao}" required>
            </div>

            <div class="form-group">
                <label for="image">Imagem</label>
                <input type="file" id="image" name="image" value="${param.image}" required>
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
      <footer class="footer">
        <div class="container">
          <p>&copy; 2024 Mobile Genius. Todos os direitos reservados.</p>
        </div>
      </footer>
      <!-- End Footer -->
</body>
</html>
