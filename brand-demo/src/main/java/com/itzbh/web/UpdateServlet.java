package com.itzbh.web;

import com.alibaba.fastjson.JSON;
import com.itzbh.pojo.Brand;
import com.itzbh.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/updateservlet")
public class UpdateServlet extends HttpServlet {
    BrandService service=new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                System.out.println(cookie.getValue());
            }

        }*/
        BufferedReader reader = req.getReader();
        String params = reader.readLine();

        Brand brand = JSON.parseObject(params, Brand.class);
        try {
            service.UpdateBrand(brand);
        } catch (Exception e) {
            resp.getWriter().write("error");
        }
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
