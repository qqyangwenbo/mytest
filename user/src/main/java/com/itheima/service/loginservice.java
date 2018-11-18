package com.itheima.service;

import com.itheima.bean.User;
import com.itheima.dao.logindao;

import java.util.List;

public class loginservice {
    public int login(String username, String password) {
            logindao logindao = new logindao();
        try {
            List<User> list = logindao.login(username, password);

           return 0;
        } catch (Exception e) {
            e.printStackTrace();
            int insert = new logindao().insert(username, password);
            return 1;
            }

    }
}
