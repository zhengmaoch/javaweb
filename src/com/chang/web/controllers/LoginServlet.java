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

@WebServlet(name = "LoginServlet", urlPatterns = "/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService service = new UserServiceImpl();
        User user = service.login(username,password);

        if(user != null){
            request.getSession().setAttribute("user", user);
//            response.sendRedirect(request.getContextPath() + "/index.jsp");

            request.getRequestDispatcher("/servlet/ListUserServlet").forward(request,response);
            return;
        }

        request.setAttribute("message", "用户名或密码错误！浏览器将在3秒后跳转。<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/servlet/LoginUIServlet'>");
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }
}
