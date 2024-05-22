package br.com.mobileGenius.servlet;

import br.com.mobileGenius.DAO.UserDAO;
import br.com.mobileGenius.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        // Passando as informações para o objeto user
        User user = new User(username, password, false);

        // Verifica as credenciais do usuário e depois cria ele
        User isValidUser = new UserDAO().verifyCredentials(user);

        if (isValidUser != null && isValidUser.isLoggedUser()) {
            // Inicia a sessão
            HttpSession session = req.getSession();

            // Define o atributo de sessão para o ID do usuário
            session.setAttribute("LoggedUserId", isValidUser.getId());

            // Define o atributo de sessão para o nome de usuário
            session.setAttribute("LoggedUser", username);

            // Define o atributo de sessão para o tipo de usuário (admin ou não)
            session.setAttribute("Type", isValidUser.isAdmin());

            if (isValidUser.isAdmin()) {
                // Caso usuário seja admin - enviado para área de administrador
                resp.sendRedirect("/encontre-todos-celulares");
                System.out.println("Usuário é admin");
            } else {
                // Caso usuário não seja admin
                resp.sendRedirect("/area-cliente?username=" + isValidUser.getUsername());
                System.out.println("Usuário não é admin");
            }
        } else {
            // Usuário não encontrado no banco de dados
            req.setAttribute("message", "Usuário ou senha estão incorretos!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            System.out.println("Usuário não encontrado no banco de dados - login servlet");
        }
    }
}
