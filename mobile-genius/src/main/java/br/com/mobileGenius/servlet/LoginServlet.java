package br.com.mobileGenius.servlet;

import br.com.mobileGenius.DAO.UsuarioDAO;
import br.com.mobileGenius.model.Usuario;

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
        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");


        UsuarioDAO usuarioDao = new UsuarioDAO();

        Usuario usuario = usuarioDao.getUsuariosPorNome(nome,senha);

        if (usuario != null && usuario.isLoggedUser()) {

            req.getSession().setAttribute("LoggedUser", nome);
            req.getSession().setAttribute("administrador", usuario.isAdministrador());

            if (usuario.isAdministrador()) {

                // Caso usuario seja admin - enviado para area de administrador
                resp.sendRedirect("/encontre-todos-celulares");
                System.out.println("Usuario e admin");

            } else {

                // Caso usuario nao seja admin
                req.getRequestDispatcher("/areaCliente.jsp").forward(req, resp);
                System.out.println("Usuario não é admin");
            }

        } else {

            // Usuário não encontrado no banco de dados
            req.setAttribute("message", "Usuário ou senha estão incorretos!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            System.out.println("Usuário não encontrado no banco de dados- login servlet");
        }
    }
}
