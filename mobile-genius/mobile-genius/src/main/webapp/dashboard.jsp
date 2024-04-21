<!DOCTYPE html>
<html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <meta charset="UTF-8">
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
                        <td>${celular.getId()}</td>
                        <td>${celular.getMarca()}</td>
                        <td>
                            <form action="/delete-celular" method="post">
                                <input type="hidden" id="id" name="id" value="${celular.id}">
                                <button type="submit">Deletar</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
