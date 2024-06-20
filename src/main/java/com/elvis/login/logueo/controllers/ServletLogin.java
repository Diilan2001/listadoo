package com.elvis.login.logueo.controllers;

import com.elvis.login.logueo.services.LoginService;
import com.elvis.login.logueo.services.LoginServiceImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

//creamos el Path para la conexión al Servlet
@WebServlet({"/Login", "/ServletLogin"})

public class ServletLogin extends HttpServlet {
    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceImplement();
        Optional<String> usernameOptional = auth.getUserName(req);
        if (usernameOptional.isPresent()) {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.print("<!DOCTYPE html>");
                out.print("<html>");
                out.print("<head>");
                out.print("<meta charset=\"UTF-8\">");
                out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                out.print("<title>Hola " + usernameOptional.get() + "</title>");

                out.print("<link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
                out.print("</head>");
                out.println("<body>");
                out.print("<div class=\"container\">");
                out.print("<h1 class=\"mt-5\">Hola " + usernameOptional.get() + ", has iniciado sesión con éxito</h1>");
                out.print("<p><a href='" + req.getContextPath() + "/index.html' class=\"btn btn-primary\">Volver</a></p>");
                out.print("<p><a href='" + req.getContextPath() + "/logout' class=\"btn btn-danger\">Cerrar sesión</a><p>");
                out.print("</div>");
                out.println("</body>");
                out.print("</html>");
            }
        }else{
            getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect(req.getContextPath() + "/ServletLogin");
        }else{
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Lo sentimos no esta autorizado para ingresar al sistema");
        }
    }





}

