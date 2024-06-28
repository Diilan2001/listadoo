<%@ page import="javax.swing.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.elvis.login.logueo.models.Producto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%
    Optional<String> username = (Optional<String>) request.getAttribute("username");
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de productos</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .navy-button {
            background-color: #001f3f;
            color: white;
            border-color: #001f3f;
        }

        .navy-button:hover {
            background-color: #001934;
            border-color: #001934;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h1>Listado de productos para comprar</h1>

    <% if (username != null && username.isPresent()) { %>
    <a href="<%= request.getContextPath() %>/formulario" class="btn btn-success mb-3">Crear Nuevo Producto</a>
    <% } %>

    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>ID Producto</th>
            <th>Nombre</th>
            <th>Categoría</th>
            <th>Descripción</th>
            <% if (username != null && username.isPresent()) { %>
            <th>Precio</th>
            <th>Acciones</th>
            <% } %>
        </tr>
        </thead>
        <tbody>
        <% if (productos != null && !productos.isEmpty()) { %>
        <% for (Producto p : productos) { %>
        <tr>
            <td><%= p.getIdProducto() %></td>
            <td><%= p.getNombre() %></td>
            <td><%= p.getCategoria().getNombre() %></td>
            <td><%= p.getDescripcion() %></td>
            <% if (username != null && username.isPresent()) { %>
            <td><%= p.getPrecio() %></td>
            <td>
                <a class="btn navy-button" href="<%= request.getContextPath() %>/agregar-carro?id=<%= p.getIdProducto() %>">ADD TO CART</a>
                <a class="btn navy-button" href="<%= request.getContextPath() %>/editar-producto?id=<%= p.getIdProducto() %>">EDIT</a>
                <a class="btn navy-button" href="<%= request.getContextPath() %>/eliminar-carro?id=<%= p.getIdProducto() %>">DELETE</a>
            </td>
            <% } %>
        </tr>
        <% } %>
        <% } else { %>
        <tr>
            <td colspan="<%= username != null && username.isPresent() ? 6 : 4 %>" class="text-center">No hay productos disponibles</td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>