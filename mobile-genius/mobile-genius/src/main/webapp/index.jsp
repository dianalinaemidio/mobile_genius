<html>
<body>
<h2>Cadastro celular</h2>

<form action="/create-celular" method="post">

    <label>Celular</label>
    <input type="text" name="marca" id="marca" value="${param.marca}">
    <input type="hidden" id="id" name="id" value="${param.id}">

    <button type="submit">Register</button>

</form>
</body>
</html>
