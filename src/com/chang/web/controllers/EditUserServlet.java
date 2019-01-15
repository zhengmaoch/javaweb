package com.chang.web.controllers;

import com.chang.domain.User;
import com.chang.services.UserService;
import com.chang.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditUserServlet", urlPatterns = "/servlet/EditUserServlet")
public class EditUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        UserService service = new UserServiceImpl();
        User user = service.getUser(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/WEB-INF/jsp/edituser.jsp").forward(request,response);
    }
}
