package br.com.mobileGenius.servlet;

import br.com.mobileGenius.DAO.CelularDAO;
import br.com.mobileGenius.DAO.UserDAO;
import br.com.mobileGenius.DAO.CarrinhoDAO;
import br.com.mobileGenius.model.Carrinho;
import br.com.mobileGenius.model.Celular;
import br.com.mobileGenius.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Celular> celulares = new CelularDAO().findCelular();
        req.setAttribute("celulares", celulares);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDao = new UserDAO();
        CelularDAO celularDao = new CelularDAO();
        CarrinhoDAO carrinhoDao = new CarrinhoDAO();

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("LoggedUser");

        if (username != null) {
            User userLogado = userDao.encontrarUsuarioPorUsername(username);
            String celularId = req.getParameter("celularId");

            if (celularId != null && !celularId.isEmpty()) {

                Celular celular = celularDao.findCelularById(celularId);
                Carrinho carrinho = carrinhoDao.findCarrinhoByUserId(userLogado.getId());
                carrinho.adicionarCelular(celular);
                carrinhoDao.updateCarrinho(carrinho);

                resp.sendRedirect(req.getContextPath() + "/carrinho?id="+carrinho.getId());
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
