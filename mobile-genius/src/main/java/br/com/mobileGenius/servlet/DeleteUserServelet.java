package br.com.mobileGenius.servlet;

<<<<<<< HEAD
import br.com.mobileGenius.DAO.UserDAO;
=======
import br.com.mobileGenius.DAO.CelularDAO;
import br.com.mobileGenius.DAO.UsuarioDAO;
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a

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
<<<<<<< HEAD
        String userCliente = req.getParameter("cliente");

        new UserDAO().deleteUserId(userId);

        if(userCliente != null) {

            resp.sendRedirect("/login");

        }else {

            resp.sendRedirect("/find-all-user");
        }
=======

        new UsuarioDAO().deletarUsuario(userId);

        resp.sendRedirect("/find-all-user");
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a

    }


}
