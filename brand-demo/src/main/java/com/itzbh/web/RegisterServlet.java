package com.itzbh.web;

import com.itzbh.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registerservlet")
public class RegisterServlet extends HttpServlet {



    UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String username=req.getParameter("username");
            String password=req.getParameter("password");

        HttpSession session = req.getSession();
        String checkcodegen = (String) session.getAttribute("checkcodegen");
        session.removeAttribute("checkcodegen");
        String yanzhengma=req.getParameter("checkCode");
        if(checkcodegen.equalsIgnoreCase(yanzhengma)){
            boolean flag=userService.Register(username,password);
            if(flag==false){
                //不OK
                req.setAttribute("register_msg","用户名已存在");
                req.getRequestDispatcher("/register.jsp").forward(req,resp);
            }
            else{
                req.setAttribute("register_msg","注册成功");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }
        else {
            req.setAttribute("check_msg","验证码错误");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
            {
        this.doGet(req, resp);
    }



}
