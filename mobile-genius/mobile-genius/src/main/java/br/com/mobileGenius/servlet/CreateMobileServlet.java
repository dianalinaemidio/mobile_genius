
package br.com.mobileGenius.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/create-mobile")

public class CreateMobileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mobileName = request.getParameter("mobile-name");



        System.out.println(mobileName);

        request.getRequestDispatcher("index.html").forward(request, response);

    }
}
