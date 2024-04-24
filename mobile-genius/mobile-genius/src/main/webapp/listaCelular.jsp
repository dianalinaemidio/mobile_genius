    <html lang="pt-BR">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <title>Celulares</title>
        <%@ page contentType="text/html; charset=UTF-8" %>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="./style/listaCelular.css">
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

                </div>
                <div class="icones">
                    <a href="#"><i class="fa-solid fa-user"></i></a>
                    <a href="#"></a><i class="fa-solid fa-cart-shopping"></i></a>
                </div>
            </nav>
        </div>
    </header>
    <div class="modal-content">
        <h3>LISTA DE CELULARES CADASTRADOS</h3>

        <table>
                        <tr>
                            <th>ID</th>
                            <th>Marca</th>
                            <th>Modelo</th>
                            <th>Preco</th>
                            <th>Quantidade</th>
                            <th>Descricao</th>
                            <th>Ações</th>
                        </tr>

                        <c:forEach var="celular" items="${celulares}">
                            <tr>
                                <td>${celular.id}</td>
                                <td>${celular.marca}</td>
                                <td>${celular.modelo}</td>
                                <td>${celular.preco}</td>
                                <td>${celular.quantidade}</td>
                                <td>${celular.descricao}</td>
                                <td>
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
                                            <button type="submit">Update</button>
                                        </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

    </div>
    <footer>
        <div class="container">
            <div class="footer-logo">
                <img src="img/logo.png" alt="Mobile Genius">
            </div>
            <div class="footer-links">
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="#">Loja</a></li>
                    <li><a href="#">Opções de Pagamentos</a></li>
                </ul>
            </div>
        </div>
    </footer>
    </body>
    </html>
