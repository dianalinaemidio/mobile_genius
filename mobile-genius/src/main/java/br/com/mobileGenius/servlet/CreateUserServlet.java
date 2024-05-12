package br.com.mobileGenius.servlet;

import br.com.mobileGenius.DAO.UserDAO;
import br.com.mobileGenius.model.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

// Para onde o formulario html faz a requisicao
@WebServlet("/create-user")

public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // Pegando as informações da requisicao do metodo post
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean type = false;

        User user = new User(id, username, password, type);

        UserDAO userDao = new UserDAO();


        if (id.isBlank()) {
            userDao.createUser(user);
            response.sendRedirect("/index.jsp");

        } else {

            userDao.updateUser(user);
            response.sendRedirect("/find-all-user"); // Pagina que lista os usuarios

        }

    } // Fim do doPost

} // Fim da classe createUserServelet


