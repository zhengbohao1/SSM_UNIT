package com.itzbh.web.Filter;

import com.itzbh.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //访问的路径是否跟注册登录相关
        String[] urls={"/login.jsp","/imgs/","/css/","/loginservlet",
        "/register.jsp","/registerservlet","/checkcodeservlet"};

        //跟登录注册相关的路径都先放行，放行完就return。
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        String string = httpServletRequest.getRequestURL().toString();
        for (String url : urls) {
            if(string.contains(url)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }

        HttpSession session = httpServletRequest.getSession();
        User user = (User)session.getAttribute("user");
        if(user==null){
            //没有登录，跳转并拦截
            session.setAttribute("loginMsg","请先登录！");
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
        }
        else{
            //登陆过了，那就放走，放行
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
