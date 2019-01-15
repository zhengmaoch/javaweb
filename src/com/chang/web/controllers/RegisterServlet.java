package com.chang.web.controllers;

import com.chang.domain.User;
import com.chang.exception.UserExistException;
import com.chang.services.UserService;
import com.chang.services.impl.UserServiceImpl;
import com.chang.utils.WebUtils;
import com.chang.web.formbean.RegisterForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "RegisterServlet", urlPatterns = "/servlet/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        RegisterForm form = WebUtils.requestToBean(request, RegisterForm.class);
        boolean b = form.validate();

        if(!b){
            request.setAttribute("form", form);
            request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request,response);
            return;
        }

        User user = new User();
        WebUtils.copyBean(form, user);
        user.setId(WebUtils.generateID());
        user.setCreatedTime(new Date());

        UserService service = new UserServiceImpl();
        try {
            service.register(user);
            request.setAttribute("message","恭喜您，注册成功！<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/index.jsp'>");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
            return;
        } catch (UserExistException e) {
            form.getErrors().put("username","注册的用户名已存在！");
//            request.setAttribute("message","注册的用户名已存在！");
            request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request,response);
            return;
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("message","服务器出现未知错误！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
            return;
        }

    }
}
