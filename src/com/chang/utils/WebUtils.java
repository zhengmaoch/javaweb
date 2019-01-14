package com.chang.utils;

import com.chang.domain.User;
import com.chang.web.formbean.RegisterForm;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class WebUtils {

    public static <T> T requestToBean(HttpServletRequest request, Class<T> beanClass){
        try {
            T bean = beanClass.newInstance();

            Enumeration e = request.getParameterNames();
            while (e.hasMoreElements()){
                String name = (String) e.nextElement();
                String value = request.getParameter(name);
                BeanUtils.setProperty(bean, name,value);
            }
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void copyBean(RegisterForm form, User user) {
    }

    public static String GenerateID() {
        return null;
    }
}
