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
                        <a href="#" class="icon__item" id="cart-btn">
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
<<<<<<< HEAD
                <th>Nome</th>
                <th>Sobrenome</th>
                <th>CPF</th>
                <th>Data de Nascimento</th>
                <th>Endereço</th>
                <th>Email</th>
                <th>Número Celular</th>
                <th>Senha</th>
                <th>Admin</th>
                <th>Logged User</th>
=======
                <th>Senha</th>
                <th>Type</th>
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a
                <c:if test="${sessionScope.LoggedUser != null}">
                    <th>Ações</th>
                </c:if>
            </tr>

            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
<<<<<<< HEAD
                    <td>${user.nome}</td>
                    <td>${user.sobrenome}</td>
                    <td>${user.cpf}</td>
                    <td>${user.dataNascimento}</td>
                    <td>${user.endereco}</td>
                    <td>${user.email}</td>
                    <td>${user.numeroCelular}</td>
                    <td>${user.password}</td>
                    <td>${user.admin}</td>
                    <td>${user.loggedUser}</td>

                    <td>
                        <c:if test="${sessionScope.LoggedUser != null}">
                            <c:if test="${sessionScope.admin}">
=======
                    <td>${user.password}</td>
                    <td>${user.type}</td>

                    <td>
                        <c:if test="${sessionScope.LoggedUser != null}">
                            <c:if test="${sessionScope.Type}">
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a
                                <form action="/delete-user" method="post">
                                    <input type="hidden" id="id" name="id" value="${user.id}">
                                    <button type="submit">Deletar</button>
                                </form>
                                <span> | </span>
                                <form action="/cadastrarUser.jsp" method="post">
                                    <input type="hidden" name="id" value="${user.id}">
                                    <input type="hidden" name="username" value="${user.username}">
<<<<<<< HEAD
                                    <input type="hidden" name="nome" value="${user.nome}">
                                    <input type="hidden" name="sobrenome" value="${user.sobrenome}">
                                    <input type="hidden" name="cpf" value="${user.cpf}">
                                    <input type="hidden" name="datanascimento" value="${user.dataNascimento}">
                                    <input type="hidden" name="endereco" value="${user.endereco}">
                                    <input type="hidden" name="email" value="${user.email}">
                                    <input type="hidden" name="numerocelular" value="${user.numeroCelular}">
                                    <input type="hidden" name="password" value="${user.password}">
                                    <input type="hidden" name="admin" value="${user.admin}">
                                    <input type="hidden" name="loggedUser" value="${user.loggedUser}">

                                    <button type="submit">Atualizar</button>
=======
                                    <input type="hidden" name="password" value="${user.password}">
                                    <input type="hidden" name="type" value="${user.type}">

                                    <button type="submit">Update</button>
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a
                                </form>
                            </c:if>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>

<<<<<<< HEAD

    </div>

    <!-- Footer -->
    <footer id="footer" class="section footer">
        <div class="container">
            <div class="footer__top">
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="#">Loja</a></li>
                    <li><a href="login.jsp">Login</a></li>
                </ul>
            </div>
        </div>
    </footer>
    <!-- End Footer -->
=======
    </div>

  <!-- Footer -->
      <footer class="footer">
        <div class="container">
          <p>&copy; 2024 Mobile Genius.</p>
        </div>
      </footer>
  <!-- End Footer -->
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a
</body>
</html>
