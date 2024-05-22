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

@WebServlet("/finalizar-compra")
public class FinalizarCompraServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("LoggedUser");

        if (username != null) {
            UserDAO userDao = new UserDAO();
            CarrinhoDAO carrinhoDao = new CarrinhoDAO();
            VendaDAO vendaDao = new VendaDAO();
            CelularDAO celularDao = new CelularDAO();

            User userLogado = userDao.encontrarUsuarioPorUsername(username);

            String carrinhoId = req.getParameter("carrinhoId");
            if (carrinhoId != null) {
                Carrinho carrinho = carrinhoDao.getCarrinhoById(carrinhoId);

                if (carrinho != null) {

                    carrinhoDao.updateCarrinho(carrinho);

                    List<Celular> celulares = carrinho.getCelulares();

                    for (Celular celular : celulares) {
                        int quantidade = celular.getQuantidade();

                        if (quantidade > 0) {
                            celular.setQuantidade(quantidade - 1);
                            celularDao.updateCelular(celular);
                        } else {

                            resp.sendRedirect(req.getContextPath() + "/carrinho?error=ProdutoEsgotado&produto=" + celular.getModelo());
                            return;

                        }
                    }



                    Date dataAtual = new Date(System.currentTimeMillis());
                    Venda venda = new Venda(userLogado, dataAtual, carrinho);
                    vendaDao.salvar(venda);

                    carrinho.limparCarrinho();
                    carrinhoDao.updateCarrinho(carrinho);

                    resp.sendRedirect(req.getContextPath() + "/agradecimento.jsp");
                    return;
                }
            }
        }

        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}

