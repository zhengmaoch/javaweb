package com.chang.web.controller;

import com.chang.domain.User;
import com.chang.services.UserService;
import com.chang.services.impl.UserServiceImpl;
import com.chang.utils.WebUtils;
import com.chang.web.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/servlet/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.setCharacterEncoding("UTF-8");

        UserModel form = WebUtils.requestToModel(request, UserModel.class);
        boolean b = form.validate();

        if(!b){
            request.setAttribute("form", form);
            request.getRequestDispatcher("WEB-INF/jsp/edituser.jsp").forward(request,response);
            return;
        }

        User user = new User();
        WebUtils.copyModel(form, user);

        UserService service = new UserServiceImpl();
        try {
            service.updateUser(user);
            request.setAttribute("message","恭喜您，编辑成功！");
            request.getRequestDispatcher("/servlet/ListUserServlet").forward(request,response);
            return;
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("message","服务器出现未知错误！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
            return;
        }


    }
}
