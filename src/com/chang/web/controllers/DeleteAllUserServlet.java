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
import java.util.List;

@WebServlet(name = "DeleteAllUserServlet", urlPatterns = "/servlet/DeleteAllUserServlet")
public class DeleteAllUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService service = new UserServiceImpl();
        List<User> users = service.getAllUser();
        for (User user: users) {
            service.deleteUser(user.getId());
        }

        request.getRequestDispatcher("/WEB-INF/jsp/listuser.jsp").forward(request,response);
    }
}
