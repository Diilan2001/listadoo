<%--
  Created by IntelliJ IDEA.
  User: ESTUDIANTE
  Date: 21/6/2024
  Time: 8:00
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.elvis.login.logueo.models.*" %>

<%
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categoria");
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
    Producto producto = (Producto) request.getAttribute("producto");
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Producto</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Crear Nuevo Producto</h1>

    <% if (errores != null && !errores.isEmpty()) { %>
    <div class="alert alert-danger">
        <ul>
            <% for (Map.Entry<String, String> error : errores.entrySet()) { %>
            <li><%= error.getValue() %></li>
            <% } %>
        </ul>
    </div>
    <% } %>

    <form action="<%= request.getContextPath() %>/formulario" method="post">
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" class="form-control" value="<%= producto != null ? producto.getNombre() : "" %>" required>
        </div>

        <div class="form-group">
            <label for="categoria">Categoría:</label>
            <select id="categoria" name="categoria" class="form-control" required>
                <option value="">Selecciona una categoría</option>
                <% for (Categoria c : categorias) { %>
                <option value="<%= c.getIdCategoria() %>" <%= (producto != null && producto.getCategoria() != null && producto.getCategoria().getIdCategoria() == c.getIdCategoria()) ? "selected" : "" %>><%= c.getNombre() %></option>
                <% } %>
            </select>
        </div>

        <div class="form-group">
            <label for="descripcion">Descripción:</label>
            <textarea id="descripcion" name="descripcion" class="form-control" rows="5" required><%= producto != null ? producto.getDescripcion() : "" %></textarea>
        </div>

        <div class="form-group">
            <label for="precio">Precio:</label>
            <input type="number" id="precio" name="precio" class="form-control" min="0" step="0.01" value="<%= producto != null ? producto.getPrecio() : "" %>" required>
        </div>

        <button type="submit" class="btn btn-primary">Crear Producto</button>
        <a href="<%= request.getContextPath() %>/index.html" class="btn btn-secondary ml-2">Volver</a>
    </form>
</div>

<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>