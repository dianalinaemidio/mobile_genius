<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <%@ page contentType="text/html; charset=UTF-8" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <header class="header">
    <span class="scroll-link">
        <a href="/index"> Mobile Genius </a>
    </span>
  </header>
 <main>
     <div class="page-title">Seu Carrinho</div>


     <% String error = request.getParameter("error"); %>
     <% String produto = request.getParameter("produto"); %>
     <% if (error != null && !error.isEmpty()) { %>
         <div class="error-message">
             <% if (error.equals("ProdutoEsgotado")) { %>
                  <p>Celular <%= produto %> esgotado.</p>
             <% } %>
         </div>
     <% } %>

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
                     <%-- Loop sobre os celulares no carrinho --%>
                     <c:forEach var="celular" items="${celulares}">
                         <tr>
                             <td>
                                 <div class="product">
                                     <img src="${celular.image}" alt="" />
                                     <div class="info">
                                         <div class="name">${celular.modelo}</div>
                                         <div class="category">${celular.marca}</div>
                                     </div>
                                 </div>
                             </td>
                             <td>R$ ${celular.preco}</td> <%-- Exibe o preço do celular --%>
                             <td>1</td>
                             <td>R$ ${celular.preco}</td> <%-- Exibe o total para este celular --%>
                             <td>
                                 <form action="${pageContext.request.contextPath}/carrinho" method="post">
                                   <input type="hidden" name="carrinhoId" value="${carrinhoId}" />
                                   <input type="hidden" name="celularId" value="${celular.id}" />
                                   <button type="submit" class="remove" onclick="return confirm('Tem certeza que deseja remover este item do carrinho?');">
                                      <i class="bx bx-x">Deletar</i>
                                   </button>
                                 </form>
                             </td>
                         </tr>
                     </c:forEach>
                 </tbody>
             </table>
         </section>
         <aside>
             <div class="box">
                 <header>Resumo da compra</header>
                 <div class="info">
                     <div><span>Sub-total</span><span>R$ ${totalCarrinho}</span></div> <%-- Exibe o sub-total do carrinho --%>
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
                     <span>R$ ${totalCarrinho}</span>
                 </footer>
             </div>
             <form action="${pageContext.request.contextPath}/finalizar-compra" method="post">
                 <input type="hidden" name="carrinhoId" value="${carrinhoId}" />
                 <button type="submit" id="finalizar-compra-btn">Finalizar Compra</button>
             </form>

         </aside>
     </div>
 </main>
 </main>


  <footer class="footer">
    <div class="container">
      <p>&copy; 2024 Mobile Genius.</p>
    </div>
  </footer>

    <script>
        var modal = document.getElementById("myModal");

        var finalizarCompraBtn = document.getElementById("finalizar-compra-btn");

        var span = document.querySelector(".close");

        finalizarCompraBtn.onclick = function() {
          modal.style.display = "block";
          setTimeout(redirectToCongratulations, 3000); // Redireciona para página de agradecimento em 3s
        }

        span.onclick = function() {
          modal.style.display = "none";
        }

        window.onclick = function(event) {
          if (event.target == modal) {
            modal.style.display = "none";
          }
        }

        function redirectToCongratulations() {
          window.location.href = "/agradecimento.jsp";
        }
   </script>



</body>

</html>
