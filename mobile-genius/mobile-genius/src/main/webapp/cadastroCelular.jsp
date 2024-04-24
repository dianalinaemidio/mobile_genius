<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mobile Genius</title>
    <link rel="stylesheet" href="./style/cadastroCelular.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <header>
        <div class="container">
            <nav>
                <div class="logo">
                    <img src="./img/logo.png" alt="Mobile Genius">
                </div>
                <div class="menu">
                    <ul>
                        <li><a href="#">Apple</a></li>
                        <li><a href="#">Samsung</a></li>
                        <li><a href="#">Motorola</a></li>
                        <li><a href="#">Xiaomi</a></li>
                        <li><a href="#">Asus</a></li>
                    </ul>
                </div>
                <div class="icones">
                    <a href="#"><i class="fa-solid fa-user"></i></a>
                    <a href="#"></a><i class="fa-solid fa-cart-shopping"></i></a>
                </div>
            </nav>
        </div>
    </header>

    <section class="banner">
        <div class="container">
            <div class="banner-content"></div>
        </div>
    </section>
    

    <form action="/create-celular" method="post">
        <div class="container-form">
            <h2>Cadastro de Celular</h2>
            <form>
              <div class="form-group">
                <label for="marca">Marca</label>
                <input type="text" id="marca" name="marca">
              </div>
              <div class="form-group">
                <label for="modelo">Modelo</label>
                <input type="text" id="modelo" name="modelo">
              </div>
              <div class="form-group">
                <label for="preco">Preço</label>
                <input type="text" id="preco" name="preco">
              </div>
              <div class="form-group">
                <label for="descricao">Descrição</label>
                <textarea id="descricao" name="descricao"></textarea>
              </div>
              <div class="buttons">
                <button type="submit">Confirmar</button>
                  <a href="listaCelular.jsp" class="btn">Detalhes</a>
              </div>
            </form>
          </div>
        </form>

    <footer>
        <div class="container">
            <div class="footer-logo">
                <img src="img/logo.png" alt="Mobile Genius">
            </div>
            <div class="footer-links">
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Loja</a></li>
                    <li><a href="#">Opções de Pagamentos</a></li>
                </ul>
            </div>
        </div>
    </footer>
</body>
</html>