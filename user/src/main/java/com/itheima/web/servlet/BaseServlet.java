package com.itheima.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@WebServlet("/aa")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        try {
            //获得请求参数
            String method = req.getParameter("method");
            //获得字节码
            Class clazz = this.getClass();
            //获得方法对象
            Method method1 = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            method1.invoke(this, req, resp);
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}