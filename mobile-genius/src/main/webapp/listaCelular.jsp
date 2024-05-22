<!DOCTYPE html>
    <html lang="pt-BR">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <title>Celulares</title>
        <%@ page contentType="text/html; charset=UTF-8" %>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="style/listaCelular.css">
        <link rel="stylesheet" href="style/styles.css">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

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

   <c:if test="${sessionScope.LoggedUser != null}">
       <span class="logged-user-links">${sessionScope.loggedUser}</span>
       <a href="/logout" class="logged-user-links">Logout</a>
       <a href="/cadastroCelular.jsp" class="logged-user-links">Cadastrar celular</a>
       <a href="/find-all-user" class="logged-user-links" >Lista de usuários</a>
   </c:if>

       <div class="modal-content">
           <h3>LISTA DE CELULARES CADASTRADOS</h3>

           <table>
                           <tr>
                               <th>ID</th>
                               <th>Marca</th>
                               <th>Modelo</th>
                               <th>Preco</th>
                               <th>Quantidade</th>
                               <th>Descrição</th>
                               <th>Imagem</th>

                               <c:if test="${sessionScope.LoggedUser != null}">
                                   <th>Ações</th>
                               </c:if>

                           </tr>

                           <c:forEach var="celular" items="${celulares}">
                               <tr>
                                   <td>${celular.id}</td>
                                   <td>${celular.marca}</td>
                                   <td>${celular.modelo}</td>
                                   <td>${celular.preco}</td>
                                   <td>${celular.quantidade}</td>
                                   <td>${celular.descricao}</td>
                                   <td><img src="${celular.image}" alt="Imagem do celular" width="100"></td>

                                   <td>

                                       <c:if test="${sessionScope.LoggedUser != null}">
                                           <c:if test="${sessionScope.Type}">
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
                                                   <input type="hidden" name="image" value="${celular.image}">
                                                   <button type="submit">Update</button>
                                               </form>
                                           </c:if>
                                       </c:if>


                                   </td>
                               </tr>
                           </c:forEach>
                       </table>

       </div>




 <!-- Footer -->
   <footer class="footer">
     <div class="container">
       <p>&copy; 2024 Mobile Genius.</p>
     </div>
   </footer>
   <!-- End Footer -->
    </body>
    </html>
