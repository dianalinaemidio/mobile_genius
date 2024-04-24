<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mobile Genius</title>
    <link rel="stylesheet" href="css/cadastroCelular.css">
</head>
<body>
    <header>
        <div class="container">
            <nav>
                <div class="logo">
                    <img src="img/logo.png" alt="Mobile Genius">
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
                    <a href="#"><img src="img/user.png" alt="user"></a>
                    <a href="#"><img src="img/carrinho.png" alt="carrinho"></a>
                </div>
            </nav>
        </div>
    </header>

    <section class="banner">
        <div class="container">
            <div class="banner-content">
                <img src="img/logo.png" alt="Mobile Genius">
                <a href="#" class="home-link">Home</a>
            </div>
        </div>
    </section>
    

    <form action="/create-celular" method="post">
        <div class="container-form">
            <h2>Detalhes do Celular</h2>
            <form>
              <div class="form-group">
                <label for="marca">Marca</label>
                <input type="text" id="marca" name="marca" required value="${param.id}">
              </div>
              <div class="form-group">
                <label for="modelo">Modelo</label>
                <input type="text" id="modelo" name="modelo" required value="${param.id}">
              </div>
              <div class="form-group">
                <label for="preco">Preço</label>
                <input type="text" id="preco" name="preco" required value="${param.id}">
              </div>
              <div class="form-group">
                <label for="descricao">Descrição</label>
                <textarea id="descricao" name="descricao" required value="${param.id}"></textarea>
              </div>
              <button type="submit">Confirmar</button>
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
