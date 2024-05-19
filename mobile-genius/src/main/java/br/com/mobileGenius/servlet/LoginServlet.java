package br.com.mobileGenius.servlet;

<<<<<<< HEAD
import br.com.mobileGenius.DAO.UserDAO;
import br.com.mobileGenius.model.User;
=======
import br.com.mobileGenius.DAO.UsuarioDAO;
import br.com.mobileGenius.model.Usuario;
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a

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
<<<<<<< HEAD
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean admin = false;

        // Passando as informações para o objeto user
        User user = new User(username, password, admin);

        // Verifica as credenciais do usuário e depois cria ele
        User isValidUser = new UserDAO().verifyCredentials(user);

        if (isValidUser != null && isValidUser.isLoggedUser()) {
            req.getSession().setAttribute("LoggedUser", username);
            req.getSession().setAttribute("admin", isValidUser.isAdmin());


            if (isValidUser.isAdmin()) {
=======
        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");


        UsuarioDAO usuarioDao = new UsuarioDAO();

        Usuario usuario = usuarioDao.getUsuariosPorNome(nome,senha);

        if (usuario != null && usuario.isLoggedUser()) {

            req.getSession().setAttribute("LoggedUser", nome);
            req.getSession().setAttribute("administrador", usuario.isAdministrador());

            if (usuario.isAdministrador()) {
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a

                // Caso usuario seja admin - enviado para area de administrador
                resp.sendRedirect("/encontre-todos-celulares");
                System.out.println("Usuario e admin");

            } else {

                // Caso usuario nao seja admin
<<<<<<< HEAD
                resp.sendRedirect("/area-cliente?username=" + isValidUser.getUsername());
=======
                req.getRequestDispatcher("/areaCliente.jsp").forward(req, resp);
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a
                System.out.println("Usuario não é admin");
            }

        } else {

            // Usuário não encontrado no banco de dados
            req.setAttribute("message", "Usuário ou senha estão incorretos!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
<<<<<<< HEAD
            System.out.println("Usuário não encontrado no banco de dados");
=======
            System.out.println("Usuário não encontrado no banco de dados- login servlet");
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a
        }
    }
}
