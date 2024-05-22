package br.com.mobileGenius.servlet;

import br.com.mobileGenius.DAO.CarrinhoDAO;
import br.com.mobileGenius.DAO.CelularDAO;
import br.com.mobileGenius.DAO.UserDAO;
import br.com.mobileGenius.DAO.VendaDAO;
import br.com.mobileGenius.model.Carrinho;
import br.com.mobileGenius.model.Celular;
import br.com.mobileGenius.model.User;
import br.com.mobileGenius.model.Venda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;



@WebServlet("/carrinho")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("LoggedUser");

        if (username != null) {
            UserDAO userDao = new UserDAO();
            CarrinhoDAO carrinhoDao = new CarrinhoDAO();
            CelularDAO celularDao = new CelularDAO();

            User userLogado = userDao.encontrarUsuarioPorUsername(username);
            Carrinho carrinho = carrinhoDao.findCarrinhoByUserId(userLogado.getId());

            if (carrinho != null) {
                String celularId = req.getParameter("add");

                if (celularId != null) {
                    Celular celular = celularDao.findCelularById(celularId);

                    if (celular.getQuantidade() > 0) {
                        // Adiciona o celular ao carrinho
                        carrinho.adicionarCelular(celular);
                        carrinhoDao.updateCarrinho(carrinho);
                    } else {
                        String errorMessage = "Quantidade insuficiente para adicionar este celular ao carrinho.";
                        String script = "alert('" + errorMessage + "');";
                        resp.getWriter().println("<script>" + script + "</script>");
                        return;
                    }
                }

                List<Celular> celulares = carrinho.getCelulares();
                req.setAttribute("carrinhoId", carrinho.getId());
                req.setAttribute("celulares", celulares);
                req.setAttribute("totalCarrinho", carrinho.getTotal());

                req.getRequestDispatcher("/cart.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/index");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String carrinhoId = req.getParameter("carrinhoId");
        String celularId = req.getParameter("celularId");
        CarrinhoDAO carrinhoDao = new CarrinhoDAO();
        CelularDAO celularDao = new CelularDAO();

        Celular c = celularDao.findCelularById(celularId);
        Carrinho carrinho = carrinhoDao.getCarrinhoById(carrinhoId);

        carrinho.removerCelular(c);
        carrinhoDao.updateCarrinho(carrinho);
        carrinhoDao.deleteCelular(carrinhoId,celularId);



        resp.sendRedirect(req.getContextPath() + "/carrinho?id=" + carrinhoId);
    }
}