package com.elvis.login.logueo.controllers;

import com.elvis.login.logueo.models.Carro;
import com.elvis.login.logueo.models.ItemCarro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/eliminar-carro")
public class EliminarCarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idProducto = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        Carro carro = (Carro) session.getAttribute("carro");

        if (carro != null) {
            Optional<ItemCarro> itemOptional = carro.getItems().stream()
                    .filter(item -> item.getProducto().getIdProducto().equals(idProducto))
                    .findFirst();
            itemOptional.ifPresent(carro::removeItemCarro);
        }

        resp.sendRedirect(req.getContextPath() + "/ver-carro");
    }
}

