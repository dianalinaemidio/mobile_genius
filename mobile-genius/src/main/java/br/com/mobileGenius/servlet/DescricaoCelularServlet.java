package br.com.mobileGenius.servlet;

import br.com.mobileGenius.DAO.CelularDAO;
import br.com.mobileGenius.DAO.UserDAO;
import br.com.mobileGenius.model.Celular;
import br.com.mobileGenius.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/descricao")
public class DescricaoCelularServlet extends HttpServlet {

    // Usando o metodo get para pegar o id
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String celularId = request.getParameter("id");
        System.out.println(celularId);

        // Verificar se o ID não é nulo e tratar possíveis erros
        if (celularId != null) {

            // Chamar a classe DAO para obter detalhes do celular
            CelularDAO celularDAO = new CelularDAO();
            Celular celular = celularDAO.findCelularById(celularId);

            // Atribuir o objeto celular aos atributos da request
            request.setAttribute("celular", celular);

            // Encaminhar a requisição para a página de descrição
            request.getRequestDispatcher("detalhesCelular.jsp").forward(request, response);

        } else {
            // Tratar o caso onde o ID não foi passado ou é inválido
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID do celular não informado ou inválido.");
        }
    }
}
