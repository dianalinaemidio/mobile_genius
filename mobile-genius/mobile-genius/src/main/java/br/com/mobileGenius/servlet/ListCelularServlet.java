package br.com.mobileGenius.servlet;


import br.com.mobileGenius.DAO.CelularDAO;
import br.com.mobileGenius.Model.Celular;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



@WebServlet("/encontre-todos-celulares")

public class ListCelularServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Celular> celulares = new CelularDAO().findCelular();

        req.setAttribute("celulares", celulares);

        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

    }

}