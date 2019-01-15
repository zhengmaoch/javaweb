package com.chang.web.formbean;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class RegisterForm {
    private String id;
    private String username;
    private String password;
    private String password2;
    private String email;
    private String birthday;
    private String nikename;

    private Map errors = new HashMap();

    public boolean validate(){

        return true;
    }
}
