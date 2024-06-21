package com.elvis.login.logueo.controllers;

import com.elvis.login.logueo.models.Producto;
import com.elvis.login.logueo.services.LoginService;
import com.elvis.login.logueo.services.LoginServiceImplement;
import com.elvis.login.logueo.services.ProductoService;
import com.elvis.login.logueo.services.ProductoServiceJdbcImplement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productoServlet", "/Producto"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");

        ProductoService service = new ProductoServiceJdbcImplement(conn);
        List<Producto> productos = service.listar();
        LoginService auth = new LoginServiceImplement();
        Optional<String> usernameOptional = auth.getUserName(req);

        req.setAttribute("productos", productos);
        req.setAttribute("username", usernameOptional);

        //aqui es donde reenviamos la info al jsp
        getServletContext().getRequestDispatcher("/listadoProductos.jsp").forward(req, resp);
    }
}
