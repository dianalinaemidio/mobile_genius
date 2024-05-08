package br.com.mobileGenius.servlet;

import br.com.mobileGenius.DAO.UserDAO;
import br.com.mobileGenius.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean type = false;

        User user = new User(username, password, type);

       User isValidUser = new UserDAO().verifyCredentials(user);

        if (isValidUser.isLoggedUser()) {
            req.getSession().setAttribute("LoggedUser", username);
            req.getSession().setAttribute("Type", isValidUser.isType());

            resp.sendRedirect("/encontre-todos-celulares");

        } else {
            req.setAttribute("message", "Credenciais inválidas");

            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
