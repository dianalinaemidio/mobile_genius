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

  <!-- Custom StyleSheet -->
  <link rel="stylesheet" href="style/cart.css" />

  <title>Carrinho de Compras</title>
</head>

<body>
  <header>
    <span>Carrinho de compras <b>MobileGenius</b></span>
  </header>
  <main>
    <div class="page-title">Seu Carrinho</div>
    <div class="content">
      <section>
        <table>
          <thead>
            <tr>
              <th>Produto</th>
              <th>Preço</th>
              <th>Quantidade</th>
              <th>Total</th>
              <th>-</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <div class="product">
                  <img src="https://picsum.photos/100/120" alt="" />
                  <div class="info">
                    <div class="name">Nome do produto</div>
                    <div class="category">Categoria</div>
                  </div>
                </div>
              </td>
              <td>R$ 120</td>
              <td>
                <div class="qty">
                  <button><i class="bx bx-minus"></i></button>
                  <span>2</span>
                  <button><i class="bx bx-plus"></i></button>
                </div>
              </td>
              <td>R$ 240</td>
              <td>
                <button class="remove"><i class="bx bx-x"></i></button>
              </td>
            </tr>
            <tr>
              <td>
                <div class="product">
                  <img src="https://picsum.photos/100/120" alt="" />
                  <div class="info">
                    <div class="name">Nome do produto</div>
                    <div class="category">Categoria</div>
                  </div>
                </div>
              </td>
              <td>R$ 120</td>
              <td>
                <div class="qty">
                  <button><i class="bx bx-minus"></i></button>
                  <span>2</span>
                  <button><i class="bx bx-plus"></i></button>
                </div>
              </td>
              <td>R$ 240</td>
              <td>
                <button class="remove"><i class="bx bx-x"></i></button>
              </td>
            </tr>
            <tr>
              <td>
                <div class="product">
                  <img src="https://picsum.photos/100/120" alt="" />
                  <div class="info">
                    <div class="name">Nome do produto</div>
                    <div class="category">Categoria</div>
                  </div>
                </div>
              </td>
              <td>R$ 120</td>
              <td>
                <div class="qty">
                  <button><i class="bx bx-minus"></i></button>
                  <span>2</span>
                  <button><i class="bx bx-plus"></i></button>
                </div>
              </td>
              <td>R$ 240</td>
              <td>
                <button class="remove"><i class="bx bx-x"></i></button>
              </td>
            </tr>
          </tbody>
        </table>
      </section>
      <aside>
        <div class="box">
          <header>Resumo da compra</header>
          <div class="info">
            <div><span>Sub-total</span><span>R$ 418</span></div>
            <div><span>Frete</span><span>Gratuito</span></div>
            <div>
              <button>
                Adicionar cupom de desconto
                <i class="bx bx-right-arrow-alt"></i>
              </button>
            </div>
          </div>
          <footer>
            <span>Total</span>
            <span>R$ 418</span>
          </footer>
        </div>
        <button id="finalizar-compra-btn">Finalizar Compra</button>
      </aside>
    </div>
  </main>

    <!-- Modal -->
    <div id="myModal" class="modal">
      <div class="modal-content">
        <span class="close">&times;</span>
        <div class="redirect-message">Parabéns pela sua compra!</div>
        <div class="redirect-message">Estamos te redirecionando para a página principal...</div>
      </div>
    </div>

  <footer class="footer">
    <div class="container">
      <p>&copy; 2024 Mobile Genius. Todos os direitos reservados.</p>
    </div>
  </footer>
    <script>
        var modal = document.getElementById("myModal");

        var finalizarCompraBtn = document.getElementById("finalizar-compra-btn");

        var span = document.querySelector(".close");

        finalizarCompraBtn.onclick = function() {
          modal.style.display = "block";
          setTimeout(redirectToIndex, 3000); // Redireciona para página Index em 3s
        }

        span.onclick = function() {
          modal.style.display = "none";
        }

        window.onclick = function(event) {
          if (event.target == modal) {
            modal.style.display = "none";
          }
        }

        function redirectToIndex() {
          window.location.href = "/index.jsp";
        }
   </script>

</body>

</html>
