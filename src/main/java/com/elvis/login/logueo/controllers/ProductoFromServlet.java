package com.elvis.login.logueo.controllers;

import com.elvis.login.logueo.models.Categoria;
import com.elvis.login.logueo.models.Producto;
import com.elvis.login.logueo.services.ProductoService;
import com.elvis.login.logueo.services.ProductoServiceJdbcImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;
import java.util.concurrent.ThreadPoolExecutor;

@WebServlet("/formulario")
public class ProductoFromServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        ProductoService service = new ProductoServiceJdbcImplement(conn);
        Integer idCategoria;
        try{
            idCategoria = Integer.parseInt(req.getParameter("idCategoria"));
        }catch(NumberFormatException e){
            idCategoria = 0;
        }
        Producto producto = new Producto();
        producto.setCategoria(new Categoria());
        if(idCategoria > 0){
            Optional<Producto> o = service.porId(idCategoria);
            if(o.isPresent()){
                producto = o.get();
            }
        }
        req.setAttribute("categoria", service.listarCategorias());
        req.setAttribute("producto", producto);
        getServletContext().getRequestDispatcher("/formulario.jsp").forward(req,resp);
    }
}
