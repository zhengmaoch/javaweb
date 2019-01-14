package com.chang.web.controllers;

import com.chang.domain.User;
import com.chang.utils.WebUtils;
import com.chang.web.formbean.RegisterForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RegisterForm form = WebUtils.requestToBean(request, RegisterForm.class);
        boolean b = form.validate();

        if(!b){
            request.setAttribute("form", form);
            request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request,response);
            return;
        }

        User user = new User();
        WebUtils.copyBean(form, user);
        user.setId(WebUtils.GenerateID());

    }
}
