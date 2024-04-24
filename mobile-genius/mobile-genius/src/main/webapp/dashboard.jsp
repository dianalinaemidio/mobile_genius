<!DOCTYPE html>
<html lang="pt-BR">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <%@ page contentType="text/html; charset=UTF-8" %>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Dashboard</title>
    </head>
    <body>
        <div>
            <h1>Cadastrando o Celular</h1>

            <table>
                <tr>
                    <th>ID</th>
                    <th>Marca</th>
                    <th>Actions</th>
                </tr>

                <c:forEach var="celular" items="${celulares}">
                    <tr>
                        <td>${celular.id}</td>
                        <td>${celular.marca}</td>
                        <td>
                            <form action="/delete-celular" method="post">
                                <input type="hidden" id="id" name="id" value="${celular.id}">
                                <button type="submit">Deletar</button>

                                <span> | </span>
                                    <a href="index.jsp?id=${celular.id}&name=${celular.marca}">Update</a>

                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
