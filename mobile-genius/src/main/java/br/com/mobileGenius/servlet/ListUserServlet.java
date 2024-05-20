package br.com.mobileGenius.servlet;

import br.com.mobileGenius.DAO.UserDAO;
import br.com.mobileGenius.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-user")

public class ListUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = new UserDAO().findUser();

        req.setAttribute("users", users);

        req.getRequestDispatcher("listaUser.jsp").forward(req, resp);


    }

}