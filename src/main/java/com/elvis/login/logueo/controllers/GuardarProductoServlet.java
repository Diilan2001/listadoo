package com.elvis.login.logueo.controllers;

import com.elvis.login.logueo.models.Categoria;
import com.elvis.login.logueo.models.Producto;
import com.elvis.login.logueo.repositorio.ProductoRepositoryJdbcImplement;
import com.elvis.login.logueo.repositorio.Repositorys;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/guardar-producto")
public class GuardarProductoServlet extends HttpServlet {

    private Repositorys<Producto> productoRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        // Obtener la conexión desde el contexto de la aplicación
        Connection conn = (Connection) getServletContext().getAttribute("conn");
        productoRepository = new ProductoRepositoryJdbcImplement(conn);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        double precio = Double.parseDouble(req.getParameter("precio"));
        int idCategoria = Integer.parseInt(req.getParameter("categoria"));

        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCategoria);

        Producto nuevoProducto = new Producto(null, nombre, categoria, descripcion, precio);

        try {
            productoRepository.guardar(nuevoProducto);
            resp.sendRedirect(req.getContextPath() + "/listado-productos");
        } catch (SQLException e) {
            throw new ServletException("Error al guardar el producto", e);
        }
    }
}
