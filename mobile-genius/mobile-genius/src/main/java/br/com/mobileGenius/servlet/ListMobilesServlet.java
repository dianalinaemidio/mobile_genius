package br.com.mobileGenius.servlet;


import br.com.mobileGenius.DAO.MobileDAO;
import br.com.mobileGenius.Model.Mobile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



@WebServlet("/find-all-cars")

public class ListMobilesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Mobile> mobiles = new MobileDAO().findMobile();

        req.setAttribute("mobiles", mobiles);

        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

    }

}