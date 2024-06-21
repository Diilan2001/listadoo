
<%@ page import="javax.swing.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.elvis.login.logueo.models.Producto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<% Optional<String> username=(Optional)request.getAttribute("username"); %>
<% List<Producto> productos = (List<Producto>) request.getAttribute("productos"); %>

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



    <% if (username != null && !username.isEmpty()) { %>
    <a href="<%=request.getContextPath()%>/formulario">CREAR NUEVO PRODUCTO</a>
    <% } %>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>ID PRODUCTO</th>
            <th>Nombre</th>
            <th>Categoria</th>
            <th>Descripción</th>

            <% if (username != null && !username.isEmpty()) { %>
            <th>valor</th>
            <th>agregar</th>
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
            <%-- Display these columns conditionally if user is logged in --%>
            <% if (username != null && !username.isEmpty()) { %>
            <td><%= p.getPrecio() %></td>
            <td><a class="btn btn-primary" href="<%= request.getContextPath() %>/agregar-carro?id=<%= p.getIdProducto() %>">Añadir al carro</a>
                <a class="btn btn-primary" href="<%= request.getContextPath() %>/agregar-carro?id=<%= p.getIdProducto() %>">Eliminar</a></td>

            <% } %>
        </tr>
        <% } %>
        <% } else { %>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
