package com.itzbh.Controller.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Component
public class Userinterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截开始");
        if(request.getRequestURI().contains("login")||request.getRequestURI().contains("register"))
        {
            System.out.println("是login.html或register.html");
            return true;
        }
        System.out.println("不是login.html");
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");
        if(username!=null){
            System.out.println("已登录");
            return  true;
        }
        System.out.println("不是login.html且未登录");
        response.sendRedirect("/ssm_unit_war/pages/login.html"); // 内部重定向
        System.out.println("转走");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post执行");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after执行");
    }
}
