
package br.com.mobileGenius.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.com.mobileGenius.Model.Celular;
import br.com.mobileGenius.DAO.CelularDAO;

@WebServlet("/create-celular")

public class CreateCelularServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String celularNome = request.getParameter("celular-nome");

        Celular celular = new Celular(celularNome);

        CelularDAO celularDao = new CelularDAO();

        celularDao.createCelular(celular);

        System.out.println(celularNome);

        response.sendRedirect("/encontre-todos-celulares");

    }
}
