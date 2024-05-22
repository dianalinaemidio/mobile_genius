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
        <a href="listaUser.jsp" class="logged-user-links">Lista de usuários</a>
    </c:if>

    <div class="modal-content">
        <h3>LISTA DE USUÁRIOS CADASTRADOS</h3>

       <table>
           <tr>
               <th>ID</th>
               <th>Username</th>
               <th>Nome</th>
               <th>Sobrenome</th>
               <th>CPF</th>
               <th>Data de Nascimento</th>
               <th>Endereço</th>
               <th>Email</th>
               <th>Número de Celular</th>
               <c:if test="${sessionScope.LoggedUser != null}">
                   <th>Ações</th>
               </c:if>
           </tr>

           <c:forEach var="user" items="${users}">
               <tr>
                   <td>${user.id}</td>
                   <td>${user.username}</td>
                   <td>${user.nome}</td>
                   <td>${user.sobrenome}</td>
                   <td>${user.cpf}</td>
                   <td>${user.dataNascimento}</td>
                   <td>${user.endereco}</td>
                   <td>${user.email}</td>
                   <td>${user.numeroCelular}</td>

                   <c:if test="${sessionScope.LoggedUser != null}">
                       <td>
                           <form action="/delete-user" method="post">
                               <input type="hidden" name="id" value="${user.id}">
                               <button type="submit">Deletar</button>
                           </form>
                           <form action="cadastrarUser.jsp" method="post">
                               <input type="hidden" name="id" value="${user.id}">
                               <input type="hidden" name="username" value="${user.username}">
                               <input type="hidden" name="nome" value="${user.nome}">
                               <input type="hidden" name="sobrenome" value="${user.sobrenome}">
                               <input type="hidden" name="cpf" value="${user.cpf}">
                               <input type="hidden" name="datanascimento" value="${user.dataNascimento}">
                               <input type="hidden" name="endereco" value="${user.endereco}">
                               <input type="hidden" name="email" value="${user.email}">
                               <input type="hidden" name="numerocelular" value="${user.numeroCelular}">
                               <input type="hidden" name="senha" value="${user.password}">
                               <button type="submit" name="action" value="update">Update</button>
                           </form>
                       </td>
                   </c:if>
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
