package br.com.mobileGenius.servlet;

import br.com.mobileGenius.DAO.UserDAO;


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
        String userCliente = req.getParameter("cliente");

        new UserDAO().deleteUserId(userId);

        if(userCliente != null) {

            resp.sendRedirect("/login");

        }else {

            resp.sendRedirect("/find-all-user");
        }

    }


}
