/*
package com.itzbh.web;

import com.alibaba.fastjson.JSON;
import com.itzbh.Config.SpringConfig;
import com.itzbh.pojo.Brand;
import com.itzbh.service.BrandService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectallservlet")
public class SelectAllServlet extends HttpServlet {



    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    BrandService accountService = context.getBean(BrandService.class);
    BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用函数
        List<Brand> brands = accountService.selectAll();

        */
/*String value="张三";
        value= URLEncoder.encode(value);*//*



        //存入req域中
        req.setAttribute("brands",brands);

        */
/*Cookie cookie=new Cookie("username",value);

        cookie.setMaxAge(60*60*24*7);

        resp.addCookie(cookie);
*//*


        //转发到breand.jsp
        //req.getRequestDispatcher("/brand.jsp").forward(req,resp);

        */
/*Gson gson = new Gson();
        String json = gson.toJson(brands);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);*//*


        //用fastJason把brands转换为json
        String jsonString = JSON.toJSONString(brands);
        //再把这个json转走
        resp.setContentType("text/JSON;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }



}
*/
