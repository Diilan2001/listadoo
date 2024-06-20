
<%@ page import="javax.swing.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.elvis.login.logueo.models.Producto" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de productos</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Listado de productos para comprar</h1>
    <%-- Optional username display --%>
    <% String username = (String) request.getAttribute("username"); %>
    <% if (username != null && !username.isEmpty()) { %>
    <div class='alert alert-primary' role='alert'> HOLA <%= username %> ¡Bienvenido!</div>
    <% } %>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>ID PRODUCTO</th>
            <th>nombre</th>
            <th>categoria</th>
            <th>descripción</th>

            <% if (username != null && !username.isEmpty()) { %>
            <th>valor</th>
            <th>agregar</th>
            <% } %>
        </tr>
        </thead>
        <tbody>
        <% List<Producto> productos = (List<Producto>) request.getAttribute("productos"); %>
        <% if (productos != null && !productos.isEmpty()) { %>
        <% for (Producto p : productos) { %>
        <tr>
            <td><%= p.getIdProducto() %></td>
            <td><%= p.getNombre() %></td>
            <td><%= p.getCategoria() %></td>
            <td><%= p.getDescripcion() %></td>
            <%-- Display these columns conditionally if user is logged in --%>
            <% if (username != null && !username.isEmpty()) { %>
            <td><%= p.getPrecio() %></td>
            <td><a class="btn btn-primary" href="<%= request.getContextPath() %>/agregar-carro?id=<%= p.getIdProducto() %>">Añadir al carro</a></td>
            <% } %>
        </tr>
        <% } %>
        <% } else { %>
        <tr>
            <td colspan="6">No hay productos disponibles.</td> <%-- Colspan debe coincidir con el número de columnas en tu tabla --%>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
