
package br.com.mobileGenius.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.com.mobileGenius.Model.Mobile;
import br.com.mobileGenius.DAO.MobileDAO;

@WebServlet("/create-mobile")

public class CreateMobileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mobileName = request.getParameter("mobile-name");

        Mobile mobile = new Mobile(mobileName);

        MobileDAO mobileDao = new MobileDAO();

        mobileDao.createMobile(mobile);

        System.out.println(mobileName);

        response.sendRedirect("/find-all-cars");

    }
}
