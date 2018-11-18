package com.itheima.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.ResultInfo;
import com.itheima.bean.User;
import com.itheima.service.loginservice;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/user")
public class debarkuser  extends BaseServlet{

    public void longinuser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultInfo resultInfo=null;
        ObjectMapper objectMapper = new ObjectMapper();
        String data=null;
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            loginservice loginservice = new loginservice();
            int login = loginservice.login(username, password);
            if(login>0){
            resultInfo=new ResultInfo(true,login,"可以注册");
            }else {
                resultInfo=new ResultInfo(false,null,"不可以注册");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,"不可以注册");
        } finally {
            data = objectMapper.writeValueAsString(resultInfo);
            response.getWriter().print(data);
        }


    }
}
