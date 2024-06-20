<%--
  Created by IntelliJ IDEA.
  User: ADMIN-ITQ
  Date: 30/5/2024
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ingresando al Sistema</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>

    </style>
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Iniciar sesión</h1>
    <form action="/logueo_war_exploded/Login" method="post">
        <div class="form-group">
            <label for="username">Nombre de Usuario</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Ingrese su nombre de usuario">
        </div>
        <div class="form-group">
            <label for="password">Contraseña</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Ingrese su contraseña">
        </div>
        <button type="submit" class="btn btn-primary">Iniciar sesión</button>
    </form>
</div>


</body>
</html>
