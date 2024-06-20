<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.elvis.login.logueo.models.*" %>
<%Carro carro = (Carro) session.getAttribute("carro");%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carro de compras</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <style>

    </style>
</head>
<body>
<div class="container">
    <h1 class="mt-5">Carro de compras</h1>
    <% if (carro == null || carro.getItems().isEmpty()) { %>
    <p>Lo sentimos, no hay productos en el carro de compras.</p>
    <% } else { %>
    <table class="table mt-4">
        <thead class="thead-dark">
        <tr>
            <th>ID PRODUCTO</th>
            <th>NOMBRE</th>
            <th>PRECIO</th>
            <th>CANTIDAD</th>
            <th>SUBTOTAL</th>
        </tr>
        </thead>
        <tbody>
        <% for (ItemCarro item : carro.getItems()) { %>
        <tr>
            <td><%= item.getProducto().getIdProducto() %></td>
            <td><%= item.getProducto().getNombre() %></td>
            <td>$<%= item.getProducto().getPrecio() %></td>
            <td><%= item.getCantidad() %></td>
            <td>$<%= item.getImporte() %></td>
        </tr>
        <% } %>
        <tr>
            <td colspan="4" class="text-right"><strong>Total:</strong></td>
            <td><strong>$<%= carro.getTotal() %></strong></td>
        </tr>
        </tbody>
    </table>
    <% } %>
    <p><a href="<%= request.getContextPath() %>/productos" class="btn btn-primary">Seguir comprando</a></p>
    <p><a href="<%= request.getContextPath() %>/index.html" class="btn btn-secondary">Volver</a></p>
</div>

</body>
</html>