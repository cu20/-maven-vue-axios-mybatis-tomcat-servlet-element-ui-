package com.itheima.sh.web;

import com.itheima.sh.pojo.User;
import com.itheima.sh.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.防止中文乱码
        request.setCharacterEncoding("utf-8");
        //2.接收前端提交的请求参数
        /*
            username: zhangsan
            pwd: 1234
         */
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        User user= new User();
        user.setUsername(username);
        user.setPassword(pwd);

        //交给业务对象进行注册
        UserServiceImpl userService = new UserServiceImpl();
        int u = -1;
        //先判断是否该用户名已存在
        User Inspector = userService.check(user);
        if(Inspector==null){
            u = userService.register(user);
        }

        //6.判断u是否等于null
        if(u==-1){
            //7.如果u等于null，说明没有查到用户，登录失败，响应给前端一个false
            response.getWriter().print(false);
        }else{
            //8.如果u不等于null，说明查到用户了，登录成功，响应给前端一个true
            response.getWriter().print(true);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}