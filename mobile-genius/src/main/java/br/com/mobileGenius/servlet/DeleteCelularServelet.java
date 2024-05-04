package br.com.mobileGenius.servlet;

import br.com.mobileGenius.DAO.CelularDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delete-celular")

public class DeleteCelularServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String celularId = req.getParameter("id");

        new CelularDAO().deleteCelularId(celularId);

        resp.sendRedirect("/encontre-todos-celulares");

    }


}
