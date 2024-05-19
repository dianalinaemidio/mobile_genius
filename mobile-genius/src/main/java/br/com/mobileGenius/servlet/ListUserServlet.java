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
import java.util.List;

@WebServlet("/find-all-user")

public class ListUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

<<<<<<< HEAD
        List<User> users = new UserDAO().findUser();
=======
        List<Usuario> users = new UsuarioDAO().listarUsuarios();
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a

        req.setAttribute("users", users);

        req.getRequestDispatcher("listaUser.jsp").forward(req, resp);


    }

}