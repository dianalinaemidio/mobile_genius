package br.com.mobileGenius.servlet;

import br.com.mobileGenius.DAO.CelularDAO;
import br.com.mobileGenius.DAO.UsuarioDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delete-user")

public class DeleteUserServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String userId = req.getParameter("id");

        new UsuarioDAO().deletarUsuario(userId);

        resp.sendRedirect("/find-all-user");

    }


}
