s<!DOCTYPE html>
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
  <link rel="stylesheet" href="style/login.css" />
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

            <a href="/cart.jsp" class="icon__item" id="cart-btn" class="a-btn">
              <img src="/img/cart-icon.png" alt="Cart">
            </a>
          </div>
        </nav>
      </div>
    </div>
    </header>
  <!-- End Header -->

<<<<<<< HEAD
    <section class="form">
            <div class="container-form">

                <div class="form-container">

                <form action="/login" method="post">
                    <span>${requestScope.message}</span>
                    <div class="form-container">
                        <h2>LOGIN</h2>
                        <input type="text" name="username" placeholder="Usuário" required>
                        <input type="password" name="password" placeholder="Senha" required>
                        <button type="submit">Entrar</button>
                    </div>
                </form>
                <div class="buttons">
                    <a href="cadastrarUser.jsp" class="btn">Cadastrar-se</a>
                </div>

                    </form>
                </div>
            </div>
        </section>
    <!-- Footer -->
=======
   <section class="form">
       <div class="container-form">
           <div class="form-container">
               <form action="/login" method="post">
                   <span>${requestScope.message}</span>
                   <h2>LOGIN</h2>
                   <input type="text" name="nome" placeholder="Usuário" required>
                   <input type="password" name="senha" placeholder="Senha" required>
                   <button type="submit">Entrar</button>
               </form>
               <div class="buttons">
                   <a href="cadastrarUser.jsp" class="btn">Cadastrar-se</a>
               </div>
           </div>
       </div>
   </section>

  <!-- Footer -->
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a
      <footer class="footer">
        <div class="container">
          <p>&copy; 2024 Mobile Genius.</p>
        </div>
      </footer>
<<<<<<< HEAD
      <!-- End Footer -->
=======
  <!-- End Footer -->
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a
</html>
