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
                <th>Senha</th>
                <th>Type</th>
                <c:if test="${sessionScope.LoggedUser != null}">
                    <th>Ações</th>
                </c:if>
            </tr>

            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.type}</td>

                    <td>
                        <c:if test="${sessionScope.LoggedUser != null}">
                            <c:if test="${sessionScope.Type}">
                                <form action="/delete-user" method="post">
                                    <input type="hidden" id="id" name="id" value="${user.id}">
                                    <button type="submit">Deletar</button>
                                </form>
                                <span> | </span>
                                <form action="/cadastrarUser.jsp" method="post">
                                    <input type="hidden" name="id" value="${user.id}">
                                    <input type="hidden" name="username" value="${user.username}">
                                    <input type="hidden" name="password" value="${user.password}">
                                    <input type="hidden" name="type" value="${user.type}">

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
</body>
</html>
