package com.elvis.login.logueo.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editar-producto")
public class EditarProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idProducto = Integer.parseInt(req.getParameter("id"));
        // Lógica para obtener y mostrar los detalles del producto a editar
        // ...

        req.getRequestDispatcher("/editar-producto.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idProducto = Integer.parseInt(req.getParameter("id"));
        // Lógica para actualizar el producto
        // ...

        resp.sendRedirect(req.getContextPath() + "/listado-productos");
    }
}
