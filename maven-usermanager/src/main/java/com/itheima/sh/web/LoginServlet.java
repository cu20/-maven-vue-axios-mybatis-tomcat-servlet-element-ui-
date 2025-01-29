package com.itheima.sh.web;

import com.itheima.sh.pojo.User;
import com.itheima.sh.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.解决post请求的中文乱码问题
        request.setCharacterEncoding("utf-8");
        //2.接收前端提交的请求参数
        /*
            username: zhangsan
            pwd: 1234
         */
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        //3.将请求参数封装到User实体类对象中===》user
        User user = new User();
        user.setUsername(username);
        user.setPassword(pwd);
        //4.创建业务层即service层的对象
        UserServiceImpl userService = new UserServiceImpl();
        //5.使用业务层对象调用业务层的登录方法将user对象传递到业务层
        User u = userService.login(user);
        //6.判断u是否等于null
        if(u==null){
        //7.如果u等于null，说明没有查到用户，登录失败，响应给前端一个false
            response.getWriter().print(false);
        }else{
            //8.如果u不等于null，说明查到用户了，登录成功，响应给前端一个true
            response.getWriter().print(true);
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}