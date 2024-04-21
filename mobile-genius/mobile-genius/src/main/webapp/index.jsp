<html>
<body>
<h2>Cadastro celular</h2>

<form action="/create-celular" method="post">

    <label>Celular</label>

    <!-- param.name esta refereciando no dashboard o name -->
    <input type="text" name="marca" id="marca" value="${param.name}">
    <input type="hidden" name="id" id="id" value="${param.id}">

    <button type="submit">Register</button>

</form>
</body>
</html>
