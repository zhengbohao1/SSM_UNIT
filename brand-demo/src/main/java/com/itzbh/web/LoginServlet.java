package com.itzbh.web;

import com.itzbh.pojo.User;
import com.itzbh.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {



    UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username, password);
        if (user == null) {
            //登录失败
            req.setAttribute("loginMsg", "用户名或者密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        } else {

            if("on".equals(req.getParameter("remember"))){
                Cookie username1 = new Cookie("username2", username);
                Cookie password1 = new Cookie("password", password);

                username1.setMaxAge(60*60*24*7);
                password1.setMaxAge(60*60*24*7);

                resp.addCookie(username1);
                resp.addCookie(password1);
            }
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("/brand_demo_war/01-vue.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
            {
        this.doGet(req, resp);
    }



}
