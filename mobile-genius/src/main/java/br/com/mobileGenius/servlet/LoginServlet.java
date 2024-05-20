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

        // Pegando as informações da página
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean admin = false;

        // Verifica as credenciais do usuário
        UserDAO userDAO = new UserDAO();
        User isValidUser = userDAO.verifyCredentials(new User(username, password));


        if (isValidUser != null && isValidUser.isLoggedUser()) {
            req.getSession().setAttribute("LoggedUser", username);
            req.getSession().setAttribute("admin", isValidUser.isAdmin());

            if (isValidUser .isAdmin()) {
                // Caso usuario seja admin - enviado para area de administrador
                resp.sendRedirect("/encontre-todos-celulares");
                System.out.println("Usuario e admin");

            } else {
                // Caso usuario nao seja admin
                resp.sendRedirect("/area-cliente?username=" + isValidUser.getUsername());
                req.getRequestDispatcher("/areaCliente.jsp").forward(req, resp);
                System.out.println("Usuario não é admin");
            }

        } else {
            // Usuário não encontrado no banco de dados
            req.setAttribute("message", "Usuário ou senha estão incorretos!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            System.out.println("Usuário não encontrado no banco de dados ou credenciais incorretas");
        }
    }
}
